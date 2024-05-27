package br.com.fiap.CondicoesAmbientais.dto;

import br.com.fiap.CondicoesAmbientais.model.CondicoesAmbientais;
import br.com.fiap.CondicoesAmbientais.model.Role;
import br.com.fiap.CondicoesAmbientais.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDTO (
        Long idUsuario,
        @NotBlank(message = "Campo Obrigatório")
        String nome,
        @NotBlank(message = "Campo Obrigatório")
        @Email(message = "e-mail inválido")
        String email,
        @NotBlank(message = "Campo Obrigatório")
        @Size(min = 6,max = 20,message = "A senha deve conter de 6 a 20 caracteres")
        String senha,

        Role role

){
        public UsuarioDTO(Usuario usuario) {
                this(
                        usuario.getIdUsuario(),
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getSenha(),
                        usuario.getRole()
                );
        }
}
