package br.com.fiap.CondicoesAmbientais.repository;

import br.com.fiap.CondicoesAmbientais.model.CondicoesAmbientais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondicoesAmbientaisRepository extends JpaRepository<CondicoesAmbientais, Long> {
}
