CREATE TABLE Cidade2(
idCidade	INT				NOT NULL,
nome		VARCHAR(30)		NOT NULL,
uf			VARCHAR(2)		NOT NULL,
CONSTRAINT PK_Cidade PRIMARY KEY(idCidade)
);

INSERT INTO Cidade (idCidade, nome, uf) VALUES (1, 'São Leopoldo', 'RS');

ALTER TABLE Cidade ADD
CONSTRAINT PK_Cidade PRIMARY KEY (idCidade);

INSERT INTO Cidade VALUES (2, 'Esteio', 'RS');

SELECT * FROM Cidade;

CREATE TABLE Cliente (
idCliente	INT			IDENTITY	NOT NULL,
nome		VARCHAR(30)				NOT NULL,
endereco	VARCHAR(30),
bairro		VARCHAR(30),
idCidade	INT
);

INSERT INTO Cliente (nome) VALUES ('Maria');

SELECT * FROM Cliente;

Create table Cidade (
idCidade   int			NOT NULL, 
nome       varchar(30)	NOT NULL, 
uf         varchar(2)	NOT NULL, 
constraint PK_Cidade    
Primary Key (idCidade), 
constraint UK_Cidade_Nome Unique (nome));

INSERT INTO Cidade (idCidade, nome, uf) VALUES (1, 'São Leopoldo', 'RS');

INSERT INTO Cidade (idCidade, nome, uf) VALUES (2, 'São Leopoldo', 'RS'); ---Testando erro

SELECT nome FROM Cidade WHERE idCidade = 1;

Create table Empregado( 
idEmpregado		INT			NOT NULL, 
nome			VARCHAR(50) NOT NULL, 
sexo			CHAR(1)		NOT NULL,
idCidade		INT			NOT NULL, 
constraint PK_Empregado Primary Key (idEmpregado), 
constraint CC_Empregado_Sexo  Check (Sexo in ('F','M')), 
constraint FK_Empregado_Cidade Foreign Key (idCidade) References Cidade(idCidade));

exec SP_HELP 'Empregado';

SELECT * FROM Cidade;

INSERT INTO Empregado
(idEmpregado, nome, sexo, idCidade)
VALUES
(1, 'Maria', 'F', 1);


