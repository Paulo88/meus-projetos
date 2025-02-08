-- Tabela: municipio
CREATE TABLE municipio (
    cd_municipio INT AUTO_INCREMENT PRIMARY KEY,
    nm_municipio VARCHAR(50),
    sg_uf CHAR(2)
);

-- Tabela: endereco
CREATE TABLE endereco (
    cd_endereco INT AUTO_INCREMENT PRIMARY KEY,
    ds_logradouro VARCHAR(50),
    ds_complemento VARCHAR(50),
    nm_bairro VARCHAR(30),
    nr_cep CHAR(8),
    cd_municipio INT,
    FOREIGN KEY (cd_municipio) REFERENCES municipio(cd_municipio)
);

-- Tabela: contato (para normalizar telefones e emails)
CREATE TABLE contato (
    cd_contato INT AUTO_INCREMENT PRIMARY KEY,
    nr_telefone VARCHAR(15),
    ds_email VARCHAR(50)
);

-- Tabela: cliente
CREATE TABLE cliente (
    cd_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nm_cliente VARCHAR(50),
    dt_nascimento DATE,
    cd_endereco INT,
    cd_contato INT,
    FOREIGN KEY (cd_endereco) REFERENCES endereco(cd_endereco),
    FOREIGN KEY (cd_contato) REFERENCES contato(cd_contato)
);

-- Tabela: prestador_servico
CREATE TABLE prestador_servico (
    cd_prestador INT AUTO_INCREMENT PRIMARY KEY,
    nm_prestador VARCHAR(50),
    cd_endereco INT,
    cd_contato INT,
    FOREIGN KEY (cd_endereco) REFERENCES endereco(cd_endereco),
    FOREIGN KEY (cd_contato) REFERENCES contato(cd_contato)
);

-- Tabela: servico
CREATE TABLE servico (
    cd_servico INT AUTO_INCREMENT PRIMARY KEY,
    ds_servico VARCHAR(50),
    vl_servico DECIMAL(8,2)
);

-- Tabela: servico_prestador
CREATE TABLE servico_prestador (
    cd_prestador INT,
    cd_servico INT,
    PRIMARY KEY (cd_prestador, cd_servico),
    FOREIGN KEY (cd_prestador) REFERENCES prestador_servico(cd_prestador),
    FOREIGN KEY (cd_servico) REFERENCES servico(cd_servico)
);

-- Tabela: agendamento
CREATE TABLE agendamento (
    nr_agendamento INT AUTO_INCREMENT PRIMARY KEY,
    dt_agendamento DATE,
    hr_agendamento TIME,
    cd_prestador INT,
    cd_cliente INT,
    FOREIGN KEY (cd_prestador) REFERENCES prestador_servico(cd_prestador),
    FOREIGN KEY (cd_cliente) REFERENCES cliente(cd_cliente)
);

-- Tabela: agendamento_servico
CREATE TABLE agendamento_servico (
    nr_agendamento INT,
    cd_servico INT,
    qt_servico INT,
    vl_servico DECIMAL(8,2),
    PRIMARY KEY (nr_agendamento, cd_servico),
    FOREIGN KEY (nr_agendamento) REFERENCES agendamento(nr_agendamento),
    FOREIGN KEY (cd_servico) REFERENCES servico(cd_servico)
);

-- Tabela: categoria
CREATE TABLE categoria (
    cd_categoria INT AUTO_INCREMENT PRIMARY KEY,
    ds_categoria VARCHAR(50)
);

-- Tabela: produto
CREATE TABLE produto (
    cd_produto INT AUTO_INCREMENT PRIMARY KEY,
    nm_produto VARCHAR(50),
    ds_produto VARCHAR(50),
    vl_custo DECIMAL(8,2),
    vl_venda DECIMAL(8,2),
    qt_estoque INT,
    cd_categoria INT,
    FOREIGN KEY (cd_categoria) REFERENCES categoria(cd_categoria)
);

-- Tabela: item_nota_fiscal
CREATE TABLE item_nota_fiscal (
    nr_nota_fiscal INT,
    cd_produto INT,
    qt_produto INT,
    vl_produto DECIMAL(8,2),
    PRIMARY KEY (nr_nota_fiscal, cd_produto),
    FOREIGN KEY (nr_nota_fiscal) REFERENCES nota_fiscal(nr_nota_fiscal),
    FOREIGN KEY (cd_produto) REFERENCES produto(cd_produto)
);

-- Tabela: nota_fiscal
CREATE TABLE nota_fiscal (
    nr_nota_fiscal INT AUTO_INCREMENT PRIMARY KEY,
    dt_emissao DATE,
    vl_total DECIMAL(8,2),
    cd_cliente INT,
    FOREIGN KEY (cd_cliente) REFERENCES cliente(cd_cliente)
);

-- Tabela: especie
CREATE TABLE especie (
    cd_especie INT AUTO_INCREMENT PRIMARY KEY,
    nm_especie VARCHAR(30)
);

-- Tabela: raca
CREATE TABLE raca (
    cd_raca INT AUTO_INCREMENT PRIMARY KEY,
    nm_raca VARCHAR(50),
    cd_especie INT,
    FOREIGN KEY (cd_especie) REFERENCES especie(cd_especie)
);

-- Tabela: animal
CREATE TABLE animal (
    cd_animal INT AUTO_INCREMENT PRIMARY KEY,
    nm_animal VARCHAR(50),
    ds_animal VARCHAR(50),
    dt_nascimento DATE,
    tp_porte CHAR(1),
    cd_raca INT,
    cd_cliente INT,
    FOREIGN KEY (cd_raca) REFERENCES raca(cd_raca),
    FOREIGN KEY (cd_cliente) REFERENCES cliente(cd_cliente)
);


-- Inserindo dados fictícios em municipio
INSERT INTO municipio (nm_municipio, sg_uf) VALUES ('Blumenau', 'SC'), ('Florianópolis', 'SC'), ('Curitiba', 'PR'), ('São Paulo', 'SP'), ('Rio de Janeiro', 'RJ');

-- Inserindo dados fictícios em endereco
INSERT INTO endereco (ds_logradouro, ds_complemento, nm_bairro, nr_cep, cd_municipio) 
VALUES ('Rua das Flores', 'Apto 101', 'Centro', '89010000', 1),
       ('Av. Paulista', 'Sala 302', 'Bela Vista', '01310100', 4),
       ('Rua XV de Novembro', 'Casa 10', 'Glória', '80230000', 3),
       ('Rua Silva Jardim', 'Apto 203', 'Copacabana', '22010000', 5),
       ('Rua Independência', 'Casa 5', 'Vila Nova', '88030300', 2);

-- Inserindo dados fictícios em contato
INSERT INTO contato (nr_telefone, ds_email) 
VALUES ('47999999999', 'cliente1@gmail.com'), 
       ('1133445566', 'prestador1@empresa.com'), 
       ('41988887777', 'cliente2@yahoo.com'), 
       ('21977778888', 'cliente3@hotmail.com'), 
       ('48988884444', 'prestador2@empresa.com');

-- Inserindo dados fictícios em cliente
INSERT INTO cliente (nm_cliente, dt_nascimento, cd_endereco, cd_contato) 
VALUES ('João Silva', '1990-05-10', 1, 1), 
       ('Maria Fernandes', '1985-11-15', 2, 3),
       ('Carlos Souza', '1978-02-20', 3, 4);

-- Inserindo dados fictícios em prestador_servico
INSERT INTO prestador_servico (nm_prestador, cd_endereco, cd_contato)
VALUES ('Empresa A', 2, 2),
       ('Empresa B', 5, 5);

-- Inserindo dados fictícios em servico
INSERT INTO servico (ds_servico, vl_servico) 
VALUES ('Banho e Tosa', 80.00), 
       ('Consulta Veterinária', 150.00), 
       ('Vacinação', 50.00);

-- Inserindo dados fictícios em servico_prestador
INSERT INTO servico_prestador (cd_prestador, cd_servico) 
VALUES (1, 1), 
       (1, 2), 
       (2, 3);

-- Inserindo dados fictícios em agendamento
INSERT INTO agendamento (dt_agendamento, hr_agendamento, cd_prestador, cd_cliente) 
VALUES ('2024-11-01', '10:00:00', 1, 1), 
       ('2024-11-02', '14:30:00', 2, 2);

-- Inserindo dados fictícios em agendamento_servico
INSERT INTO agendamento_servico (nr_agendamento, cd_servico, qt_servico, vl_servico) 
VALUES (1, 1, 1, 80.00), 
       (1, 2, 1, 150.00), 
       (2, 3, 2, 100.00);
