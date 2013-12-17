-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.13 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             8.0.0.4522
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para banco
CREATE DATABASE IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `banco`;


-- Volcando estructura para tabla banco.cuentabancaria
CREATE TABLE IF NOT EXISTS `cuentabancaria` (
  `idcuentabancaria` int(11) NOT NULL,
  `sucursalBancaria` varchar(45) NOT NULL,
  `numeroCuenta` varchar(45) NOT NULL,
  `dc` varchar(45) NOT NULL,
  `saldo` decimal(10,0) NOT NULL,
  `cif` varchar(45) NOT NULL,
  PRIMARY KEY (`idcuentabancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.cuentabancaria: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cuentabancaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuentabancaria` ENABLE KEYS */;


-- Volcando estructura para tabla banco.entidadbancaria
CREATE TABLE IF NOT EXISTS `entidadbancaria` (
  `idEntidad` int(11) NOT NULL,
  `codigoEntidad` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `cif` varchar(45) NOT NULL,
  `tipoEntidadBancaria` varchar(45) NOT NULL,
  PRIMARY KEY (`idEntidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.entidadbancaria: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `entidadbancaria` DISABLE KEYS */;
INSERT INTO `entidadbancaria` (`idEntidad`, `codigoEntidad`, `nombre`, `cif`, `tipoEntidadBancaria`) VALUES
	(1, 'S85', 'Bankia', 'B11555478', 'BANCO'),
	(3, 'Q34', 'Bankia', 'C78963214', 'BANCO'),
	(4, 'A15', 'Bankia', 'S87965125', 'BANCO'),
	(5, 'X45', 'Santander', 'S45515789', 'BANCO'),
	(7, 'D85', 'Bankia', 'A59869878', 'BANCO'),
	(8, 'W78', 'Caixa', 'Q8965896', 'BANCO'),
	(11, ' T78', 'Banco de Barcelona', ' B78787878', 'CAJADEAHORRO'),
	(12, ' R45', 'Banco de Madrid', ' P67888484', 'BANCO');
/*!40000 ALTER TABLE `entidadbancaria` ENABLE KEYS */;


-- Volcando estructura para tabla banco.movimientobancario
CREATE TABLE IF NOT EXISTS `movimientobancario` (
  `idmovimientobancario` int(11) NOT NULL,
  `tipoMovimientoBancario` varchar(45) NOT NULL,
  `importe` decimal(10,0) NOT NULL,
  `fecha` datetime NOT NULL,
  `saldoTotal` decimal(10,0) NOT NULL,
  `concepto` varchar(45) NOT NULL,
  PRIMARY KEY (`idmovimientobancario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.movimientobancario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `movimientobancario` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimientobancario` ENABLE KEYS */;


-- Volcando estructura para tabla banco.sucursalbancaria
CREATE TABLE IF NOT EXISTS `sucursalbancaria` (
  `idSucursal` int(11) NOT NULL,
  `entidadBancaria` varchar(45) NOT NULL,
  `codigoSucursal` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idSucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.sucursalbancaria: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `sucursalbancaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `sucursalbancaria` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
