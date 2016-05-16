USE LojaNinja;

CREATE TABLE Usuario(
    id int IDENTITY UNIQUE NOT NULL,
    nome varchar(100) NOT NULL,
    email varchar(250) UNIQUE NOT NULL,
    senha varchar(100) NOT NULL,
	PRIMARY KEY (id)	
);

CREATE TABLE Permissao(
    id int IDENTITY UNIQUE NOT NULL,
    nome varchar(100) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE UsuarioPorPermissao(
    id int IDENTITY UNIQUE NOT NULL,
    idUsuario int NOT NULL,
	idPermissao int NOT NULL
);

INSERT INTO Usuario 
(nome, email, senha)
VALUES
('Administrador', 'admin@admin.com', '63874adc5789a6e2e1fc51e40871dd53');

INSERT INTO Permissao
(nome)
VALUES 
('ADMIN');

INSERT INTO UsuarioPorPermissao
(idUsuario, idPermissao)
VALUES
(1, 2);

SELECT * FROM Usuario;

SELECT * FROM Permissao;

SELECT * FROM UsuarioPorPermissao;