-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `mregID` int(5) NOT NULL,
  `mname` varchar(20) NOT NULL,
  `mgrade` int(2) NOT NULL,
  `memail` varchar(20) NOT NULL,
  `mcontactnum` int(10) NOT NULL,
  `mstatus` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`mregID`, `mname`, `mgrade`, `memail`, `mcontactnum`, `mstatus`) VALUES
(4, 'rrr', 6, 'fgg', 1234567890, 'Enable'),
(5, 'ffff', 7, 'fffffefe@', 3223, 'Enable'),
(6, 'gggggg', 7, 'fewfe', 34234, 'Enable'),
(7, 'kalani', 12, 'kalani@gmail.com', 1112223334, 'Enable'),
(8, 'ZZZ', 7, 'asd', 5555, 'Enable'),
(9, 'uuuuu', 12, 'uuu@gmail.com', 1111111111, 'Enable'),
(10, 'rrrewqwert', 6, 'fgg@gmail.com', 1234567890, 'Enable'),
(11, 'ZZZ123', 7, 'asd@gmail.com', 1234567890, 'Enable'),
(12, '', 8, 'cham@gmail.com', 1234567890, 'Enable');

