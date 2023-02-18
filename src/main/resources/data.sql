create table tb_cidades(
    id bigint primary key auto_increment,
    cidade varchar(50) not null,
    qtd_habitantes bigint not null
);

insert into tb_cidades
    (cidade, qtd_habitantes)
values
    ('São Paulo', 12033372),
    ('Rio de Janeiro', 6748000),
    ('Fortaleza', 8000000),
    ('Salvador', 7000000),
    ('Belo Horizonte', 6000000),
    ('Porto Alegre', 7770000),
    ('Porto Velho', 4948989),
    ('Palmas', 78787900),
    ('Recife', 23234788),
    ('Natal', 78978979),
    ('Brasilia', 12123132);