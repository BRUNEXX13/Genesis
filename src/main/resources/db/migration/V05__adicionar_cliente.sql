CREATE TABLE cliente (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT UNIQUE,
nome VARCHAR (50) NOT NULL,
sobrenome VARCHAR (50) NOT NULL,
cpf VARCHAR (50) NOT NULL UNIQUE,
email VARCHAR (50) NOT NULL UNIQUE,
telefone VARCHAR (50) NOT NULL,
genero VARCHAR(50) NOT NULL,
codigo_banco BIGINT(20) ,
FOREIGN KEY (codigo_banco) REFERENCES banco(codigo),
codigo_conta BIGINT(20) ,
FOREIGN KEY (codigo_conta) REFERENCES conta(codigo),
codigo_proposta BIGINT(20),
FOREIGN KEY (codigo_proposta) REFERENCES proposta(codigo),
codigo_cidade BIGINT(20),
 FOREIGN KEY (codigo_cidade) REFERENCES cidade(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;