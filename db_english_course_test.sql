-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th1 18, 2026 lúc 07:23 PM
-- Phiên bản máy phục vụ: 8.3.0
-- Phiên bản PHP: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `db_english_course_test`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `banner`
--

DROP TABLE IF EXISTS `banner`;
CREATE TABLE IF NOT EXISTS `banner` (
  `banner_id` int NOT NULL AUTO_INCREMENT,
  `url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  PRIMARY KEY (`banner_id`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `banner`
--

INSERT INTO `banner` (`banner_id`, `url`) VALUES
(34, 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768747424/banners/rlgdcbxtw0lrfvl6dg9d.jpg'),
(35, 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768747451/banners/ragpthlzecnjohgogiqk.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `course_Id` bigint NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) DEFAULT NULL,
  `description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `img_url` longtext,
  `price` decimal(38,2) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`course_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `course`
--

INSERT INTO `course` (`course_Id`, `course_name`, `description`, `img_url`, `price`, `level`, `status`, `created_at`) VALUES
(15, 'English For Beginners', 'Khóa học tiếng Anh cho người mất gốc, giúp làm quen với từ vựng cơ bản, phát âm chuẩn và các mẫu câu giao tiếp đơn giản trong đời sống hằng ngày.', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768752189/courses/r9qe22ufaimab1blg4bj.jpg', 200000.00, 'beginner', 'active', '2026-01-18 16:03:11'),
(16, 'Basic English Grammar', 'Khóa học tập trung vào ngữ pháp nền tảng như các thì cơ bản, cấu trúc câu và cách sử dụng đúng trong giao tiếp và viết.', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768752230/courses/vh6r0ha6biera1w2vpb3.jpg', 250000.00, 'intermediate', 'active', '2026-01-18 16:03:51'),
(17, 'English Communication Basics', 'Phát triển kỹ năng giao tiếp tiếng Anh cơ bản, luyện phản xạ nói trong các tình huống thường gặp như chào hỏi, giới thiệu bản thân.', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768752271/courses/t5yojgjbvsuiz2e2p2ja.jpg', 300000.00, 'beginner', 'active', '2026-01-18 16:04:32'),
(18, 'English Vocabulary Building', 'Mở rộng vốn từ vựng tiếng Anh theo chủ đề thông dụng như công việc, gia đình, du lịch và sinh hoạt hằng ngày.', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768752329/courses/xhmvoeijraevv0refskp.jpg', 350000.00, 'intermediate', 'active', '2026-01-18 16:05:30'),
(19, 'Pronunciation and Accent Training', 'Luyện phát âm chuẩn quốc tế, sửa lỗi phát âm phổ biến và cải thiện ngữ điệu khi nói tiếng Anh.', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768752483/courses/ffbclaknsfi8ola7bniq.png', 400000.00, 'advanced', 'active', '2026-01-18 16:08:04'),
(20, 'Listening Skills for Daily English', 'Rèn kỹ năng nghe tiếng Anh thông qua hội thoại đời sống, giúp người học nghe hiểu nhanh và chính xác hơn.', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768752516/courses/d2ltwgd41sgiok569z9q.png', 450000.00, 'advanced', 'active', '2026-01-18 16:08:38'),
(21, 'Speaking Practice for Beginners', 'Tập trung luyện nói tiếng Anh từ cơ bản đến nâng cao, giúp người học tự tin khi giao tiếp với người nước ngoài.', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768752597/courses/avpprhdwcx1htwipn4js.png', 500000.00, 'beginner', 'active', '2026-01-18 16:09:58'),
(22, 'Reading English Step by Step', 'Phát triển kỹ năng đọc hiểu tiếng Anh thông qua các đoạn văn ngắn, bài báo đơn giản và câu chuyện thực tế.', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768752639/courses/knfqsxeu5zo5h1rzvown.png', 600000.00, 'intermediate', 'active', '2026-01-18 16:10:40'),
(23, 'English Fundamentals', 'Hướng dẫn cách viết câu, đoạn văn và email tiếng Anh cơ bản phục vụ học tập và công việc.', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768752784/courses/fkystsftpdpzbfu0h10z.png', 550000.00, 'advanced', 'active', '2026-01-18 16:13:05'),
(24, 'English for Office', 'Tiếng Anh giao tiếp văn phòng, tập trung vào email, họp hành và trao đổi công việc trong môi trường công sở.', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768752900/courses/hu3eem8b91h2j39vtb4z.png', 680000.00, 'advanced', 'active', '2026-01-18 16:15:01'),
(25, 'English for Travel and Daily Life', 'Trang bị tiếng Anh cần thiết khi du lịch, mua sắm, hỏi đường và giao tiếp trong đời sống hằng ngày.', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768752942/courses/oj5jzwdswxrcn6ir9qbp.png', 720000.00, 'beginner', 'active', '2026-01-18 16:15:43'),
(26, 'Intermediate English', 'Nâng cao kiến thức ngữ pháp tiếng Anh trung cấp, giúp người học sử dụng câu phức và cấu trúc nâng cao hơn.', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768753212/courses/oaf5qscryloxhsdutqj5.png', 750000.00, 'intermediate', 'active', '2026-01-18 16:20:13'),
(27, 'English Listening and Speaking Practice', 'Kết hợp luyện nghe và nói tiếng Anh thông qua hội thoại thực tế, giúp cải thiện phản xạ ngôn ngữ.', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768753261/courses/keglgxahmx2o2d4ibitd.png', 760000.00, 'advanced', 'active', '2026-01-18 16:21:02'),
(28, 'English Preparation Basics', 'Làm quen với các dạng bài kiểm tra tiếng Anh phổ biến, giúp người học tự tin khi làm bài test và đánh giá năng lực.', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768753398/courses/f4lvthndd4vn6ult9rbp.png', 980000.00, 'beginner', 'active', '2026-01-18 16:23:20');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `final_test`
--

DROP TABLE IF EXISTS `final_test`;
CREATE TABLE IF NOT EXISTS `final_test` (
  `final_test_Id` bigint NOT NULL AUTO_INCREMENT,
  `course_Id` bigint DEFAULT NULL,
  `test_title` varchar(255) DEFAULT NULL,
  `description` longtext,
  `total_questions` int DEFAULT NULL,
  `time_limit` int DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`final_test_Id`),
  KEY `course_Id` (`course_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `final_test`
--

INSERT INTO `final_test` (`final_test_Id`, `course_Id`, `test_title`, `description`, `total_questions`, `time_limit`, `created_at`) VALUES
(18, 15, 'English Basics Test', 'Bài kiểm tra đánh giá kiến thức tiếng Anh cơ bản dành cho người mới bắt đầu.', 5, 15, '2026-01-18 09:26:00'),
(19, 16, 'Grammar Fundamentals Test', 'Kiểm tra các cấu trúc ngữ pháp tiếng Anh nền tảng và cách sử dụng đúng.', 5, 20, '2026-01-18 09:27:16'),
(20, 17, 'Vocabulary Basic Test', 'Đánh giá vốn từ vựng tiếng Anh cơ bản theo các chủ đề thông dụng.', 7, 15, '2026-01-18 09:27:34'),
(21, 18, 'Pronunciation Awareness Test', 'Kiểm tra khả năng nhận diện phát âm và ngữ điệu tiếng Anh.', 3, 12, '2026-01-18 09:27:55'),
(22, 19, 'Listening Comprehension Test', 'Đánh giá kỹ năng nghe hiểu tiếng Anh qua các đoạn hội thoại ngắn.', 8, 25, '2026-01-18 09:28:28'),
(23, 20, 'Speaking Readiness Test', 'Kiểm tra mức độ sẵn sàng giao tiếp tiếng Anh trong các tình huống thực tế.', 4, 15, '2026-01-18 09:29:04'),
(24, 28, 'General English Level Test', 'Đánh giá tổng quát trình độ tiếng Anh hiện tại của người học.', 3, 10, '2026-01-18 09:29:37'),
(25, 22, 'Reading Comprehension Basics', 'Bài kiểm tra kỹ năng đọc hiểu tiếng Anh với nội dung đơn giản.', 4, 15, '2026-01-18 09:30:16'),
(26, 21, 'Speaking Readiness Test', 'Kiểm tra mức độ sẵn sàng giao tiếp tiếng Anh trong các tình huống thực tế.', 4, 15, '2026-01-18 09:31:04'),
(27, 23, 'Writing Fundamentals Test', 'Đánh giá khả năng viết câu và đoạn văn tiếng Anh cơ bản.', 4, 15, '2026-01-18 09:32:27'),
(28, 24, 'Office English Test', 'Đánh giá tiếng Anh sử dụng trong môi trường văn phòng và công việc.', 5, 20, '2026-01-18 09:33:09'),
(29, 25, 'Travel English Test', 'Kiểm tra kỹ năng tiếng Anh cần thiết khi du lịch và di chuyển.', 5, 15, '2026-01-18 09:33:38'),
(30, 26, 'Intermediate Grammar Test', 'Bài kiểm tra ngữ pháp tiếng Anh trình độ trung cấp.', 4, 15, '2026-01-18 09:34:20'),
(31, 27, 'Vocabulary Expansion Test', 'Đánh giá khả năng mở rộng và sử dụng từ vựng tiếng Anh nâng cao', 5, 30, '2026-01-18 09:34:41');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `final_test_question`
--

DROP TABLE IF EXISTS `final_test_question`;
CREATE TABLE IF NOT EXISTS `final_test_question` (
  `final_question_Id` bigint NOT NULL AUTO_INCREMENT,
  `final_test_Id` bigint DEFAULT NULL,
  `question_text` longtext,
  `option_a` varchar(255) DEFAULT NULL,
  `option_b` varchar(255) DEFAULT NULL,
  `option_c` varchar(255) DEFAULT NULL,
  `option_d` varchar(255) DEFAULT NULL,
  `correct_option` varchar(255) DEFAULT NULL,
  `explanation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`final_question_Id`),
  KEY `final_test_Id` (`final_test_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `final_test_question`
--

INSERT INTO `final_test_question` (`final_question_Id`, `final_test_Id`, `question_text`, `option_a`, `option_b`, `option_c`, `option_d`, `correct_option`, `explanation`) VALUES
(44, 18, 'What is the correct greeting in English?', 'Goodbye', 'Hello', 'Thanks', 'Sorry', 'B', '“Hello” là câu chào phổ biến nhất khi gặp ai đó.\nGoodbye → dùng khi chia tay\nThanks → dùng để cảm ơn\nSorry → dùng khi xin lỗi'),
(45, 18, 'Choose the correct word: “I ___ a student.”', 'is', 'are', 'am', 'be', 'C', 'Chủ ngữ “I” luôn đi với động từ am trong thì hiện tại đơn.\nis → dùng cho he/she/it\nare → dùng cho you/we/they\nbe → dạng nguyên mẫu, không dùng trực tiếp trong câu này'),
(46, 18, 'Which word means “xin chào”?', 'Goodbye', 'Please', 'Hello', 'Thanks', 'C', '“Hello” có nghĩa là “xin chào”.\nGoodbye → tạm biệt\nPlease → làm ơn\nThanks → cảm ơn'),
(47, 18, 'Choose the correct response to: “How are you?”', 'I am a student', 'I am fine, thank you', 'Goodbye', 'My name is John', 'B', '“How are you?” dùng để hỏi thăm sức khỏe.\nCâu trả lời phù hợp nhất là “I am fine, thank you.”\nCác đáp án còn lại không đúng ngữ cảnh giao tiếp.'),
(48, 18, 'What is the plural of “book”?', 'book', 'books', 'bookes', 'booking', 'A', 'Danh từ số nhiều của “book” được tạo bằng cách thêm -s → books.\nbook → số ít\nbookes → sai chính tả\nbooking → là danh từ khác, không phải số nhiều'),
(49, 19, 'Choose the correct sentence.', 'She go to school every day.', 'She goes to school every day.', 'She going to school every day.', 'She gone to school every day.', 'B', 'She là số ít nên động từ thêm -s'),
(50, 19, 'Choose the correct verb: He ___ a teacher.', 'are', 'is', 'am', 'be', 'B', 'He là chủ ngữ số ít nên dùng is'),
(51, 19, 'Which sentence is in past tense?', 'I eat breakfast.', 'I am eating breakfast.', 'I ate breakfast.', 'I will eat breakfast.', 'C', 'Ate là quá khứ của eat'),
(52, 19, 'Choose the correct form.', 'They is happy.', 'They are happy.', 'They am happy.', 'They be happy.', 'B', 'They là số nhiều nên dùng are'),
(53, 19, 'Which sentence is correct?', 'She don’t like coffee.', 'She doesn’t like coffee.', 'She not like coffee.', 'She didn’t likes coffee.', 'B', 'Hiện tại đơn phủ định với she dùng doesn’t'),
(54, 20, 'What is the meaning of \"apple\"?', 'A kind of fruit', 'A type of animal', 'A vehicle', 'A color', 'A', 'Apple nghĩa là quả táo, thuộc nhóm trái cây'),
(55, 20, 'Choose the correct word: I drink ___ every morning.', 'rice', 'water', 'chair', 'book', 'B', 'Water là đồ uống, phù hợp ngữ cảnh'),
(56, 20, 'What does \"teacher\" mean?', 'Người học sinh', 'Người dạy học', 'Người bán hàng', 'Người lái xe', 'B', 'Teacher nghĩa là giáo viên'),
(57, 20, 'Which word means \"very big\"?', 'small', 'tiny', 'huge', 'short', 'C', 'Huge mang nghĩa rất lớn'),
(58, 20, 'Choose the correct word: She lives in a big ___.', 'eat', 'house', 'drink', 'run', 'B', 'House là danh từ chỉ nơi ở'),
(59, 20, 'What is the opposite of \"cold\"?', 'hot', 'cool', 'freezing', 'wet', 'A', 'Hot là trái nghĩa của cold'),
(60, 20, 'Which word is a color?', 'dog', 'run', 'blue', 'table', 'C', 'Blue là màu sắc'),
(61, 21, 'Which word has a different pronunciation of the ending \"-s\"?', 'cats', 'dogs', 'books', 'watches', 'D', '\"Watches\" có âm /ɪz/, các từ còn lại là /s/ hoặc /z/'),
(62, 21, 'Which word is pronounced with a silent letter?', 'knife', 'name', 'cat', 'dog', 'A', 'Chữ \"k\" trong \"knife\" là âm câm'),
(63, 21, 'Which word has the stress on the first syllable?', 'about', 'begin', 'teacher', 'agree', 'C', 'Teacher được nhấn âm tiết đầu: TEA-cher'),
(64, 21, 'Which word has a different pronunciation of the ending \"-s\"?', 'cats', 'dogs', 'books', 'watches', 'D', '\"Watches\" có âm /ɪz/, các từ còn lại là /s/ hoặc /z/'),
(65, 21, 'Which word is pronounced with a silent letter?', 'knife', 'name', 'cat', 'dog', 'A', 'Chữ \"k\" trong \"knife\" là âm câm'),
(66, 21, 'Which word has the stress on the first syllable?', 'about', 'begin', 'teacher', 'agree', 'C', 'Teacher được nhấn âm tiết đầu: TEA-cher'),
(67, 23, 'What should you say when meeting someone for the first time?', 'How old are you?', 'Nice to meet you', 'What do you want?', 'Where are you going?', 'B', 'Câu chào lịch sự'),
(68, 23, 'How do you ask for help politely?', 'Help me', 'Can you help me, please?', 'Do it now', 'You must help', 'B', 'Câu lịch sự'),
(69, 23, 'What do you say to end a conversation?', 'Hello', 'Sorry', 'Goodbye', 'Thanks', 'C', 'Goodbye dùng để kết thúc'),
(70, 23, 'How do you respond to \"How are you?\"', 'Yes', 'I am fine, thank you', 'Goodbye', 'No', 'B', 'Câu trả lời chuẩn'),
(71, 24, 'Choose the correct sentence.', 'She go to school', 'She goes to school', 'She going school', 'She gone school', 'B', 'Ngôi thứ 3 số ít + s'),
(72, 24, 'Which word is a noun?', 'Run', 'Quick', 'Happiness', 'Fast', 'C', 'Happiness là danh từ'),
(73, 24, 'Choose the correct tense: Yesterday I ___ a movie.', 'watch', 'watches', 'watched', 'watching', 'C', 'Yesterday → quá khứ'),
(74, 25, 'What is the main idea of the passage?', 'The weather', 'A short story', 'Daily routine', 'Food', 'C', 'Bài đọc nói về sinh hoạt hằng ngày'),
(75, 25, 'Who is mentioned in the passage?', 'A teacher', 'A student', 'A doctor', 'A farmer', 'B', 'Nhân vật chính là học sinh'),
(76, 25, 'When does the activity happen?', 'In the morning', 'At night', 'In the evening', 'At noon', 'A', 'Đoạn văn nói buổi sáng'),
(77, 25, 'What does the word \"routine\" mean?', 'Something new', 'Daily habit', 'A place', 'A job', 'B', 'Routine = thói quen hằng ngày'),
(78, 26, 'What should you say when meeting someone for the first time?', 'Goodbye', 'See you', 'Nice to meet you', 'Thanks', 'C', 'Câu chào lịch sự khi gặp lần đầu'),
(79, 26, 'How do you ask for help politely?', 'Help me', 'Can you help me?', 'You help', 'Help now', 'B', 'Can you… là cách hỏi lịch sự'),
(80, 26, 'What do you say when you do not understand?', 'Yes', 'No', 'I don’t understand', 'Okay', 'C', 'Dùng khi chưa hiểu'),
(81, 26, 'What is a polite response to thanks?', 'Yes', 'No', 'Welcome', 'You’re welcome', 'D', 'Câu đáp lịch sự'),
(82, 27, 'Choose the correct sentence.', 'I like play football', 'I like playing football', 'I like played football', 'I liking football', 'B', 'Like + V-ing'),
(83, 27, 'Which sentence is correct?', 'She go to work', 'She goes work', 'She goes to work', 'She going work', 'C', 'Cấu trúc đúng'),
(84, 27, 'Choose the correct punctuation.', 'Hello how are you', 'Hello, how are you?', 'Hello how are you.', 'Hello; how are you', 'B', 'Câu hỏi cần dấu ?'),
(85, 27, 'Which word starts with a capital letter?', 'city', 'school', 'monday', 'John', 'D', 'Tên riêng viết hoa'),
(86, 28, 'What does \"meeting\" mean?', 'Cuộc họp', 'Email', 'Báo cáo', 'Nghỉ phép', 'A', 'Meeting = cuộc họp'),
(87, 28, 'How do you say xin nghỉ phép?', 'I go home', 'I take leave', 'I want off', 'I leave job', 'B', 'Take leave = xin nghỉ'),
(88, 28, 'Which is a formal greeting?', 'Hi bro', 'Hey', 'Good morning', 'Yo', 'C', 'Dùng trong môi trường công sở'),
(89, 28, 'What does deadline mean?', 'Cuộc họp', 'Hạn chót', 'Lương', 'Dự án', 'B', 'Deadline = hạn cuối'),
(90, 28, 'Who is your manager?', 'Đồng nghiệp', 'Khách hàng', 'Sếp', 'Bạn bè', 'C', 'Manager = quản lý'),
(91, 29, 'Where is the airport?', 'Sân vận động', 'Nhà ga', 'Sân bay', 'Khách sạn', 'C', 'Airport = sân bay'),
(92, 29, 'What does passport mean?', 'Vé', 'Hộ chiếu', 'Tiền', 'Hành lý', 'B', 'Passport = hộ chiếu'),
(93, 29, 'How do you ask for directions?', 'Where you go?', 'How much?', 'Can you help me?', 'Excuse me, where is...?', 'D', 'Cách hỏi đường'),
(94, 29, 'What is luggage?', 'Hành lý', 'Taxi', 'Vé', 'Khách sạn', 'A', 'Luggage = hành lý'),
(95, 29, 'Which word relates to travel?', 'Office', 'Ticket', 'Homework', 'Salary', 'B', 'Ticket dùng khi đi lại'),
(96, 30, 'If it rains, I ___ at home.', 'stay', 'will stay', 'stayed', 'staying', 'B', 'Câu điều kiện loại 1'),
(97, 30, 'She has lived here ___ 5 years.', 'since', 'for', 'during', 'from', 'B', 'For + khoảng thời gian'),
(98, 30, 'Choose correct passive voice.', 'He built the house', 'The house is built', 'The house was built', 'The house builds', 'C', 'Bị động quá khứ'),
(99, 30, 'Choose correct modal verb.', 'You must to go', 'You must go', 'You must going', 'You must goes', 'B', 'Must + V nguyên mẫu'),
(100, 31, 'Which word means \"increase\"?', 'Reduce', 'Expand', 'Close', 'Stop', 'B', 'Expand = mở rộng'),
(101, 31, 'Opposite of \"cheap\" is?', 'Small', 'Low', 'Expensive', 'Free', 'C', 'Cheap ↔ expensive'),
(102, 31, 'Which word means \"very tired\"?', 'Happy', 'Exhausted', 'Angry', 'Excited', 'B', 'Exhausted = rất mệt'),
(103, 31, 'Which is a synonym of \"fast\"?', 'Quick', 'Slow', 'Late', 'Hard', 'A', 'Fast = quick'),
(104, 31, 'Which word relates to technology?', 'Computer', 'Bread', 'Chair', 'Milk', 'A', 'Computer thuộc công nghệ'),
(105, 22, 'What is the woman asking for?', 'Directions', 'Food', 'A job', 'Help with homework', 'A', 'Câu hỏi hỏi về đường đi'),
(106, 22, 'Where does the conversation take place?', 'At a school', 'At a restaurant', 'At an airport', 'At a hospital', 'B', 'Nội dung liên quan gọi món'),
(107, 22, 'What time is the meeting?', '8 AM', '9 AM', '10 AM', '11 AM', 'C', 'Người nói nhắc rõ 10 AM'),
(108, 22, 'What does the man want to buy?', 'A ticket', 'A book', 'A phone', 'A laptop', 'A', 'Từ khóa: buy a ticket'),
(109, 22, 'Who is calling?', 'A friend', 'A teacher', 'A customer', 'A doctor', 'C', 'Ngữ cảnh gọi dịch vụ'),
(110, 22, 'What is the problem?', 'Late delivery', 'Wrong order', 'No payment', 'Bad service', 'B', 'Nhấn mạnh order sai'),
(111, 22, 'What will happen next?', 'They leave', 'They wait', 'They eat', 'They cancel', 'B', 'Người nói yêu cầu chờ'),
(112, 22, 'How does the woman feel?', 'Happy', 'Angry', 'Confused', 'Excited', 'C', 'Ngữ điệu thể hiện bối rối');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lesson`
--

DROP TABLE IF EXISTS `lesson`;
CREATE TABLE IF NOT EXISTS `lesson` (
  `lesson_Id` bigint NOT NULL AUTO_INCREMENT,
  `course_Id` bigint DEFAULT NULL,
  `lesson_title` varchar(255) DEFAULT NULL,
  `description` longtext,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`lesson_Id`),
  KEY `course_Id` (`course_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `lesson`
--

INSERT INTO `lesson` (`lesson_Id`, `course_Id`, `lesson_title`, `description`, `created_at`) VALUES
(11, 15, 'Introduction to English', 'Bài học mở đầu giúp người học làm quen với tiếng Anh cơ bản và phương pháp học hiệu quả', NULL),
(12, 16, 'Basic Grammar Overview', 'Giới thiệu các cấu trúc ngữ pháp tiếng Anh nền tảng', NULL),
(13, 17, 'Everyday Vocabulary', 'Từ vựng tiếng Anh thông dụng sử dụng trong đời sống hằng ngày', NULL),
(14, 18, 'English Pronunciation Basics', 'Làm quen với phát âm tiếng Anh và các âm cơ bản', NULL),
(15, 19, 'Listening Skills Foundation', 'Rèn luyện kỹ năng nghe hiểu tiếng Anh cơ bản', NULL),
(16, 20, 'Basic Speaking Practice', 'Thực hành giao tiếp tiếng Anh trong các tình huống đơn giản', NULL),
(17, 21, 'Common Daily Conversations', 'Hội thoại tiếng Anh thông dụng trong cuộc sống', NULL),
(18, 22, 'Reading Simple Texts', 'Luyện đọc các đoạn văn tiếng Anh ngắn và dễ', NULL),
(19, 23, 'Writing Simple Sentences', 'Học cách viết câu tiếng Anh đơn giản và đúng ngữ pháp', NULL),
(20, 24, 'Office English Basics', 'Tiếng Anh cơ bản sử dụng trong môi trường công sở', NULL),
(21, 25, 'Travel English Essentials', 'Những mẫu câu tiếng Anh cần thiết khi đi du lịch', NULL),
(22, 26, 'Intermediate Grammar Concepts', 'Các điểm ngữ pháp tiếng Anh trình độ trung cấp', NULL),
(23, 27, 'Advanced Vocabulary Building', 'Mở rộng vốn từ vựng tiếng Anh nâng cao', NULL),
(24, 28, 'General English Review', 'Ôn tập tổng quát kiến thức tiếng Anh đã học', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lesson_grammar`
--

DROP TABLE IF EXISTS `lesson_grammar`;
CREATE TABLE IF NOT EXISTS `lesson_grammar` (
  `grammar_Id` bigint NOT NULL AUTO_INCREMENT,
  `lesson_Id` bigint DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `explanation` longtext,
  `example` longtext,
  `video_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  PRIMARY KEY (`grammar_Id`),
  KEY `lesson_Id` (`lesson_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `lesson_grammar`
--

INSERT INTO `lesson_grammar` (`grammar_Id`, `lesson_Id`, `title`, `explanation`, `example`, `video_url`) VALUES
(25, 11, 'Daily Routine', 'This lesson is about daily activities people do every day.', 'I wake up at 6 a.m. and go to work at 8.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763591/grammar/video/pt3lblwwffrjbdfe8wca.mp4'),
(26, 12, 'Office Conversation', 'This lesson focuses on conversations in the workplace.', 'The meeting starts at 9 a.m. in the conference room.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763429/grammar/video/ce80lyhrmwk4txucyk7z.mp4'),
(27, 13, 'Public Announcement', 'This lesson helps you understand announcements in public places.', 'Attention please, the train will arrive at platform 3.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763591/grammar/video/pt3lblwwffrjbdfe8wca.mp4'),
(28, 14, 'Technology Talk', 'This lesson is about discussions related to technology.', 'Technology makes our lives easier and faster.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763429/grammar/video/ce80lyhrmwk4txucyk7z.mp4'),
(29, 15, 'Event Information', 'This lesson explains how to understand event schedules.', 'The event will last for one hour.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763591/grammar/video/pt3lblwwffrjbdfe8wca.mp4'),
(30, 16, 'Customer Service Call', 'This lesson covers phone conversations with customer service.', 'I am calling to confirm my order.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763429/grammar/video/ce80lyhrmwk4txucyk7z.mp4'),
(31, 17, 'Travel Plan', 'This lesson is about planning and discussing trips.', 'We will travel to the mountains this weekend.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763591/grammar/video/pt3lblwwffrjbdfe8wca.mp4'),
(32, 18, 'Advertisement', 'This lesson helps learners understand advertisements.', 'This course is suitable for beginners.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763429/grammar/video/ce80lyhrmwk4txucyk7z.mp4'),
(33, 19, 'Shopping Conversation', 'This lesson focuses on conversations in shops.', 'I would like to exchange this product.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763591/grammar/video/pt3lblwwffrjbdfe8wca.mp4'),
(34, 20, 'Project Discussion', 'This lesson is about discussing project schedules and plans.', 'We need to postpone the plan.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763429/grammar/video/ce80lyhrmwk4txucyk7z.mp4'),
(35, 21, 'Reminder Call', 'This lesson helps you understand reminder calls.', 'This is a reminder about the deadline.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763591/grammar/video/pt3lblwwffrjbdfe8wca.mp4'),
(36, 22, 'Safety Instructions', 'This lesson teaches how to follow safety instructions.', 'Please wear a helmet for your safety.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763429/grammar/video/ce80lyhrmwk4txucyk7z.mp4'),
(37, 23, 'Schedule Change', 'This lesson is about announcements of changes.', 'The class has been moved to next week.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763591/grammar/video/pt3lblwwffrjbdfe8wca.mp4'),
(38, 24, 'Job Interview', 'This lesson prepares you for interview situations.', 'Please arrive early and prepare your documents.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763429/grammar/video/ce80lyhrmwk4txucyk7z.mp4'),
(39, 11, 'Daily Routine', 'This lesson is about daily activities people do every day.', 'I wake up at 6 a.m. and go to work at 8.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763591/grammar/video/pt3lblwwffrjbdfe8wca.mp4'),
(40, 11, 'Daily Routine', 'This lesson is about daily activities people do every day.', 'I wake up at 6 a.m. and go to work at 8.', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768763429/grammar/video/ce80lyhrmwk4txucyk7z.mp4');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lesson_listening`
--

DROP TABLE IF EXISTS `lesson_listening`;
CREATE TABLE IF NOT EXISTS `lesson_listening` (
  `listening_Id` bigint NOT NULL AUTO_INCREMENT,
  `lesson_Id` bigint DEFAULT NULL,
  `audio_url` longtext,
  `transcript` longtext,
  PRIMARY KEY (`listening_Id`),
  KEY `lesson_Id` (`lesson_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `lesson_listening`
--

INSERT INTO `lesson_listening` (`listening_Id`, `lesson_Id`, `audio_url`, `transcript`) VALUES
(20, 20, 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768761469/listen/audio/liuj34ixakgr1bbv3y8i.mp3', 'Every morning, I wake up at six o’clock. I brush my teeth and wash my face before having breakfast with my family. My breakfast is usually bread and milk. After that, I put on my uniform and go to school by bus.\nAt school, I study English, math, and science. My favorite subject is English because I like learning new words. After school, I go home and do my homework. In the evening, I watch TV or read books before going to bed at ten o’clock.'),
(21, 12, 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768761538/listen/audio/oyizuxdueis2ughtthuz.mp3', 'Yesterday was a busy day for me. I woke up late because I went to bed very late the night before. I missed the bus, so I walked to school.\r\nIn the afternoon, I studied grammar with my teacher. We learned about past tense and practiced many exercises. After class, I met my friend and talked about our homework. I felt tired but happy when I got home.'),
(22, 11, 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768761538/listen/audio/oyizuxdueis2ughtthuz.mp3', 'Learning English pronunciation is not easy for me. Some sounds are difficult to say, especially “th” and “r”.\r\nEvery day, I practice by listening to English videos and repeating after the speakers. I also record my voice and listen again. Slowly, my pronunciation is getting better, and I feel more confident when speaking.'),
(23, 13, 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768761538/listen/audio/oyizuxdueis2ughtthuz.mp3', 'Hello, this is Anna speaking. I am calling to ask about the meeting tomorrow. The meeting will start at nine in the morning and end at eleven.\r\nPlease remember to bring your notebook and arrive early. If you have any questions, you can call me back later. Thank you for listening.'),
(24, 14, 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768761538/listen/audio/oyizuxdueis2ughtthuz.mp3', 'Hello everyone, my name is Tom. I am a student and I live in the city. I like learning English because it helps me talk to people from other countries.\r\nIn my free time, I enjoy playing football and listening to music. I hope I can speak English fluently in the future.'),
(25, 15, 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768761538/listen/audio/oyizuxdueis2ughtthuz.mp3', 'Life in the city is very busy. People wake up early and go to work or school. There are many cars and buses on the road.\r\nAlthough city life is noisy, it is also exciting. There are many shops, restaurants, and parks. I like living in the city because everything is convenient.'),
(26, 16, 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768761538/listen/audio/oyizuxdueis2ughtthuz.mp3', 'One day, a small boy found a lost dog near his house. The dog looked hungry and tired.\r\nThe boy gave the dog some food and water. Later, he found the owner and returned the dog. Both the boy and the owner felt very happy.'),
(27, 17, 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768761538/listen/audio/oyizuxdueis2ughtthuz.mp3', 'Yesterday, I went to a restaurant with my friends. We ordered noodles, fried rice, and some drinks.\r\nThe waiter was very friendly and helped us choose the food. After eating, we talked and laughed together. It was a great evening.'),
(28, 18, 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768761538/listen/audio/oyizuxdueis2ughtthuz.mp3', 'Writing emails is important in daily life. When I write an email, I always start with a greeting.\r\nI try to use simple words and clear sentences. At the end of the email, I say goodbye politely. This helps the reader understand my message easily.'),
(29, 19, 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768761538/listen/audio/oyizuxdueis2ughtthuz.mp3', 'Every morning, I arrive at the office at eight thirty. I check my emails and plan my tasks for the day.\r\nIn the afternoon, I attend meetings with my team. We discuss our work and share ideas. Before going home, I finish my reports.'),
(30, 21, 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768761538/listen/audio/oyizuxdueis2ughtthuz.mp3', 'When I travel by plane, I arrive at the airport early. First, I check in and show my passport.\r\nThen, I wait at the gate until it is time to board. During the flight, I listen to music or watch a movie.'),
(31, 22, 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768761538/listen/audio/oyizuxdueis2ughtthuz.mp3', 'Learning new vocabulary helps me understand English better. I often write new words in a notebook.\r\nI also try to use these words in sentences. When I review them every day, I remember them longer and use them more naturally.'),
(32, 23, 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768761538/listen/audio/oyizuxdueis2ughtthuz.mp3', 'Life in the city is very busy. People wake up early and go to work or school. There are many cars and buses on the road.\r\nAlthough city life is noisy, it is also exciting. There are many shops, restaurants, and parks. I like living in the city because everything is convenient.'),
(33, 24, 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768761538/listen/audio/oyizuxdueis2ughtthuz.mp3', 'Last Sunday, my mother and I went to the market near our house. The market was very crowded and noisy.\r\nWe bought vegetables, fruits, meat, and some bread. My mother talked to the sellers while I helped her carry the bags. After shopping, we went home and cooked lunch together. The food was delicious.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lesson_reading`
--

DROP TABLE IF EXISTS `lesson_reading`;
CREATE TABLE IF NOT EXISTS `lesson_reading` (
  `reading_Id` bigint NOT NULL AUTO_INCREMENT,
  `lesson_Id` bigint DEFAULT NULL,
  `passage` longtext,
  PRIMARY KEY (`reading_Id`),
  KEY `lesson_Id` (`lesson_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `lesson_reading`
--

INSERT INTO `lesson_reading` (`reading_Id`, `lesson_Id`, `passage`) VALUES
(11, 11, 'English is an important language used all over the world. Many people learn English to communicate with others, study abroad, or get better jobs. Learning English takes time and practice, but with the right method, it becomes easier and more enjoyable.'),
(12, 12, 'Grammar is the structure of a language. Understanding basic grammar helps learners form correct sentences and express ideas clearly. When grammar is used correctly, communication becomes more effective.'),
(13, 13, 'Vocabulary plays a key role in learning English. The more words you know, the easier it is to understand reading texts and conversations. Learning new words every day is a good habit for language learners.'),
(14, 14, 'Pronunciation is how words are spoken. Correct pronunciation helps others understand you better. Listening to native speakers and practicing aloud are useful ways to improve pronunciation.'),
(15, 15, 'Listening skills are developed by hearing English in real situations. Watching videos, listening to podcasts, or talking with others can improve listening comprehension over time.'),
(16, 16, 'Speaking English confidently requires practice. Making mistakes is normal when learning a new language. The important thing is to keep speaking and not be afraid of errors.'),
(17, 17, 'Daily conversations often include greetings, questions, and simple responses. Learning common phrases helps learners communicate more naturally in everyday situations.'),
(18, 18, 'Reading simple English texts helps learners understand sentence structure and vocabulary usage. Reading regularly improves comprehension and overall language skills.'),
(19, 19, 'Writing helps learners organize their thoughts in English. Starting with simple sentences and gradually writing longer paragraphs is an effective way to improve writing skills.'),
(20, 20, 'English is widely used in offices and workplaces. Understanding common office terms and expressions helps employees communicate professionally with colleagues and clients.'),
(21, 21, 'Traveling becomes easier when you can speak English. Knowing how to ask for directions, order food, and communicate at airports is very useful for travelers.'),
(22, 22, 'Intermediate English learners focus on using grammar accurately in different situations. Practice helps learners use tenses and sentence structures more naturally.'),
(23, 23, 'Advanced vocabulary allows learners to express ideas more clearly and precisely. Reading books and articles helps expand vocabulary knowledge.'),
(24, 24, 'Reviewing English lessons regularly helps learners remember what they have studied. Revision strengthens understanding and improves long-term language ability.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lesson_vocabulary`
--

DROP TABLE IF EXISTS `lesson_vocabulary`;
CREATE TABLE IF NOT EXISTS `lesson_vocabulary` (
  `vocabulary_Id` bigint NOT NULL AUTO_INCREMENT,
  `lesson_Id` bigint DEFAULT NULL,
  `word` varchar(255) DEFAULT NULL,
  `meaning` varchar(255) DEFAULT NULL,
  `example` varchar(255) DEFAULT NULL,
  `pronunciation` varchar(255) DEFAULT NULL,
  `img_url` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `audio_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  PRIMARY KEY (`vocabulary_Id`),
  KEY `lesson_Id` (`lesson_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `lesson_vocabulary`
--

INSERT INTO `lesson_vocabulary` (`vocabulary_Id`, `lesson_Id`, `word`, `meaning`, `example`, `pronunciation`, `img_url`, `audio_url`) VALUES
(12, 11, 'Dad', 'cha , bố ', 'My dad is saleman', 'dæd', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757622/vocabulary/images/syaaibi0ay69ghhobnks.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757626/vocabulary/audio/gm7uvra5myu7bl65pfuo.mp3'),
(13, 11, 'Mom', 'mẹ', 'Happy birthday, mom', 'mɒm', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757233/vocabulary/images/t8dsqlvcsp6gkjhnl2dq.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757242/vocabulary/audio/flppin3xf7tgragsognu.mp3'),
(14, 12, 'Rabbit', 'con thỏ', 'I like rabbit because they are cute', '\'ræbit', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757417/vocabulary/images/wv5dqtjz2oeheck4m23g.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757420/vocabulary/audio/u0bisizifzq8x01ktzes.mp3'),
(15, 12, 'Book', 'cuốn sách', 'The book is in the bag', 'bʊk', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757586/vocabulary/images/al3hmivjd1u4cooie8lb.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757589/vocabulary/audio/tebnlgikx9tm4q12vo0a.mp3'),
(16, 13, 'Dad', 'cha , bố ', 'My dad is saleman', 'dæd', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757622/vocabulary/images/syaaibi0ay69ghhobnks.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757626/vocabulary/audio/gm7uvra5myu7bl65pfuo.mp3'),
(17, 13, 'Mom', 'mẹ', 'Happy birthday, mom', 'mɒm', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757233/vocabulary/images/t8dsqlvcsp6gkjhnl2dq.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757242/vocabulary/audio/flppin3xf7tgragsognu.mp3'),
(18, 14, 'Rabbit', 'con thỏ', 'I like rabbit because they are cute', '\'ræbit', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757417/vocabulary/images/wv5dqtjz2oeheck4m23g.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757420/vocabulary/audio/u0bisizifzq8x01ktzes.mp3'),
(19, 14, 'Book', 'cuốn sách', 'The book is in the bag', 'bʊk', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757586/vocabulary/images/al3hmivjd1u4cooie8lb.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757589/vocabulary/audio/tebnlgikx9tm4q12vo0a.mp3'),
(20, 13, 'Dad', 'cha, bố', 'My dad is a salesman', 'dæd', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757622/vocabulary/images/syaaibi0ay69ghhobnks.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757626/vocabulary/audio/gm7uvra5myu7bl65pfuo.mp3'),
(21, 13, 'Mom', 'mẹ', 'Happy birthday, mom', 'mɒm', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757233/vocabulary/images/t8dsqlvcsp6gkjhnl2dq.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757242/vocabulary/audio/flppin3xf7tgragsognu.mp3'),
(22, 14, 'Rabbit', 'con thỏ', 'I like rabbits because they are cute', 'ræbit', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757417/vocabulary/images/wv5dqtjz2oeheck4m23g.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757420/vocabulary/audio/u0bisizifzq8x01ktzes.mp3'),
(23, 14, 'Book', 'cuốn sách', 'The book is in the bag', 'bʊk', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757586/vocabulary/images/al3hmivjd1u4cooie8lb.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757589/vocabulary/audio/tebnlgikx9tm4q12vo0a.mp3'),
(24, 15, 'Dad', 'cha, bố', 'My dad is a salesman', 'dæd', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757622/vocabulary/images/syaaibi0ay69ghhobnks.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757626/vocabulary/audio/gm7uvra5myu7bl65pfuo.mp3'),
(25, 16, 'Mom', 'mẹ', 'Happy birthday, mom', 'mɒm', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757233/vocabulary/images/t8dsqlvcsp6gkjhnl2dq.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757242/vocabulary/audio/flppin3xf7tgragsognu.mp3'),
(26, 15, 'Rabbit', 'con thỏ', 'I like rabbits because they are cute', 'ræbit', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757417/vocabulary/images/wv5dqtjz2oeheck4m23g.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757420/vocabulary/audio/u0bisizifzq8x01ktzes.mp3'),
(27, 16, 'Book', 'cuốn sách', 'The book is in the bag', 'bʊk', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757586/vocabulary/images/al3hmivjd1u4cooie8lb.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757589/vocabulary/audio/tebnlgikx9tm4q12vo0a.mp3'),
(28, 17, 'Dad', 'cha, bố', 'My dad is a salesman', 'dæd', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757622/vocabulary/images/syaaibi0ay69ghhobnks.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757626/vocabulary/audio/gm7uvra5myu7bl65pfuo.mp3'),
(29, 17, 'Mom', 'mẹ', 'Happy birthday, mom', 'mɒm', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757233/vocabulary/images/t8dsqlvcsp6gkjhnl2dq.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757242/vocabulary/audio/flppin3xf7tgragsognu.mp3'),
(30, 17, 'Rabbit', 'con thỏ', 'I like rabbits because they are cute', 'ræbit', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757417/vocabulary/images/wv5dqtjz2oeheck4m23g.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757420/vocabulary/audio/u0bisizifzq8x01ktzes.mp3'),
(31, 17, 'Book', 'cuốn sách', 'The book is in the bag', 'bʊk', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757586/vocabulary/images/al3hmivjd1u4cooie8lb.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757589/vocabulary/audio/tebnlgikx9tm4q12vo0a.mp3'),
(32, 18, 'Dad', 'cha, bố', 'My dad is a salesman', 'dæd', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757622/vocabulary/images/syaaibi0ay69ghhobnks.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757626/vocabulary/audio/gm7uvra5myu7bl65pfuo.mp3'),
(33, 19, 'Mom', 'mẹ', 'Happy birthday, mom', 'mɒm', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757233/vocabulary/images/t8dsqlvcsp6gkjhnl2dq.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757242/vocabulary/audio/flppin3xf7tgragsognu.mp3'),
(34, 19, 'Rabbit', 'con thỏ', 'I like rabbits because they are cute', 'ræbit', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757417/vocabulary/images/wv5dqtjz2oeheck4m23g.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757420/vocabulary/audio/u0bisizifzq8x01ktzes.mp3'),
(35, 18, 'Book', 'cuốn sách', 'The book is in the bag', 'bʊk', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757586/vocabulary/images/al3hmivjd1u4cooie8lb.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757589/vocabulary/audio/tebnlgikx9tm4q12vo0a.mp3'),
(36, 20, 'Dad', 'cha, bố', 'My dad is a salesman', 'dæd', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757622/vocabulary/images/syaaibi0ay69ghhobnks.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757626/vocabulary/audio/gm7uvra5myu7bl65pfuo.mp3'),
(37, 21, 'Mom', 'mẹ', 'Happy birthday, mom', 'mɒm', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757233/vocabulary/images/t8dsqlvcsp6gkjhnl2dq.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757242/vocabulary/audio/flppin3xf7tgragsognu.mp3'),
(38, 21, 'Rabbit', 'con thỏ', 'I like rabbits because they are cute', 'ræbit', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757417/vocabulary/images/wv5dqtjz2oeheck4m23g.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757420/vocabulary/audio/u0bisizifzq8x01ktzes.mp3'),
(39, 22, 'Book', 'cuốn sách', 'The book is in the bag', 'bʊk', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757586/vocabulary/images/al3hmivjd1u4cooie8lb.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757589/vocabulary/audio/tebnlgikx9tm4q12vo0a.mp3'),
(40, 23, 'Dad', 'cha, bố', 'My dad is a salesman', 'dæd', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757622/vocabulary/images/syaaibi0ay69ghhobnks.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757626/vocabulary/audio/gm7uvra5myu7bl65pfuo.mp3'),
(41, 23, 'Mom', 'mẹ', 'Happy birthday, mom', 'mɒm', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757233/vocabulary/images/t8dsqlvcsp6gkjhnl2dq.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757242/vocabulary/audio/flppin3xf7tgragsognu.mp3'),
(42, 24, 'Rabbit', 'con thỏ', 'I like rabbits because they are cute', 'ræbit', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757417/vocabulary/images/wv5dqtjz2oeheck4m23g.jpg', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757420/vocabulary/audio/u0bisizifzq8x01ktzes.mp3'),
(43, 24, 'Book', 'cuốn sách', 'The book is in the bag', 'bʊk', 'https://res.cloudinary.com/dvobbzlf6/image/upload/v1768757586/vocabulary/images/al3hmivjd1u4cooie8lb.webp', 'https://res.cloudinary.com/dvobbzlf6/video/upload/v1768757589/vocabulary/audio/tebnlgikx9tm4q12vo0a.mp3');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `listening_question`
--

DROP TABLE IF EXISTS `listening_question`;
CREATE TABLE IF NOT EXISTS `listening_question` (
  `question_Id` bigint NOT NULL AUTO_INCREMENT,
  `listening_Id` bigint DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `option_a` varchar(255) DEFAULT NULL,
  `option_b` varchar(255) DEFAULT NULL,
  `option_c` varchar(255) DEFAULT NULL,
  `option_d` varchar(255) DEFAULT NULL,
  `correct_option` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`question_Id`),
  KEY `listening_Id` (`listening_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `listening_question`
--

INSERT INTO `listening_question` (`question_Id`, `listening_Id`, `question`, `option_a`, `option_b`, `option_c`, `option_d`, `correct_option`) VALUES
(21, 20, 'What is the speaker mainly talking about?', 'Daily routine', 'Travel plan', 'Work schedule', 'Family life', 'A'),
(22, 20, 'Where does the conversation take place?', 'At home', 'At school', 'At the office', 'At a restaurant', 'C'),
(23, 21, 'What time does the meeting start?', '8:00 AM', '9:00 AM', '10:00 AM', '11:00 AM', 'B'),
(24, 21, 'Who is the woman talking to?', 'Her manager', 'Her friend', 'Her client', 'Her teacher', 'A'),
(25, 21, 'What will happen next?', 'They will cancel the meeting', 'They will reschedule', 'They will start immediately', 'They will wait for others', 'D'),
(26, 22, 'What is the main purpose of the announcement?', 'To give instructions', 'To apologize', 'To make an invitation', 'To provide information', 'D'),
(27, 22, 'Who should pay attention to the announcement?', 'Students', 'Employees', 'Customers', 'Visitors', 'B'),
(28, 23, 'What is the topic of the talk?', 'Health', 'Technology', 'Education', 'Environment', 'B'),
(29, 23, 'Who is the speaker?', 'A teacher', 'A doctor', 'An engineer', 'A student', 'C'),
(30, 24, 'What does the speaker suggest?', 'Taking notes', 'Asking questions', 'Arriving early', 'Leaving early', 'C'),
(31, 24, 'How long will the event last?', '30 minutes', '1 hour', '2 hours', 'All day', 'B'),
(32, 25, 'Why is the man calling?', 'To make a complaint', 'To ask for help', 'To confirm an order', 'To cancel a service', 'C'),
(33, 25, 'What is the problem?', 'Late delivery', 'Wrong address', 'Broken product', 'Missing payment', 'A'),
(34, 26, 'Where will the trip take place?', 'In the city', 'In the countryside', 'At the beach', 'In the mountains', 'D'),
(35, 26, 'What should participants bring?', 'Food', 'Water', 'Warm clothes', 'Documents', 'C'),
(36, 27, 'What is being advertised?', 'A course', 'A job', 'A product', 'An event', 'A'),
(37, 27, 'Who is the advertisement for?', 'Beginners', 'Experts', 'Children', 'Everyone', 'D'),
(38, 28, 'What does the woman want?', 'More information', 'A refund', 'An exchange', 'A discount', 'B'),
(39, 28, 'What will the man do next?', 'Call back later', 'Check the system', 'Ask his manager', 'Send an email', 'B'),
(40, 29, 'What is the main issue discussed?', 'Traffic', 'Weather', 'Schedule', 'Budget', 'C'),
(41, 29, 'What decision is made?', 'Postpone the plan', 'Cancel the plan', 'Continue as planned', 'Change location', 'A'),
(42, 30, 'What is the purpose of the call?', 'Reminder', 'Invitation', 'Complaint', 'Thank you', 'A'),
(43, 30, 'When is the deadline?', 'Today', 'Tomorrow', 'Next week', 'Next month', 'C'),
(44, 31, 'What does the speaker emphasize?', 'Safety', 'Speed', 'Cost', 'Quality', 'A'),
(45, 31, 'Who should follow the instructions?', 'Drivers', 'Passengers', 'Staff', 'Visitors', 'D'),
(46, 32, 'What is the speaker announcing?', 'A delay', 'A cancellation', 'A promotion', 'A change', 'D'),
(47, 32, 'What is affected by the announcement?', 'Flights', 'Classes', 'Meetings', 'Orders', 'B'),
(48, 33, 'What is the situation?', 'An interview', 'A discussion', 'A presentation', 'A negotiation', 'A'),
(49, 33, 'What advice is given?', 'Prepare documents', 'Speak clearly', 'Arrive early', 'Dress formally', 'C');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE IF NOT EXISTS `payment` (
  `payment_Id` bigint NOT NULL AUTO_INCREMENT,
  `user_Id` bigint DEFAULT NULL,
  `amount` decimal(38,2) DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `name_bank` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`payment_Id`),
  KEY `user_Id` (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `payment`
--

INSERT INTO `payment` (`payment_Id`, `user_Id`, `amount`, `payment_method`, `payment_status`, `name_bank`) VALUES
(48, 20, 1000000.00, 'vnpay', 'success', 'NCB');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `payment_course`
--

DROP TABLE IF EXISTS `payment_course`;
CREATE TABLE IF NOT EXISTS `payment_course` (
  `payment_course_Id` bigint NOT NULL AUTO_INCREMENT,
  `payment_Id` bigint DEFAULT NULL,
  `course_Id` bigint DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`payment_course_Id`),
  KEY `course_Id` (`course_Id`),
  KEY `payment_Id` (`payment_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `payment_course`
--

INSERT INTO `payment_course` (`payment_course_Id`, `payment_Id`, `course_Id`, `created_at`) VALUES
(64, 48, 20, '2026-01-18 19:19:56'),
(65, 48, 23, '2026-01-18 19:19:56');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `progress`
--

DROP TABLE IF EXISTS `progress`;
CREATE TABLE IF NOT EXISTS `progress` (
  `progress_Id` bigint NOT NULL AUTO_INCREMENT,
  `user_course_Id` bigint DEFAULT NULL,
  `lesson_Id` bigint DEFAULT NULL,
  `progress_percent` decimal(38,2) DEFAULT NULL,
  `last_accessed` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`progress_Id`),
  KEY `user_course_Id` (`user_course_Id`),
  KEY `lesson_Id` (`lesson_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `progress`
--

INSERT INTO `progress` (`progress_Id`, `user_course_Id`, `lesson_Id`, `progress_percent`, `last_accessed`, `status`) VALUES
(22, 32, 16, 50.00, '2026-01-18 12:21:57', 'learning');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `reading_question`
--

DROP TABLE IF EXISTS `reading_question`;
CREATE TABLE IF NOT EXISTS `reading_question` (
  `question_Id` bigint NOT NULL AUTO_INCREMENT,
  `reading_Id` bigint DEFAULT NULL,
  `question` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `option_a` varchar(255) DEFAULT NULL,
  `option_b` varchar(255) DEFAULT NULL,
  `option_c` varchar(255) DEFAULT NULL,
  `option_d` varchar(255) DEFAULT NULL,
  `correct_option` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`question_Id`),
  KEY `reading_Id` (`reading_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `reading_question`
--

INSERT INTO `reading_question` (`question_Id`, `reading_Id`, `question`, `option_a`, `option_b`, `option_c`, `option_d`, `correct_option`) VALUES
(11, 11, 'What is the main idea of the passage?', 'Daily life', 'Technology', 'Education', 'Health', 'A'),
(12, 11, 'Who is the passage mainly for?', 'Students', 'Workers', 'Children', 'Everyone', 'D'),
(13, 12, 'What does the author mainly discuss?', 'A problem', 'A solution', 'An experience', 'An opinion', 'C'),
(14, 12, 'Which word best describes the tone?', 'Serious', 'Friendly', 'Angry', 'Sad', 'B'),
(15, 13, 'What is the purpose of the text?', 'To inform', 'To persuade', 'To entertain', 'To complain', 'A'),
(16, 13, 'What can be inferred from the passage?', 'Something changed', 'Nothing happened', 'Everything failed', 'No plan exists', 'A'),
(17, 13, 'Who is mentioned in the passage?', 'A teacher', 'A manager', 'A student', 'A customer', 'C'),
(18, 14, 'What happened first?', 'The meeting started', 'The plan changed', 'The problem appeared', 'The report was written', 'C'),
(19, 14, 'What is the result?', 'Success', 'Failure', 'Delay', 'Cancellation', 'A'),
(20, 15, 'What is the text mainly about?', 'A project', 'A vacation', 'A service', 'A product', 'A'),
(21, 15, 'Why is the service important?', 'It saves time', 'It saves money', 'It saves energy', 'It saves space', 'B'),
(22, 15, 'Who would benefit most?', 'Students', 'Employees', 'Managers', 'Customers', 'D'),
(23, 16, 'What does the writer suggest?', 'Taking action', 'Waiting longer', 'Asking for help', 'Ignoring the issue', 'A'),
(24, 16, 'What is the main concern?', 'Time', 'Cost', 'Quality', 'Safety', 'D'),
(25, 17, 'What is the passage mainly about?', 'Health habits', 'Work habits', 'Study habits', 'Daily routines', 'C'),
(26, 17, 'What advice is given?', 'Practice daily', 'Sleep early', 'Eat healthy', 'Exercise more', 'A'),
(27, 18, 'Why was the rule changed?', 'To improve safety', 'To reduce cost', 'To save time', 'To increase profit', 'A'),
(28, 18, 'Who is affected by the change?', 'Employees', 'Customers', 'Students', 'Visitors', 'B'),
(29, 18, 'When does it take effect?', 'Immediately', 'Next week', 'Next month', 'Next year', 'A'),
(30, 19, 'What is the announcement about?', 'A delay', 'A new rule', 'A warning', 'An event', 'D'),
(31, 19, 'Where will it take place?', 'At school', 'At the office', 'In the city', 'Online', 'C'),
(32, 20, 'What is the topic of the passage?', 'Technology', 'Environment', 'Education', 'Health', 'B'),
(33, 20, 'What problem is mentioned?', 'Pollution', 'Traffic', 'Noise', 'Weather', 'A'),
(34, 21, 'What does the author believe?', 'Change is necessary', 'Nothing will change', 'Everything is perfect', 'The plan will fail', 'A'),
(35, 21, 'What supports this idea?', 'Facts', 'Examples', 'Opinions', 'Statistics', 'B'),
(36, 21, 'Who disagrees?', 'Experts', 'The public', 'No one', 'The author', 'C'),
(37, 22, 'What is the main purpose?', 'To explain', 'To advertise', 'To warn', 'To entertain', 'A'),
(38, 22, 'What is recommended?', 'Follow instructions', 'Ignore advice', 'Ask questions', 'Wait patiently', 'A'),
(39, 23, 'What does the passage describe?', 'A process', 'A story', 'A rule', 'A problem', 'A'),
(40, 23, 'What is the first step?', 'Prepare materials', 'Read carefully', 'Ask for help', 'Start immediately', 'A'),
(41, 24, 'What is the passage mainly about?', 'A journey', 'A plan', 'An experience', 'A lesson', 'C'),
(42, 24, 'What did the writer learn?', 'To be patient', 'To work harder', 'To trust others', 'To manage time', 'D');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `test_result`
--

DROP TABLE IF EXISTS `test_result`;
CREATE TABLE IF NOT EXISTS `test_result` (
  `result_test_Id` bigint NOT NULL AUTO_INCREMENT,
  `final_test_Id` bigint DEFAULT NULL,
  `user_Id` bigint DEFAULT NULL,
  `score` decimal(38,2) DEFAULT NULL,
  `completed_at` datetime DEFAULT NULL,
  PRIMARY KEY (`result_test_Id`),
  KEY `user_Id` (`user_Id`),
  KEY `final_test_Id` (`final_test_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `test_result`
--

INSERT INTO `test_result` (`result_test_Id`, `final_test_Id`, `user_Id`, `score`, `completed_at`) VALUES
(11, 20, 20, 14.00, '2026-01-18 19:22:29');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `url_vnpay`
--

DROP TABLE IF EXISTS `url_vnpay`;
CREATE TABLE IF NOT EXISTS `url_vnpay` (
  `url_Id` bigint NOT NULL AUTO_INCREMENT,
  `url` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  PRIMARY KEY (`url_Id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `url_vnpay`
--

INSERT INTO `url_vnpay` (`url_Id`, `url`) VALUES
(11, 'http://localhost:8080/payment/vnpay-return?vnp_Amount=100000000&vnp_BankCode=NCB&vnp_BankTranNo=VNP15401289&vnp_CardType=ATM&vnp_OrderInfo=Thanh+to%C3%A1n+kh%C3%B3a+h%E1%BB%8Dc+20%2C23%3A+Thanh+to%C3%A1n+kh%C3%B3a+h%E1%BB%8Dc&vnp_PayDate=20260119022013&vnp_ResponseCode=00&vnp_TmnCode=7ZPJ8G62&vnp_TransactionNo=15401289&vnp_TransactionStatus=00&vnp_TxnRef=48&vnp_SecureHash=719bebba16f42a9d913d44cbc33081dfb9791e363994a42c56d5696c27e4e7866604128398ea0bf57fbd9874809553ff858bf7d29a4e70e36fb73646f23d39a6');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_Id` bigint NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `refresh_token` varchar(255) DEFAULT NULL,
  `provider` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`user_Id`, `full_name`, `email`, `birthday`, `phone_number`, `password`, `refresh_token`, `provider`, `role`, `created_at`) VALUES
(19, 'admin1', 'admin@gmail.com', '', '123456789', 'admin1', NULL, 'local', 'admin', '2026-01-18 14:37:37'),
(20, 'Vy Luong', 'luongtrieuvy1103@gmail.com', ' ', NULL, 'GOOGLE_USER', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsdW9uZ3RyaWV1dnkxMTAzQGdtYWlsLmNvbSIsImlhdCI6MTc2ODc2Mzk2NCwiZXhwIjoxNzY5MzY4NzY0fQ.XFMDdh8GLvZMBX1gKA3GwsKwnVY0Y78-QQ6Q-MM0Q8w', 'google', 'user', '2026-01-18 19:19:25');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_course`
--

DROP TABLE IF EXISTS `user_course`;
CREATE TABLE IF NOT EXISTS `user_course` (
  `user_course_Id` bigint NOT NULL AUTO_INCREMENT,
  `course_Id` bigint DEFAULT NULL,
  `user_Id` bigint DEFAULT NULL,
  `enrolled_at` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_course_Id`),
  KEY `user_Id` (`user_Id`),
  KEY `course_Id` (`course_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `user_course`
--

INSERT INTO `user_course` (`user_course_Id`, `course_Id`, `user_Id`, `enrolled_at`, `status`) VALUES
(32, 20, 20, '2026-01-18 19:20:22', 'active'),
(33, 23, 20, '2026-01-18 19:20:22', 'active');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_vocabulary`
--

DROP TABLE IF EXISTS `user_vocabulary`;
CREATE TABLE IF NOT EXISTS `user_vocabulary` (
  `save_Id` bigint NOT NULL AUTO_INCREMENT,
  `user_Id` bigint DEFAULT NULL,
  `vocabulary_Id` bigint DEFAULT NULL,
  `saved_at` datetime DEFAULT NULL,
  PRIMARY KEY (`save_Id`),
  KEY `user_Id` (`user_Id`),
  KEY `vocabulary_Id` (`vocabulary_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Đang đổ dữ liệu cho bảng `user_vocabulary`
--

INSERT INTO `user_vocabulary` (`save_Id`, `user_Id`, `vocabulary_Id`, `saved_at`) VALUES
(21, 20, 36, '2026-01-18 12:20:35');

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `final_test`
--
ALTER TABLE `final_test`
  ADD CONSTRAINT `fk_final_test__course` FOREIGN KEY (`course_Id`) REFERENCES `course` (`course_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `final_test_question`
--
ALTER TABLE `final_test_question`
  ADD CONSTRAINT `fk_final_test_question__final_test` FOREIGN KEY (`final_test_Id`) REFERENCES `final_test` (`final_test_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `lesson`
--
ALTER TABLE `lesson`
  ADD CONSTRAINT `fk_lesson__course` FOREIGN KEY (`course_Id`) REFERENCES `course` (`course_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `lesson_grammar`
--
ALTER TABLE `lesson_grammar`
  ADD CONSTRAINT `fk_lesson_grammar__lesson` FOREIGN KEY (`lesson_Id`) REFERENCES `lesson` (`lesson_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `lesson_listening`
--
ALTER TABLE `lesson_listening`
  ADD CONSTRAINT `fk_lesson_listening__lesson` FOREIGN KEY (`lesson_Id`) REFERENCES `lesson` (`lesson_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `lesson_reading`
--
ALTER TABLE `lesson_reading`
  ADD CONSTRAINT `fk_lesson_reading__lesson` FOREIGN KEY (`lesson_Id`) REFERENCES `lesson` (`lesson_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `lesson_vocabulary`
--
ALTER TABLE `lesson_vocabulary`
  ADD CONSTRAINT `fk_lesson_vocabulary__lesson` FOREIGN KEY (`lesson_Id`) REFERENCES `lesson` (`lesson_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `listening_question`
--
ALTER TABLE `listening_question`
  ADD CONSTRAINT `fk_listening_question__listening` FOREIGN KEY (`listening_Id`) REFERENCES `lesson_listening` (`listening_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `fk_payment__user` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `payment_course`
--
ALTER TABLE `payment_course`
  ADD CONSTRAINT `fk_payment_course__course` FOREIGN KEY (`course_Id`) REFERENCES `course` (`course_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_payment_course__payment` FOREIGN KEY (`payment_Id`) REFERENCES `payment` (`payment_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `progress`
--
ALTER TABLE `progress`
  ADD CONSTRAINT `fk_progress__lesson` FOREIGN KEY (`lesson_Id`) REFERENCES `lesson` (`lesson_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_progress__user_course` FOREIGN KEY (`user_course_Id`) REFERENCES `user_course` (`user_course_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `reading_question`
--
ALTER TABLE `reading_question`
  ADD CONSTRAINT `fk_reading_question__reading` FOREIGN KEY (`reading_Id`) REFERENCES `lesson_reading` (`reading_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `test_result`
--
ALTER TABLE `test_result`
  ADD CONSTRAINT `fk_test_result__final_test` FOREIGN KEY (`final_test_Id`) REFERENCES `final_test` (`final_test_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_test_result__user` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `user_course`
--
ALTER TABLE `user_course`
  ADD CONSTRAINT `fk_user_course__course` FOREIGN KEY (`course_Id`) REFERENCES `course` (`course_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user_course__user` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `user_vocabulary`
--
ALTER TABLE `user_vocabulary`
  ADD CONSTRAINT `fk_user_vocabulary__user` FOREIGN KEY (`user_Id`) REFERENCES `user` (`user_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user_vocabulary__vocabulary` FOREIGN KEY (`vocabulary_Id`) REFERENCES `lesson_vocabulary` (`vocabulary_Id`) ON DELETE RESTRICT ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
