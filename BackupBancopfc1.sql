-- MySQL dump 10.13  Distrib 5.1.73, for Win32 (ia32)
--
-- Host: localhost    Database: pfc1
-- ------------------------------------------------------
-- Server version	5.1.73-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tabauditoria`
--

DROP TABLE IF EXISTS `tabauditoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabauditoria` (
  `idtabAuditoria` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dataAcesso` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tabusuario_id_usuario` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idtabAuditoria`),
  KEY `fk_tabAuditoria_tabusuario1_idx` (`tabusuario_id_usuario`),
  CONSTRAINT `fk_tabAuditoria_tabusuario1` FOREIGN KEY (`tabusuario_id_usuario`) REFERENCES `tabusuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabauditoria`
--

LOCK TABLES `tabauditoria` WRITE;
/*!40000 ALTER TABLE `tabauditoria` DISABLE KEYS */;
INSERT INTO `tabauditoria` VALUES (1,'2015-12-28 21:26:03',2),(2,'2016-01-21 15:57:35',2);
/*!40000 ALTER TABLE `tabauditoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabcliente`
--

DROP TABLE IF EXISTS `tabcliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabcliente` (
  `idcliente` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tabContato_id_contato` int(10) unsigned NOT NULL,
  `dataCadCliente` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `empresa` varchar(45) NOT NULL,
  `cnpj` varchar(18) NOT NULL,
  `tabusuario_id_usuario` int(10) unsigned NOT NULL,
  `tabSetor_idtabSetor` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idcliente`),
  KEY `fk_tabCliente_tabContato1_idx` (`tabContato_id_contato`),
  KEY `fk_tabcliente_tabusuario1_idx` (`tabusuario_id_usuario`),
  KEY `fk_tabcliente_tabSetor1_idx` (`tabSetor_idtabSetor`),
  CONSTRAINT `fk_tabCliente_tabContato1` FOREIGN KEY (`tabContato_id_contato`) REFERENCES `tabcontato` (`id_contato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabcliente_tabSetor1` FOREIGN KEY (`tabSetor_idtabSetor`) REFERENCES `tabsetor` (`idtabSetor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabcliente_tabusuario1` FOREIGN KEY (`tabusuario_id_usuario`) REFERENCES `tabusuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabcliente`
--

LOCK TABLES `tabcliente` WRITE;
/*!40000 ALTER TABLE `tabcliente` DISABLE KEYS */;
INSERT INTO `tabcliente` VALUES (1,62,'2016-01-20 20:21:10','Cliente A','00.000.000/0000-00',2,8),(2,64,'2015-12-28 21:28:52','Cliente B','87.878.787/8787-87',2,8),(3,68,'2016-01-10 04:48:55','Empresa C','87.455.546/5666-66',2,9),(4,70,'2016-01-10 04:09:31','Cliente EE','00.000.000/0000-00',2,11),(5,72,'2016-01-01 20:24:27','Cliente F','77.878.454/2323-31',2,11),(6,74,'2016-01-03 02:14:30','Cliente Z','78.545.651/2541-33',2,9),(7,80,'2016-01-11 04:22:45','m','87.874.545/4554-54',2,9),(8,82,'2016-01-11 04:23:26','ppp','33.333.333/3333-33',2,8),(9,84,'2016-01-11 04:32:04','b','22.222.222/2222-22',2,8),(10,86,'2016-01-11 04:32:41','g','78.555.555/5555-55',2,8),(11,90,'2016-01-20 21:22:43','teste cnpj','00.000.000/0000-00',2,8);
/*!40000 ALTER TABLE `tabcliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabcontato`
--

DROP TABLE IF EXISTS `tabcontato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabcontato` (
  `id_contato` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_contato`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabcontato`
--

LOCK TABLES `tabcontato` WRITE;
/*!40000 ALTER TABLE `tabcontato` DISABLE KEYS */;
INSERT INTO `tabcontato` VALUES (55),(56),(57),(58),(59),(60),(61),(62),(63),(64),(65),(66),(67),(68),(69),(70),(71),(72),(73),(74),(75),(76),(77),(78),(79),(80),(81),(82),(83),(84),(85),(86),(87),(88),(89),(90),(91);
/*!40000 ALTER TABLE `tabcontato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabdetauditoria`
--

DROP TABLE IF EXISTS `tabdetauditoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabdetauditoria` (
  `idtabDetAuditoria` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dataModificacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `descricao` varchar(300) NOT NULL,
  `tabAuditoria_idtabAuditoria` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idtabDetAuditoria`),
  KEY `fk_tabDetAuditoria_tabAuditoria1_idx` (`tabAuditoria_idtabAuditoria`),
  CONSTRAINT `fk_tabDetAuditoria_tabAuditoria1` FOREIGN KEY (`tabAuditoria_idtabAuditoria`) REFERENCES `tabauditoria` (`idtabAuditoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabdetauditoria`
--

LOCK TABLES `tabdetauditoria` WRITE;
/*!40000 ALTER TABLE `tabdetauditoria` DISABLE KEYS */;
INSERT INTO `tabdetauditoria` VALUES (2,'2015-12-28 21:27:18','Empresa Cliente A /CNPJ: 87.878.787/8787-87 foi cadastrada.',1),(3,'2015-12-28 21:28:52','Empresa Cliente B /CNPJ: 87.878.787/8787-87teve os dados alterados.',1),(4,'2016-01-01 20:16:38','Empresa Empresa C /CNPJ: 87.455.546/5666-66 foi cadastrada.',1),(5,'2016-01-01 20:22:21','Empresa Cliente E /CNPJ: 78.544.444/4444-45 foi cadastrada.',1),(6,'2016-01-01 20:24:27','Empresa Cliente F /CNPJ: 77.878.454/2323-31 foi cadastrada.',1),(7,'2016-01-03 02:14:31','Empresa Cliente Z /CNPJ: 78.545.651/2541-33 foi cadastrada.',1),(8,'2016-01-10 00:08:01','Empresa Empresa C /CNPJ: 87.455.546/5666-66teve os dados alterados.',1),(9,'2016-01-10 04:09:31','Empresa Cliente EE /CNPJ: 00.000.000/0000-00teve os dados alterados.',1),(10,'2016-01-10 04:48:55','Empresa Empresa C /CNPJ: 87.455.546/5666-66teve os dados alterados.',1),(11,'2016-01-11 04:22:46','Empresa m /CNPJ: 87.874.545/4554-54 foi cadastrada.',1),(12,'2016-01-11 04:23:27','Empresa ppp /CNPJ: 33.333.333/3333-33 foi cadastrada.',1),(13,'2016-01-11 04:32:05','Empresa b /CNPJ: 22.222.222/2222-22 foi cadastrada.',1),(14,'2016-01-11 04:32:41','Empresa g /CNPJ: 78.555.555/5555-55 foi cadastrada.',1),(15,'2016-01-15 03:09:21','Empresa  /CNPJ:   .   .   /    -   foi cadastrada.',1),(16,'2016-01-20 20:21:10','Empresa Cliente A /CNPJ: 00.000.000/0000-00teve os dados alterados.',1),(17,'2016-01-20 21:22:04','Empresa teste cnpj /CNPJ:   .   .   /    -   foi cadastrada.',1),(18,'2016-01-20 21:22:43','Empresa teste cnpj /CNPJ: 00.000.000/0000-00teve os dados alterados.',1);
/*!40000 ALTER TABLE `tabdetauditoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabdetequipamento`
--

DROP TABLE IF EXISTS `tabdetequipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabdetequipamento` (
  `idDetEquipamento` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tabmodelo_idtabModelo` int(10) unsigned NOT NULL,
  `tabfabricante_idtabFabricante` int(10) unsigned NOT NULL,
  `tabfornecedor_id_forn` int(10) unsigned NOT NULL,
  `tabequipamento_idEquipamento` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idDetEquipamento`),
  KEY `fk_tabDetEquipamento_tabmodelo1_idx` (`tabmodelo_idtabModelo`),
  KEY `fk_tabDetEquipamento_tabfabricante1_idx` (`tabfabricante_idtabFabricante`),
  KEY `fk_tabDetEquipamento_tabfornecedor1_idx` (`tabfornecedor_id_forn`),
  KEY `fk_tabDetEquipamento_tabequipamento1_idx` (`tabequipamento_idEquipamento`),
  CONSTRAINT `fk_tabDetEquipamento_tabequipamento1` FOREIGN KEY (`tabequipamento_idEquipamento`) REFERENCES `tabequipamento` (`idEquipamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabDetEquipamento_tabfabricante1` FOREIGN KEY (`tabfabricante_idtabFabricante`) REFERENCES `tabfabricante` (`idtabFabricante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabDetEquipamento_tabfornecedor1` FOREIGN KEY (`tabfornecedor_id_forn`) REFERENCES `tabfornecedor` (`id_forn`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabDetEquipamento_tabmodelo1` FOREIGN KEY (`tabmodelo_idtabModelo`) REFERENCES `tabmodelo` (`idtabModelo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabdetequipamento`
--

LOCK TABLES `tabdetequipamento` WRITE;
/*!40000 ALTER TABLE `tabdetequipamento` DISABLE KEYS */;
INSERT INTO `tabdetequipamento` VALUES (1,2,2,2,1),(2,2,1,2,2),(3,3,2,1,1),(4,3,1,1,1);
/*!40000 ALTER TABLE `tabdetequipamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabdetlocacao`
--

DROP TABLE IF EXISTS `tabdetlocacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabdetlocacao` (
  `idDetLocacao` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `valorLocacao` double unsigned NOT NULL,
  `tabLocacao_idtabDetLocacao` int(10) unsigned NOT NULL,
  `tabdetequipamento_idDetEquipamento` int(10) unsigned NOT NULL,
  `quantEquipamento` int(11) NOT NULL,
  PRIMARY KEY (`idDetLocacao`),
  KEY `fk_tabDetLocacao_tabLocacao1_idx` (`tabLocacao_idtabDetLocacao`),
  KEY `fk_tabdetlocacao_tabdetequipamento1_idx` (`tabdetequipamento_idDetEquipamento`),
  CONSTRAINT `fk_tabdetlocacao_tabdetequipamento1` FOREIGN KEY (`tabdetequipamento_idDetEquipamento`) REFERENCES `tabdetequipamento` (`idDetEquipamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabDetLocacao_tabLocacao1` FOREIGN KEY (`tabLocacao_idtabDetLocacao`) REFERENCES `tablocacao` (`idtabDetLocacao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabdetlocacao`
--

LOCK TABLES `tabdetlocacao` WRITE;
/*!40000 ALTER TABLE `tabdetlocacao` DISABLE KEYS */;
INSERT INTO `tabdetlocacao` VALUES (1,200,1,2,52),(2,235,2,2,20),(3,500,3,2,10);
/*!40000 ALTER TABLE `tabdetlocacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabdetproduto`
--

DROP TABLE IF EXISTS `tabdetproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabdetproduto` (
  `idDetProduto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) NOT NULL,
  `precoEntrada` double NOT NULL,
  `precoSaida` double NOT NULL,
  `quantidadeMinima` int(11) NOT NULL,
  `tabproduto_id_prod` int(10) unsigned NOT NULL,
  `tabfabricante_idtabFabricante` int(10) unsigned NOT NULL,
  `tabmodelo_idtabModelo` int(10) unsigned NOT NULL,
  `dataCadastro` date NOT NULL,
  PRIMARY KEY (`idDetProduto`),
  KEY `fk_tabDetProduto_tabproduto1_idx` (`tabproduto_id_prod`),
  KEY `fk_tabDetProduto_tabfabricante1_idx` (`tabfabricante_idtabFabricante`),
  KEY `fk_tabDetProduto_tabmodelo1_idx` (`tabmodelo_idtabModelo`),
  CONSTRAINT `fk_tabDetProduto_tabfabricante1` FOREIGN KEY (`tabfabricante_idtabFabricante`) REFERENCES `tabfabricante` (`idtabFabricante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabDetProduto_tabmodelo1` FOREIGN KEY (`tabmodelo_idtabModelo`) REFERENCES `tabmodelo` (`idtabModelo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabDetProduto_tabproduto1` FOREIGN KEY (`tabproduto_id_prod`) REFERENCES `tabproduto` (`id_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabdetproduto`
--

LOCK TABLES `tabdetproduto` WRITE;
/*!40000 ALTER TABLE `tabdetproduto` DISABLE KEYS */;
INSERT INTO `tabdetproduto` VALUES (1,300,255,280.5,50,1,2,1,'2015-12-29'),(2,700,300,375,40,2,3,2,'2015-12-29'),(3,100,125,162.5,25,1,2,2,'2015-12-30'),(4,90,110,140.8,20,2,2,5,'2015-12-24'),(5,475,123,136.53,22,1,2,3,'2016-01-13'),(6,14,250,362.5,22,1,3,2,'2016-01-12');
/*!40000 ALTER TABLE `tabdetproduto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabdetservico_equipamento`
--

DROP TABLE IF EXISTS `tabdetservico_equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabdetservico_equipamento` (
  `iddetServico_Equipamento` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tabdetequipamento_idDetEquipamento` int(10) unsigned NOT NULL,
  `tabservico_idservico` int(10) unsigned NOT NULL,
  PRIMARY KEY (`iddetServico_Equipamento`),
  KEY `fk_tabdetServico_Equipamento_tabdetequipamento1_idx` (`tabdetequipamento_idDetEquipamento`),
  KEY `fk_tabdetServico_Equipamento_tabservico1_idx` (`tabservico_idservico`),
  CONSTRAINT `fk_tabdetServico_Equipamento_tabdetequipamento1` FOREIGN KEY (`tabdetequipamento_idDetEquipamento`) REFERENCES `tabdetequipamento` (`idDetEquipamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabdetServico_Equipamento_tabservico1` FOREIGN KEY (`tabservico_idservico`) REFERENCES `tabservico` (`idservico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabdetservico_equipamento`
--

LOCK TABLES `tabdetservico_equipamento` WRITE;
/*!40000 ALTER TABLE `tabdetservico_equipamento` DISABLE KEYS */;
INSERT INTO `tabdetservico_equipamento` VALUES (1,3,1),(2,3,2),(3,2,2),(4,1,3),(5,2,4),(6,2,5),(7,1,6),(8,1,7),(9,1,12),(10,1,13),(11,1,14),(12,1,15),(13,2,15),(14,3,15),(15,4,15);
/*!40000 ALTER TABLE `tabdetservico_equipamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabdetservico_funcionario`
--

DROP TABLE IF EXISTS `tabdetservico_funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabdetservico_funcionario` (
  `idDetServico_funcionario` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tabfuncionario_idfuncionario` int(10) unsigned NOT NULL,
  `tabservico_idservico` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idDetServico_funcionario`),
  KEY `fk_tabDetServico_funcionario_tabfuncionario1_idx` (`tabfuncionario_idfuncionario`),
  KEY `fk_tabDetServico_funcionario_tabservico1_idx` (`tabservico_idservico`),
  CONSTRAINT `fk_tabDetServico_funcionario_tabfuncionario1` FOREIGN KEY (`tabfuncionario_idfuncionario`) REFERENCES `tabfuncionario` (`idfuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabDetServico_funcionario_tabservico1` FOREIGN KEY (`tabservico_idservico`) REFERENCES `tabservico` (`idservico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabdetservico_funcionario`
--

LOCK TABLES `tabdetservico_funcionario` WRITE;
/*!40000 ALTER TABLE `tabdetservico_funcionario` DISABLE KEYS */;
INSERT INTO `tabdetservico_funcionario` VALUES (1,3,1),(2,3,2),(3,4,2),(4,4,3),(5,3,4),(6,3,5),(7,3,6),(8,4,7),(9,4,12),(10,4,13),(11,4,14),(12,3,15);
/*!40000 ALTER TABLE `tabdetservico_funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabdetservico_produto`
--

DROP TABLE IF EXISTS `tabdetservico_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabdetservico_produto` (
  `iddetServico_produto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tabdetproduto_idDetProduto` int(10) unsigned NOT NULL,
  `quantidadeComprada` int(11) NOT NULL,
  `tabservico_idservico` int(10) unsigned NOT NULL,
  PRIMARY KEY (`iddetServico_produto`),
  KEY `fk_tabdetServico_produto_tabdetproduto1_idx` (`tabdetproduto_idDetProduto`),
  KEY `fk_tabdetServico_produto_tabservico1_idx` (`tabservico_idservico`),
  CONSTRAINT `fk_tabdetServico_produto_tabdetproduto1` FOREIGN KEY (`tabdetproduto_idDetProduto`) REFERENCES `tabdetproduto` (`idDetProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabdetServico_produto_tabservico1` FOREIGN KEY (`tabservico_idservico`) REFERENCES `tabservico` (`idservico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabdetservico_produto`
--

LOCK TABLES `tabdetservico_produto` WRITE;
/*!40000 ALTER TABLE `tabdetservico_produto` DISABLE KEYS */;
INSERT INTO `tabdetservico_produto` VALUES (1,1,12,3),(2,2,5,4),(4,2,2,4),(5,2,58,6),(6,6,45,6),(7,3,2,6),(8,2,2,12),(9,1,3,13),(10,1,2,14),(11,2,12,15);
/*!40000 ALTER TABLE `tabdetservico_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabdetservico_tiposerv`
--

DROP TABLE IF EXISTS `tabdetservico_tiposerv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabdetservico_tiposerv` (
  `iddetServico_TipoServ` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tabtipo_serv_idtabTipo_serv` int(10) unsigned NOT NULL,
  `tabservico_idservico` int(10) unsigned NOT NULL,
  PRIMARY KEY (`iddetServico_TipoServ`),
  KEY `fk_tabdetServico_TipoServ_tabtipo_serv1_idx` (`tabtipo_serv_idtabTipo_serv`),
  KEY `fk_tabdetServico_TipoServ_tabservico1_idx` (`tabservico_idservico`),
  CONSTRAINT `fk_tabdetServico_TipoServ_tabservico1` FOREIGN KEY (`tabservico_idservico`) REFERENCES `tabservico` (`idservico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabdetServico_TipoServ_tabtipo_serv1` FOREIGN KEY (`tabtipo_serv_idtabTipo_serv`) REFERENCES `tabtipo_serv` (`idtabTipo_serv`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabdetservico_tiposerv`
--

LOCK TABLES `tabdetservico_tiposerv` WRITE;
/*!40000 ALTER TABLE `tabdetservico_tiposerv` DISABLE KEYS */;
INSERT INTO `tabdetservico_tiposerv` VALUES (1,2,1),(2,2,2),(3,1,2),(4,1,3),(5,2,4),(6,1,4),(7,1,6),(8,1,7),(9,1,12),(10,1,13),(11,1,14),(12,1,15);
/*!40000 ALTER TABLE `tabdetservico_tiposerv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabdetvendas`
--

DROP TABLE IF EXISTS `tabdetvendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabdetvendas` (
  `idtabDetVendas` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) NOT NULL,
  `tabVendas_idtabVendas` int(10) unsigned NOT NULL,
  `tabdetproduto_idDetProduto` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idtabDetVendas`),
  KEY `fk_tabDetVendas_tabVendas1_idx` (`tabVendas_idtabVendas`),
  KEY `fk_tabdetvendas_tabdetproduto1_idx` (`tabdetproduto_idDetProduto`),
  CONSTRAINT `fk_tabdetvendas_tabdetproduto1` FOREIGN KEY (`tabdetproduto_idDetProduto`) REFERENCES `tabdetproduto` (`idDetProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabDetVendas_tabVendas1` FOREIGN KEY (`tabVendas_idtabVendas`) REFERENCES `tabvendas` (`idtabVendas`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabdetvendas`
--

LOCK TABLES `tabdetvendas` WRITE;
/*!40000 ALTER TABLE `tabdetvendas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabdetvendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabemail`
--

DROP TABLE IF EXISTS `tabemail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabemail` (
  `id_email` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `contato_id_contato` int(10) unsigned NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id_email`),
  KEY `fk_email_Contato1_idx` (`contato_id_contato`),
  CONSTRAINT `fk_email_Contato1` FOREIGN KEY (`contato_id_contato`) REFERENCES `tabcontato` (`id_contato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabemail`
--

LOCK TABLES `tabemail` WRITE;
/*!40000 ALTER TABLE `tabemail` DISABLE KEYS */;
INSERT INTO `tabemail` VALUES (47,57,'contforn1.com'),(48,59,'aforn1.com'),(49,61,'contAforn1.com.br'),(50,63,'contCliA.com'),(51,65,'contClieB.com'),(52,67,'cont2forn2.com'),(53,69,'contEmpresaC.com'),(54,71,'contatoClienteEE.com'),(55,73,'contatoCliF.com'),(56,75,'contatoClientez.com'),(57,76,'funcionario1.com'),(58,77,'funcionario2.com'),(59,78,'funcionario1.com'),(60,79,'funcionario2.com'),(61,81,'gracielaribeiroaraujo20@gmail.com'),(62,83,'j'),(63,85,'b'),(64,87,'h'),(65,88,'gg'),(66,91,'gracielaribeiroaraujo20@gmail.com');
/*!40000 ALTER TABLE `tabemail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabendereco`
--

DROP TABLE IF EXISTS `tabendereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabendereco` (
  `id_endereco` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `rua` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `pais` varchar(45) NOT NULL,
  `cod_contato` int(10) unsigned NOT NULL,
  `cep` varchar(10) NOT NULL,
  PRIMARY KEY (`id_endereco`),
  KEY `fk_endereco_Contato1_idx` (`cod_contato`),
  CONSTRAINT `fk_endereco_Contato1` FOREIGN KEY (`cod_contato`) REFERENCES `tabcontato` (`id_contato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabendereco`
--

LOCK TABLES `tabendereco` WRITE;
/*!40000 ALTER TABLE `tabendereco` DISABLE KEYS */;
INSERT INTO `tabendereco` VALUES (36,'A','1','A','A','BA','Brasil',56,'11111-111'),(37,'A','1','A','A','BA','Brasil',58,'11111-111'),(38,'A','1','A','A','BA','Brasil',60,'11111-111'),(39,'B','12','B','B','BA','Brasil',62,'78487-845'),(40,'B','12','B','B','BA','Brasil',64,'87878-454'),(41,'C','54','C','C','BA','Brasil',66,'23564-545'),(42,'B','78000','Cristo Reiiii','Dias D\'ávilaaaa','BA','Brasil',68,'00000-000'),(43,'E','85','D','Camaçari','BA','Brasil',70,'84545-656'),(44,'D','475','H','Salvador','BA','Brasil',72,'87845-454'),(45,'Z','100','Z','Z','SP','Brasil',74,'78454-212'),(46,'B','100','A','Cidade A','BA','Brasil',76,'45754-544'),(47,'E','210','E','E','ES','BRASIL',77,'28789-565'),(48,'A','54','A','A','BA','Brasil',78,'21548-455'),(49,'D','20','D','dias d','BA','Brasil',79,'22124-544'),(50,'raa','aa','gg','ggg','ba','brazil',80,'21121-212'),(51,'j','j','j','j','jj','j',82,'77777-777'),(52,'b','b','b','b','bb','b',84,'88555-555'),(53,'h','h','h','h','hh','h',86,'63333-333'),(54,'gg','gg','gg','gg','455','Brasil',88,'87845-455'),(55,'     -   ','','     -   ','     -   ','     -   ','Brasil',89,'     -   '),(56,'Dias D\'Ávila','25','Cristo REi','Dias D\'Ávila','BA','Brasil',90,'42850-000');
/*!40000 ALTER TABLE `tabendereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabequipamento`
--

DROP TABLE IF EXISTS `tabequipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabequipamento` (
  `idEquipamento` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tabusuario_id_usuario` int(10) unsigned NOT NULL,
  `equipamento` varchar(45) NOT NULL,
  PRIMARY KEY (`idEquipamento`),
  KEY `fk_tabequipamento_tabusuario1_idx` (`tabusuario_id_usuario`),
  CONSTRAINT `fk_tabequipamento_tabusuario1` FOREIGN KEY (`tabusuario_id_usuario`) REFERENCES `tabusuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabequipamento`
--

LOCK TABLES `tabequipamento` WRITE;
/*!40000 ALTER TABLE `tabequipamento` DISABLE KEYS */;
INSERT INTO `tabequipamento` VALUES (1,2,'Equipamento 1'),(2,2,'Equipamento 2');
/*!40000 ALTER TABLE `tabequipamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabfabricante`
--

DROP TABLE IF EXISTS `tabfabricante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabfabricante` (
  `idtabFabricante` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fabricante` varchar(45) NOT NULL,
  PRIMARY KEY (`idtabFabricante`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabfabricante`
--

LOCK TABLES `tabfabricante` WRITE;
/*!40000 ALTER TABLE `tabfabricante` DISABLE KEYS */;
INSERT INTO `tabfabricante` VALUES (1,'Fabricante 1'),(2,'Fabricante 2'),(3,'Fabricante 3'),(4,'Fabricante 4');
/*!40000 ALTER TABLE `tabfabricante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabfornecedor`
--

DROP TABLE IF EXISTS `tabfornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabfornecedor` (
  `id_forn` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tabContato_id_contato` int(10) unsigned NOT NULL,
  `fornecedor` varchar(45) NOT NULL,
  `tabUsuario_id_usuario` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_forn`),
  KEY `fk_tabFornecedor_tabContato1_idx` (`tabContato_id_contato`),
  KEY `fk_tabFornecedor_tabUsuario1_idx` (`tabUsuario_id_usuario`),
  CONSTRAINT `fk_tabFornecedor_tabContato1` FOREIGN KEY (`tabContato_id_contato`) REFERENCES `tabcontato` (`id_contato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabFornecedor_tabUsuario1` FOREIGN KEY (`tabUsuario_id_usuario`) REFERENCES `tabusuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabfornecedor`
--

LOCK TABLES `tabfornecedor` WRITE;
/*!40000 ALTER TABLE `tabfornecedor` DISABLE KEYS */;
INSERT INTO `tabfornecedor` VALUES (1,60,'Fornecedor 1',2),(2,66,'Fornecedor 2',2);
/*!40000 ALTER TABLE `tabfornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabfuncionario`
--

DROP TABLE IF EXISTS `tabfuncionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabfuncionario` (
  `idfuncionario` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tabContato_id_contato` int(10) unsigned NOT NULL,
  `tabUsuario_id_usuario` int(10) unsigned NOT NULL,
  `funcionario` varchar(45) NOT NULL,
  `rg` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `cargo` varchar(45) NOT NULL,
  `salario` varchar(45) NOT NULL,
  `data_admissao` varchar(10) NOT NULL,
  `ctps` varchar(14) NOT NULL,
  `serie` varchar(4) NOT NULL,
  `numeroCtps` varchar(7) NOT NULL,
  `uf` varchar(2) NOT NULL,
  PRIMARY KEY (`idfuncionario`),
  KEY `fk_funcionario_tabContato1_idx` (`tabContato_id_contato`),
  KEY `fk_funcionario_tabUsuario1_idx` (`tabUsuario_id_usuario`),
  CONSTRAINT `fk_funcionario_tabContato1` FOREIGN KEY (`tabContato_id_contato`) REFERENCES `tabcontato` (`id_contato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_tabUsuario1` FOREIGN KEY (`tabUsuario_id_usuario`) REFERENCES `tabusuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabfuncionario`
--

LOCK TABLES `tabfuncionario` WRITE;
/*!40000 ALTER TABLE `tabfuncionario` DISABLE KEYS */;
INSERT INTO `tabfuncionario` VALUES (3,78,2,'Funcionario 1','65645654-56','465.656.565-65','Administrador','2600.0','22/05/2016','487.89898.56-6','656','455','AP'),(4,79,2,'Funcionario 2','56522323-23','236.336.663-23','Programador','2500.0','03/05/2001','323.23232.32-3','122','21221','AP'),(5,88,2,'ggggg','98.745.454-54','548.745.454-84','g','12545.0','22/10/2016','457.84545.45-4','5454','014','AP');
/*!40000 ALTER TABLE `tabfuncionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabhistoricodeproduto`
--

DROP TABLE IF EXISTS `tabhistoricodeproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabhistoricodeproduto` (
  `idVariacaoDePreco` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `valor` double NOT NULL,
  `dataCadastro` date NOT NULL,
  `quantidade` int(11) NOT NULL,
  `tabDetProduto_idDetProduto` int(10) unsigned NOT NULL,
  `tabfornecedor_id_forn` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idVariacaoDePreco`),
  KEY `fk_tabHistoricoDeProduto_tabDetProduto1_idx` (`tabDetProduto_idDetProduto`),
  KEY `fk_tabhistoricodeproduto_tabfornecedor1_idx` (`tabfornecedor_id_forn`),
  CONSTRAINT `fk_tabHistoricoDeProduto_tabDetProduto1` FOREIGN KEY (`tabDetProduto_idDetProduto`) REFERENCES `tabdetproduto` (`idDetProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabhistoricodeproduto_tabfornecedor1` FOREIGN KEY (`tabfornecedor_id_forn`) REFERENCES `tabfornecedor` (`id_forn`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabhistoricodeproduto`
--

LOCK TABLES `tabhistoricodeproduto` WRITE;
/*!40000 ALTER TABLE `tabhistoricodeproduto` DISABLE KEYS */;
INSERT INTO `tabhistoricodeproduto` VALUES (1,255,'2015-12-29',500,1,1),(2,400,'2015-12-30',300,2,1),(3,125,'2015-12-30',100,3,1),(4,110,'2015-12-24',100,4,1),(5,123,'2016-01-13',475,5,1),(6,250,'2016-01-12',14,6,1);
/*!40000 ALTER TABLE `tabhistoricodeproduto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tablembrete`
--

DROP TABLE IF EXISTS `tablembrete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tablembrete` (
  `idLembrete` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tabcliente_idcliente` int(10) unsigned NOT NULL,
  `tabusuario_id_usuario` int(10) unsigned NOT NULL,
  `dataContato` date NOT NULL,
  `hora` time NOT NULL,
  `descricao` text NOT NULL,
  PRIMARY KEY (`idLembrete`),
  KEY `fk_tabLembrete_tabcliente1_idx` (`tabcliente_idcliente`),
  KEY `fk_tablembrete_tabusuario1_idx` (`tabusuario_id_usuario`),
  CONSTRAINT `fk_tabLembrete_tabcliente1` FOREIGN KEY (`tabcliente_idcliente`) REFERENCES `tabcliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tablembrete_tabusuario1` FOREIGN KEY (`tabusuario_id_usuario`) REFERENCES `tabusuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tablembrete`
--

LOCK TABLES `tablembrete` WRITE;
/*!40000 ALTER TABLE `tablembrete` DISABLE KEYS */;
INSERT INTO `tablembrete` VALUES (1,2,2,'2015-12-23','22:11:00','Deus é amor'),(2,3,2,'2016-01-14','22:54:00','kkkkkkkkkkkkkk'),(3,4,2,'2016-01-14','11:25:00','Lembrete'),(4,3,2,'2016-01-21','22:45:00','aaa'),(5,3,2,'2016-01-14','15:45:00',''),(6,4,2,'2016-01-14','01:44:00','lkkoih'),(7,3,2,'2016-01-21','14:55:00','xxzxxzxz'),(8,5,2,'2016-01-13','21:55:00','ffffhjhkjk');
/*!40000 ALTER TABLE `tablembrete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tablocacao`
--

DROP TABLE IF EXISTS `tablocacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tablocacao` (
  `idtabDetLocacao` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tabusuario_id_usuario` int(10) unsigned NOT NULL,
  `tabcliente_idcliente` int(10) unsigned NOT NULL,
  `DescricaoLocacao` varchar(500) DEFAULT NULL,
  `tabordemserv_idtabOrdemServ` int(10) unsigned NOT NULL,
  `dataLocacao` date NOT NULL,
  `horaLocacao` time NOT NULL,
  `dataDevolucao` date NOT NULL,
  PRIMARY KEY (`idtabDetLocacao`),
  KEY `fk_tabLocacao_tabcliente1_idx` (`tabcliente_idcliente`),
  KEY `fk_tablocacao_tabusuario1_idx` (`tabusuario_id_usuario`),
  KEY `fk_tablocacao_tabordemserv1_idx` (`tabordemserv_idtabOrdemServ`),
  CONSTRAINT `fk_tabLocacao_tabcliente1` FOREIGN KEY (`tabcliente_idcliente`) REFERENCES `tabcliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tablocacao_tabordemserv1` FOREIGN KEY (`tabordemserv_idtabOrdemServ`) REFERENCES `tabordemserv` (`idtabOrdemServ`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tablocacao_tabusuario1` FOREIGN KEY (`tabusuario_id_usuario`) REFERENCES `tabusuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tablocacao`
--

LOCK TABLES `tablocacao` WRITE;
/*!40000 ALTER TABLE `tablocacao` DISABLE KEYS */;
INSERT INTO `tablocacao` VALUES (1,2,2,'AAAAAAAAAAAAAAAAAAAAAAhhhhhhhhh',1,'2016-01-02','22:50:00','2016-01-12'),(2,2,2,'CCCC',2,'2016-01-02','22:32:00','2016-01-04'),(3,2,1,'aa',3,'2016-01-09','22:14:00','2016-01-15');
/*!40000 ALTER TABLE `tablocacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabmodelo`
--

DROP TABLE IF EXISTS `tabmodelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabmodelo` (
  `idtabModelo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `modelo` varchar(70) NOT NULL,
  PRIMARY KEY (`idtabModelo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabmodelo`
--

LOCK TABLES `tabmodelo` WRITE;
/*!40000 ALTER TABLE `tabmodelo` DISABLE KEYS */;
INSERT INTO `tabmodelo` VALUES (1,'Modelo 1'),(2,'Modelo 2'),(3,'Modelo 3'),(5,'Modelo 4');
/*!40000 ALTER TABLE `tabmodelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabordemserv`
--

DROP TABLE IF EXISTS `tabordemserv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabordemserv` (
  `idtabOrdemServ` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tipoServico` varchar(45) NOT NULL,
  PRIMARY KEY (`idtabOrdemServ`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabordemserv`
--

LOCK TABLES `tabordemserv` WRITE;
/*!40000 ALTER TABLE `tabordemserv` DISABLE KEYS */;
INSERT INTO `tabordemserv` VALUES (1,'Aluguel'),(2,'Aluguel'),(3,'Aluguel'),(4,'Manutenção'),(5,'Manutenção'),(6,'Manutenção'),(7,'Manutenção'),(8,'Manutenção'),(9,'Manutenção'),(10,'Manutenção'),(11,'Manutenção'),(12,'Manutenção'),(13,'Manutenção'),(14,'Manutenção'),(15,'Manutenção'),(16,'Manutenção'),(17,'Manutenção'),(18,'Manutenção'),(19,'Manutenção'),(20,'Vendas');
/*!40000 ALTER TABLE `tabordemserv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabpessoacontato`
--

DROP TABLE IF EXISTS `tabpessoacontato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabpessoacontato` (
  `idPessoaContato` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `contato` varchar(45) NOT NULL,
  `cod_contato` int(10) unsigned NOT NULL,
  `tabcliente_idcliente` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idPessoaContato`),
  KEY `fk_tabPessoaContato_tabcontato1_idx` (`cod_contato`),
  KEY `fk_tabpessoacontato_tabcliente1_idx` (`tabcliente_idcliente`),
  CONSTRAINT `fk_tabpessoacontato_tabcliente1` FOREIGN KEY (`tabcliente_idcliente`) REFERENCES `tabcliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabPessoaContato_tabcontato1` FOREIGN KEY (`cod_contato`) REFERENCES `tabcontato` (`id_contato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabpessoacontato`
--

LOCK TABLES `tabpessoacontato` WRITE;
/*!40000 ALTER TABLE `tabpessoacontato` DISABLE KEYS */;
INSERT INTO `tabpessoacontato` VALUES (1,'Contato Cliente A',63,1),(2,'Contato cliente B',65,2),(3,'Contato empresa C',69,3),(4,'Contato Cliente EE',71,4),(5,'Contato cliente F',73,5),(6,'contato cliente z',75,6),(7,'uytutuy',81,7),(8,'jj',83,8),(9,'b',85,9),(10,'h',87,10),(11,'gg',91,11);
/*!40000 ALTER TABLE `tabpessoacontato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabpessoacontatofornecedor`
--

DROP TABLE IF EXISTS `tabpessoacontatofornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabpessoacontatofornecedor` (
  `idPessoaContatoFornecedor` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `contato` varchar(45) NOT NULL,
  `tabfornecedor_id_forn` int(10) unsigned NOT NULL,
  `tabcontato_id_contato` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idPessoaContatoFornecedor`),
  KEY `fk_tabPessoaContatoFornecedor_tabfornecedor1_idx` (`tabfornecedor_id_forn`),
  KEY `fk_tabPessoaContatoFornecedor_tabcontato1_idx` (`tabcontato_id_contato`),
  CONSTRAINT `fk_tabPessoaContatoFornecedor_tabcontato1` FOREIGN KEY (`tabcontato_id_contato`) REFERENCES `tabcontato` (`id_contato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabPessoaContatoFornecedor_tabfornecedor1` FOREIGN KEY (`tabfornecedor_id_forn`) REFERENCES `tabfornecedor` (`id_forn`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabpessoacontatofornecedor`
--

LOCK TABLES `tabpessoacontatofornecedor` WRITE;
/*!40000 ALTER TABLE `tabpessoacontatofornecedor` DISABLE KEYS */;
INSERT INTO `tabpessoacontatofornecedor` VALUES (1,'ContatoA forn 1',1,61),(2,'Contato forn 2',2,67);
/*!40000 ALTER TABLE `tabpessoacontatofornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabproduto`
--

DROP TABLE IF EXISTS `tabproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabproduto` (
  `id_prod` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `produto` varchar(45) NOT NULL,
  `tabusuario_id_usuario` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_prod`),
  KEY `fk_tabProdutos_tabusuario1_idx` (`tabusuario_id_usuario`),
  CONSTRAINT `fk_tabProdutos_tabusuario1` FOREIGN KEY (`tabusuario_id_usuario`) REFERENCES `tabusuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabproduto`
--

LOCK TABLES `tabproduto` WRITE;
/*!40000 ALTER TABLE `tabproduto` DISABLE KEYS */;
INSERT INTO `tabproduto` VALUES (1,'Produto A',2),(2,'Produto 2',2),(3,'Peça B',2);
/*!40000 ALTER TABLE `tabproduto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabrotinacontato`
--

DROP TABLE IF EXISTS `tabrotinacontato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabrotinacontato` (
  `idRotinaContato` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cliente_idcliente` int(10) unsigned NOT NULL,
  `tabusuario_id_usuario` int(10) unsigned NOT NULL,
  `dataRotina` date NOT NULL,
  `horaRotina` time NOT NULL,
  `descricaoRotina` varchar(500) NOT NULL,
  PRIMARY KEY (`idRotinaContato`),
  KEY `fk_tabRotinaContato_tabcliente1_idx` (`cliente_idcliente`),
  KEY `fk_tabrotinacontato_tabusuario1_idx` (`tabusuario_id_usuario`),
  CONSTRAINT `fk_tabRotinaContato_tabcliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `tabcliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabrotinacontato_tabusuario1` FOREIGN KEY (`tabusuario_id_usuario`) REFERENCES `tabusuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabrotinacontato`
--

LOCK TABLES `tabrotinacontato` WRITE;
/*!40000 ALTER TABLE `tabrotinacontato` DISABLE KEYS */;
INSERT INTO `tabrotinacontato` VALUES (1,2,2,'2016-01-12','22:22:00','Rotina'),(2,3,2,'2016-01-12','23:55:00','rotina teste empresa C'),(3,4,2,'2016-01-12','22:22:00','rotina teste cliente EE'),(4,4,2,'2016-01-20','14:52:00','rotina EE'),(5,3,2,'2016-01-19','22:54:00','looloklkllj'),(6,4,2,'2016-01-21','20:22:00','aaaaa'),(7,4,2,'2016-01-28','22:14:00','teste rotina combobox');
/*!40000 ALTER TABLE `tabrotinacontato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabservico`
--

DROP TABLE IF EXISTS `tabservico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabservico` (
  `idservico` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tabUsuario_id_usuario` int(10) unsigned NOT NULL,
  `tabCliente_idcliente` int(10) unsigned NOT NULL,
  `preco` double NOT NULL,
  `dataServico` date NOT NULL,
  `tabordemserv_idtabOrdemServ` int(10) unsigned NOT NULL,
  `descricao_servico` longtext,
  `maoDeObra` double NOT NULL,
  PRIMARY KEY (`idservico`),
  KEY `fk_servico_tabUsuario1_idx` (`tabUsuario_id_usuario`),
  KEY `fk_servico_tabCliente1_idx` (`tabCliente_idcliente`),
  KEY `fk_tabservico_tabordemserv1_idx` (`tabordemserv_idtabOrdemServ`),
  CONSTRAINT `fk_servico_tabCliente1` FOREIGN KEY (`tabCliente_idcliente`) REFERENCES `tabcliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_servico_tabUsuario1` FOREIGN KEY (`tabUsuario_id_usuario`) REFERENCES `tabusuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabservico_tabordemserv1` FOREIGN KEY (`tabordemserv_idtabOrdemServ`) REFERENCES `tabordemserv` (`idtabOrdemServ`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabservico`
--

LOCK TABLES `tabservico` WRITE;
/*!40000 ALTER TABLE `tabservico` DISABLE KEYS */;
INSERT INTO `tabservico` VALUES (1,2,2,500,'2016-01-13',4,'Descrição vento',500),(2,2,5,6000,'2016-01-13',5,'Descrição',6000),(3,2,1,3866,'2016-01-07',6,'AAAAAAA',500),(4,2,3,18270,'2016-01-13',7,'mmmmmmm',15645),(5,2,5,500,'2016-01-13',8,'lll',500),(6,2,5,42797.5,'2016-01-21',9,'',4410),(7,2,2,5841,'2016-01-20',10,'',5841),(12,2,4,5750,'2016-01-13',15,'',5000),(13,2,4,6591.5,'2016-01-21',16,'',5000),(14,2,2,5561,'2016-01-13',17,'',5000),(15,2,3,54500,'2016-01-19',19,'',50000);
/*!40000 ALTER TABLE `tabservico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabsetor`
--

DROP TABLE IF EXISTS `tabsetor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabsetor` (
  `idtabSetor` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `setor` varchar(50) NOT NULL,
  PRIMARY KEY (`idtabSetor`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabsetor`
--

LOCK TABLES `tabsetor` WRITE;
/*!40000 ALTER TABLE `tabsetor` DISABLE KEYS */;
INSERT INTO `tabsetor` VALUES (8,'Setor A'),(9,'Setor BB'),(11,'Setor DD');
/*!40000 ALTER TABLE `tabsetor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabtel`
--

DROP TABLE IF EXISTS `tabtel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabtel` (
  `id_telefone` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Contato_id` int(10) unsigned NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `celular` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_telefone`),
  KEY `fk_telefone_Contato1_idx` (`Contato_id`),
  CONSTRAINT `fk_telefone_Contato1` FOREIGN KEY (`Contato_id`) REFERENCES `tabcontato` (`id_contato`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabtel`
--

LOCK TABLES `tabtel` WRITE;
/*!40000 ALTER TABLE `tabtel` DISABLE KEYS */;
INSERT INTO `tabtel` VALUES (42,57,'(11)1111-1111','212121212212'),(43,59,'(11)1111-1111','2122212121122'),(44,61,'(11)1111-0000','61168888888'),(45,63,'(45)8784-5454','7455784546454'),(46,65,'(57)8454-5454','000111100001'),(47,67,'101212212121','(87)8454-5124'),(48,69,'(74)4545-4584','212121121212'),(49,71,'(00)0000-0000','000011222222'),(50,73,'(65)3231-2221','32487545445'),(51,75,'(24)8745-4542','4565666666212'),(52,76,'(71)5452-4566','521112112111'),(53,77,'(71)2869-9656','657497'),(54,78,'(71)6565-6565','656565656'),(55,79,'(53)3335-6565','652332322'),(56,81,'(11)1111-0000','aaaaaaa'),(57,83,'(55)5555-5555','jj'),(58,85,'(22)2222-2222','bb'),(59,87,'(87)8888-8888','hh'),(60,88,'(54)8454-5454','4554545454'),(61,91,'(66)6666-6666','556666666666');
/*!40000 ALTER TABLE `tabtel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabtipo_serv`
--

DROP TABLE IF EXISTS `tabtipo_serv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabtipo_serv` (
  `idtabTipo_serv` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Tipo_serv` varchar(45) NOT NULL,
  PRIMARY KEY (`idtabTipo_serv`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabtipo_serv`
--

LOCK TABLES `tabtipo_serv` WRITE;
/*!40000 ALTER TABLE `tabtipo_serv` DISABLE KEYS */;
INSERT INTO `tabtipo_serv` VALUES (1,'Tipo Serviço A'),(2,'Tipo Serviço B'),(3,'Matematica'),(4,'teste'),(5,'mais um teste'),(6,'fff'),(7,'aaaa'),(8,'agora vai'),(9,' agora vai mesmo'),(10,'dddddd'),(11,'aaaaaaaa'),(12,'ggggggg'),(13,'ssssssssss'),(14,'ssssssssss'),(15,'agora foi aff');
/*!40000 ALTER TABLE `tabtipo_serv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabusuario`
--

DROP TABLE IF EXISTS `tabusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabusuario` (
  `id_usuario` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tipo_usuario` char(1) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `senha` varchar(20) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabusuario`
--

LOCK TABLES `tabusuario` WRITE;
/*!40000 ALTER TABLE `tabusuario` DISABLE KEYS */;
INSERT INTO `tabusuario` VALUES (2,'A','admin','123'),(3,'A','cris','123'),(5,'F','usuario2','123'),(6,'F','usuarioX','123');
/*!40000 ALTER TABLE `tabusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabvendas`
--

DROP TABLE IF EXISTS `tabvendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabvendas` (
  `idtabVendas` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cliente_idcliente` int(10) unsigned NOT NULL,
  `tabusuario_id_usuario` int(10) unsigned NOT NULL,
  `dataVenda` date NOT NULL,
  `hora` varchar(45) NOT NULL,
  `tabordemserv_idtabOrdemServ` int(10) unsigned NOT NULL,
  `totalVenda` double NOT NULL,
  PRIMARY KEY (`idtabVendas`),
  KEY `fk_tabVendas_tabcliente1_idx` (`cliente_idcliente`),
  KEY `fk_tabvendas_tabusuario1_idx` (`tabusuario_id_usuario`),
  KEY `fk_tabvendas_tabordemserv1_idx` (`tabordemserv_idtabOrdemServ`),
  CONSTRAINT `fk_tabVendas_tabcliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `tabcliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabvendas_tabordemserv1` FOREIGN KEY (`tabordemserv_idtabOrdemServ`) REFERENCES `tabordemserv` (`idtabOrdemServ`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabvendas_tabusuario1` FOREIGN KEY (`tabusuario_id_usuario`) REFERENCES `tabusuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabvendas`
--

LOCK TABLES `tabvendas` WRITE;
/*!40000 ALTER TABLE `tabvendas` DISABLE KEYS */;
INSERT INTO `tabvendas` VALUES (1,2,2,'2016-01-28','10:23:00',20,1204);
/*!40000 ALTER TABLE `tabvendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vw_aluguel`
--

DROP TABLE IF EXISTS `vw_aluguel`;
/*!50001 DROP VIEW IF EXISTS `vw_aluguel`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_aluguel` (
 `idtabDetLocacao` tinyint NOT NULL,
  `empresa` tinyint NOT NULL,
  `dataLocacao` tinyint NOT NULL,
  `dataDevolucao` tinyint NOT NULL,
  `idcliente` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_auditoria`
--

DROP TABLE IF EXISTS `vw_auditoria`;
/*!50001 DROP VIEW IF EXISTS `vw_auditoria`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_auditoria` (
 `idtabAuditoria` tinyint NOT NULL,
  `dataAcesso` tinyint NOT NULL,
  `tabusuario_id_usuario` tinyint NOT NULL,
  `idtabDetAuditoria` tinyint NOT NULL,
  `dataModificacao` tinyint NOT NULL,
  `descricao` tinyint NOT NULL,
  `tabAuditoria_idtabAuditoria` tinyint NOT NULL,
  `id_usuario` tinyint NOT NULL,
  `tipo_usuario` tinyint NOT NULL,
  `usuario` tinyint NOT NULL,
  `senha` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_cliente`
--

DROP TABLE IF EXISTS `vw_cliente`;
/*!50001 DROP VIEW IF EXISTS `vw_cliente`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_cliente` (
 `idcliente` tinyint NOT NULL,
  `tabContato_id_contato` tinyint NOT NULL,
  `dataCadCliente` tinyint NOT NULL,
  `empresa` tinyint NOT NULL,
  `cnpj` tinyint NOT NULL,
  `tabusuario_id_usuario` tinyint NOT NULL,
  `tabSetor_idtabSetor` tinyint NOT NULL,
  `id_endereco` tinyint NOT NULL,
  `rua` tinyint NOT NULL,
  `numero` tinyint NOT NULL,
  `bairro` tinyint NOT NULL,
  `cidade` tinyint NOT NULL,
  `estado` tinyint NOT NULL,
  `pais` tinyint NOT NULL,
  `cod_contato` tinyint NOT NULL,
  `cep` tinyint NOT NULL,
  `id_contato` tinyint NOT NULL,
  `idtabSetor` tinyint NOT NULL,
  `setor` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_combofabricanteequipamento`
--

DROP TABLE IF EXISTS `vw_combofabricanteequipamento`;
/*!50001 DROP VIEW IF EXISTS `vw_combofabricanteequipamento`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_combofabricanteequipamento` (
 `equipamento` tinyint NOT NULL,
  `modelo` tinyint NOT NULL,
  `fabricante` tinyint NOT NULL,
  `tabmodelo_idtabModelo` tinyint NOT NULL,
  `idEquipamento` tinyint NOT NULL,
  `idtabFabricante` tinyint NOT NULL,
  `idDetEquipamento` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_combofabricanteproduto`
--

DROP TABLE IF EXISTS `vw_combofabricanteproduto`;
/*!50001 DROP VIEW IF EXISTS `vw_combofabricanteproduto`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_combofabricanteproduto` (
 `produto` tinyint NOT NULL,
  `modelo` tinyint NOT NULL,
  `fabricante` tinyint NOT NULL,
  `tabmodelo_idtabModelo` tinyint NOT NULL,
  `id_prod` tinyint NOT NULL,
  `idtabFabricante` tinyint NOT NULL,
  `precoSaida` tinyint NOT NULL,
  `idDetProduto` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_contatofornecedor`
--

DROP TABLE IF EXISTS `vw_contatofornecedor`;
/*!50001 DROP VIEW IF EXISTS `vw_contatofornecedor`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_contatofornecedor` (
 `contato` tinyint NOT NULL,
  `telefone` tinyint NOT NULL,
  `email` tinyint NOT NULL,
  `id_contato` tinyint NOT NULL,
  `id_telefone` tinyint NOT NULL,
  `id_email` tinyint NOT NULL,
  `id_forn` tinyint NOT NULL,
  `idPessoaContatoFornecedor` tinyint NOT NULL,
  `celular` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_contatofuncionario`
--

DROP TABLE IF EXISTS `vw_contatofuncionario`;
/*!50001 DROP VIEW IF EXISTS `vw_contatofuncionario`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_contatofuncionario` (
 `funcionario` tinyint NOT NULL,
  `telefone` tinyint NOT NULL,
  `email` tinyint NOT NULL,
  `id_contato` tinyint NOT NULL,
  `celular` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_contatoproposta`
--

DROP TABLE IF EXISTS `vw_contatoproposta`;
/*!50001 DROP VIEW IF EXISTS `vw_contatoproposta`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_contatoproposta` (
 `contato` tinyint NOT NULL,
  `telefone` tinyint NOT NULL,
  `email` tinyint NOT NULL,
  `id_contato` tinyint NOT NULL,
  `idPessoaContato` tinyint NOT NULL,
  `celular` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_contatos`
--

DROP TABLE IF EXISTS `vw_contatos`;
/*!50001 DROP VIEW IF EXISTS `vw_contatos`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_contatos` (
 `contato` tinyint NOT NULL,
  `telefone` tinyint NOT NULL,
  `email` tinyint NOT NULL,
  `id_contato` tinyint NOT NULL,
  `id_telefone` tinyint NOT NULL,
  `id_email` tinyint NOT NULL,
  `idcliente` tinyint NOT NULL,
  `idPessoaContato` tinyint NOT NULL,
  `celular` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_detaluguel`
--

DROP TABLE IF EXISTS `vw_detaluguel`;
/*!50001 DROP VIEW IF EXISTS `vw_detaluguel`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_detaluguel` (
 `idtabDetLocacao` tinyint NOT NULL,
  `idDetLocacao` tinyint NOT NULL,
  `tabLocacao_idtabDetLocacao` tinyint NOT NULL,
  `equipamento` tinyint NOT NULL,
  `fabricante` tinyint NOT NULL,
  `modelo` tinyint NOT NULL,
  `valorLocacao` tinyint NOT NULL,
  `quantEquipamento` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_detservequipamento`
--

DROP TABLE IF EXISTS `vw_detservequipamento`;
/*!50001 DROP VIEW IF EXISTS `vw_detservequipamento`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_detservequipamento` (
 `idservico` tinyint NOT NULL,
  `idDetEquipamento` tinyint NOT NULL,
  `iddetServico_Equipamento` tinyint NOT NULL,
  `idEquipamento` tinyint NOT NULL,
  `equipamento` tinyint NOT NULL,
  `descricao_servico` tinyint NOT NULL,
  `modelo` tinyint NOT NULL,
  `fabricante` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_detservfuncionario`
--

DROP TABLE IF EXISTS `vw_detservfuncionario`;
/*!50001 DROP VIEW IF EXISTS `vw_detservfuncionario`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_detservfuncionario` (
 `idservico` tinyint NOT NULL,
  `idDetServico_funcionario` tinyint NOT NULL,
  `idfuncionario` tinyint NOT NULL,
  `funcionario` tinyint NOT NULL,
  `cpf` tinyint NOT NULL,
  `cargo` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_detservicoproduto`
--

DROP TABLE IF EXISTS `vw_detservicoproduto`;
/*!50001 DROP VIEW IF EXISTS `vw_detservicoproduto`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_detservicoproduto` (
 `idservico` tinyint NOT NULL,
  `idDetProduto` tinyint NOT NULL,
  `iddetServico_produto` tinyint NOT NULL,
  `id_prod` tinyint NOT NULL,
  `produto` tinyint NOT NULL,
  `precoSaida` tinyint NOT NULL,
  `quantidadeComprada` tinyint NOT NULL,
  `descricao_servico` tinyint NOT NULL,
  `dataServico` tinyint NOT NULL,
  `modelo` tinyint NOT NULL,
  `fabricante` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_detservtiposervico`
--

DROP TABLE IF EXISTS `vw_detservtiposervico`;
/*!50001 DROP VIEW IF EXISTS `vw_detservtiposervico`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_detservtiposervico` (
 `idservico` tinyint NOT NULL,
  `iddetServico_TipoServ` tinyint NOT NULL,
  `idtabTipo_serv` tinyint NOT NULL,
  `Tipo_serv` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_equipamentos`
--

DROP TABLE IF EXISTS `vw_equipamentos`;
/*!50001 DROP VIEW IF EXISTS `vw_equipamentos`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_equipamentos` (
 `idEquipamento` tinyint NOT NULL,
  `equipamento` tinyint NOT NULL,
  `idDetEquipamento` tinyint NOT NULL,
  `modelo` tinyint NOT NULL,
  `fabricante` tinyint NOT NULL,
  `fornecedor` tinyint NOT NULL,
  `tabequipamento_idEquipamento` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_fornecedordefeito`
--

DROP TABLE IF EXISTS `vw_fornecedordefeito`;
/*!50001 DROP VIEW IF EXISTS `vw_fornecedordefeito`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_fornecedordefeito` (
 `id_forn` tinyint NOT NULL,
  `tabContato_id_contato` tinyint NOT NULL,
  `fornecedor` tinyint NOT NULL,
  `tabUsuario_id_usuario` tinyint NOT NULL,
  `id_telefone` tinyint NOT NULL,
  `Contato_id` tinyint NOT NULL,
  `telefone` tinyint NOT NULL,
  `id_email` tinyint NOT NULL,
  `contato_id_contato` tinyint NOT NULL,
  `email` tinyint NOT NULL,
  `id_endereco` tinyint NOT NULL,
  `rua` tinyint NOT NULL,
  `numero` tinyint NOT NULL,
  `bairro` tinyint NOT NULL,
  `cidade` tinyint NOT NULL,
  `estado` tinyint NOT NULL,
  `pais` tinyint NOT NULL,
  `cod_contato` tinyint NOT NULL,
  `cep` tinyint NOT NULL,
  `id_contato` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_fornecedores`
--

DROP TABLE IF EXISTS `vw_fornecedores`;
/*!50001 DROP VIEW IF EXISTS `vw_fornecedores`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_fornecedores` (
 `id_forn` tinyint NOT NULL,
  `tabContato_id_contato` tinyint NOT NULL,
  `fornecedor` tinyint NOT NULL,
  `tabUsuario_id_usuario` tinyint NOT NULL,
  `id_endereco` tinyint NOT NULL,
  `rua` tinyint NOT NULL,
  `numero` tinyint NOT NULL,
  `bairro` tinyint NOT NULL,
  `cidade` tinyint NOT NULL,
  `estado` tinyint NOT NULL,
  `pais` tinyint NOT NULL,
  `cod_contato` tinyint NOT NULL,
  `cep` tinyint NOT NULL,
  `id_contato` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_produtos`
--

DROP TABLE IF EXISTS `vw_produtos`;
/*!50001 DROP VIEW IF EXISTS `vw_produtos`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_produtos` (
 `id_prod` tinyint NOT NULL,
  `produto` tinyint NOT NULL,
  `modelo` tinyint NOT NULL,
  `fabricante` tinyint NOT NULL,
  `precoEntrada` tinyint NOT NULL,
  `precoSaida` tinyint NOT NULL,
  `quantidade` tinyint NOT NULL,
  `quantidadeMinima` tinyint NOT NULL,
  `tabproduto_id_prod` tinyint NOT NULL,
  `idDetProduto` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_servico`
--

DROP TABLE IF EXISTS `vw_servico`;
/*!50001 DROP VIEW IF EXISTS `vw_servico`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_servico` (
 `idservico` tinyint NOT NULL,
  `empresa` tinyint NOT NULL,
  `preco` tinyint NOT NULL,
  `dataServico` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vw_aluguel`
--

/*!50001 DROP TABLE IF EXISTS `vw_aluguel`*/;
/*!50001 DROP VIEW IF EXISTS `vw_aluguel`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_aluguel` AS select `tablocacao`.`idtabDetLocacao` AS `idtabDetLocacao`,`tabcliente`.`empresa` AS `empresa`,`tablocacao`.`dataLocacao` AS `dataLocacao`,`tablocacao`.`dataDevolucao` AS `dataDevolucao`,`tabcliente`.`idcliente` AS `idcliente` from (`tablocacao` join `tabcliente` on((`tabcliente`.`idcliente` = `tablocacao`.`tabcliente_idcliente`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_auditoria`
--

/*!50001 DROP TABLE IF EXISTS `vw_auditoria`*/;
/*!50001 DROP VIEW IF EXISTS `vw_auditoria`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_auditoria` AS select `tabauditoria`.`idtabAuditoria` AS `idtabAuditoria`,`tabauditoria`.`dataAcesso` AS `dataAcesso`,`tabauditoria`.`tabusuario_id_usuario` AS `tabusuario_id_usuario`,`tabdetauditoria`.`idtabDetAuditoria` AS `idtabDetAuditoria`,`tabdetauditoria`.`dataModificacao` AS `dataModificacao`,`tabdetauditoria`.`descricao` AS `descricao`,`tabdetauditoria`.`tabAuditoria_idtabAuditoria` AS `tabAuditoria_idtabAuditoria`,`tabusuario`.`id_usuario` AS `id_usuario`,`tabusuario`.`tipo_usuario` AS `tipo_usuario`,`tabusuario`.`usuario` AS `usuario`,`tabusuario`.`senha` AS `senha` from ((`tabauditoria` join `tabdetauditoria`) join `tabusuario` on(((`tabauditoria`.`idtabAuditoria` = `tabdetauditoria`.`tabAuditoria_idtabAuditoria`) and (`tabauditoria`.`tabusuario_id_usuario` = `tabusuario`.`id_usuario`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_cliente`
--

/*!50001 DROP TABLE IF EXISTS `vw_cliente`*/;
/*!50001 DROP VIEW IF EXISTS `vw_cliente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_cliente` AS select `cli`.`idcliente` AS `idcliente`,`cli`.`tabContato_id_contato` AS `tabContato_id_contato`,`cli`.`dataCadCliente` AS `dataCadCliente`,`cli`.`empresa` AS `empresa`,`cli`.`cnpj` AS `cnpj`,`cli`.`tabusuario_id_usuario` AS `tabusuario_id_usuario`,`cli`.`tabSetor_idtabSetor` AS `tabSetor_idtabSetor`,`ende`.`id_endereco` AS `id_endereco`,`ende`.`rua` AS `rua`,`ende`.`numero` AS `numero`,`ende`.`bairro` AS `bairro`,`ende`.`cidade` AS `cidade`,`ende`.`estado` AS `estado`,`ende`.`pais` AS `pais`,`ende`.`cod_contato` AS `cod_contato`,`ende`.`cep` AS `cep`,`cont`.`id_contato` AS `id_contato`,`setor`.`idtabSetor` AS `idtabSetor`,`setor`.`setor` AS `setor` from (((`tabcliente` `cli` join `tabendereco` `ende`) join `tabcontato` `cont`) join `tabsetor` `setor` on(((`cont`.`id_contato` = `cli`.`tabContato_id_contato`) and (`cont`.`id_contato` = `ende`.`cod_contato`) and (`ende`.`cod_contato` = `cont`.`id_contato`) and (`cli`.`tabSetor_idtabSetor` = `setor`.`idtabSetor`)))) group by `cli`.`idcliente` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_combofabricanteequipamento`
--

/*!50001 DROP TABLE IF EXISTS `vw_combofabricanteequipamento`*/;
/*!50001 DROP VIEW IF EXISTS `vw_combofabricanteequipamento`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_combofabricanteequipamento` AS select `tabequipamento`.`equipamento` AS `equipamento`,`tabmodelo`.`modelo` AS `modelo`,`tabfabricante`.`fabricante` AS `fabricante`,`tabdetequipamento`.`tabmodelo_idtabModelo` AS `tabmodelo_idtabModelo`,`tabequipamento`.`idEquipamento` AS `idEquipamento`,`tabfabricante`.`idtabFabricante` AS `idtabFabricante`,`tabdetequipamento`.`idDetEquipamento` AS `idDetEquipamento` from (((`tabdetequipamento` join `tabequipamento`) join `tabfabricante`) join `tabmodelo` on(((`tabdetequipamento`.`tabmodelo_idtabModelo` = `tabmodelo`.`idtabModelo`) and (`tabdetequipamento`.`tabequipamento_idEquipamento` = `tabequipamento`.`idEquipamento`) and (`tabdetequipamento`.`tabfabricante_idtabFabricante` = `tabfabricante`.`idtabFabricante`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_combofabricanteproduto`
--

/*!50001 DROP TABLE IF EXISTS `vw_combofabricanteproduto`*/;
/*!50001 DROP VIEW IF EXISTS `vw_combofabricanteproduto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_combofabricanteproduto` AS select `tabproduto`.`produto` AS `produto`,`tabmodelo`.`modelo` AS `modelo`,`tabfabricante`.`fabricante` AS `fabricante`,`tabdetproduto`.`tabmodelo_idtabModelo` AS `tabmodelo_idtabModelo`,`tabproduto`.`id_prod` AS `id_prod`,`tabfabricante`.`idtabFabricante` AS `idtabFabricante`,`tabdetproduto`.`precoSaida` AS `precoSaida`,`tabdetproduto`.`idDetProduto` AS `idDetProduto` from (((`tabdetproduto` join `tabproduto`) join `tabfabricante`) join `tabmodelo` on(((`tabdetproduto`.`tabmodelo_idtabModelo` = `tabmodelo`.`idtabModelo`) and (`tabdetproduto`.`tabproduto_id_prod` = `tabproduto`.`id_prod`) and (`tabdetproduto`.`tabfabricante_idtabFabricante` = `tabfabricante`.`idtabFabricante`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_contatofornecedor`
--

/*!50001 DROP TABLE IF EXISTS `vw_contatofornecedor`*/;
/*!50001 DROP VIEW IF EXISTS `vw_contatofornecedor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_contatofornecedor` AS select `p`.`contato` AS `contato`,`tel`.`telefone` AS `telefone`,`m`.`email` AS `email`,`cont`.`id_contato` AS `id_contato`,`tel`.`id_telefone` AS `id_telefone`,`m`.`id_email` AS `id_email`,`forn`.`id_forn` AS `id_forn`,`p`.`idPessoaContatoFornecedor` AS `idPessoaContatoFornecedor`,`tel`.`celular` AS `celular` from ((((`tabfornecedor` `forn` join `tabpessoacontatofornecedor` `p`) join `tabtel` `tel`) join `tabemail` `m`) join `tabcontato` `cont` on(((`p`.`tabfornecedor_id_forn` = `forn`.`id_forn`) and (`cont`.`id_contato` = `p`.`tabcontato_id_contato`) and (`cont`.`id_contato` = `tel`.`Contato_id`) and (`cont`.`id_contato` = `m`.`contato_id_contato`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_contatofuncionario`
--

/*!50001 DROP TABLE IF EXISTS `vw_contatofuncionario`*/;
/*!50001 DROP VIEW IF EXISTS `vw_contatofuncionario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_contatofuncionario` AS select `tabfuncionario`.`funcionario` AS `funcionario`,`tabtel`.`telefone` AS `telefone`,`tabemail`.`email` AS `email`,`tabcontato`.`id_contato` AS `id_contato`,`tabtel`.`celular` AS `celular` from (((`tabfuncionario` join `tabtel`) join `tabemail`) join `tabcontato` on(((`tabcontato`.`id_contato` = `tabfuncionario`.`tabContato_id_contato`) and (`tabcontato`.`id_contato` = `tabtel`.`Contato_id`) and (`tabcontato`.`id_contato` = `tabemail`.`contato_id_contato`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_contatoproposta`
--

/*!50001 DROP TABLE IF EXISTS `vw_contatoproposta`*/;
/*!50001 DROP VIEW IF EXISTS `vw_contatoproposta`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_contatoproposta` AS select `tabpessoacontato`.`contato` AS `contato`,`tabtel`.`telefone` AS `telefone`,`tabemail`.`email` AS `email`,`tabcontato`.`id_contato` AS `id_contato`,`tabpessoacontato`.`idPessoaContato` AS `idPessoaContato`,`tabtel`.`celular` AS `celular` from (((`tabpessoacontato` join `tabtel`) join `tabemail`) join `tabcontato` on(((`tabcontato`.`id_contato` = `tabpessoacontato`.`cod_contato`) and (`tabcontato`.`id_contato` = `tabtel`.`Contato_id`) and (`tabcontato`.`id_contato` = `tabemail`.`contato_id_contato`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_contatos`
--

/*!50001 DROP TABLE IF EXISTS `vw_contatos`*/;
/*!50001 DROP VIEW IF EXISTS `vw_contatos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_contatos` AS select `tabpessoacontato`.`contato` AS `contato`,`tabtel`.`telefone` AS `telefone`,`tabemail`.`email` AS `email`,`tabcontato`.`id_contato` AS `id_contato`,`tabtel`.`id_telefone` AS `id_telefone`,`tabemail`.`id_email` AS `id_email`,`tabcliente`.`idcliente` AS `idcliente`,`tabpessoacontato`.`idPessoaContato` AS `idPessoaContato`,`tabtel`.`celular` AS `celular` from ((((`tabcliente` join `tabpessoacontato`) join `tabtel`) join `tabemail`) join `tabcontato` on(((`tabpessoacontato`.`tabcliente_idcliente` = `tabcliente`.`idcliente`) and (`tabcontato`.`id_contato` = `tabpessoacontato`.`cod_contato`) and (`tabcontato`.`id_contato` = `tabtel`.`Contato_id`) and (`tabcontato`.`id_contato` = `tabemail`.`contato_id_contato`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_detaluguel`
--

/*!50001 DROP TABLE IF EXISTS `vw_detaluguel`*/;
/*!50001 DROP VIEW IF EXISTS `vw_detaluguel`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_detaluguel` AS select `tablocacao`.`idtabDetLocacao` AS `idtabDetLocacao`,`tabdetlocacao`.`idDetLocacao` AS `idDetLocacao`,`tabdetlocacao`.`tabLocacao_idtabDetLocacao` AS `tabLocacao_idtabDetLocacao`,`tabequipamento`.`equipamento` AS `equipamento`,`tabfabricante`.`fabricante` AS `fabricante`,`tabmodelo`.`modelo` AS `modelo`,`tabdetlocacao`.`valorLocacao` AS `valorLocacao`,`tabdetlocacao`.`quantEquipamento` AS `quantEquipamento` from (((((`tablocacao` join `tabdetlocacao`) join `tabequipamento`) join `tabdetequipamento`) join `tabmodelo`) join `tabfabricante` on(((`tablocacao`.`idtabDetLocacao` = `tabdetlocacao`.`tabLocacao_idtabDetLocacao`) and (`tabdetequipamento`.`idDetEquipamento` = `tabdetlocacao`.`tabdetequipamento_idDetEquipamento`) and (`tabdetequipamento`.`tabequipamento_idEquipamento` = `tabequipamento`.`idEquipamento`) and (`tabdetequipamento`.`tabmodelo_idtabModelo` = `tabmodelo`.`idtabModelo`) and (`tabdetequipamento`.`tabfabricante_idtabFabricante` = `tabfabricante`.`idtabFabricante`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_detservequipamento`
--

/*!50001 DROP TABLE IF EXISTS `vw_detservequipamento`*/;
/*!50001 DROP VIEW IF EXISTS `vw_detservequipamento`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_detservequipamento` AS select `tabservico`.`idservico` AS `idservico`,`tabdetequipamento`.`idDetEquipamento` AS `idDetEquipamento`,`tabdetservico_equipamento`.`iddetServico_Equipamento` AS `iddetServico_Equipamento`,`tabequipamento`.`idEquipamento` AS `idEquipamento`,`tabequipamento`.`equipamento` AS `equipamento`,`tabservico`.`descricao_servico` AS `descricao_servico`,`tabmodelo`.`modelo` AS `modelo`,`tabfabricante`.`fabricante` AS `fabricante` from (((((`tabservico` join `tabdetservico_equipamento`) join `tabdetequipamento`) join `tabmodelo`) join `tabfabricante`) join `tabequipamento` on(((`tabservico`.`idservico` = `tabdetservico_equipamento`.`tabservico_idservico`) and (`tabdetequipamento`.`idDetEquipamento` = `tabdetservico_equipamento`.`tabdetequipamento_idDetEquipamento`) and (`tabequipamento`.`idEquipamento` = `tabdetequipamento`.`tabequipamento_idEquipamento`) and (`tabdetequipamento`.`tabmodelo_idtabModelo` = `tabmodelo`.`idtabModelo`) and (`tabdetequipamento`.`tabfabricante_idtabFabricante` = `tabfabricante`.`idtabFabricante`)))) order by `tabservico`.`idservico` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_detservfuncionario`
--

/*!50001 DROP TABLE IF EXISTS `vw_detservfuncionario`*/;
/*!50001 DROP VIEW IF EXISTS `vw_detservfuncionario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_detservfuncionario` AS select `tabservico`.`idservico` AS `idservico`,`tabdetservico_funcionario`.`idDetServico_funcionario` AS `idDetServico_funcionario`,`tabfuncionario`.`idfuncionario` AS `idfuncionario`,`tabfuncionario`.`funcionario` AS `funcionario`,`tabfuncionario`.`cpf` AS `cpf`,`tabfuncionario`.`cargo` AS `cargo` from ((`tabservico` join `tabdetservico_funcionario`) join `tabfuncionario` on(((`tabservico`.`idservico` = `tabdetservico_funcionario`.`tabservico_idservico`) and (`tabfuncionario`.`idfuncionario` = `tabdetservico_funcionario`.`tabfuncionario_idfuncionario`)))) order by `tabservico`.`idservico` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_detservicoproduto`
--

/*!50001 DROP TABLE IF EXISTS `vw_detservicoproduto`*/;
/*!50001 DROP VIEW IF EXISTS `vw_detservicoproduto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_detservicoproduto` AS select `tabservico`.`idservico` AS `idservico`,`tabdetproduto`.`idDetProduto` AS `idDetProduto`,`tabdetservico_produto`.`iddetServico_produto` AS `iddetServico_produto`,`tabproduto`.`id_prod` AS `id_prod`,`tabproduto`.`produto` AS `produto`,`tabdetproduto`.`precoSaida` AS `precoSaida`,`tabdetservico_produto`.`quantidadeComprada` AS `quantidadeComprada`,`tabservico`.`descricao_servico` AS `descricao_servico`,`tabservico`.`dataServico` AS `dataServico`,`tabmodelo`.`modelo` AS `modelo`,`tabfabricante`.`fabricante` AS `fabricante` from (((((`tabservico` join `tabdetservico_produto`) join `tabdetproduto`) join `tabmodelo`) join `tabfabricante`) join `tabproduto` on(((`tabservico`.`idservico` = `tabdetservico_produto`.`tabservico_idservico`) and (`tabdetproduto`.`idDetProduto` = `tabdetservico_produto`.`tabdetproduto_idDetProduto`) and (`tabproduto`.`id_prod` = `tabdetproduto`.`tabproduto_id_prod`) and (`tabdetproduto`.`tabmodelo_idtabModelo` = `tabmodelo`.`idtabModelo`) and (`tabdetproduto`.`tabfabricante_idtabFabricante` = `tabfabricante`.`idtabFabricante`)))) order by `tabservico`.`idservico` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_detservtiposervico`
--

/*!50001 DROP TABLE IF EXISTS `vw_detservtiposervico`*/;
/*!50001 DROP VIEW IF EXISTS `vw_detservtiposervico`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_detservtiposervico` AS select `tabservico`.`idservico` AS `idservico`,`tabdetservico_tiposerv`.`iddetServico_TipoServ` AS `iddetServico_TipoServ`,`tabtipo_serv`.`idtabTipo_serv` AS `idtabTipo_serv`,`tabtipo_serv`.`Tipo_serv` AS `Tipo_serv` from ((`tabservico` join `tabdetservico_tiposerv`) join `tabtipo_serv` on(((`tabservico`.`idservico` = `tabdetservico_tiposerv`.`tabservico_idservico`) and (`tabdetservico_tiposerv`.`tabtipo_serv_idtabTipo_serv` = `tabtipo_serv`.`idtabTipo_serv`)))) order by `tabservico`.`idservico` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_equipamentos`
--

/*!50001 DROP TABLE IF EXISTS `vw_equipamentos`*/;
/*!50001 DROP VIEW IF EXISTS `vw_equipamentos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_equipamentos` AS select `tabequipamento`.`idEquipamento` AS `idEquipamento`,`tabequipamento`.`equipamento` AS `equipamento`,`tabdetequipamento`.`idDetEquipamento` AS `idDetEquipamento`,`tabmodelo`.`modelo` AS `modelo`,`tabfabricante`.`fabricante` AS `fabricante`,`tabfornecedor`.`fornecedor` AS `fornecedor`,`tabdetequipamento`.`tabequipamento_idEquipamento` AS `tabequipamento_idEquipamento` from ((((`tabequipamento` join `tabdetequipamento`) join `tabmodelo`) join `tabfabricante`) join `tabfornecedor` on(((`tabdetequipamento`.`tabequipamento_idEquipamento` = `tabequipamento`.`idEquipamento`) and (`tabdetequipamento`.`tabmodelo_idtabModelo` = `tabmodelo`.`idtabModelo`) and (`tabdetequipamento`.`tabfabricante_idtabFabricante` = `tabfabricante`.`idtabFabricante`) and (`tabdetequipamento`.`tabfornecedor_id_forn` = `tabfornecedor`.`id_forn`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_fornecedordefeito`
--

/*!50001 DROP TABLE IF EXISTS `vw_fornecedordefeito`*/;
/*!50001 DROP VIEW IF EXISTS `vw_fornecedordefeito`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_fornecedordefeito` AS select `forn`.`id_forn` AS `id_forn`,`forn`.`tabContato_id_contato` AS `tabContato_id_contato`,`forn`.`fornecedor` AS `fornecedor`,`forn`.`tabUsuario_id_usuario` AS `tabUsuario_id_usuario`,`tel`.`id_telefone` AS `id_telefone`,`tel`.`Contato_id` AS `Contato_id`,`tel`.`telefone` AS `telefone`,`email`.`id_email` AS `id_email`,`email`.`contato_id_contato` AS `contato_id_contato`,`email`.`email` AS `email`,`ende`.`id_endereco` AS `id_endereco`,`ende`.`rua` AS `rua`,`ende`.`numero` AS `numero`,`ende`.`bairro` AS `bairro`,`ende`.`cidade` AS `cidade`,`ende`.`estado` AS `estado`,`ende`.`pais` AS `pais`,`ende`.`cod_contato` AS `cod_contato`,`ende`.`cep` AS `cep`,`cont`.`id_contato` AS `id_contato` from ((((`tabfornecedor` `forn` join `tabtel` `tel`) join `tabemail` `email`) join `tabendereco` `ende`) join `tabcontato` `cont` on(((`cont`.`id_contato` = `forn`.`tabContato_id_contato`) and (`cont`.`id_contato` = `tel`.`Contato_id`) and (`cont`.`id_contato` = `email`.`contato_id_contato`) and (`cont`.`id_contato` = `ende`.`cod_contato`) and (`ende`.`cod_contato` = `cont`.`id_contato`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_fornecedores`
--

/*!50001 DROP TABLE IF EXISTS `vw_fornecedores`*/;
/*!50001 DROP VIEW IF EXISTS `vw_fornecedores`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_fornecedores` AS select `forn`.`id_forn` AS `id_forn`,`forn`.`tabContato_id_contato` AS `tabContato_id_contato`,`forn`.`fornecedor` AS `fornecedor`,`forn`.`tabUsuario_id_usuario` AS `tabUsuario_id_usuario`,`ende`.`id_endereco` AS `id_endereco`,`ende`.`rua` AS `rua`,`ende`.`numero` AS `numero`,`ende`.`bairro` AS `bairro`,`ende`.`cidade` AS `cidade`,`ende`.`estado` AS `estado`,`ende`.`pais` AS `pais`,`ende`.`cod_contato` AS `cod_contato`,`ende`.`cep` AS `cep`,`cont`.`id_contato` AS `id_contato` from ((`tabfornecedor` `forn` join `tabendereco` `ende`) join `tabcontato` `cont` on(((`cont`.`id_contato` = `forn`.`tabContato_id_contato`) and (`cont`.`id_contato` = `ende`.`cod_contato`) and (`ende`.`cod_contato` = `cont`.`id_contato`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_produtos`
--

/*!50001 DROP TABLE IF EXISTS `vw_produtos`*/;
/*!50001 DROP VIEW IF EXISTS `vw_produtos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_produtos` AS select `tabproduto`.`id_prod` AS `id_prod`,`tabproduto`.`produto` AS `produto`,`tabmodelo`.`modelo` AS `modelo`,`tabfabricante`.`fabricante` AS `fabricante`,`tabdetproduto`.`precoEntrada` AS `precoEntrada`,`tabdetproduto`.`precoSaida` AS `precoSaida`,`tabdetproduto`.`quantidade` AS `quantidade`,`tabdetproduto`.`quantidadeMinima` AS `quantidadeMinima`,`tabdetproduto`.`tabproduto_id_prod` AS `tabproduto_id_prod`,`tabdetproduto`.`idDetProduto` AS `idDetProduto` from (((`tabproduto` join `tabdetproduto`) join `tabfabricante`) join `tabmodelo` on(((`tabdetproduto`.`tabproduto_id_prod` = `tabproduto`.`id_prod`) and (`tabdetproduto`.`tabfabricante_idtabFabricante` = `tabfabricante`.`idtabFabricante`) and (`tabdetproduto`.`tabmodelo_idtabModelo` = `tabmodelo`.`idtabModelo`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_servico`
--

/*!50001 DROP TABLE IF EXISTS `vw_servico`*/;
/*!50001 DROP VIEW IF EXISTS `vw_servico`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_servico` AS select `tabservico`.`idservico` AS `idservico`,`tabcliente`.`empresa` AS `empresa`,`tabservico`.`preco` AS `preco`,`tabservico`.`dataServico` AS `dataServico` from (`tabservico` join `tabcliente` on((`tabcliente`.`idcliente` = `tabservico`.`tabCliente_idcliente`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-21 14:46:08
