package ir.codeyad.bookstore.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Entity
@Table(schema = SchemaName.schemaName)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{
    private String username;
    private String password;

}