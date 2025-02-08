-- Criação das Tabelas

CREATE TABLE Cliente (
    cliente_id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(255),
    telefone VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE Veiculo (
    veiculo_id INT PRIMARY KEY AUTO_INCREMENT,
    placa VARCHAR(10) UNIQUE NOT NULL,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    ano_fabricacao INT,
    ano_modelo INT,
    combustiveis VARCHAR(50)
);

CREATE TABLE Ordem_Servico (
    ordem_id INT PRIMARY KEY AUTO_INCREMENT,
    cliente_id INT,
    veiculo_id INT,
    data_emissao DATE,
    valor_total DECIMAL(10,2),
    situacao VARCHAR(20),
    FOREIGN KEY (cliente_id) REFERENCES Cliente(cliente_id),
    FOREIGN KEY (veiculo_id) REFERENCES Veiculo(veiculo_id)
);

CREATE TABLE Servico (
    servico_id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    valor DECIMAL(10,2),
    tempo_estimado VARCHAR(20)
);

CREATE TABLE Categoria_Peca (
    categoria_id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE Peca (
    peca_id INT PRIMARY KEY AUTO_INCREMENT,
    categoria_id INT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    quantidade_estoque INT,
    valor_custo DECIMAL(10,2),
    valor_venda DECIMAL(10,2),
    FOREIGN KEY (categoria_id) REFERENCES Categoria_Peca(categoria_id)
);

CREATE TABLE Profissional (
    profissional_id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE,
    email VARCHAR(100),
    telefone VARCHAR(20)
);

CREATE TABLE Especialidade (
    especialidade_id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE Profissional_Especialidade (
    profissional_id INT,
    especialidade_id INT,
    PRIMARY KEY (profissional_id, especialidade_id),
    FOREIGN KEY (profissional_id) REFERENCES Profissional(profissional_id),
    FOREIGN KEY (especialidade_id) REFERENCES Especialidade(especialidade_id)
);

CREATE TABLE Ordem_Servico_Servico (
    ordem_id INT,
    servico_id INT,
    profissional_id INT,
    PRIMARY KEY (ordem_id, servico_id),
    FOREIGN KEY (ordem_id) REFERENCES Ordem_Servico(ordem_id),
    FOREIGN KEY (servico_id) REFERENCES Servico(servico_id),
    FOREIGN KEY (profissional_id) REFERENCES Profissional(profissional_id)
);

CREATE TABLE Ordem_Servico_Peca (
    ordem_id INT,
    peca_id INT,
    quantidade INT,
    PRIMARY KEY (ordem_id, peca_id),
    FOREIGN KEY (ordem_id) REFERENCES Ordem_Servico(ordem_id),
    FOREIGN KEY (peca_id) REFERENCES Peca(peca_id)
);

CREATE TABLE Nota_Fiscal (
    nota_id INT PRIMARY KEY AUTO_INCREMENT,
    ordem_id INT,
    tipo VARCHAR(20), -- 'Serviço' ou 'Peça'
    data_emissao DATE,
    valor_total DECIMAL(10,2),
    FOREIGN KEY (ordem_id) REFERENCES Ordem_Servico(ordem_id)
);

CREATE TABLE Nota_Fiscal_Servico (
    nota_id INT,
    servico_id INT,
    quantidade INT,
    valor DECIMAL(10,2),
    PRIMARY KEY (nota_id, servico_id),
    FOREIGN KEY (nota_id) REFERENCES Nota_Fiscal(nota_id),
    FOREIGN KEY (servico_id) REFERENCES Servico(servico_id)
);

CREATE TABLE Nota_Fiscal_Peca (
    nota_id INT,
    peca_id INT,
    quantidade INT,
    valor DECIMAL(10,2),
    PRIMARY KEY (nota_id, peca_id),
    FOREIGN KEY (nota_id) REFERENCES Nota_Fiscal(nota_id),
    FOREIGN KEY (peca_id) REFERENCES Peca(peca_id)
);

-- Inserção de Dados

-- Inserir Cliente
INSERT INTO Cliente (nome, endereco, telefone, email) VALUES
('João R. Silva', 'Rua das Flores, 123, Bairro Jardim, São Paulo/SC - CEP 12345-678', '(11) 98765-4321', 'joaor.silva@email.com');

-- Inserir Veículo
INSERT INTO Veiculo (placa, marca, modelo, ano_fabricacao, ano_modelo, combustiveis) VALUES
('ABC-1234', 'Ford', 'Fiesta', 2015, 2016, 'Gasolina, Álcool');

-- Inserir Serviços
INSERT INTO Servico (nome, descricao, valor, tempo_estimado) VALUES
('Troca de Óleo', 'Substituição do óleo do motor e filtro.', 100.00, '1 hora'),
('Alinhamento e Balanceamento', 'Ajuste do alinhamento e balanceamento das rodas.', 120.00, '2 horas');

-- Inserir Categorias de Peças
INSERT INTO Categoria_Peca (nome) VALUES
('Motor'),
('Pneus');

-- Inserir Peças
INSERT INTO Peca (categoria_id, nome, descricao, quantidade_estoque, valor_custo, valor_venda) VALUES
(1, 'Filtro de Óleo', 'Filtro de óleo para motor', 10, 30.00, 50.00),
(1, 'Óleo motor 10/50', 'Óleo motor 10W-50', 50, 20.00, 50.00),
(2, 'Pneu 175/65R14', 'Pneu para rodas 175/65R14', 20, 300.00, 400.00);

-- Inserir Profissionais
INSERT INTO Profissional (nome, data_nascimento, email, telefone) VALUES
('Carlos A. Souza', '1985-05-20', 'carlos.souza@oficina.com', '(11) 91234-5678'),
('Maria T. Lima', '1990-08-15', 'maria.lima@oficina.com', '(11) 92345-6789');

-- Inserir Especialidades
INSERT INTO Especialidade (nome) VALUES
('Mecânica Geral'),
('Suspensão e Pneus');

-- Associar Profissionais às Especialidades
INSERT INTO Profissional_Especialidade (profissional_id, especialidade_id) VALUES
(1, 1), -- Carlos A. Souza - Mecânica Geral
(2, 2); -- Maria T. Lima - Suspensão e Pneus

-- Inserir Ordem de Serviço
INSERT INTO Ordem_Servico (cliente_id, veiculo_id, data_emissao, valor_total, situacao) VALUES
(1, 1, '2024-09-13', 1270.00, 'Finalizada');

-- Inserir Serviços na Ordem de Serviço
INSERT INTO Ordem_Servico_Servico (ordem_id, servico_id, profissional_id) VALUES
(1, 1, 1), -- Troca de Óleo executada por Carlos A. Souza
(1, 2, 2); -- Alinhamento e Balanceamento executado por Maria T. Lima

-- Inserir Peças na Ordem de Serviço
INSERT INTO Ordem_Servico_Peca (ordem_id, peca_id, quantidade) VALUES
(1, 1, 1), -- 1 Filtro de Óleo
(1, 2, 4), -- 4 Óleo motor 10/50
(1, 3, 2); -- 2 Pneu 175/65R14

-- Inserir Notas Fiscais
-- Nota Fiscal de Serviço
INSERT INTO Nota_Fiscal (ordem_id, tipo, data_emissao, valor_total) VALUES
(1, 'Serviço', '2024-09-13', 220.00);

-- Nota Fiscal de Peça
INSERT INTO Nota_Fiscal (ordem_id, tipo, data_emissao, valor_total) VALUES
(1, 'Peça', '2024-09-13', 1050.00);

-- Inserir Detalhes dos Serviços na Nota Fiscal de Serviço
INSERT INTO Nota_Fiscal_Servico (nota_id, servico_id, quantidade, valor) VALUES
(1, 1, 1, 100.00), -- Troca de Óleo
(1, 2, 1, 120.00); -- Alinhamento e Balanceamento

-- Inserir Detalhes das Peças na Nota Fiscal de Peça
INSERT INTO Nota_Fiscal_Peca (nota_id, peca_id, quantidade, valor) VALUES
(2, 1, 1, 50.00), -- Filtro de Óleo
(2, 2, 4, 50.00), -- Óleo motor 10/50
(2, 3, 2, 400.00); -- Pneu 175/65R14

-- Consultas para Verificar os Dados Inseridos

-- Clientes
SELECT * FROM Cliente;

-- Veículos
SELECT * FROM Veiculo;

-- Profissionais
SELECT * FROM Profissional;

-- Especialidades
SELECT * FROM Especialidade;

-- Ordem de Serviço
SELECT * FROM Ordem_Servico;

-- Serviços
SELECT * FROM Servico;

-- Peças
SELECT * FROM Peca;

-- Notas Fiscais
SELECT * FROM Nota_Fiscal;

-- Relações
SELECT * FROM Ordem_Servico_Servico;
SELECT * FROM Ordem_Servico_Peca;
SELECT * FROM Nota_Fiscal_Servico;
SELECT * FROM Nota_Fiscal_Peca;
