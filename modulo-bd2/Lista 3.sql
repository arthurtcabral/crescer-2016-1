--1

CREATE PROCEDURE UPDATE_PEDIDO (pIDPEDIDO in Number) AS
  BEGIN
  
  UPDATE PEDIDO pe
  SET (pe.VALORPEDIDO) = (SELECT SUM(pi.QUANTIDADE * pi.PRECOUNITARIO)
                          FROM PedidoItem pi
                          INNER JOIN Pedido ped
                          ON pi.IDPedido = pIDPEDIDO
                          GROUP BY (pi.IDPedido))
  WHERE pe.IDPedido = pIDPEDIDO;
  
  END;

  DECLARE
  vIDPEDIDO NUMBER := '&Informe_IDPedido';
  
BEGIN
 UPDATE_PEDIDO(vIDPEDIDO);
END;

--2

CREATE FUNCTION ULTIMO_PEDIDO(pIDCLIENTE in NUMBER) RETURN DATE AS
vData VARCHAR2(10);
BEGIN

SELECT MIN(pe.DATAPEDIDO)
INTO vData
FROM Pedido pe
INNER JOIN CLIENTE
ON pe.IDCliente = pIDCLIENTE
GROUP BY pe.DATAPEDIDO;

RETURN vData;

END;

DECLARE
vULTIMO_PEDIDO DATE;
  
BEGIN
 vULTIMO_PEDIDO := ULTIMO_PEDIDO(1864);
 dbms_output.put_line(TO_CHAR(vULTIMO_PEDIDO, 'dd/mm/yyyy'));
END;



--3

CREATE FUNCTION QUANTIDADE_PRODUTOS_VENDIDOS(pIDPRODUTO in NUMBER, pPERIODO in VARCHAR2) RETURN NUMBER AS
vQUANTIDADE NUMBER;
BEGIN

SELECT SUM(pi.QUANTIDADE)
INTO vQUANTIDADE
FROM PEDIDOITEM pi
INNER JOIN PEDIDO pe
ON pi.IDPedido = pe.IDPedido
WHERE
pi.IDPRODUTO = pIDPRODUTO 
AND
pe.DATAPEDIDO BETWEEN TO_DATE('01'||pPERIODO, 'dd/MM/yyyy') AND LAST_DAY(TO_DATE('01'||pPERIODO, 'dd/MM/yyyy'))+0.99999;

RETURN vQUANTIDADE;

END;

DECLARE
vQUANTIDADE NUMBER;
  
BEGIN
 vQUANTIDADE := QUANTIDADE_PRODUTOS_VENDIDOS(5120, '/03/2013');
 dbms_output.put_line(vQUANTIDADE);
END;