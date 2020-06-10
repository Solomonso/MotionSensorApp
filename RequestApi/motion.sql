-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 09, 2020 at 09:51 PM
-- Server version: 5.6.25
-- PHP Version: 5.5.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `motion`
--

-- --------------------------------------------------------

--
-- Table structure for table `back_door`
--

CREATE TABLE IF NOT EXISTS `back_door` (
  `id` int(11) NOT NULL,
  `motion` varchar(30) DEFAULT NULL,
  `time_detected` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `front_door`
--

CREATE TABLE IF NOT EXISTS `front_door` (
  `id` int(11) NOT NULL,
  `motion` varchar(30) DEFAULT NULL,
  `time_detected` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `front_door`
--

INSERT INTO `front_door` (`id`, `motion`, `time_detected`) VALUES
(1, 'device_new', '2020-06-09 19:26:50'),
(2, '', '2020-06-09 19:30:38'),
(3, 'Motion Detected', '2020-06-09 19:33:31');

-- --------------------------------------------------------

--
-- Table structure for table `master_bedroom`
--

CREATE TABLE IF NOT EXISTS `master_bedroom` (
  `id` int(11) NOT NULL,
  `motionbed` varchar(30) DEFAULT NULL,
  `time_detected` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `master_bedroom`
--

INSERT INTO `master_bedroom` (`id`, `motionbed`, `time_detected`) VALUES
(1, 'bedroom', '2020-06-09 08:54:45.538265'),
(2, 'bedroom', '2020-06-09 08:58:02.690257');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `back_door`
--
ALTER TABLE `back_door`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `front_door`
--
ALTER TABLE `front_door`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `master_bedroom`
--
ALTER TABLE `master_bedroom`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `back_door`
--
ALTER TABLE `back_door`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `front_door`
--
ALTER TABLE `front_door`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `master_bedroom`
--
ALTER TABLE `master_bedroom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
