
-- MySQL Script generated by MySQL Workbench
-- Fri Oct 14 20:13:09 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema albergueDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `albergueDB` ;

-- -----------------------------------------------------
-- Schema albergueDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `albergueDB` DEFAULT CHARACTER SET utf8 ;
USE `albergueDB` ;

-- -----------------------------------------------------
-- Table `albergueDB`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `albergueDB`.`Funcionario` (
  `idFuncionario` INT NOT NULL AUTO_INCREMENT,
  `nomeFuncionario` VARCHAR(45) NOT NULL,
  `cpfFuncionario` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idFuncionario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `albergueDB`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `albergueDB`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `nomePessoa` VARCHAR(45) NOT NULL,
  `cpfPessoa` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `observacao` VARCHAR(45) NULL,
  `genero` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPessoa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `albergueDB`.`Alojamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `albergueDB`.`Alojamento` (
  `idAlojamento` INT NOT NULL AUTO_INCREMENT,
  `idPessoa` INT NOT NULL,
  `cama` INT NOT NULL,
  `quarto` INT NOT NULL,
  `data` varchar(11) NOT NULL,
  PRIMARY KEY (`idAlojamento`),
  CONSTRAINT `fk_Alojamento_Pessoa`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `albergueDB`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `albergueDB`.`Doador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `albergueDB`.`Doador` (
  `idDoador` INT NOT NULL AUTO_INCREMENT,
  `nomeDoador` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDoador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `albergueDB`.`Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `albergueDB`.`Item` (
  `idItem` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idItem`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `albergueDB`.`Doacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `albergueDB`.`Doacao` (
  `idDoacao` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(200) NOT NULL,
  `data` VARCHAR(45) NOT NULL,
  `quantidade` INT NOT NULL,
  `idDoador` INT NOT NULL,
  `idItem` INT NOT NULL,
  `desItem` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idDoacao`),
  CONSTRAINT `fk_Doacao_Doador1`
    FOREIGN KEY (`idDoador`)
    REFERENCES `albergueDB`.`Doador` (`idDoador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Doacao_Item1`
    FOREIGN KEY (`idItem`)
    REFERENCES `albergueDB`.`Item` (`idItem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `albergueDB`.`Vagas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `albergueDB`.`Vagas` (
  `quantidadeDeCamas` INT NOT NULL,
  PRIMARY KEY (`quantidadeDeCamas`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Inserção de Dados `albergueDB`
-- -----------------------------------------------------
/*Funcionário*/
INSERT INTO funcionario (nomeFuncionario,cpfFuncionario,senha,telefone,email,endereco,usuario) VALUES ("Luis","264.575.945-19","1234","(19)3633-5599","luiz@sou.fae.br","rua teste","adm");
INSERT INTO funcionario (nomeFuncionario,cpfFuncionario,senha,telefone,email,endereco,usuario) VALUES ("Natalia","947.562.124-19","1234","(19)3633-5799","natalia@sou.fae.br","rua teste1","adm");
INSERT INTO funcionario (nomeFuncionario,cpfFuncionario,senha,telefone,email,endereco,usuario) VALUES ("Thiago","558.456.957-19","1234","(19)3632-9465","thiago.gadiani@sou.fae.br","rua teste2","adm");
INSERT INTO funcionario (nomeFuncionario,cpfFuncionario,senha,telefone,email,endereco,usuario) VALUES ("Rodrigo","654.555.741-19","1234","(19)3631-6575","rodrigo@sou.fae.br","rua teste3","adm");

/*Pessoa*/
INSERT INTO pessoa (nomePessoa,cpfPessoa,cidade,observacao,genero) VALUES ("Jão","945.624.155-19","Passos","MG","Masculino");
INSERT INTO pessoa (nomePessoa,cpfPessoa,cidade,observacao,genero) VALUES ("Maria","957.632.648-17","Curitiba","RS","Feminino");
INSERT INTO pessoa (nomePessoa,cpfPessoa,cidade,observacao,genero) VALUES ("Zé","634.689.652-15.","Cruz das Almas","BA","Masculino");
INSERT INTO pessoa (nomePessoa,cpfPessoa,cidade,observacao,genero) VALUES ("Miriam","997.625.667-66","Goiânia","GO","Feminino");

/*Alojamento*/
INSERT INTO alojamento (idPessoa,cama,quarto,data) VALUES (1,1,1,"24/10/2022");
INSERT INTO alojamento (idPessoa,cama,quarto,data) VALUES (4,6,2,"24/10/2022");
INSERT INTO alojamento (idPessoa,cama,quarto,data) VALUES (1,3,2,"26/10/2022");
INSERT INTO alojamento (idPessoa,cama,quarto,data) VALUES (1,6,3,"28/10/2022");
INSERT INTO alojamento (idPessoa,cama,quarto,data) VALUES (4,1,1,"28/10/2022");
INSERT INTO alojamento (idPessoa,cama,quarto,data) VALUES (4,3,4,"30/10/2022");
INSERT INTO alojamento (idPessoa,cama,quarto,data) VALUES (1,2,3,"30/10/2022");

/*Doador*/
INSERT INTO doador (nomeDoador,telefone,cpf,genero) VALUES ("Maria não Aparecida","(19)3633-2233","741.648.249-26","Feminino");
INSERT INTO doador (nomeDoador,telefone,cpf,genero) VALUES ("Adalberto","(19)3633-1133","954.349.249-17","Masculino");
INSERT INTO doador (nomeDoador,telefone,cpf,genero) VALUES ("Godofredo","(19)3613-1122","624.137.549-99","Masculino");
INSERT INTO doador (nomeDoador,telefone,cpf,genero) VALUES ("Maria Aparecida","(19)3633-3333","617.537.985-77","Feminino");

/*Ítem*/
INSERT INTO item (nome) VALUES ("Roupa");
INSERT INTO item (nome) VALUES ("calçado");
INSERT INTO item (nome) VALUES ("alimentos");
INSERT INTO item (nome) VALUES ("Roupa de Cama");

/*Doação*/
INSERT INTO doacao (descricao,data,quantidade,idDoador,idItem,desItem) VALUES ("calça","25/10/2022",2,3,1,"Roupa");
INSERT INTO doacao (descricao,data,quantidade,idDoador,idItem,desItem) VALUES ("tenis","25/10/2022",3,2,2,"calçado");
INSERT INTO doacao (descricao,data,quantidade,idDoador,idItem,desItem) VALUES ("arroz","25/10/2022",1,3,3,"alimentos");
INSERT INTO doacao (descricao,data,quantidade,idDoador,idItem,desItem) VALUES ("feijao","26/10/2022",1,3,3,"alimentos");
INSERT INTO doacao (descricao,data,quantidade,idDoador,idItem,desItem) VALUES ("cobertor","26/10/2022",3,1,4,"Roupa de Cama");

/*Vagas*/
INSERT INTO vagas (quantidadeDeCamas) VALUES (11);