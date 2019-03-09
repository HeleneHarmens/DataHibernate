-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 09, 2019 at 12:21 PM
-- Server version: 5.7.24-log
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rpgdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `characters`
--

CREATE TABLE `characters` (
  `characterID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `characterName` varchar(25) NOT NULL,
  `className` varchar(25) NOT NULL,
  `characterLvl` int(11) NOT NULL,
  `user_userID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `characters`
--

INSERT INTO `characters` (`characterID`, `userID`, `characterName`, `className`, `characterLvl`, `user_userID`) VALUES
(5, 3, 'Stixus', 'Hunter', 4, NULL),
(6, 5, 'BananaMuffin', 'Druid', 6, NULL),
(7, 1, 'Enehel', 'Hunter', 10, NULL),
(8, 9, 'PalaCraig', 'Paladin', 8, NULL),
(10, 11, 'Marmar', 'Rogue', 3, NULL),
(11, 1, 'Sidus', 'Warlock', 20, NULL),
(12, 12, 'Catman', 'Paladin', 5, NULL),
(13, 13, 'Camzz', 'Hunter', 19, NULL),
(14, 2, 'MissBeast', 'Mage', 3, NULL),
(15, 22, 'Grefs', 'Warlock', 22, NULL),
(16, 23, 'Erix', 'Mage', 17, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE `classes` (
  `classID` int(11) NOT NULL,
  `className` varchar(25) NOT NULL,
  `Abilities` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`classID`, `className`, `Abilities`) VALUES
(29, 'Druid', '\'Entangling Roots\', \'Shapeshifting\''),
(30, 'Hunter', '\'Disengage\', \'MultiShot\''),
(31, 'Mage', '\'Polymorph\', \'Shapeshifting\''),
(32, 'Paladin', '\'Judgement\', \'Blade of Justice\''),
(33, 'Warlock', '\'Felbolt\', \'Summon Imp\''),
(37, 'Rogue', '\'Blind\', \'Pick Pocket\'');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(11) NOT NULL,
  `userName` varchar(25) NOT NULL,
  `userEmail` varchar(50) NOT NULL,
  `userPassword` varchar(40) NOT NULL,
  `userPasswordHidden` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `userName`, `userEmail`, `userPassword`, `userPasswordHidden`) VALUES
(1, 'Helene', 'helene.harmens@gmail.com', 'passord1', NULL),
(2, 'Line', 'line@gmail.com', 'passord2', NULL),
(3, 'Stian', 'stixus@gmail.com', 'passord3', NULL),
(5, 'Marius', 'marius@gmail.com', 'passord4', NULL),
(9, 'Craig', 'craig@gmail.com', 'password123', NULL),
(11, 'Marianne', 'marri@hotmail.com', 'elefant', NULL),
(12, 'Oliver', 'olli@gmail.com', 'p09876', NULL),
(13, 'Camilla', 'cam@gmail.com', 'drossap', NULL),
(22, 'ThomasG', 'thomasg@gmail.com', 'mittPassord', NULL),
(23, 'ErikH', 'erik.harmens@gmail.com', 'psrd15', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `characters`
--
ALTER TABLE `characters`
  ADD PRIMARY KEY (`characterID`),
  ADD UNIQUE KEY `characterName` (`characterName`),
  ADD UNIQUE KEY `characterID` (`characterID`),
  ADD KEY `userID` (`userID`),
  ADD KEY `className` (`className`),
  ADD KEY `FKcd02hpyqtf2d09fmlq96prma2` (`user_userID`);

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`classID`),
  ADD UNIQUE KEY `className` (`className`),
  ADD UNIQUE KEY `classID` (`classID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `userName` (`userName`,`userEmail`),
  ADD UNIQUE KEY `userID` (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `characters`
--
ALTER TABLE `characters`
  MODIFY `characterID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `classes`
--
ALTER TABLE `classes`
  MODIFY `classID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `characters`
--
ALTER TABLE `characters`
  ADD CONSTRAINT `FKcd02hpyqtf2d09fmlq96prma2` FOREIGN KEY (`user_userID`) REFERENCES `users` (`userID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
