package io.github.rafaelsilva91.locallizacao.domain.repositories;

import io.github.rafaelsilva91.locallizacao.domain.entities.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByCidade(String cidade);
    List<Cidade> findByCidadeStartingWith(String cidade);
    List<Cidade> findByCidadeEndingWith(String cidade);
    List<Cidade> findByCidadeContaining(String cidade);

    //ordenacao
    @Query(" select c from Cidade c where upper(c.cidade) like upper(?1) ")
    List<Cidade> findByCidadeLike(String cidade, Sort sort);

    //paginacao
    @Query(" select c from Cidade c where upper(c.cidade) like upper(?1) ")
    Page<Cidade> findByCidadeLike(String cidade, Pageable pageable);

    List<Cidade> findByHabitantes(Long value);
    List<Cidade> findByHabitantesLessThan(Long value);
    List<Cidade> findByHabitantesGreaterThan(Long value);

    List<Cidade> findByHabitantesLessThanEqual(Long value);
    List<Cidade> findByHabitantesGreaterThanEqual(Long value);

    List<Cidade> findByHabitantesLessThanAndCidadeLike(Long value, String cidade);

}
