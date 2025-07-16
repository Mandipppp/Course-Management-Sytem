-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 11, 2024 at 06:58 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `CMS`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `courseId` int(11) NOT NULL,
  `courseName` varchar(50) NOT NULL,
  `isDeleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`courseId`, `courseName`, `isDeleted`) VALUES
(1, 'Bachelor In International Business Management', 0),
(2, 'Bachelor In Information Technology', 0),
(14, 'Bachelors in Science', 0);

-- --------------------------------------------------------

--
-- Table structure for table `modules`
--

CREATE TABLE `modules` (
  `module_id` int(11) NOT NULL,
  `module_name` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `isOptional` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `modules`
--

INSERT INTO `modules` (`module_id`, `module_name`, `level`, `courseId`, `isDeleted`, `isOptional`) VALUES
(166, 'Advanced Database Management', 4, 2, 0, 0),
(167, 'Cloud Computing Technologies', 4, 2, 0, 0),
(168, 'Artificial Intelligence Applications', 5, 2, 0, 0),
(169, 'Blockchain Technology', 5, 2, 0, 0),
(170, 'Ethical Hacking and Penetration Testing', 6, 2, 0, 1),
(171, 'Virtual Reality and Augmented Reality', 6, 2, 0, 0),
(172, 'International Marketing Strategies', 4, 1, 0, 0),
(173, 'Cross-Cultural Management', 4, 1, 0, 0),
(174, 'International Finance', 5, 1, 0, 0),
(175, 'Strategic Management in Global Context', 5, 1, 0, 0),
(176, 'International Business Strategy', 6, 1, 0, 1),
(177, 'Crisis Management in Global Enterprises', 6, 1, 0, 0),
(178, 'optional Module-I', 6, 2, 1, 1),
(179, 'optional-module-II', 6, 2, 1, 1),
(180, 'Optional 5', 6, 2, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `student_id` int(11) NOT NULL,
  `module_id` int(11) NOT NULL,
  `marks` decimal(5,2) DEFAULT NULL,
  `grade` char(1) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`student_id`, `module_id`, `marks`, `grade`, `course_id`) VALUES
(29, 166, 50.00, 'C', 2),
(29, 167, 45.00, 'C', 2),
(29, 168, 0.00, NULL, 2),
(29, 169, 0.00, NULL, 2),
(29, 170, 80.00, 'A', 2),
(29, 171, 75.00, 'B', 2),
(35, 166, 0.00, NULL, 2),
(35, 167, 0.00, NULL, 2),
(35, 168, 0.00, NULL, 2),
(35, 169, 0.00, NULL, 2),
(35, 170, 80.00, 'A', 2),
(35, 171, 0.00, NULL, 2),
(37, 166, 0.00, NULL, 2),
(37, 167, 0.00, NULL, 2),
(37, 168, 0.00, NULL, 2),
(37, 169, 0.00, NULL, 2),
(37, 170, 0.00, NULL, 2),
(37, 171, 0.00, NULL, 2),
(37, 180, 0.00, NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL,
  `module_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacher_id`, `module_id`) VALUES
(28, 166),
(28, 167),
(28, 168),
(28, 169),
(28, 179),
(30, 170),
(30, 171),
(30, 172);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `fName` varchar(20) NOT NULL,
  `mName` varchar(20) NOT NULL,
  `Lname` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `password` varchar(12) NOT NULL,
  `type` varchar(10) NOT NULL,
  `current_level` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `fName`, `mName`, `Lname`, `email`, `phone`, `password`, `type`, `current_level`) VALUES
(2, 'Mahendraa', '', 'Parajuli', 'mp@gmail.com', '9811223312', 'hello', 'admin', 0),
(4, 'Yog', 'Raj', 'Bhandari', 'yogi@gmail.com', '9801267310', 'password', 'admin', 0),
(28, 'Raj', '', 'Khanal', 'rk@gmail.com', '9812127889', 'teacher', 'teacher', 0),
(29, 'Mandip', '', 'Raut', 'mr@gmail.com', '9861366140', 'student', 'student', 5),
(30, 'Ashok', '', 'Dhungana', 'ad@gmail.com', '9812563411', 'teacher', 'teacher', 0),
(32, 'Ayush', '', 'Dhakal', 'dha@gmail.com', '9867554432', 'admin', 'admin', 0),
(35, 'Samir', '', 'Bhattarai', 'sb@gmail.com', '9856785512', 'student', 'student', 4),
(37, 'Binod', '', 'Chalise', 'cb40@gmail.com', '9856834115', 'binod', 'student', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`courseId`);

--
-- Indexes for table `modules`
--
ALTER TABLE `modules`
  ADD PRIMARY KEY (`module_id`),
  ADD KEY `courseId` (`courseId`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_id`,`module_id`),
  ADD KEY `module_id` (`module_id`),
  ADD KEY `fk_course_id` (`course_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacher_id`,`module_id`),
  ADD KEY `module_id` (`module_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `courseId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `modules`
--
ALTER TABLE `modules`
  MODIFY `module_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=181;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `modules`
--
ALTER TABLE `modules`
  ADD CONSTRAINT `modules_ibfk_1` FOREIGN KEY (`courseId`) REFERENCES `courses` (`courseId`);

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `fk_course_id` FOREIGN KEY (`course_id`) REFERENCES `courses` (`courseId`),
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `students_ibfk_2` FOREIGN KEY (`module_id`) REFERENCES `modules` (`module_id`);

--
-- Constraints for table `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`module_id`) REFERENCES `modules` (`module_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
