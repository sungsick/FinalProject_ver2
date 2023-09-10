INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `user_phone`, `user_gender`, `user_date`, `user_mbti`, `user_img`, `user_regdate`)
VALUES
    ('test', '테스트계정', '1234', '01012345678', 'M', '1998-08-21', 'ENTJ', 'default1.png', '2023-08-21 12:34:56'),
    ('john_doe@example.com', 'JohnDoe', 'password123', '01012345678', 'M', '1998-08-21', 'ENTJ', 'default1.png', '2023-08-21 12:34:56'),
    ('jane_smith@example.com', 'JaneSmith', 'pass4321', '01098765432', 'F', '2000-08-21', 'INFP', 'default2.png', '2023-08-22 09:15:30'),
    ('alex_brown@example.com', 'AlexBrown', 'securepwd', '01055555555', 'M', '1960-08-21', 'INTJ', 'default1.png', '2023-08-23 18:27:45'),
    ('sample@example.com', '샘플', '1234', '01055555555', 'M', '1970-08-21', 'INTJ', 'default1.png', '2023-08-25 20:45:00'),
    ('user1@example.com', 'UserOne', 'userpass1', '01011111111', 'F', '1967-08-21', 'ISFJ', 'default2.png', '2023-08-26 07:30:20'),
    ('user2@example.com', 'UserTwo', 'userpass2', '01022222222', 'M', '1978-08-21', 'ESTP', 'default1.png', '2023-08-26 16:15:55'),
    ('user3@example.com', 'UserThree', 'userpass3', '01033333333', 'F', '1956-08-21', 'ENFP', 'default2.png', '2023-08-26 22:10:45'),
    ('user4@example.com', 'UserFour', 'userpass4', '01044444444', 'M', '1999-08-21', 'ISTJ', 'default1.png', '2023-08-29 11:05:30'),
    ('user5@example.com', 'UserFive', 'userpass5', '01055555555', 'F', '2023-08-21', 'ESFP', 'default2.png', '2023-08-30 19:20:15'),
    ('user6@example.com', 'UserSix', 'userpass6', '01066666666', 'M', '2023-08-21', 'INTJ', 'default1.png', '2023-08-31 12:00:00'),
    ('user7@example.com', 'UserSeven', 'userpass7', '01077777777', 'F', '2023-08-21', 'ESFP', 'default2.png', NOW()),
    ('user8@example.com', 'UserEight', 'userpass8', '01088888888', 'M', '2023-08-21', 'INTJ', 'default1.png', NOW()),
    ('user9@example.com', 'UserNine', 'userpass9', '01099999999', 'F', '2023-08-21', 'ISFP', 'default2.png', NOW());

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

INSERT INTO accompany (user_number, ac_regdate, ac_title, ac_text, ac_people, ac_region, ac_startdate, ac_enddate,
                       ac_status, ac_picture, ac_viewcount, ac_travelstyle, ac_personalhash)
VALUES (1, '2023-09-03', '가을 나들이 동행자 찾아요', '가을에 함께 나들이를 가실 분을 찾습니다. 어느 지역이든 좋아요.', 2, '서울', '2023-10-15', '2023-10-30',
        '', 'acc1.png', 0, '', ''),
       (2, '2023-09-04', '경주 여행 가고 싶어요', '경주로 여행을 계획 중이에요. 함께 가실 분 찾아요.', 1, '경주', '2023-11-05', '2023-11-15', '', 'acc2.jpeg',
        0, '', ''),
       (3, '2023-09-06', '소박한 마을 여행 동행자 구합니다', '한국의 소박한 마을을 여행하려고 합니다. 함께 가실 분 찾아요.', 2, '전라북도', '2023-10-10',
        '2023-10-25', '', 'acc3.jpeg', '0', '', ''),
       (1, '2023-09-07', '가을 바다 여행 동행 찾아요', '가을에 바다 여행을 함께 하실 분을 찾습니다. 동해, 부산 등 어디든 좋아요.', 3, '강원도', '2023-11-01',
        '2023-11-20', '', 'acc4.jpg', '0', '', ''),
       (5, '2023-09-08', '역사 여행 친구 찾아요', '한국의 역사적인 장소를 여행하려고 합니다. 함께 가실 분 찾아요.', 2, '경상도', '2023-10-25', '2023-11-05',
        '', 'acc5.jpeg', '0', '', ''),
       (1, '2023-09-09', '산림욕 여행 동행 구합니다', '한국의 아름다운 산림욕을 함께 즐길 동행을 찾습니다.', 1, '강원도', '2023-11-10', '2023-11-25', '',
        'acc6.jpg', '0', '', ''),
       (5, '2023-09-10', '한국 전통 마을 여행 동행자 찾아요', '한국의 전통 마을을 여행하려고 합니다. 함께 가실 분 찾아요.', 1, '경기도', '2023-10-15',
        '2023-10-30', '', 'acc7.jpg', '0', '', ''),
       (4, '2023-09-11', '제주 자연 속 모험 여행 동행', '한국 자연 속 모험 여행을 함께 할 동행을 찾아요.', 2, '제주도', '2023-11-05', '2023-11-15', '',
        'acc8.jpg', '0', '', ''),
       (3, '2023-09-12', '제주도 오션뷰 여행 친구 찾아요', '한국의 아름다운 오션뷰를 감상하려고 합니다. 함께 갈 분 찾아요.', 1, '제주도', '2023-10-10',
        '2023-10-25', '', 'acc9.jpg', '0', '', ''),
       (2, '2023-09-13', '충청도 고즈넉한 여행 파트너', '한국의 고즈넉한 여행지를 방문하려고 합니다. 함께 가실 분 찾아요.', 2, '충청도', '2023-10-20',
        '2023-11-10', '', 'acc10.jpg', '0', '', ''),
       (1, '2023-09-14', '산책 동행', '충청도의 아름다운 산책 함께 할 동행을 찾습니다.', 1, '충청도', '2023-11-01', '2023-11-20', '', 'acc11.jpg', '0', '',
        ''),
       (2, '2023-09-15', '가을 풍경 감상', '서울의 가을 풍경을 감상하려고 합니다. 함께 갈 분 찾습니다.', 2, '서울', '2023-11-10', '2023-11-25', '', 'acc12.jpeg',
        '0', '', ''),
       (3, '2023-09-16', '부산 바다 여행', '부산의 멋진 바다를 즐기고 싶어요. 함께 바다 여행하실 분 찾아요.', 3, '부산', '2023-11-20', '2023-12-05', '',
        'acc13.jpeg', '0', '', ''),
       (4, '2023-09-17', '대구 역사 탐방', '대구의 역사적인 장소를 탐방하려고 합니다. 함께 탐방하실 분 구합니다.', 4, '대구', '2023-11-25', '2023-12-10', '',
        'acc14.webp', '0', '', ''),
       (5, '2023-09-18', '전주 음식 여행', '전주의 다양한 음식을 즐기려고 합니다. 함께 음식 여행하실 분 찾아요.', 5, '전주', '2023-12-01', '2023-12-15', '',
        'acc15.jpg', '0', '', ''),
       (5, '2023-09-19', '대전 문화 탐방', '대전의 문화적인 장소를 탐방하려고 합니다. 함께 문화 여행하실 분 찾습니다.', 6, '대전', '2023-12-05', '2023-12-20',
        '', 'acc16.jpg', '0', '', ''),
       (4, '2023-09-20', '인천 해변 휴식', '인천의 해변을 휴식하며 즐기고 싶습니다. 함께 휴식하실 분 모집합니다.', 7, '인천', '2023-12-10', '2023-12-25', '',
        'acc17.jpg', '0', '', ''),
       (3, '2023-09-21', '울산 해양 모험', '울산의 해양 모험을 즐기고 싶어요. 함께 해양 모험하실 분 구합니다.', 8, '울산', '2023-12-15', '2023-12-30', '',
        'acc18.jpg', '0', '', ''),
       (2, '2023-09-22', '세종 자연 탐험', '세종의 자연을 탐험하려고 합니다. 함께 자연 탐험하실 분 찾아요.', 9, '세종', '2023-12-20', '2024-01-05', '',
        'acc19.jpg', '0', '', ''),
       (1, '2023-09-23', '강원도 여행', '강원도의 아름다운 자연을 즐기려고 합니다. 함께 여행하실 분 찾습니다.', 10, '강원도', '2023-12-25', '2024-01-10',
        '', 'acc20.jpg', '0', '', ''),
       (5, '2023-09-24', '경기도 가을 풍경', '경기도의 가을 풍경을 감상하려고 합니다. 함께 가실 분 찾아요.', 11, '경기도', '2024-01-01', '2024-01-15', '',
        'acc21.jpg', '0', '', ''),
       (4, '2023-09-25', '전라북도 예술 여행', '전라북도에서 예술을 즐기고 싶어요. 함께 예술 여행하실 분 찾습니다.', 12, '전라북도', '2024-01-05',
        '2024-01-20', '', 'acc22.jpg', '0', '', ''),
       (3, '2023-09-26', '전라남도 해변 휴식', '전라남도의 아름다운 해변에서 휴식하려고 합니다. 함께 휴식하실 분 찾아요.', 13, '전라남도', '2024-01-10',
        '2024-01-25', '', 'acc23.jpg', '0', '', ''),
       (1, '2023-09-28', '경상남도 해양 모험', '경상남도의 해양 모험을 즐기고 싶어요. 함께 해양 모험하실 분 구합니다.', 15, '경상남도', '2024-01-20',
        '2024-02-05', '', 'acc24.jpg', '0', '', '');

INSERT INTO `ticket_info` (`tic_airline_logo`,`tic_flight_departure_date`,`tic_flight_arrival_date`, `tic_seat_grade`,`tic_airline_name`, `tic_fee`,`tic_from_location`, `tic_to_location`,`tic_vihicle_id`,`user_number`)
VALUES
    ('eastar.jpg','202310230030', '202310220930','이코노미','이스타항공','580,000','인천','제주','ABC1004',1),
    ('jinair.jpg','202310230130', '202310221130','이코노미','이스타항공','590,000','김포','제주','ABD1005',1),
    ('eastar.jpg','202310230230', '202310221230','이코노미','이스타항공','520,000','인천','제주','ABE1006',2),
    ('eastar.jpg','202310230330', '202310221330','이코노미','이스타항공','530,000','인천','제주','ABF1007',2),
    ('eastar.jpg','202310230430', '202310221430','이코노미','이스타항공','540,000','인천','제주','ABG1008',3),
    ('eastar.jpg','202310230530', '202310221530','이코노미','이스타항공','550,000','인천','제주','ABH1009',3);

INSERT INTO `rent_info` (`rent_oil`,`rent_accommodate`,`rent_year`,`rent_type`,`rent_name`,`rent_company`,`rent_option`, `rent_price`,`rent_departure_date`, `rent_arrival_date`,`rent_img`, `user_number`)
VALUES
    ('휘발유',5,'2015','중형','쏘나타','KH렌터카', '여러개있음','69000','2023-08-22','2023-08-20','sonata.png',1),
    ('경유',9,'2015','대형','카니발','KH렌터카', '여러개있음','99000','2023-08-24','2023-08-19','carnival.png',1),
    ('경유',4,'2015','소형','ray','KH렌터카', '하나도없음','89000','2023-08-27','2023-08-25','ray.jpg',2),
    ('휘발유',5,'2015','중형','sonata','KH렌터카', '여러개있음','49000','2023-08-25','2023-08-23','sonata.jpg',2),
    ('경유',4,'2015','소형','casper','KH렌터카', '하나도없음','59000','2023-08-26','2023-08-24','casper.jpg',3),
    ('휘발유',4,'2015','소형','casper','KH렌터카', '여러개있음','69000','2023-08-25','2023-08-24','casper.jpg',3);

--
-- INSERT INTO ticket_info (tic_ticket_id, tic_flight_departure_date, tic_flight_arrival_date, tic_seat_grade, tic_airline_name, tic_fee, tic_from_location, tic_to_location, tic_vihicle_id, user_number)
-- VALUES
--     (1, '202309110715', '202309110810', '이코노미', '아시아나항공', '72900', '김포', '여수', 'OZ8733', 4),
--     (2, '202309140845', '202309140945', '이코노미', '대한항공', '119700', '제주', '김해', 'KE1512', 4),
--     (3, '202309120930', '202309121030', '비즈니스', '에어부산', '145200', '서울', '부산', 'BX701', 5),
--     (4, '202309092300', '202309100100', '퍼스트클래스', '아시아나항공', '182000', '인천', '도쿄', 'OZ102', 6),
--     (5, '202309051200', '202309052100', '이코노미', '대한항공', '85000', '서울', '상하이', 'KE888', 7),
--     (6, '202309181500', '202309181700', '비즈니스', '아시아나항공', '98000', '서울', '베이징', 'OZ201', 8),
--     (7, '202309082030', '202309082200', '이코노미', '에어부산', '56000', '부산', '제주', 'BX123', 9),
--     (8, '202309072345', '202309080145', '퍼스트클래스', '대한항공', '212500', '서울', '파리', 'KE456', 10),
--     (9, '202309141030', '202309141145', '이코노미', '아시아나항공', '74000', '제주', '서울', 'OZ456', 11),
--     (10, '202309171815', '202309171930', '비즈니스', '에어부산', '112300', '부산', '서울', 'BX789', 12),
--     (11, '202309091100', '202309091300', '퍼스트클래스', '대한항공', '210000', '서울', '상하이', 'KE999', 13),
--     (12, '202309191545', '202309191745', '이코노미', '아시아나항공', '69000', '서울', '도쿄', 'OZ789', 14);


INSERT INTO chat_room (`user_number1`, `user_number2`)
VALUES
    (1, 2),
    (1, 3),
    (1, 4),
    (2, 3);




INSERT INTO chat_message (`room_id`, `content`, `sender_id`,`send_time`)
VALUES
    (1, '1번방임. 안녕하세요 저는 1번입니다.', 1, '2023-08-01 14:10:41'),
    (1, '저는 2번입니다.', 2, NOW()),
    (2, '2번방의 1번이보낸 메시지', 1, '2023-09-01 14:10:41'),
    (2, '2번방의 3번이 보낸 메시지', 3, NOW()),
    (3, '3번방의 1번이 보낸 메시지', 1, NOW()),
    (3, '3번방의 4번이 보낸 메시지', 4, '2023-09-08 14:10:41'),
    (4, '4번방의 2번이 3번에게 보낸다..', 2, NOW()),
    (4, '4번방의 3번이 2번에게 보낸다.', 3, NOW());
