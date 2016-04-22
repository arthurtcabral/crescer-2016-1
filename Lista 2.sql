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

Select SUBSTRING(Nome, 1, 3) as NomeCidade, UF From CIDADE Order by NomeCidade


SELECT SUBSTRING(Nome, 1, CHARINDEX(' ', Nome, 1) - 1) as Nome FROM Associado Order By Nome ASC; 											 --Exercício 1

SELECT																							 --Exercício 2
Nome,
DATEDIFF(Year, DataNascimento, GETDATE()) as Idade 
From Associado;

SELECT																							 --Exercício 3
NomeEmpregado,
DATEDIFF(MONTH, DataAdmissao, GETDATE()) as MesesDeTrabalho
FROM Empregado
Where DataAdmissao BETWEEN ('1980-05-01') AND ('1982-01-20');

SELECT TOP 1 Cargo, COUNT(1) as CargoComMaisEmpregados											 						 --Exercício 4
FROM Empregado
GROUP BY Cargo
ORDER BY CargoComMaisEmpregados DESC;

SELECT * FROM Associado;

SELECT																							 --Exercício 6
Nome,
DATEADD(YEAR, 50, DataNascimento) as DataQueCompletou50Anos,
DATEPART(WEEKDAY, DATEADD(YEAR, 50, DataNascimento)) as DiaDaSemana
FROM Associado;

SELECT * FROM Cidade;

SELECT																							 --Exercício 7
UF as Estado,
COUNT(Nome) as NumeroCidades
FROM Cidade 
GROUP BY UF;

SELECT																							 --Exercício 8
Nome as Municipio
FROM Cidade
GROUP BY Nome
HAVING Count(Nome) > 1;

SELECT * FROM Associado;

SELECT TOP 1																						  --Exercício 9
(IDAssociado + 1) as ProximoIDAssociado
FROM Associado
ORDER BY IDAssociado DESC;

INSERT INTO CidadeAux (IDCidade, Nome, UF)														 				 --Exercício 10
SELECT min(IDCidade), Nome, UF FROM Cidade GROUP BY Nome, UF;

SELECT * FROM Cidade;

UPDATE Cidade																					 	 --Exercício 11
SET Nome = '*' + Nome
WHERE Nome in
(SELECT Nome FROM Cidade GROUP BY Nome
HAVING COUNT(Nome) > 1);

SELECT Nome,																						 --Exercício 12
CASE WHEN Sexo = 'F' THEN 'Feminino' 
WHEN Sexo = 'M' THEN 'Masculino'
End as Sexo from Associado;

SELECT * FROM Empregado;

SELECT NomeEmpregado, Salario,																				 --Exercício 13
CASE WHEN Salario < 1164.00 THEN '0%'
WHEN Salario BETWEEN (1164.00) AND (2326.00) THEN '15%'
WHEN Salario > 2326.00 THEN '27.5%'
END as 'DescontoImpostoDeRenda' FROM Empregado;

SELECT * FROM Cidade;

DELETE FROM Cidade																					 --Exercício 14
WHERE Nome IN	
  (SELECT Nome FROM Cidade
  GROUP BY Nome
   HAVING COUNT(Nome)>1)
   AND NOT IDCidade IN
  (SELECT MIN(IDCidade) FROM Cidade
   GROUP BY Nome
   HAVING COUNT(Nome)>1)

ALTER TABLE Cidade																					 --Exercício 15											
ADD UNIQUE (Nome);
