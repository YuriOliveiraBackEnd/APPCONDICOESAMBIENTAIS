package br.com.fiap.CondicoesAmbientais.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbl_CondicoesAmbiental")
public class CondicoesAmbientais {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TBL_CondicoesAmbiental_SEQ"
    )
    @SequenceGenerator(
            name = "TBL_CondicoesAmbiental_SEQ",
            sequenceName = "TBL_CondicoesAmbiental_SEQ",
            allocationSize = 1)
    private Long id;
    private String qualidadeAr;
    private String umidade;
    private String temperatura;
    private String contatoEmergencia;
    private String desastreNatural;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQualidadeAr() {
        return qualidadeAr;
    }

    public void setQualidadeAr(String qualidadeAr) {
        this.qualidadeAr = qualidadeAr;
    }

    public String getUmidade() {
        return umidade;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public String getDesastreNatural() {
        return desastreNatural;
    }

    public void setDesastreNatural(String desastreNatural) {
        this.desastreNatural = desastreNatural;
    }



    @Override
    public String toString() {
        return "CondicoesAmbiental{" +
                "id=" + id +
                ", qualidadeAr='" + qualidadeAr + '\'' +
                ", umidade=" + umidade +
                ", temperatura=" + temperatura +
                ", contatoEmergencia='" + contatoEmergencia + '\'' +
                ", desastreNatural='" + desastreNatural + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CondicoesAmbientais that = (CondicoesAmbientais) o;
        return Objects.equals(id, that.id) && Objects.equals(qualidadeAr, that.qualidadeAr) && Objects.equals(umidade, that.umidade) && Objects.equals(temperatura, that.temperatura) && Objects.equals(contatoEmergencia, that.contatoEmergencia) && Objects.equals(desastreNatural, that.desastreNatural);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qualidadeAr, umidade, temperatura, contatoEmergencia, desastreNatural);
    }
}
