CREATE TABLE `books` (
  `bid` int(4) NOT NULL,
  `bname` varchar(20) NOT NULL,
  `bauthor` varchar(20) NOT NULL,
  `bcategory` char(20) NOT NULL,
  `bqty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `books` (`bid`, `bname`, `bauthor`, `bcategory`, `bqty`) VALUES
(1, 'fgfdg', 'drgreg', 'Science', 2),
(3, 'aaaa', 'erfrefref', 'English', 2),
(6, 'test this nor', 'wer', 'Science', 2),
(7, 'we', 'aliena', 'Maths', 2),
(12, 'abc', 'rrr', 'English', 777777),
(13, 'AAA', 'rrr', 'History', 7),
