CREATE TABLE estilo (
codigo 	BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
nome	VARCHAR(50) NOT NULL 	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE banco (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
numero BIGINT(20)  NOT NULL,
nome VARCHAR (50)NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE produto (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(50) ,
tipo VARCHAR(50) ,
codigo_banco BIGINT(20) ,
FOREIGN KEY (codigo_banco) REFERENCES banco(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE tabela (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR (50) NOT NULL,
coeficiente DECIMAL (10,2) NOT NULL,
codigo_produto BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_produto) REFERENCES produto(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE proposta (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
ade VARCHAR(50) NOT NULL,
descricao TEXT NOT NULL,
origem VARCHAR(50) NOT NULL,
valorParcela DECIMAL (10,2) NOT NULL,
valorTotal DECIMAL (10,2) NOT NULL,
valorLiquido DECIMAL (10,2) NOT NULL,
codigo_tabela BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_tabela) REFERENCES tabela(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	


CREATE TABLE comissao (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(50) NOT NULL,
valorPaga DECIMAL (10,2) NOT NULL,
valorRecebida DECIMAL (10,2) NOT NULL,
codigo_proposta BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_proposta) REFERENCES proposta(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	


	INSERT INTO banco VALUES (0, 341, 'Itau');
	INSERT INTO banco VALUES (0, 743, 'Santander');
	INSERT INTO banco VALUES (0, 778, 'Hsbc');
	INSERT INTO banco VALUES (0, 747, 'Banco do Brasil');
	
	INSERT INTO produto VALUES (0, 'PIROCOPETERO', 'Cartão', 1);
	INSERT INTO produto VALUES (0, 'Refinanceamento', 'Cartão', 1);
	INSERT INTO produto VALUES (0, 'Novo', 'Teste', 2);
	INSERT INTO produto VALUES (0, 'Cartao', 'Teste', 3);
	
	
	INSERT INTO tabela VALUES (0, 'Taxa Itau', 100, 1);
	
	INSERT INTO proposta VALUES (0, '007', 'James Bond', 'Nacional', 10.00, 20.00, 30.00, 1);
	
	
