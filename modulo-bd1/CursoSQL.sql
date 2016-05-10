create table Empregado (
 IDEmpregado    int not null
,NomeEmpregado  varchar(30) not null
,Cargo          varchar(15) not null
,IDGerente      int null
,DataAdmissao   datetime not null
,Salario        decimal(7,2) not null
,Comissao       decimal(7,2)
,IDDepartamento int
);

insert into Empregado values (7369 ,'SMITH', 'Atendente', '7902', convert(datetime, '1980/12/17', 111), 800, null, 20);
insert into Empregado values (7499 ,'ALLEN', 'Vendedor', '7698', convert(datetime, '1981/02/20', 111), 1600, 300, 30);
insert into Empregado values (7521 ,'WARD', 'Vendedor', '7698', convert(datetime, '1981/02/22', 111), 1250, 500, 30);
insert into Empregado values (7566 ,'JONES', 'Gerente', '7839', convert(datetime, '1981/04/02', 111), 2975, null, 20);
insert into Empregado values (7654 ,'MARTIN', 'Vendedor', '7698', convert(datetime, '1981/09/28', 111), 1250, 1400, 30);
insert into Empregado values (7698 ,'BLAKE', 'Gerente', '7839', convert(datetime, '1981/05/01', 111), 2850, null, 30);
insert into Empregado values (7782 ,'CLARK', 'Gerente', '7839', convert(datetime, '1981/06/09', 111), 2450, null, 10);
insert into Empregado values (7788 ,'SCOTT', 'Analista', '7566', convert(datetime, '1982/12/09', 111), 3000, null, 20);
insert into Empregado values (7839 ,'KING', 'Presidente', null, convert(datetime, '1981/11/17', 111), 5000, null, null);
insert into Empregado values (7844 ,'TURNER', 'Vendedor', '7698', convert(datetime, '1981/09/08', 111), 1500, 0, 30);
insert into Empregado values (7876 ,'ADAMS', 'Atendente', '7788', convert(datetime, '1983/01/12', 111), 1100, null, 20);
insert into Empregado values (7900 ,'JAMES', 'Atendente', '7698', convert(datetime, '1981/12/03', 111), 950, null, 30);
insert into Empregado values (7902 ,'FORD', 'Analista', '7566', convert(datetime, '1981/12/03', 111), 3000, null, 20);
insert into Empregado values (7934 ,'MILLER', 'Atendente', '7782', convert(datetime, '1982/01/23', 111), 1300, null, 10);
insert into Empregado values (7940 ,'ANDREW', 'Atendente', '7782', convert(datetime, '1988/01/20', 111), 1150, null, null);

create table Departamento (
 IDDepartamento   int not null
,NomeDepartamento varchar(30)
,Localizacao      varchar(25)
);

insert into Departamento values (10,'Contabilidade', 'SAO PAULO');
insert into Departamento values (20,'Pesquisa', 'SAO LEOPOLDO');
insert into Departamento values (30,'Vendas', 'SAO PAULO');
insert into Departamento values (40,'Operações', 'RECIFE');
insert into Departamento values (1, 'Presidência', 'RIBEIRAO PRETO');
insert into Departamento values (60, 'Tecnologia', 'PORTO ALEGRE');

---------
ALTER TABLE Departamento ADD  CONSTRAINT PK_departamento 
  PRIMARY KEY  
  (IDDepartamento);

ALTER TABLE Empregado ADD  CONSTRAINT PK_Empregado
  PRIMARY KEY  
  (IDEmpregado);

ALTER TABLE Empregado ADD CONSTRAINT FK_Empregado_Departamento
  FOREIGN KEY (IDDepartamento) REFERENCES Departamento (IDDepartamento);

CREATE INDEX IX_Empregado_Departamento ON Empregado (IDDepartamento);

SELECT 
NomeEmpregado	as	Nome,
salario			as	SalarioMensal,
(salario*12)	as	SalarioAnual
FROM Empregado;

SELECT
IDEmpregado, 
NomeEmpregado	as	Nome,
salario			as	SalarioMensal,
(salario*12)	as	SalarioAnual
FROM Empregado
WHERE IDEmpregado in (7369, 7499, 7566);

SELECT
IDEmpregado, 
NomeEmpregado	as	Nome,
salario			as	SalarioMensal,
(salario*12)	as	SalarioAnual
FROM Empregado
WHERE IDEmpregado = 7369
OR IDEmpregado = 7499
OR IDEmpregado = 7566;

SELECT
IDEmpregado, 
NomeEmpregado	as	Nome,
salario			as	SalarioMensal,
(salario*12)	as	SalarioAnual
FROM Empregado
WHERE IDEmpregado BETWEEN 1000 AND 8000
AND Salario > 2000;

SELECT * FROM Empregado;

SELECT * FROM Cidade;

SELECT NomeEmpregado			   --Exercício 1
FROM Empregado
ORDER BY DataAdmissao ASC;

SELECT NomeEmpregado, Salario	   --Exercício 2
FROM Empregado
WHERE Cargo = 'Atendente'
OR Salario < 18.500;

SELECT IDCidade					   --Exercício 3	
FROM Cidade
WHERE Nome = 'Uberlândia';

SELECT IDCidade, Nome as Municipio --Exercício 4
FROM Cidade
WHERE UF = 'RS';

SELECT COUNT(IDEmpregado) NumeroEmpregados
FROM Empregado;

SELECT COUNT(Comissao) -- Contou todas as linhas Comissao que possuiam valor
FROM Empregado;

SELECT 
MAX(salario) MaiorSalario,
MIN(salario) MenorSalario 
FROM Empregado;

Select Cargo, 
COUNT(1) as Total 
From Empregado 
Group By Cargo;

SELECT NomeEmpregado,
Salario,
ISNULL(Comissao, 0) as Comissao,			-- Se for null, atribui 0 a Comissao
(Salario + ISNULL(Comissao, 0)) as Total_Salario
From Empregado;

SELECT Nome,
REPLACE(Nome, 'A', 'É') primeiro_replace,
UF
FROM Cidade;

select IDAssociado, Nome, 
Case when sexo = 'F' then 'Feminino' 
when sexo = 'M' then 'Masculino' 
else 'sei lá' End as Genero from associado;

Select SUBSTRING(Nome, 1, 3) as NomeCidade, UF From CIDADE Order by NomeCidade;

SELECT SUBSTRING(Nome, 1, CHARINDEX(' ', Nome, 1) - 1) as Nome FROM Associado Order By Nome ASC; --Exercício 1

SELECT																							 --Exercício 2
Nome,
DATEDIFF(Year, DataNascimento, GETDATE()) as Idade 
From Associado;

SELECT																							 --Exercício 3
NomeEmpregado,
DATEDIFF(MONTH, DataAdmissao, GETDATE()) as MesesDeTrabalho
FROM Empregado
Where DataAdmissao BETWEEN ('1980-05-01') AND ('1982-01-20');

SELECT TOP 1 Cargo, COUNT(1) as CargoComMaisEmpregados											 --Exercício 4
FROM Empregado
GROUP BY Cargo
ORDER BY CargoComMaisEmpregados DESC;

SELECT * FROM Associado;

SELECT																							 --Exercício 6
Nome,
DATEADD(YEAR, 50, DataNascimento) as DataQueCompletou50Anos,
DATEPART(WEEKDAY, DATEADD(YEAR, 50, DataNascimento)) as DiaDaSemana
FROM Associado;

