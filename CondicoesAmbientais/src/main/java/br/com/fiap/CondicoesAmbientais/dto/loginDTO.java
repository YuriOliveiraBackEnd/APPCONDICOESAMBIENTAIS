package br.com.fiap.CondicoesAmbientais.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record loginDTO(
        @NotBlank(message = "Campo Obrigatório")
        @Email(message = "e-mail inválido")
        String email,
        @NotBlank(message = "Campo Obrigatório")
        @Size(min = 6,max = 20,message = "A senha deve conter de 6 a 20 caracteres")
        String senha
) {
}
