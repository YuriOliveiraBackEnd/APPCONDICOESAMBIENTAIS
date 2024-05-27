package br.com.fiap.CondicoesAmbientais.config.security;

import br.com.fiap.CondicoesAmbientais.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${minha.chave.secreta}")
    private String palavrasecreta;

    public String gerarToken(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(palavrasecreta);
            String token = JWT
                    .create()
                    .withIssuer("condicoesAmbientais")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(gerarDateDeExpiracao())
                    .sign(algorithm);

            return token;
        }catch (JWTCreationException erro){
            throw   new RuntimeException("Não foi possivel gerar o token");
        }

    }
    public  String validarToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(palavrasecreta);
            return  JWT.require(algorithm)
                    .withIssuer("condicoesAmbientais")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException erro){
            return "";
        }
    }
    public Instant gerarDateDeExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
