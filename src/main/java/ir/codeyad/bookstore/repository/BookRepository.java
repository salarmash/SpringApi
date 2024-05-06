package ir.codeyad.bookstore.repository;

import ir.codeyad.bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
