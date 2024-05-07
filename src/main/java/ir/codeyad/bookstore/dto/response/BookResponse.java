package ir.codeyad.bookstore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class BookResponse {
    private Long id;
    private String name;
    private Long price;
}
