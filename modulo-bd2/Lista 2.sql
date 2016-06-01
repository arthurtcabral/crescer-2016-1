--1

DECLARE
vNomeCliente VARCHAR2(150);
vNomeCidade VARCHAR2(150);
vPrimeiraCompra DATE;
vUltimaCompra DATE;
vSomaValores NUMBER;

BEGIN

SELECT cli.Nome, ci.Nome, MIN(pe.DataPedido), MAX(pe.DataPedido), SUM(pe.ValorPedido)
INTO vNomeCliente, vNomeCidade, vPrimeiraCompra, vUltimaCompra, vSomaValores
FROM CLIENTE cli
INNER JOIN CIDADE ci
ON cli.IDCIDADE = ci.IDCIDADE
INNER JOIN Pedido pe
ON cli.IDCliente = pe.IDCLIENTE
WHERE cli.IDCLIENTE = &pIDCLIENTE
GROUP BY cli.Nome,  ci.Nome;


DBMS_OUTPUT.PUT_LINE('Cliente: ' || vNomeCliente);
DBMS_OUTPUT.PUT_LINE('Cidade: ' || vNomeCidade);
DBMS_OUTPUT.PUT_LINE('Data da primeira compra: ' || vPrimeiraCompra);
DBMS_OUTPUT.PUT_LINE('Data da última compra: ' || vUltimaCompra);
DBMS_OUTPUT.PUT_LINE('Valor total: ' || vSomaValores);

END;

--2

SELECT MAX(IDCIDADE) FROM CIDADE;
CREATE SEQUENCE SQLCIDADE START WITH 4669;

DECLARE
vExiste INTEGER;
vNome VARCHAR(150) := '&Nome_da_Cidade';
vUF VARCHAR(2) := '&Nome_do_UF';

BEGIN

SELECT MIN(IDCidade)
INTO vExiste
FROM CIDADE
WHERE UPPER(NOME) = UPPER(vNome) AND UPPER(UF) = UPPER(vUF)
GROUP BY (NOME);
EXCEPTION
  WHEN NO_DATA_FOUND THEN
  vExiste := 0;
  
  IF (vExiste = 0) THEN
  INSERT INTO CIDADE VALUES (SQLCIDADE.NEXTVAL, vNome, vUF);
  DBMS_OUTPUT.PUT_LINE('Cadastrado com sucesso');
  ELSE 
  DBMS_OUTPUT.PUT_LINE('Essa cidade já foi cadastrada!');
  END IF;
  
END;