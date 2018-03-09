CREATE TABLE estilo (
codigo 	BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
nome	VARCHAR(50) NOT NULL 	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE banco (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
numero BIGINT(20) NOT NULL UNIQUE,
nome VARCHAR (50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE produto (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
descricao TEXT NOT NULL,
tipo TEXT NOT NULL,
codigo_banco BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_banco) REFERENCES banco(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE tabela (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR (50) NOT NULL,
tipo VARCHAR(50) NOT NULL,
coeficiente DECIMAL (10,2) NOT NULL,
valor_liquido DECIMAL (10,2) NOT NULL,
codigo_produto BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_produto) REFERENCES produto(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE proposta (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
ade VARCHAR(50) NOT NULL,
descricao TEXT NOT NULL,
valor_parcela DECIMAL (10,2) NOT NULL,
valor_total  DECIMAL (10,2) NOT NULL,
valor_liquido  DECIMAL (10,2) NOT NULL,
comissao DECIMAL (10,2) NOT NULL,
sabor VARCHAR(50) NOT NULL,
codigo_tabela BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_tabela) REFERENCES tabela(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



	INSERT INTO banco VALUES (0, 341, 'Itau');
	INSERT INTO banco VALUES (0, 743, 'Santander');
	INSERT INTO banco VALUES (0, 778, 'Hsbc');
	INSERT INTO banco VALUES (0, 747, 'Banco do Brasil');
	
	INSERT INTO produto VALUES (0, 'Refinanceamento', 'Cartão', 1);
	INSERT INTO produto VALUES (0, 'Novo', 'Teste', 2);
	INSERT INTO produto VALUES (0, 'Cartao', 'Teste', 3);

	INSERT INTO banco VALUES (0, 341, 'ITAU');
	INSERT INTO banco VALUES (0, 777, 'SANTANDER');
	INSERT INTO produto VALUES (0, 'TESTE1', 'CARTAO', 1);

