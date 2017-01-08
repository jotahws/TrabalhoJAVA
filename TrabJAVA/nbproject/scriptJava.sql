CREATE DATABASE `trabjava` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `veiculo` (
  `idveiculo` int(11) NOT NULL AUTO_INCREMENT,
  `valor_compra` double DEFAULT NULL,
  `placa` varchar(45) DEFAULT NULL,
  `ano` int(11) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idveiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

CREATE TABLE `automovel` (
  `idautomovel` int(11) NOT NULL AUTO_INCREMENT,
  `veiculo` int(11) DEFAULT NULL,
  `modelo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idautomovel`),
  KEY `veiculo_idx` (`veiculo`),
  CONSTRAINT `fkveiculoA` FOREIGN KEY (`veiculo`) REFERENCES `veiculo` (`idveiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `motocicleta` (
  `idmotocicleta` int(11) NOT NULL AUTO_INCREMENT,
  `veiculo` int(11) DEFAULT NULL,
  `modelo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idmotocicleta`),
  KEY `veiculo_idx` (`veiculo`),
  KEY `fkmodelo_idx` (`modelo`),
  CONSTRAINT `fkveiculoM` FOREIGN KEY (`veiculo`) REFERENCES `veiculo` (`idveiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `van` (
  `idvan` int(11) NOT NULL AUTO_INCREMENT,
  `veiculo` int(11) DEFAULT NULL,
  `modelo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idvan`),
  KEY `veiculo_idx` (`veiculo`),
  CONSTRAINT `fkveiculoV` FOREIGN KEY (`veiculo`) REFERENCES `veiculo` (`idveiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `endereco` (
  `idendereco` int(11) NOT NULL AUTO_INCREMENT,
  `rua` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idendereco`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sobrenome` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `rg` varchar(45) NOT NULL,
  `endereco` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcliente`),
  KEY `endereco_idx` (`endereco`),
  CONSTRAINT `fkendereco` FOREIGN KEY (`endereco`) REFERENCES `endereco` (`idendereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `locacao` (
  `idlocacao` int(11) NOT NULL AUTO_INCREMENT,
  `dias` int(11) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `data` date DEFAULT NULL,
  `cliente` int(11) DEFAULT NULL,
  `veiculo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idlocacao`),
  KEY `cliente_idx` (`cliente`),
  KEY `veiculo_idx` (`veiculo`),
  CONSTRAINT `fkcliente` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkveiculo` FOREIGN KEY (`veiculo`) REFERENCES `veiculo` (`idveiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
