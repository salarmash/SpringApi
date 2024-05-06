package ir.codeyad.bookstore.repository;

import ir.codeyad.bookstore.models.Factor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactorRepository extends JpaRepository<Factor, Long> {
}
