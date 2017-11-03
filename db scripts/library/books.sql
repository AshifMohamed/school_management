
-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `bid` int(4) NOT NULL,
  `bname` varchar(20) NOT NULL,
  `bauthor` varchar(20) NOT NULL,
  `bcategory` char(20) NOT NULL,
  `bqty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`bid`, `bname`, `bauthor`, `bcategory`, `bqty`) VALUES
(3, 'aaaa', 'erfrefref', 'English', 9),
(6, 'test this nor', 'wer', 'Science', 2),
(7, 'we', 'aliena', 'Maths', 2),
(12, 'abc', 'rrr', 'English', 4),
(13, 'AAA1', 'rrr', 'History', 7),
(14, 'qwerty', 'wqeqe', 'Science', 3),
(15, 'lear art', 'ron thomas', 'Art', 4),
(16, 'heart', 'kumari subasinghe', 'Science', 4),
(17, 'we rew', 'aliena', 'Maths', 2),
(18, 'emma 1', 'kamani ediriweera', 'Art', 3),
(20, 'AAA1', 'rrr', 'Choose book category', 7),
(21, 'WWq', 'FF', 'Science', 11),
(22, 'Drawing', 'kamani lokuge', 'Art', 3),
(23, 'mathematical help', 'amal gamage', 'Maths', 7),
(24, 'bashaa', 'D.karurarathne ', 'Tamil', 2),
(25, 'English 2', 'Helan', 'English', 5),
(26, 'Drawing 2', 'sibil weththasinghe', 'Art', 2);

