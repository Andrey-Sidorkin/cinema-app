package cinema.dto.request;

import cinema.lib.FieldsValueMatch;
import cinema.lib.ValidEmail;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!"
)
public class UserRequestDto {
    @ValidEmail
    private String email;
    @NotNull
    @Size(min = 8, max = 40)
    @Pattern(regexp = "^\\w*(([A-Z]+\\w*\\d+)|(\\d+\\w*[A-Z]+))\\w*$")
    private String password;
    @NotNull
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
