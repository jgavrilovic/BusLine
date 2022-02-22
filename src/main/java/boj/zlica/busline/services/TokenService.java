package boj.zlica.busline.services;

import boj.zlica.busline.dto.UserEntity;
import boj.zlica.busline.exceptions.TokenParsingException;
import boj.zlica.busline.securities.JWT.TokenResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


import java.util.Arrays;


@Service
@PropertySource(value = "/security.properties")
public class TokenService {

    private final String tokenSecret;

    public TokenService(@Value("${token.secret}") String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

    public TokenResponse generateTokenFor(UserEntity user) {
        String token = Jwts.builder()
                .setClaims(createClaims(user))
                .signWith(SignatureAlgorithm.HS512, tokenSecret)
                .compact();

        return new TokenResponse(token);
    }

    private Claims createClaims(UserEntity user) {
        Claims claims = Jwts.claims();

        claims.put("idUser", user.getIdUser());
        claims.put("first_name", user.getFirstName());
        claims.put("last_name", user.getLastName());
        claims.put("email", user.getEmail());
        claims.put("password", user.getPassword());
        claims.put("role", user.getRole());

        return claims;
    }

    public Claims parseToken(ProceedingJoinPoint joinPoint) {
        String token = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .filter(headerName -> headerName.startsWith("Bearer"))
                .findFirst()
                .orElseThrow(() -> new TokenParsingException("Bearer header not found!"))
                .split(" ")[1];

        return parseToken(token);
    }

    private Claims parseToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(tokenSecret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception ignored) {
            throw new TokenParsingException(String.format("Invalid token: %s!", token));
        }
    }
}
