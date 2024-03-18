USE reserva;

-- QUESTÃO 01: Recupere o número e classe dos assentos disponíveis.
SELECT DISTINCT numeroassento, classe FROM assento WHERE `status` = 'Disponível';

-- QUESTÃO 02: Recupere o fabricante e ano de fabricação das aeronaves com capacidade de mais de 200 passageiros.
SELECT DISTINCT fabricante, anofabricacao FROM aeronave WHERE capacidade > 200;
 
-- QUESTÃO 03: Recupere o número do voo e o horário de saída dos voos em que a cidade de destino é 4567.
SELECT DISTINCT numerovoo, horariosaida FROM voo WHERE cidadedestino = 4567;
  
-- QUESTÃO 04: Recupere o preço das reservas para o voo de código 1100.
SELECT DISTINCT preco FROM reserva WHERE codigovoo = 1100;
 
-- QUESTÃO 05: Recupere o código do cliente que reservou um voo no dia 10/11/2014.
SELECT DISTINCT codigocliente FROM reserva WHERE datareserva = '2014-11-10';

-- QUESTÃO 06: Recupere o código da cidade Belo Horizonte.
SELECT DISTINCT codigocidade FROM cidade WHERE nomecidade = 'Belo Horizonte';
  
-- QUESTÃO 07: Recupere o código e o prefixo das aeronaves fabricadas após 2013.
SELECT DISTINCT codigoaeronace, prefixo FROM aeronave WHERE anofabricacao > 2013;
  
-- QUESTÃO 08: Recupere os números dos assentos reservados que custaram mais de 1000 reais.
SELECT DISTINCT numeroassento FROM reserva WHERE preco > 1000;

-- QUESTÃO 09: Recupere os números dos voos que saem após as 22:00.
SELECT DISTINCT numerovoo FROM voo WHERE horariosaida > '22:00:00';
  
-- QUESTÃO 10: Recupere o endereço e telefone da cliente Joice Leite.
SELECT DISTINCT endereco, telefone FROM cliente WHERE nomecliente = 'Joice Leite';