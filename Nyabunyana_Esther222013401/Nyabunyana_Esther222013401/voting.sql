-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2022 at 02:04 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `voting`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `ADMIN`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ADMIN` ()  BEGIN insert into admin values('000','000'); 
END$$

DROP PROCEDURE IF EXISTS `CANDIDATES`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `CANDIDATES` ()  BEGIN 
select student.student_reg,fname,lname,title from student,position,candidate where student.student_reg=candidate.candidate_reg and position.pcode=candidate.pid order by title;
END$$

DROP PROCEDURE IF EXISTS `RESULTS`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `RESULTS` ()  BEGIN 
select fname,lname,title,sum(score) as total from student,position,votes,candidate where student.student_reg=candidate.candidate_reg and candidate.pid=position.pcode and candidate.candidate_reg=votes.candidate_reg group by fname ORDER BY title ASC;
END$$

DROP PROCEDURE IF EXISTS `STUDENTS`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `STUDENTS` ()  BEGIN 
SELECT * FROM STUDENT;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `regnumber` int(11) NOT NULL COMMENT 'this field will contain code that will help admin to login',
  `password` varchar(30) NOT NULL COMMENT 'this field will contain admin''s password'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`regnumber`, `password`) VALUES
(2210, '000');

-- --------------------------------------------------------

--
-- Table structure for table `candidate`
--

DROP TABLE IF EXISTS `candidate`;
CREATE TABLE `candidate` (
  `candidate_reg` varchar(20) NOT NULL COMMENT 'Candidate reg number which is also foregn key from table student',
  `pid` varchar(20) NOT NULL COMMENT 'position id which is foregn key from table position will help to know candidate position'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Stand-in structure for view `general_result`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `general_result`;
CREATE TABLE `general_result` (
`fname` varchar(30)
,`lname` varchar(30)
,`title` varchar(20)
,`total` double
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `list_of_candidate`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `list_of_candidate`;
CREATE TABLE `list_of_candidate` (
`student_reg` varchar(20)
,`fname` varchar(30)
,`lname` varchar(30)
,`title` varchar(20)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `list_of_position`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `list_of_position`;
CREATE TABLE `list_of_position` (
`pcode` varchar(20)
,`title` varchar(20)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `list_of_students`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `list_of_students`;
CREATE TABLE `list_of_students` (
`student_reg` varchar(20)
,`fname` varchar(30)
,`lname` varchar(30)
,`phone` varchar(10)
,`email` varchar(30)
,`password` varchar(20)
);

-- --------------------------------------------------------

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `pcode` varchar(20) NOT NULL COMMENT 'Primary key for this table this field will pay role for being foreign key in table candidate and also in this table will help to differentiate positions ',
  `title` varchar(20) NOT NULL COMMENT 'position title field holds title of that position'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `position`
--

INSERT INTO `position` (`pcode`, `title`) VALUES
('01', 'secretary'),
('02', 'guild cancil');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_reg` varchar(20) NOT NULL COMMENT 'registration number field ',
  `fname` varchar(30) NOT NULL COMMENT 'first name field',
  `lname` varchar(30) NOT NULL COMMENT 'last name field',
  `phone` varchar(10) NOT NULL COMMENT 'phone number field',
  `email` varchar(30) NOT NULL COMMENT 'email field',
  `password` varchar(20) NOT NULL COMMENT 'password field which will be used as one of cridencials'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `votes`
--

DROP TABLE IF EXISTS `votes`;
CREATE TABLE `votes` (
  `vid` int(11) NOT NULL COMMENT 'Vote id field will pay role of counting times of voted',
  `student_reg` varchar(20) NOT NULL COMMENT 'Student reg number field is foreign key from table student which help us to know student who vote to avoid him/her to vote maney times',
  `candidate_reg` varchar(20) NOT NULL COMMENT 'this field is foregn key from table candidate helps to know who voted',
  `score` varchar(1) NOT NULL COMMENT 'this field will help us to count votes for candidates'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure for view `general_result`
--
DROP TABLE IF EXISTS `general_result`;

DROP VIEW IF EXISTS `general_result`;
CREATE OR REPLACE VIEW `general_result`  AS SELECT `student`.`fname` AS `fname`, `student`.`lname` AS `lname`, `position`.`title` AS `title`, sum(`votes`.`score`) AS `total` FROM (((`student` join `position`) join `votes`) join `candidate`) WHERE `student`.`student_reg` = `candidate`.`candidate_reg` AND `candidate`.`pid` = `position`.`pcode` AND `candidate`.`candidate_reg` = `votes`.`candidate_reg` GROUP BY `student`.`fname` ORDER BY `position`.`title` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `list_of_candidate`
--
DROP TABLE IF EXISTS `list_of_candidate`;

DROP VIEW IF EXISTS `list_of_candidate`;
CREATE OR REPLACE VIEW `list_of_candidate`  AS SELECT `student`.`student_reg` AS `student_reg`, `student`.`fname` AS `fname`, `student`.`lname` AS `lname`, `position`.`title` AS `title` FROM ((`student` join `position`) join `candidate`) WHERE `student`.`student_reg` = `candidate`.`candidate_reg` AND `position`.`pcode` = `candidate`.`pid` ORDER BY `position`.`title` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `list_of_position`
--
DROP TABLE IF EXISTS `list_of_position`;

DROP VIEW IF EXISTS `list_of_position`;
CREATE OR REPLACE VIEW `list_of_position`  AS SELECT `position`.`pcode` AS `pcode`, `position`.`title` AS `title` FROM `position` ;

-- --------------------------------------------------------

--
-- Structure for view `list_of_students`
--
DROP TABLE IF EXISTS `list_of_students`;

DROP VIEW IF EXISTS `list_of_students`;
CREATE OR REPLACE VIEW `list_of_students`  AS SELECT `student`.`student_reg` AS `student_reg`, `student`.`fname` AS `fname`, `student`.`lname` AS `lname`, `student`.`phone` AS `phone`, `student`.`email` AS `email`, `student`.`password` AS `password` FROM `student` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`regnumber`);

--
-- Indexes for table `candidate`
--
ALTER TABLE `candidate`
  ADD PRIMARY KEY (`candidate_reg`);

--
-- Indexes for table `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`pcode`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_reg`);

--
-- Indexes for table `votes`
--
ALTER TABLE `votes`
  ADD PRIMARY KEY (`vid`),
  ADD KEY `candidate_reg` (`candidate_reg`),
  ADD KEY `student_reg` (`student_reg`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `regnumber` int(11) NOT NULL AUTO_INCREMENT COMMENT 'this field will contain code that will help admin to login', AUTO_INCREMENT=2211;

--
-- AUTO_INCREMENT for table `votes`
--
ALTER TABLE `votes`
  MODIFY `vid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Vote id field will pay role of counting times of voted', AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `candidate`
--
ALTER TABLE `candidate`
  ADD CONSTRAINT `candidate_ibfk_1` FOREIGN KEY (`candidate_reg`) REFERENCES `student` (`student_reg`);

--
-- Constraints for table `votes`
--
ALTER TABLE `votes`
  ADD CONSTRAINT `votes_ibfk_1` FOREIGN KEY (`candidate_reg`) REFERENCES `candidate` (`candidate_reg`),
  ADD CONSTRAINT `votes_ibfk_2` FOREIGN KEY (`student_reg`) REFERENCES `student` (`student_reg`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
