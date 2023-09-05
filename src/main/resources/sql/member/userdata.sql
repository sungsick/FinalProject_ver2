INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `user_phone`, `user_gender`, `user_date`, `user_mbti`, `user_img`, `user_regdate`)
VALUES
    ('john_doe', 'JohnDoe', 'password123', '01012345678', 'M', '1998-08-21', 'ENTJ', 'default1.png', '2023-08-21 12:34:56'),
    ('jane_smith', 'JaneSmith', 'pass4321', '01098765432', 'F', '2000-08-21', 'INFP', 'default2.png', '2023-08-22 09:15:30'),
    ('alex_brown', 'AlexBrown', 'securepwd', '01055555555', 'M', '1960-08-21', 'INTJ', 'default1.png', '2023-08-23 18:27:45'),
    ('test', 'yeong', '1234', '01012345678', 'M', '2023-08-21', 'INTJ', 'default1.png', '2023-08-24 14:22:10'),
    ('sample@example.com', '샘플', '1234', '01055555555', 'M', '1970-08-21', 'INTJ', 'default1.png', '2023-08-25 20:45:00'),
    ('user1', 'UserOne', 'userpass1', '01011111111', 'F', '1967-08-21', 'ISFJ', 'default2.png', '2023-08-26 07:30:20'),
    ('user2', 'UserTwo', 'userpass2', '01022222222', 'M', '1978-08-21', 'ESTP', 'default1.png', '2023-08-26 16:15:55'),
    ('user3', 'UserThree', 'userpass3', '01033333333', 'F', '1956-08-21', 'ENFP', 'default2.png', '2023-08-26 22:10:45'),
    ('user4', 'UserFour', 'userpass4', '01044444444', 'M', '1999-08-21', 'ISTJ', 'default1.png', '2023-08-29 11:05:30'),
    ('user5', 'UserFive', 'userpass5', '01055555555', 'F', '2023-08-21', 'ESFP', 'default2.png', '2023-08-30 19:20:15'),
    ('user6', 'UserSix', 'userpass6', '01066666666', 'M', '2023-08-21', 'INTJ', 'default1.png', '2023-08-31 12:00:00'),
    ('user7', 'UserSeven', 'userpass7', '01077777777', 'F', '2023-08-21', 'ESFP', 'default2.png', NOW()),
    ('user8', 'UserEight', 'userpass8', '01088888888', 'M', '2023-08-21', 'INTJ', 'default1.png', NOW()),
    ('user9', 'UserNine', 'userpass9', '01099999999', 'F', '2023-08-21', 'ISFP', 'default2.png', NOW());

INSERT INTO `manager` (`manager_id`, `manager_password`)
VALUES ('admin', 'admin');

INSERT INTO `area_tourism` (`area_name`, `place_id`, `place_name`)
VALUES
    ('seoul', 126508, '경복궁'),
    ('seoul', 127220, '북한산'),
    ('seoul', 132183, '광장시장'),
    ('seoul', 781031, '홍대거리'),
    ('seoul', 126535, 'N서울타워'),
    ('seoul', 126537, '북촌한옥마을'),
    ('seoul', 129507, '청계천'),
    ('seoul', 129703, '국립중앙박물관'),
    ('jeju', 1911160, '헬로키티아일랜드'),
    ('jeju', 2048059, '아쿠아플라넷'),
    ('jeju', 228854, '용머리해안'),
    ('jeju', 126437, '정방폭포'),
    ('jeju', 1918639, '월정리해변'),
    ('jeju', 2660802, '오설록티뮤지엄'),
    ('jeju', 741109, '카멜리아힐'),
    ('jeju', 1146121, '에코랜드테마파크'),
    ('busan', 1997221, '감천문화마을'),
    ('busan', 126848, '해동용궁사'),
    ('busan', 1277679, '부산타워'),
    ('busan', 132190, '자갈치시장'),
    ('busan', 2504464, '송도해상케이블카'),
    ('busan', 127488, 'BIFF광장'),
    ('busan', 126148, '범어사'),
    ('busan', 2684712, '흰여울문화마을'),
    ('yeosu', 128017, '영취산'),
    ('yeosu', 2638438, '예술랜드'),
    ('yeosu', 2994563, '라마다해상짚트랙'),
    ('yeosu', 2736360, '아르떼뮤지엄'),
    ('yeosu', 2778049, '하멜전시관'),
    ('yeosu', 2612869, '이순신광장'),
    ('yeosu', 2037230, '아쿠아플라넷'),
    ('yeosu', 2514658, '고소동벽화마을'),
    ('gangneung', 128758, '경포해수욕장'),
    ('gangneung', 2687981, '경포아쿠아리움'),
    ('gangneung', 125789, '오죽헌'),
    ('gangneung', 2714439, '안반데기'),
    ('gangneung', 125417, '대관령자연휴양림'),
    ('gangneung', 132771, '강릉중앙시장'),
    ('gangneung', 2903111, '스카이베이호텔'),
    ('gangneung', 130123, '에디슨과학박물관'),
    ('gyeongju', 127855, '양동마을'),
    ('gyeongju', 128526, '동궁과 월지'),
    ('gyeongju', 126166, '불국사'),
    ('gyeongju', 127484, '경주국립공원'),
    ('gyeongju', 126218, '문무대왕릉'),
    ('gyeongju', 1492402, '대릉원'),
    ('gyeongju', 126207, '첨성대'),
    ('gyeongju', 126216, '석굴암');



INSERT INTO `qna` (`qna_writer`,  `qna_title`, `qna_content`, `qna_answer`, `qna_date`)
VALUES
    ('john_doe','제목1', '내용은 이것입니다1.', '답변은 아직입니다1.', now()),
    ('seokjin','제목2', '내용은 이것입니다2.',  '답변은 아직입니다2.', now()),
    ('john_doe','제목3', '내용은 이것입니다3.',  '답변은 아직입니다3.', now()),
    ('seokjin','제목4', '내용은 이것입니다4.', '답변은 아직입니다4.', now()),
    ('john_doe','제목5', '내용은 이것입니다5.', '답변은 아직입니다5.', now()),
    ('test','제목6', '내용은 이것입니다6.',  '저도 몰라요', now()),
    ('test','제목7', '내용은 이것입니다7.', '저도 몰라요', now());
select * from qna;


INSERT INTO `ticket_info` (`tic_airline_logo`,`tic_flight_departure_date`,`tic_flight_arrival_date`, `tic_seat_grade`,`tic_airline_name`, `tic_fee`,`tic_from_location`, `tic_to_location`,`tic_vihicle_id`,`user_number`)
VALUES
    ('eastar.jpg','202310230030', '202310220930','이코노미','이스타항공','580,000','인천','제주','ABC1004',4),
    ('jinair.jpg','202310230130', '202310221130','이코노미','이스타항공','590,000','김포','제주','ABD1005',4),
    ('eastar.jpg','202310230230', '202310221230','이코노미','이스타항공','520,000','인천','제주','ABE1006',2),
    ('eastar.jpg','202310230330', '202310221330','이코노미','이스타항공','530,000','인천','제주','ABF1007',2),
    ('eastar.jpg','202310230430', '202310221430','이코노미','이스타항공','540,000','인천','제주','ABG1008',3),
    ('eastar.jpg','202310230530', '202310221530','이코노미','이스타항공','550,000','인천','제주','ABH1009',3);

INSERT INTO `rent_info` (`rent_oil`,`rent_accommodate`,`rent_year`,`rent_type`,`rent_name`,`rent_company`,`rent_option`, `rent_price`,`rent_departure_date`, `rent_arrival_date`,`rent_img`, `user_number`)
VALUES
    ('휘발유',5,'2015','중형','쏘나타','KH렌터카', '여러개있음','69000','2023-08-22','2023-08-20','sonata.png',4),
    ('경유',9,'2015','대형','카니발','KH렌터카', '여러개있음','99000','2023-08-24','2023-08-19','carnival.png',4),
    ('경유',4,'2015','소형','ray','KH렌터카', '하나도없음','89000','2023-08-27','2023-08-25','ray.jpg',2),
    ('휘발유',5,'2015','중형','sonata','KH렌터카', '여러개있음','49000','2023-08-25','2023-08-23','sonata.jpg',2),
    ('경유',4,'2015','소형','casper','KH렌터카', '하나도없음','59000','2023-08-26','2023-08-24','casper.jpg',3),
    ('휘발유',4,'2015','소형','casper','KH렌터카', '여러개있음','69000','2023-08-25','2023-08-24','casper.jpg',3);
