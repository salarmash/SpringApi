package ir.codeyad.bookstore.service.book;

import ir.codeyad.bookstore.dto.request.BookRequest;
import ir.codeyad.bookstore.execption.RuleExecption;
import ir.codeyad.bookstore.dto.response.BookResponse;
import ir.codeyad.bookstore.models.Book;
import ir.codeyad.bookstore.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {

        Book save = bookRepository.save(createdBook(bookRequest));
        Optional<Book> byName = bookRepository.findByName(bookRequest.getName());
        if (byName.isPresent())
            throw new RuleExecption("Book.is.Exist");
        return createBookResponse(save);
    }

    @Override
    public Page<BookResponse> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).map((book) -> BookResponse.builder().id(book.getId())
                .name(book.getName())
                .price(book.getPrice()).build());
    }

    private Book createdBook(BookRequest bookRequest) {

        return Book.builder().name(bookRequest.getName()).price(bookRequest.getPrice()).build();
    }

    private BookResponse createBookResponse(Book book) {
        return BookResponse.builder().name(book.getName()).price(book.getPrice()).id(book.getId()).build();
    }
}
