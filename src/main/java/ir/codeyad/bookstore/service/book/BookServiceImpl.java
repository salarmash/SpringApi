package ir.codeyad.bookstore.service.book;

import ir.codeyad.bookstore.dto.request.BookRequest;
import ir.codeyad.bookstore.execption.RuleExecption;
import ir.codeyad.bookstore.dto.response.BookResponse;
import ir.codeyad.bookstore.models.Book;
import ir.codeyad.bookstore.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse save(BookRequest bookRequest) {
        // Check if a book with the same name already exists
        Optional<Book> existingBook = bookRepository.findByName(bookRequest.getName());
        if (existingBook.isPresent()) {
            throw new RuleExecption("Book already exists");
        } else {
            // Save the book to the repository if it doesn't already exist
            Book savedBook = bookRepository.save(createdBook(bookRequest));
            return createBookResponse(savedBook);
        }
    }

    @Override
    public Page<BookResponse> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).map((book) -> BookResponse.builder().id(book.getId())
                .name(book.getName())
                .price(book.getPrice()).build());
    }

    @Override
    public List<BookResponse> findByName(String name) {
        return bookRepository.findByNameContains(name).stream().map((book) -> BookResponse.builder().id(book.getId())
                .name(book.getName())
                .price(book.getPrice()).build()).collect(Collectors.toList());
    }

    @Override
    public BookResponse findById(Long id) {
      Book book=   bookRepository.findById(id).orElseThrow(()->new RuleExecption("book.not.found"));
      return createBookResponse(book);
    }

    private Book createdBook(BookRequest bookRequest) {

        return Book.builder().name(bookRequest.getName()).price(bookRequest.getPrice()).build();
    }

    private BookResponse createBookResponse(Book book) {
        return BookResponse.builder().name(book.getName()).price(book.getPrice()).id(book.getId()).build();
    }
}
