package by.sivko.pizzashop.loginservice.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JwtResponse {
    private final String jwttoken;

    public String getToken() {
        return this.jwttoken;
    }
}