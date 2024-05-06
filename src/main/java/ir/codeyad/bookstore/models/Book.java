package ir.codeyad.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(schema = SchemaName.schemaName)
public class Book extends BaseEntity {
    private String name;
    private long price;

}
