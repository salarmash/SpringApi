package ir.codeyad.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(schema = SchemaName.schemaName)
public class Factor extends BaseEntity{
    @ManyToOne
    private User user;

}
