package io.github.rafaelsilva91.locallizacao;

import io.github.rafaelsilva91.locallizacao.domain.entities.Cidade;
import io.github.rafaelsilva91.locallizacao.domain.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LocalizacaoApplication{

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}
}
