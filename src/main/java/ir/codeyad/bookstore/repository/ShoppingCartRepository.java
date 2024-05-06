package ir.codeyad.bookstore.repository;

import ir.codeyad.bookstore.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
