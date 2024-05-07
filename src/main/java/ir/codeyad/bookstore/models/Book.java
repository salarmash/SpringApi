package ir.codeyad.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Entity
@Table(schema = SchemaName.schemaName)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity {
    private String name;
    private Long price;

}
