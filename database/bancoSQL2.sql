

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;




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
movimientobancario