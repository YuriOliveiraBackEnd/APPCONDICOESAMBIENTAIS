package br.com.fiap.CondicoesAmbientais.dto;

import br.com.fiap.CondicoesAmbientais.model.CondicoesAmbientais;
import jakarta.validation.constraints.NotBlank;

public record CondicoesAmbientaisDTO(
         Long id,
         @NotBlank(message = "Campo Obrigatório")
         String qualidadeAr,
         @NotBlank(message = "Campo Obrigatório")
         String umidade,
         @NotBlank(message = "Campo Obrigatório")
         String temperatura,
         @NotBlank(message = "Campo Obrigatório")
         String contatoEmergencia,
         @NotBlank(message = "Campo Obrigatório")
         String desastreNatural
) {
    public CondicoesAmbientaisDTO(CondicoesAmbientais condicoesAmbientais) {
        this(
                condicoesAmbientais.getId(),
                condicoesAmbientais.getQualidadeAr(),
                condicoesAmbientais.getUmidade(),
                condicoesAmbientais.getTemperatura(),
                condicoesAmbientais.getContatoEmergencia(),
                condicoesAmbientais.getDesastreNatural()
        );
    }

}
