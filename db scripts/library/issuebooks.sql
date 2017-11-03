-- --------------------------------------------------------

--
-- Table structure for table `issuebooks`
--

CREATE TABLE `issuebooks` (
  `ibookID` int(11) NOT NULL,
  `memid` int(5) NOT NULL,
  `book1` text NOT NULL,
  `book2` text NOT NULL,
  `cdate` date NOT NULL,
  `rdate` date NOT NULL,
  `returnStatus` varchar(255) NOT NULL DEFAULT 'Issued'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issuebooks`
--

INSERT INTO `issuebooks` (`ibookID`, `memid`, `book1`, `book2`, `cdate`, `rdate`, `returnStatus`) VALUES
(1, 3, '12', '13', '2017-09-28', '2017-10-05', 'returned'),
(2, 100, '101', '102', '2017-11-02', '2017-11-09', 'returned'),
(3, 1001, '55', '57', '2017-11-02', '2017-11-09', 'returned'),
(4, 2001, '25', '35', '2017-11-03', '2017-11-10', 'Issued'),
(5, 7, '1001', '1002', '2017-11-03', '2017-11-10', 'returned');

