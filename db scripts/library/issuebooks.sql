CREATE TABLE `issuebooks` (
  `ibookID` int(11) NOT NULL,
  `memid` int(5) NOT NULL,
  `book1` text NOT NULL,
  `book2` text NOT NULL,
  `cdate` date NOT NULL,
  `rdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issuebooks`
--

INSERT INTO `issuebooks` (`ibookID`, `memid`, `book1`, `book2`, `cdate`, `rdate`) VALUES
(1, 3, '12', '13', '2017-09-28', '2017-10-05');

