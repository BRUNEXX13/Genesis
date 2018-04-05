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
descricao VARCHAR (50) NOT NULL,
origem VARCHAR(50) NOT NULL,
valorParcela DECIMAL (10,2) NOT NULL,
valorTotal DECIMAL (10,2) NOT NULL,
valorLiquido DECIMAL (10,2) NOT NULL,
codigo_tabela BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_tabela) REFERENCES tabela(codigo),
codigo_banco BIGINT(20) ,
FOREIGN KEY (codigo_banco) REFERENCES banco(codigo),
codigo_produto BIGINT(20) ,
FOREIGN KEY (codigo_produto) REFERENCES produto(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE comissao (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR (50) NOT NULL,
comissao DECIMAL(10, 2) NOT NULL,
bonus DECIMAL (10,2) NOT NULL,
codigo_proposta BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_proposta) REFERENCES proposta(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	

