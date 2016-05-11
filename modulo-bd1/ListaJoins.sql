SELECT														--Exercício 1
e.NomeEmpregado		as		NomeEmpregado,
d.NomeDepartamento	as		NomeDepartamento
FROM Empregado e
INNER JOIN Departamento d
ON d.IDDepartamento = e.IDDepartamento;

SELECT														--Exercício 2
a.Nome	as	NomeAssociado,
c.Nome  as	Nome
FROM Associado a
LEFT JOIN Cidade c
ON c.IDCidade = a.IDCidade;

Select c.UF, COUNT(c.IDCidade) Total_Cidades					--Exercício 3
From Cidade c 
LEFT JOIN Associado a ON c.IDCidade = a.IDCidade 
WHERE a.IDCidade is null 
Group By c.UF;

SELECT															--Exercício 4
a.Nome as NomeAssociado,
c.Nome as Municipio,
CASE WHEN c.UF = 'RS' THEN '***'
	 WHEN c.UF = 'SC' THEN '***'
	 WHEN c.UF = 'PR' THEN '***'
	 END as 'RegiaoSul?' FROM Associado a
	 INNER JOIN Cidade c ON a.IDCidade = c.IDCidade;

SELECT e.NomeEmpregado		   as	NomeEmpregado,				--Exercício 5
	   g.NomeEmpregado		   as	NomeGerente,
	   d.NomeDepartamento	   as	NomeDepartamento
From Empregado e
INNER JOIN Empregado g		   ON	e.IDGerente      = g.IDEmpregado
INNER JOIN Departamento d      ON   e.IDDepartamento = d.IDDepartamento;

Select * Into EmpregadoCopia From Empregado;					--Exercício 6
UPDATE EmpregadoCopia
SET Salario = (Salario * 0.145) + Salario
FROM EmpregadoCopia
WHERE IDDepartamento IN
(SELECT IDDepartamento FROM Departamento d WHERE d.Localizacao = 'SAO PAULO');

SELECT															--Exercício 7
e.Salario as SalarioSemReajuste, 
ec.Salario as SalarioComReajuste,
(ec.salario - e.salario) as Diferença
From Empregado e
INNER JOIN EmpregadoCopia ec ON e.IDEmpregado = ec.IDEmpregado;

SELECT * FROM EmpregadoCopia;

SELECT															--Exercício 8
NomeDepartamento
From Departamento
WHERE IDDepartamento =
(SELECT IDDepartamento 
From Empregado
WHERE Salario = (
SELECT MAX(Salario) 
from Empregado));

SELECT															--Exercício 9 
a.Nome as NomeAssociado,
c.Nome as Cidade
From Associado a
INNER JOIN Cidade c ON a.IDCidade = c.IDCidade
UNION ALL
Select 
e.NomeEmpregado, d.Localizacao 
From Empregado e 
Inner Join Departamento d 
ON e.IDDepartamento = d.IDDepartamento;

SELECT															--Exercício 10										
c.Nome, c.UF
FROM Cidade c
INNER JOIN Associado a ON a.IDCidade = c.IDCidade;