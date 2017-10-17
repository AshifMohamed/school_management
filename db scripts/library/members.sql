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
(4, 'rrr', 6, 'fgg', 423423423, 'Enable'),
(5, 'ffff', 7, 'fffffefe', 3223, 'Enable'),
(6, 'gggggg', 7, 'fewfe', 34234, 'Enable'),
(7, 'hhjj', 12, 'efwsg', 4324124, 'Enable');

