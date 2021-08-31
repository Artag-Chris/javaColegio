-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 31-08-2021 a las 05:34:42
-- Versión del servidor: 5.7.31
-- Versión de PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `colegio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acudiente`
--

DROP TABLE IF EXISTS `acudiente`;
CREATE TABLE IF NOT EXISTS `acudiente` (
  `docAcu` varchar(11) COLLATE utf8_bin NOT NULL,
  `nomAcu` varchar(30) COLLATE utf8_bin NOT NULL,
  `apeAcu` varchar(30) COLLATE utf8_bin NOT NULL,
  `dirAcu` varchar(60) COLLATE utf8_bin NOT NULL,
  `telAcu` varchar(11) COLLATE utf8_bin NOT NULL,
  `emaAcu` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`docAcu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `acudiente`
--

INSERT INTO `acudiente` (`docAcu`, `nomAcu`, `apeAcu`, `dirAcu`, `telAcu`, `emaAcu`) VALUES
('018009365', 'perez', 'monchito', 'asdfg', 'si tiene', 'elmoncho123@hotmail.com'),
('111', 'jose', 'icardo', 'bogota', '32054896', 'señorraro@hotmail.com'),
('201', 'Don pansa', 'barriga', 'afuera de la vecindad', 'si tiene', 'elmundoesmio@hotmail.com'),
('202', 'doña florinda', 'florinda', 'la vecindad', '?=no tiene', 'lachusma@gmail.com'),
('203', 'ramon', 'valdez', 'la vecindad', 'no tiene', 'otranomas@outlook.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acudientexestudiante`
--

DROP TABLE IF EXISTS `acudientexestudiante`;
CREATE TABLE IF NOT EXISTS `acudientexestudiante` (
  `consAcuxEst a` int(11) NOT NULL AUTO_INCREMENT,
  `docAcuAcuxEst v` varchar(11) COLLATE utf8_bin NOT NULL,
  `docEstAcuxEst` varchar(11) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`consAcuxEst a`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
CREATE TABLE IF NOT EXISTS `estudiante` (
  `docEst` varchar(11) COLLATE utf8_bin NOT NULL,
  `nomEst` varchar(30) COLLATE utf8_bin NOT NULL,
  `apeEst` varchar(30) COLLATE utf8_bin NOT NULL,
  `dirEst` varchar(60) COLLATE utf8_bin NOT NULL,
  `telEst` varchar(11) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`docEst`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`docEst`, `nomEst`, `apeEst`, `dirEst`, `telEst`) VALUES
('10', 'petter', 'parker', 'Central Park', '14286513'),
('101', 'el chavo', 'del 8', 'la vecindad ', 'no tiene'),
('102', 'kiko', 'florinda', 'la vencidad', 'no tiene'),
('103', 'la chilin', 'ramon', 'la vecindad', 'no tiene'),
('1088261298', 'christian', 'henao', 'encuentreme', '3205711428'),
('1088627483', 'james', 'rodriges', 'everton', 'si tiene'),
('45', 'camilo', 'perez ', 'parque', '320545');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

DROP TABLE IF EXISTS `materia`;
CREATE TABLE IF NOT EXISTS `materia` (
  `codMat` int(11) NOT NULL AUTO_INCREMENT,
  `nomMat` varchar(30) COLLATE utf8_bin NOT NULL,
  `graMat` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`codMat`)
) ENGINE=InnoDB AUTO_INCREMENT=308 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`codMat`, `nomMat`, `graMat`) VALUES
(1, 'astrofisica', 'Grado 2'),
(2, 'mecatronica', 'Grado 3'),
(3, 'español', 'Grado 2'),
(301, 'fisica quantica', '1'),
(302, 'deseño de software', '2'),
(303, 'conducción de aviones ligeros', '3'),
(305, 'ingles', 'Grado 1'),
(306, 'fisica', 'Grado 4'),
(307, 'pintar', 'Grado 5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiaxprofesor`
--

DROP TABLE IF EXISTS `materiaxprofesor`;
CREATE TABLE IF NOT EXISTS `materiaxprofesor` (
  `conMatxpro` int(11) NOT NULL AUTO_INCREMENT,
  `codMatMatxPro` int(11) NOT NULL,
  `docProfMatxPro` varchar(11) COLLATE utf8_bin NOT NULL,
  `graMatxPro` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`conMatxpro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

DROP TABLE IF EXISTS `profesor`;
CREATE TABLE IF NOT EXISTS `profesor` (
  `docPro` varchar(11) COLLATE utf8_bin NOT NULL,
  `nomPro` varchar(30) COLLATE utf8_bin NOT NULL,
  `apePro` varchar(30) COLLATE utf8_bin NOT NULL,
  `dirPro` varchar(60) COLLATE utf8_bin NOT NULL,
  `telPro` varchar(11) COLLATE utf8_bin NOT NULL,
  `emaPro` varchar(30) COLLATE utf8_bin NOT NULL,
  `titPro` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`docPro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`docPro`, `nomPro`, `apePro`, `dirPro`, `telPro`, `emaPro`, `titPro`) VALUES
('1', 'ramon', 'valdez', 'la vecindad', '555-05-55', 'fakenews@hotmail.com', 'boxeador'),
('10248965', 'mario', 'baracus', 'A-team', '3258745', 'A-team@hotmail.com', 'Profesional'),
('1428965', 'marcos antonio', 'solis', 'uruguay', '3502894', 'fakemarcos@hotmail.com', 'Magister'),
('14896324', 'pedro', 'escamoso', 'neverland', '320575612', 'escamoso@gmail.com', 'Especialista'),
('2', 'juanes', 'estaban', 'miami beach 123', '+01 2365496', 'therealjuanes@gmail.com', 'Selecciones...'),
('3', 'joe', 'doe', 'neverland island', '+99 5846368', 'joedoefoe@trueemail.com', 'medico');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
