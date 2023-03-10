package io.github.rafaelsilva91.locallizacao.controllers;

import io.github.rafaelsilva91.locallizacao.domain.entities.Cidade;
import io.github.rafaelsilva91.locallizacao.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cidades")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cidade> findAll(){
        List<Cidade> list = service.findAll();
        return list;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade save(@RequestBody Cidade request) {
        Cidade cidade = service.save(request);
        return cidade;
    }

    @GetMapping("/filtro/cidade/{cidade}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cidade> findByCidades(@PathVariable String cidade){
        List<Cidade> cidades = service.findByCidades(cidade);
        service.findByCidades(cidade).forEach(System.out::println);
        return cidades;
    }

    @GetMapping("/filtro/{filtro}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cidade> findByFilter(@PathVariable String filtro){
        List<Cidade> cidades = service.findByCidades(filtro);

        System.out.println("BEGIN");
        service.imprimirNoConsole(filtro);
        System.out.println("END");

        return cidades;
    }

    @GetMapping("/page/{filtro}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cidade> findByFilterPage(@PathVariable String filtro){
        List<Cidade> cidades = service.findByCidadesPage(filtro);

        System.out.println("BEGIN");
        service.imprimirNoConsole(filtro);
        System.out.println("END");

        return cidades;
    }


    @GetMapping("/filtro/habitantes/{habitantes}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cidade> findByHabitantes(@PathVariable Long habitantes){
        List<Cidade> cidades = service.findByHabitantes(habitantes);
        service.findByHabitantes(habitantes).forEach(System.out::println);
        return cidades;
    }


    @GetMapping("/filtro/habitantes/filter/{value}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cidade> findByHabitantesFilters(@PathVariable Long value){
        List<Cidade> cidades = service.findByHabitantes(value);

        System.out.println("BEGIN");
        service.imprimirNoConsoleHabitantes(value);
        System.out.println("END");

        return cidades;
    }

    @GetMapping("/dinamico")
    @ResponseStatus(HttpStatus.OK)
    public List<Cidade> findByFilterdinamico(@RequestBody Cidade request){
        List<Cidade> cidades = service.filtroDinamico(request);

        return cidades;
    }


}
