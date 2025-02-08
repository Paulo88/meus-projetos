-- Criação das tabelas
CREATE TABLE Aluno (
    id_aluno int NOT NULL,
    nome varchar(50) NOT NULL,
    data_nascimento varchar(50) NOT NULL,
    endereco varchar(50) NOT NULL,
    telefone varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    genero varchar(50) NOT NULL,
    peso varchar(50) NOT NULL,
    altura varchar(50) NOT NULL,
    escolaridade varchar(50) NOT NULL,
    profissao varchar(50) NOT NULL,
    cartao_identificacao varchar(50) NOT NULL,
    CONSTRAINT Aluno_pk PRIMARY KEY (id_aluno)
);

CREATE TABLE Instrutor (
    Id_instrutor int NOT NULL,
    nome varchar(50) NOT NULL,
    data_nascimento varchar(50) NOT NULL,
    endereco varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    telefone varchar(50) NOT NULL,
    Modalidade_id_modalidade int NOT NULL,
    CONSTRAINT Instrutor_pk PRIMARY KEY (Id_instrutor)
);

CREATE TABLE Matricula (
    Id_matricula int NOT NULL,
    data_matricula varchar(50) NOT NULL,
    Aluno_id_aluno int NOT NULL,
    Turma_id_turma int NOT NULL,
    CONSTRAINT Matricula_pk PRIMARY KEY (Id_matricula)
);

CREATE TABLE Modalidade (
    id_modalidade int NOT NULL,
    nome_modalidade varchar(50) NOT NULL,
    CONSTRAINT Modalidade_pk PRIMARY KEY (id_modalidade)
);

CREATE TABLE Plano (
    id_plano int NOT NULL,
    descricao varchar(50) NOT NULL,
    valor_mensal varchar(50) NOT NULL,
    valor_trimestral varchar(50) NOT NULL,
    valor_semestral varchar(50) NOT NULL,
    valor_anual varchar(50) NOT NULL,
    total_turmas varchar(50) NOT NULL,
    Aluno_id_aluno int NOT NULL,
    CONSTRAINT Plano_pk PRIMARY KEY (id_plano)
);

CREATE TABLE Presenca (
    Id_presenca int NOT NULL,
    data varchar(50) NOT NULL,
    horario varchar(50) NOT NULL,
    Aluno_id_aluno int NOT NULL,
    Turma_id_turma int NOT NULL,
    CONSTRAINT Presenca_pk PRIMARY KEY (Id_presenca)
);

CREATE TABLE Turma (
    id_turma int NOT NULL,
    dia_semana varchar(50) NOT NULL,
    horario_inicio varchar(50) NOT NULL,
    duracao varchar(50) NOT NULL,
    vagas varchar(50) NOT NULL,
    descritivo varchar(50) NOT NULL,
    Modalidade_id_modalidade int NOT NULL,
    Instrutor_Id_instrutor int NOT NULL,
    CONSTRAINT Turma_pk PRIMARY KEY (id_turma)
);

-- Dados dos alunos da academia
INSERT INTO Aluno (id_aluno, nome, data_nascimento, endereco, telefone, email, genero, peso, altura, escolaridade, profissao, cartao_identificacao)
VALUES
(1, 'João Silva', '1990-05-15', 'Rua A, 123', '1234567890', 'joao.silva@example.com', 'Masculino', '80kg', '1.80m', 'Superior Completo', 'Engenheiro', '123456789'),
(2, 'Maria Oliveira', '1985-08-20', 'Rua B, 456', '0987654321', 'maria.oliveira@example.com', 'Feminino', '65kg', '1.70m', 'Superior Completo', 'Arquiteta', '987654321'),
(3, 'Pedro Santos', '1992-11-10', 'Rua C, 789', '1122334455', 'pedro.santos@example.com', 'Masculino', '75kg', '1.75m', 'Médio Completo', 'Técnico', '112233445'),
(4, 'Ana Pereira', '1997-02-25', 'Rua D, 101', '2233445566', 'ana.pereira@example.com', 'Feminino', '55kg', '1.60m', 'Médio Completo', 'Assistente', '223344556'),
(5, 'Carlos Almeida', '1988-09-05', 'Rua E, 202', '3344556677', 'carlos.almeida@example.com', 'Masculino', '85kg', '1.85m', 'Superior Completo', 'Analista', '334455667');

INSERT INTO Modalidade (id_modalidade, nome_modalidade)
VALUES
(1, 'Musculação'),
(2, 'Yoga'),
(3, 'Pilates'),
(4, 'Natação'),
(5, 'Dança');

INSERT INTO Instrutor (Id_instrutor, nome, data_nascimento, endereco, email, telefone, Modalidade_id_modalidade)
VALUES
(1, 'Lucas Rocha', '1980-01-10', 'Rua F, 303', 'lucas.rocha@example.com', '4455667788', 1),
(2, 'Juliana Costa', '1982-04-18', 'Rua G, 404', 'juliana.costa@example.com', '5566778899', 2),
(3, 'Marcelo Fernandes', '1978-06-22', 'Rua H, 505', 'marcelo.fernandes@example.com', '6677889900', 3),
(4, 'Patrícia Lima', '1990-12-15', 'Rua I, 606', 'patricia.lima@example.com', '7788990011', 4),
(5, 'Roberto Silva', '1986-03-12', 'Rua J, 707', 'roberto.silva@example.com', '8899001122', 5);

INSERT INTO Turma (id_turma, dia_semana, horario_inicio, duracao, vagas, descritivo, Modalidade_id_modalidade, Instrutor_Id_instrutor)
VALUES
(1, 'Segunda-feira', '08:00', '1h', '10', 'Aula de musculação para iniciantes', 1, 1),
(2, 'Terça-feira', '10:00', '1h', '12', 'Aula de yoga para todos os níveis', 2, 2),
(3, 'Quarta-feira', '15:00', '1h30', '8', 'Pilates para força e flexibilidade', 3, 3),
(4, 'Quinta-feira', '09:00', '1h', '10', 'Natação para condicionamento físico', 4, 4),
(5, 'Sexta-feira', '18:00', '1h30', '15', 'Dança para entretenimento e fitness', 5, 5);

INSERT INTO Matricula (Id_matricula, data_matricula, Aluno_id_aluno, Turma_id_turma)
VALUES
(1, '2024-09-01', 1, 1),
(2, '2024-09-02', 2, 2),
(3, '2024-09-03', 3, 3),
(4, '2024-09-04', 4, 4),
(5, '2024-09-05', 5, 5);

INSERT INTO Plano (id_plano, descricao, valor_mensal, valor_trimestral, valor_semestral, valor_anual, total_turmas, Aluno_id_aluno)
VALUES
(1, 'Plano Básico', '100', '270', '500', '900', '3', 1),
(2, 'Plano Intermediário', '150', '400', '750', '1400', '4', 2),
(3, 'Plano Avançado', '200', '500', '1000', '1900', '5', 3),
(4, 'Plano Premium', '250', '600', '1200', '2200', '6', 4),
(5, 'Plano Elite', '300', '700', '1400', '2500', '7', 5);

INSERT INTO Presenca (Id_presenca, data, horario, Aluno_id_aluno, Turma_id_turma)
VALUES
(1, '2024-09-01', '08:00', 1, 1),
(2, '2024-09-02', '10:00', 2, 2),
(3, '2024-09-03', '15:00', 3, 3),
(4, '2024-09-04', '09:00', 4, 4),
(5, '2024-09-05', '18:00', 5, 5);

-- Consultar os dados e visualizar
SELECT * FROM Aluno;
SELECT * FROM Instrutor;
SELECT * FROM Matricula;
SELECT * FROM Modalidade;
SELECT * FROM Plano;
SELECT * FROM Presenca;
SELECT * FROM Turma;
