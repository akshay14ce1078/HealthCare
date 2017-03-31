-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 17, 2017 at 02:17 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `health`
--

-- --------------------------------------------------------

--
-- Table structure for table `hospital_details`
--

CREATE TABLE `hospital_details` (
  `Hosp_id` int(11) NOT NULL,
  `Hosp_name` varchar(30) NOT NULL,
  `Hosp_location` varchar(50) NOT NULL,
  `Hosp_pwd` varchar(15) NOT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL,
  `Hosp_contact` int(15) NOT NULL,
  `Grade` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hospital_details`
--

INSERT INTO `hospital_details` (`Hosp_id`, `Hosp_name`, `Hosp_location`, `Hosp_pwd`, `latitude`, `longitude`, `Hosp_contact`, `Grade`) VALUES
(111, 'induja', 'bandra', '12345', 4.5, 6.5, 1818181818, 1),
(112, 'mamata', 'cst', '123', 4.55, 8.55, 2121212121, 2);

-- --------------------------------------------------------

--
-- Table structure for table `hospital_speciality`
--

CREATE TABLE `hospital_speciality` (
  `Hsid` int(11) NOT NULL,
  `Hosp_id` int(11) NOT NULL,
  `Speciality` varchar(40) NOT NULL,
  `Doctor` varchar(30) NOT NULL,
  `Grade` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hospital_speciality`
--

INSERT INTO `hospital_speciality` (`Hsid`, `Hosp_id`, `Speciality`, `Doctor`, `Grade`) VALUES
(1, 111, 'Chest Pain', 'pawan', 1),
(2, 111, 'Abdominal Pain', 'amol', 1),
(3, 111, 'Back Pain', 'akshay', 1),
(4, 111, 'Strain/Sprain Injury', 'vinit', 1),
(5, 111, 'Accidental Injury', 'prajyot', 1),
(6, 111, 'EyeSight Problem', 'akash', 1),
(7, 111, 'Brain Hamorrhage', 'vinay', 1),
(8, 111, 'Feeds Attack', 'karan', 1),
(9, 112, 'Abdominal Pain', 'amol', 2),
(10, 112, 'Accidental Injury', 'prajyot', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `User_id` int(20) NOT NULL,
  `Fname` varchar(20) NOT NULL,
  `Lname` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Pwd` varchar(15) NOT NULL,
  `Contact1` varchar(15) NOT NULL,
  `Contact2` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`User_id`, `Fname`, `Lname`, `Email`, `Pwd`, `Contact1`, `Contact2`) VALUES
(2, 'pawan', 'lokapur', 'pawangl555@gmail.com', '123', '9833291793', '8425847979');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hospital_details`
--
ALTER TABLE `hospital_details`
  ADD PRIMARY KEY (`Hosp_id`);

--
-- Indexes for table `hospital_speciality`
--
ALTER TABLE `hospital_speciality`
  ADD PRIMARY KEY (`Hsid`),
  ADD KEY `Hosp_id` (`Hosp_id`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`User_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hospital_speciality`
--
ALTER TABLE `hospital_speciality`
  MODIFY `Hsid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `user_details`
--
ALTER TABLE `user_details`
  MODIFY `User_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `hospital_speciality`
--
ALTER TABLE `hospital_speciality`
  ADD CONSTRAINT `hospital_speciality_ibfk_1` FOREIGN KEY (`Hosp_id`) REFERENCES `hospital_details` (`Hosp_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
