package boj.zlica.busline.securities.JWT;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class TokenRequest {

    @NotNull
    @NotBlank
    private final String email;

    @NotNull
    @NotBlank
    private final String password;
}
