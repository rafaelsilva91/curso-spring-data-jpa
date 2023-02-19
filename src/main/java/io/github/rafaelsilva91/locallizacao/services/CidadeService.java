package io.github.rafaelsilva91.locallizacao.services;

import io.github.rafaelsilva91.locallizacao.domain.entities.Cidade;
import io.github.rafaelsilva91.locallizacao.domain.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional
    public List<Cidade> findAll(){
        List<Cidade> list = cidadeRepository.findAll();

        if(!list.isEmpty()){
            return list;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Objetos não encontrados na base de dados!");
    }

    @Transactional
    public Cidade save(Cidade objeto){
        return cidadeRepository.save(objeto);
    }

    @Transactional
    public List<Cidade> findByCidades(String cidade){
        return cidadeRepository.findByCidade(cidade);
    }

    public List<Cidade> findByCidadesPage(String cidade){
        Pageable pageable = PageRequest.of(0,3);
        return cidadeRepository.findByCidadeLike(cidade,pageable).toList();
    }


    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> exemple = Example.of(cidade, matcher) ;

        System.out.println("BEGIN");
        imprimirNoConsoleFiltroDinamico(exemple);
        System.out.println("END");

        return cidadeRepository.findAll(exemple);
    }

    public void imprimirNoConsoleFiltroDinamico(Example exemple){
        System.out.println();
        cidadeRepository.findAll(exemple).forEach(System.out::println);
        System.out.println();

    }

    @Transactional
    public List<Cidade> findByHabitantes(Long value){
        return cidadeRepository.findByHabitantes(value);
    }

    public void imprimirNoConsole(String filtro){
        System.out.println();

        System.out.println("StratingWith");
        cidadeRepository.findByCidadeStartingWith(filtro).forEach(System.out::println);
        System.out.println();

        System.out.println("EndingWith");
        cidadeRepository.findByCidadeEndingWith(filtro).forEach(System.out::println);
        System.out.println();

        System.out.println("Containing");
        cidadeRepository.findByCidadeContaining(filtro).forEach(System.out::println);
        System.out.println();

        System.out.println("Like Ordenacao");
        cidadeRepository.findByCidadeLike("%"+filtro+"%", Sort.by("habitantes")).forEach(System.out::println);
        System.out.println();

        System.out.println("Like Paginacao");
        Pageable pageable = PageRequest.of(0, 3);
        cidadeRepository.findByCidadeLike("%"+filtro+"%", pageable).forEach(System.out::println);
        System.out.println();

    }

    public void imprimirNoConsoleHabitantes(Long value){
        System.out.println();
        System.out.println("ByHabitantes");
        cidadeRepository.findByHabitantes(value).forEach(System.out::println);
        System.out.println();

        System.out.println("LessThan < ");
        cidadeRepository.findByHabitantesLessThan(value).forEach(System.out::println);
        System.out.println();

        System.out.println("GreaterThan > ");
        cidadeRepository.findByHabitantesGreaterThan(value).forEach(System.out::println);
        System.out.println();

        System.out.println("LessThanEqual <= ");
        cidadeRepository.findByHabitantesLessThanEqual(value).forEach(System.out::println);
        System.out.println();

        System.out.println("GreaterThan >= ");
        cidadeRepository.findByHabitantesGreaterThanEqual(value).forEach(System.out::println);
        System.out.println();


        System.out.println("LessThanAndCidadeLike >= ");
        cidadeRepository.findByHabitantesLessThanAndCidadeLike(value, "Br%").forEach(System.out::println);
        System.out.println();


    }


}
