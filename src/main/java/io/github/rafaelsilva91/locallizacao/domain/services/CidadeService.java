package io.github.rafaelsilva91.locallizacao.domain.services;

import io.github.rafaelsilva91.locallizacao.domain.entities.Cidade;
import io.github.rafaelsilva91.locallizacao.domain.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

        System.out.println("Like");
        cidadeRepository.findByCidadeLike("%"+filtro+"%").forEach(System.out::println);
        System.out.println();
    }


}
