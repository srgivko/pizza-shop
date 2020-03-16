package by.sivko.pizzashop.loginservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest  {
    @Email
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}