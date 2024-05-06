package ir.codeyad.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(schema = SchemaName.schemaName)
public class ShoppingCart extends BaseEntity{
    private int count;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Factor factor;

}
