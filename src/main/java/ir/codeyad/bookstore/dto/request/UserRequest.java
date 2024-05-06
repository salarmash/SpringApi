package ir.codeyad.bookstore.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequest {
    @NotNull(message = "{Username.Is.Null!}")
    @NotBlank(message = "{Username.Is.Blank!}")
    private final String username;
    @NotNull(message = "{Password.Is.Null!}")
    @NotBlank(message = "{Password.Is.Blank!}")
    private final String password;
}
