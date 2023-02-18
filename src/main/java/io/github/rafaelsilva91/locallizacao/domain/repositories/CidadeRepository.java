package io.github.rafaelsilva91.locallizacao.domain.repositories;

import io.github.rafaelsilva91.locallizacao.domain.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByCidade(String cidade);

    List<Cidade> findByCidadeStartingWith(String cidade);

    List<Cidade> findByCidadeEndingWith(String cidade);

    List<Cidade> findByCidadeContaining(String cidade);

    List<Cidade> findByHabitantes(Long value);
}
