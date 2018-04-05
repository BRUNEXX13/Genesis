CREATE TABLE usuario (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR (50) NOT NULL,
sobrenome VARCHAR (50) NOT NULL,
email VARCHAR (50) NOT NULL,
telefone VARCHAR (50) NOT NULL,
genero VARCHAR(50) NOT NULL,
grupo VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	

CREATE TABLE equipe (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR (50) NOT NULL,
codigo_usuario BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
