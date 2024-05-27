package br.com.fiap.CondicoesAmbientais.controller;

import br.com.fiap.CondicoesAmbientais.config.security.TokenService;
import br.com.fiap.CondicoesAmbientais.dto.TokenDTO;
import br.com.fiap.CondicoesAmbientais.dto.UsuarioDTO;
import br.com.fiap.CondicoesAmbientais.dto.loginDTO;
import br.com.fiap.CondicoesAmbientais.model.Usuario;
import br.com.fiap.CondicoesAmbientais.service.UsuarioService;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService service;

    @Autowired
    private TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid loginDTO loginDTO){
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.email(),
                        loginDTO.senha()
                );
        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return  ResponseEntity.ok(new TokenDTO(token));
    }
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public  UsuarioDTO registrar(@RequestBody @Valid UsuarioDTO usuarioDTO){
      UsuarioDTO usuariosalvo = null;
      usuariosalvo = service.salvar(usuarioDTO);
      return  usuariosalvo;
    }
}
