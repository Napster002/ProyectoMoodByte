CREATE DATABASE  IF NOT EXISTS `pruebas_ac` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pruebas_ac`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: pruebas_ac
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `enlace` text,
  `imagen` text,
  `subtitulo` varchar(225) DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT INTO `articulo` VALUES (1,'https://psicologiaymente.com/social/por-que-sobreadaptarse-a-sociedad-cambiante-es-trampa-emocional','https://images.squarespace-cdn.com/content/v1/51bdd6cfe4b09566e1112c43/1570377067462-W8EP71WJSWO72AQ2AGN6/terapia+online.JPG','La necesidad de ir al día te autosabotea','Sobrepensar'),(5,'https://www.revistaclinicacontemporanea.org/art/cc2021a16','https://i.ytimg.com/vi/tTNrZMCQCoo/maxresdefault.jpg','SelfEsteem Update and Maintenance','Autoestima: Actualización y Mantenimiennnnnnto'),(6,'https://psicologiaymente.com/social/eres-demasiado-empatico-como-poner-limites-sin-sentir-culpa','https://concepto.de/wp-content/uploads/2024/01/empatia.jpg','Trucos para saber establecer límites y evitar que la empatía te sabotee en tus relaciones.','Cómo poner límites sin sentir culpa'),(7,'https://www.mundopsicologos.com/articulos/como-saber-si-soy-neurodivergente-11-ragos-que-pueden-indicarlo','https://activatucerebro.es/wp-content/uploads/2025/01/neurodivergencia-1024x585.jpg','Ragos que pueden indicarlo','Cómo saber si soy neurodivergente'),(8,'https://www.mundopsicologos.com/articulos/el-sindrome-de-la-silla-vacia-y-los-problemas-emocionales-de-la-navidad','https://elblogdeldesarrollopersonal.es/wp-content/uploads/2023/12/silla-vacia-facebook.png','Cómo nos afecta la época navideña a nivel emocional','El síndrome de la silla vacía y los problemas emocionales de la Navidad');
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diarios`
--

DROP TABLE IF EXISTS `diarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diarios` (
  `id_usuario` bigint NOT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `FK4lk18id5db9gwwianohos5p68` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diarios`
--

LOCK TABLES `diarios` WRITE;
/*!40000 ALTER TABLE `diarios` DISABLE KEYS */;
INSERT INTO `diarios` VALUES (2),(4),(5),(6),(7),(8),(10),(11),(12),(13),(14),(15),(16),(19),(20),(23);
/*!40000 ALTER TABLE `diarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejercicio`
--

DROP TABLE IF EXISTS `ejercicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ejercicio` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` text,
  `duracion` time DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `estado_id` bigint DEFAULT NULL,
  `recurso_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmfbj0gbppvx55walqne1dejth` (`estado_id`),
  CONSTRAINT `FKmfbj0gbppvx55walqne1dejth` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejercicio`
--

LOCK TABLES `ejercicio` WRITE;
/*!40000 ALTER TABLE `ejercicio` DISABLE KEYS */;
INSERT INTO `ejercicio` VALUES (1,'Meditación guiada para dormir','00:08:00','Meditacion',3,'https://www.youtube.com/watch?v=cnFVmvbztKQ'),(3,'rutinas y posturas de yoga para principiantes, meditaciones guiadas, ejercicios de relajación y consejos útiles para tu bienestar. ','02:23:41','Respiración para reducir ansiedad',4,'https://www.youtube.com/watch?v=EGO5m_DBzF8'),(5,'Iniciación a la pintura','00:09:09','Pintura para relajarse',1,'https://www.youtube.com/watch?v=lIGwYBOyLgQ'),(6,'Ejercicios para reducir el estrés y la ansiedad.','00:20:43','Ejercicios para reducir la ansiedad',4,'https://www.youtube.com/watch?v=XIoKLoCyHho'),(7,'Tu cerebro se diseñó cuando conseguir placer era DIFÍCIL (trepar árbol, evitar tigre). Ahora placer está a un scroll. Resultado: tolerancia dopaminérgica nivel \"más frito que plátano en aceite hirviendo\". Pero puedes hackear el sistema con estrategia de guerrilla mental.','00:08:02','Cómo hackear tu cerebro para disfrutar de las cosas difíciles',1,'https://www.youtube.com/watch?v=ZQEG_u5LHlU');
/*!40000 ALTER TABLE `ejercicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entradas`
--

DROP TABLE IF EXISTS `entradas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entradas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha_entrada` date DEFAULT NULL,
  `texto` text,
  `id_diario` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKfblf76lo0xp6w2a67vxng6ju2` (`id_diario`,`fecha_entrada`),
  CONSTRAINT `FKi0xsfl9hwoqx0wc1y8cp1hk3v` FOREIGN KEY (`id_diario`) REFERENCES `diarios` (`id_usuario`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entradas`
--

LOCK TABLES `entradas` WRITE;
/*!40000 ALTER TABLE `entradas` DISABLE KEYS */;
INSERT INTO `entradas` VALUES (1,'2026-02-25','Early cansado jefe',2),(2,'2026-02-26','ggdfgdsfhsdfhgfh',2);
/*!40000 ALTER TABLE `entradas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Feliz'),(2,'Bien'),(3,'Regular'),(4,'Estresado'),(5,'Triste');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frases`
--

DROP TABLE IF EXISTS `frases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `frases` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `frase` varchar(255) DEFAULT NULL,
  `puntuacion` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frases`
--

LOCK TABLES `frases` WRITE;
/*!40000 ALTER TABLE `frases` DISABLE KEYS */;
INSERT INTO `frases` VALUES (16,'Tu energía positiva ilumina todo lo que haces.',1),(17,'Guarda este momento: te lo has ganado.',1),(18,'Hoy estás brillando más que nunca.',1),(19,'Tu alegría es contagiosa, sigue compartiéndola.',1),(20,'Disfruta este buen momento, es totalmente tuyo.',1),(21,'Todo va en buena dirección, sigue así.',2),(23,'Estás en equilibrio, y eso se nota.',2),(24,'Hoy estás avanzando con paso firme.',2),(25,'Tu calma es tu mejor aliada.',2),(26,'Lo estás haciendo muy bien, aunque no siempre lo veas.',2),(27,'No pasa nada por tener un día normal, también cuentan.',3),(28,'Respira un momento, estás haciendo lo que puedes.',3),(29,'A veces solo hay que dejar que el día fluya.',3),(30,'No necesitas estar al cien por cien para seguir adelante.',3),(31,'Un pequeño descanso puede cambiarlo todo.',3),(32,'Haz una pausa: tu mente también necesita respirar.',4),(33,'Un paso a la vez, no tienes que cargar con todo ahora.',4),(35,'Tu bienestar es más importante que cualquier tarea.',4),(36,'Permítete soltar lo que no puedes controlar.',4),(37,'Eres capaz, incluso cuando el día pesa.',4),(38,'Está bien sentirse así, no tienes que forzarte.',5),(39,'Tu emoción es válida, y pasará con el tiempo.',5),(40,'Incluso los días grises forman parte del camino.',5),(41,'No estás solo en esto, date espacio para sentir.',5),(42,'Sé amable contigo mismo hoy.',5);
/*!40000 ALTER TABLE `frases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musica`
--

DROP TABLE IF EXISTS `musica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musica` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `enlace` text,
  `estado_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7kfqcpn8knj4grrfl1ukeecm5` (`estado_id`),
  CONSTRAINT `FK7kfqcpn8knj4grrfl1ukeecm5` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musica`
--

LOCK TABLES `musica` WRITE;
/*!40000 ALTER TABLE `musica` DISABLE KEYS */;
/*!40000 ALTER TABLE `musica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro`
--

DROP TABLE IF EXISTS `registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registro` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha_registro` date DEFAULT NULL,
  `puntuacion` int NOT NULL,
  `id_usuario` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK35us08k5la7avdkff3mt03u4m` (`id_usuario`,`fecha_registro`),
  CONSTRAINT `FKq8k35m6ve564afteg8eqxcw29` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro`
--

LOCK TABLES `registro` WRITE;
/*!40000 ALTER TABLE `registro` DISABLE KEYS */;
INSERT INTO `registro` VALUES (20,'2026-02-24',2,7),(30,'2026-02-25',1,2),(31,'2026-02-25',1,4),(32,'2026-02-25',5,5),(33,'2026-02-23',3,2),(34,'2026-02-22',5,2),(35,'2026-02-21',3,2),(36,'2026-02-20',2,2),(37,'2026-02-24',4,2),(38,'2026-02-26',2,2),(40,'2026-02-26',1,16),(43,'2026-02-27',5,2);
/*!40000 ALTER TABLE `registro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `edad` int NOT NULL,
  `exp_acumulada` double NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  `genero` enum('MASCULINO','FEMENINO','OTRO','NO_ESPECIFICAR') NOT NULL,
  `nivel` int NOT NULL,
  `nombre_completo` varchar(50) NOT NULL,
  `nombre_usuario` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `tipo_usuario` enum('ADMINISTRADOR','CLIENTE_PREMIUM','CLIENTE','INVITADO') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (2,31,515.2,'1994-03-24','2025-12-18','MASCULINO',10,'Rubén Cobo González','rubencobog','2345','ADMINISTRADOR'),(4,20,60,'2006-08-26','2026-02-19','MASCULINO',1,'Akatosh, Daedra','Akatosh','1234','ADMINISTRADOR'),(5,47,0,'1978-12-12','2026-02-24','MASCULINO',0,'Fernando fernandez','Ferfer','1234','CLIENTE'),(6,43,0,'1982-07-12','2026-02-24','MASCULINO',0,'Edgar Allan Poe','EdgarPo','2345','CLIENTE'),(7,30,40,'1995-03-16','2026-02-24','MASCULINO',4,'Gabriel Oancea','Lagbri','1234','CLIENTE'),(8,26,0,'2000-03-03','2026-02-25','MASCULINO',0,'Ernesto,Sevilla','Ernest','1234','CLIENTE'),(10,25,0,'2000-03-24','2026-02-26','FEMENINO',0,'Robert','Robb','3456','CLIENTE'),(11,25,0,'2000-03-03','2026-02-26','FEMENINO',0,'Rubencio','Rubencio	','1234','CLIENTE'),(12,25,0,'2000-03-03','2026-02-26','FEMENINO',0,'Laura','Lau23','2345','CLIENTE'),(13,25,0,'2000-03-03','2026-02-26','MASCULINO',0,'Rodolfo','Rudolf','1234','CLIENTE'),(14,26,0,'2000-02-02','2026-02-26','OTRO',0,'Edgar','LaCaida','1234','CLIENTE'),(15,25,0,'2000-03-03','2026-02-26','MASCULINO',0,'Renan','Rjedidias','1234','CLIENTE'),(16,26,0,'2000-03-03','2026-02-26','MASCULINO',0,'Franko,Perez','Frank','1234','ADMINISTRADOR'),(19,36,0,'1990-01-31','2026-02-27','MASCULINO',0,'Gabriel,Capullo','GabiOancea','2345','ADMINISTRADOR'),(20,38,0,'1988-12-27','2026-02-27','MASCULINO',0,'Rey,Mysterio','ReyMysterio','619','CLIENTE_PREMIUM'),(23,26,0,'2000-07-07','2026-02-27','MASCULINO',0,'Ronaldinho,Gonsales','Ronal','1234','ADMINISTRADOR');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `crear_diario_automatico` AFTER INSERT ON `usuarios` FOR EACH ROW BEGIN
    INSERT INTO diarios (id_usuario)
    VALUES (NEW.id);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping events for database 'pruebas_ac'
--

--
-- Dumping routines for database 'pruebas_ac'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-27 17:31:44
