CREATE TABLE banco (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
numero BIGINT(20) NOT NULL,
nome VARCHAR (50) NOT NULL ,
 UNIQUE (numero),
 UNIQUE (nome)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE conta (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT UNIQUE,
agencia VARCHAR (50) NOT NULL,
numero 	BIGINT (20) NOT NULL,
titular VARCHAR (50) NOT NULL,
tipoConta VARCHAR(50) NOT NULL,
codigo_banco BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_banco) REFERENCES banco(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE usuario (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT UNIQUE,
nome VARCHAR (50) NOT NULL,
sobrenome VARCHAR (50) NOT NULL,
cpf VARCHAR (50) NOT NULL UNIQUE,
email VARCHAR (50) NOT NULL UNIQUE,
ativo BOOLEAN DEFAULT true,
senha VARCHAR (50) NOT NULL,
confSenha  VARCHAR (50) NOT NULL,
telefone VARCHAR (50) NOT NULL,
genero VARCHAR(50) NOT NULL,
grupo VARCHAR(50) NOT NULL,
data_nascimento DATE,
codigo_conta BIGINT(20) ,
FOREIGN KEY (codigo_conta) REFERENCES conta(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE produto (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(50) NOT NULL UNIQUE,
tipo VARCHAR(50) ,
codigo_banco BIGINT(20) ,
FOREIGN KEY (codigo_banco) REFERENCES banco(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE tabela (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR (50) NOT NULL UNIQUE,
coeficiente DECIMAL (10,2) NOT NULL,
codigo_produto BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_produto) REFERENCES produto(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE cliente (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT UNIQUE,
nome VARCHAR (50) NOT NULL,
sobrenome VARCHAR (50) NOT NULL,
cpf VARCHAR (50) NOT NULL UNIQUE,
rg VARCHAR (50) NOT NULL UNIQUE,
email VARCHAR (50) NOT NULL UNIQUE,
telefone VARCHAR (50) NOT NULL,
genero VARCHAR(50) NOT NULL,
codigo_conta BIGINT(20) ,
FOREIGN KEY (codigo_conta) REFERENCES conta(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE proposta (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
ade VARCHAR(50) NOT NULL UNIQUE,
descricao VARCHAR (50) NOT NULL,
origem VARCHAR(50) NOT NULL,
valorParcela DECIMAL (10,2) NOT NULL,
valorTotal DECIMAL (10,2) NOT NULL,
valorLiquido DECIMAL (10,2) NOT NULL,
data_proposta DATE,
codigo_tabela BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_tabela) REFERENCES tabela(codigo),
codigo_banco BIGINT(20) ,
FOREIGN KEY (codigo_banco) REFERENCES banco(codigo),
codigo_produto BIGINT(20) ,
FOREIGN KEY (codigo_produto) REFERENCES produto(codigo),
codigo_cliente BIGINT(20),
FOREIGN KEY (codigo_cliente) REFERENCES cliente(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE equipe (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT UNIQUE,
nome VARCHAR (50) NOT NULL UNIQUE,
percentual DECIMAL (10,2) NOT NULL,
codigo_usuario BIGINT(20) NOT NULL ,
FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	


CREATE TABLE comissao (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR (50) NOT NULL,
vlComissao DECIMAL(10, 2) NOT NULL,
bonus DECIMAL (10,2) NOT NULL,
codigo_proposta BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_proposta) REFERENCES proposta(codigo),
codigo_equipe BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_equipe) REFERENCES equipe(codigo),
codigo_usuario BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	

