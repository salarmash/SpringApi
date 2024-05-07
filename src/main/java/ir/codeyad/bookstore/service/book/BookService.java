package ir.codeyad.bookstore.service.book;

import ir.codeyad.bookstore.dto.request.BookRequest;
import ir.codeyad.bookstore.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookResponse save(BookRequest bookRequest);
    Page<BookResponse> findAll(Pageable pageable);
}
