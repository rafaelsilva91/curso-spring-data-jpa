package io.github.rafaelsilva91.locallizacao.domain.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cidades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cidade", length = 100)
    private String cidade;

    @Column(name = "qtd_habitantes")
    private Long habitantes;
}
