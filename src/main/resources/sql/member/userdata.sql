<<<<<<< HEAD
INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `user_phone`, `user_gender`, `user_date`, `user_mbti`,
                    `user_img`)
VALUES ('john_doe', 'John Doe', 'password123', '123-456-7890', 'M', '2023-08-21', 'ENTJ', 'default1.png'),
       ('jane_smith', 'Jane Smith', 'pass4321', '987-654-3210', 'F', '2023-08-21', 'INFP', 'default2.png'),
       ('alex_brown', 'Alex Brown', 'securepwd', '555-555-5555', 'M', '2023-08-21', 'INTJ', 'default1.png'),
       ('test', 'yeong', '1234', '555-555-5555', 'M', '2023-08-21', 'INTJ', 'default1.png'),
       ('sample@example.com', '샘플', '1234', '555-555-5555', 'M', '2023-08-21', 'INTJ', 'default1.png');
select *
from user;

INSERT INTO `qna` (`qna_writer`, `qna_title`, `qna_content`, `qna_date`, `qna_answer`)
VALUES ('john_doe', '제목1', '내용은 이것입니다1.', '2023-08-21', '답변은 아직입니다1.'),
       ('seokjin', '제목2', '내용은 이것입니다2.', '2023-08-21', '답변은 아직입니다2.'),
       ('john_doe', '제목3', '내용은 이것입니다3.', '2023-08-21', '답변은 아직입니다3.'),
       ('seokjin', '제목4', '내용은 이것입니다4.', '2023-08-21', '답변은 아직입니다4.'),
       ('john_doe', '제목5', '내용은 이것입니다5.', '2023-08-21', '답변은 아직입니다5.');

select *
from qna;

=======
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
>>>>>>> 0992b31d6998afeab96c372e603668f413fb255a

INSERT INTO `car_info` (`car_name`, `car_year`, `car_nation`, `car_type`, `oil_type`, `driver_age`, `car_people`,
                        `car_price`, `car_discount`, `com_id`, `car_option`, `car_img`)
VALUES ('더 뉴 레이', '2020년 출시', '국내', '경형', '디젤', '21세 이상', 4, 100000, 25000, 1, '옵션없음', 'sample.jpg'),
       ('더 뉴 레이', '2019년 출시', '국내', '경형', '가솔린', '26세 이상', 4, 100000, 25000, 5, '옵션없음', 'sample.jpg'),
       ('카니발', '2017년 출시', '국내', '승합', '디젤', '26세 이상', 7, 200000, 70000, 1, '블랙박스, 내비게이션', 'sample.jpg'),
       ('캐스퍼', '2018년 출시', '국내', '경형', '디젤', '21세 이상', 5, 250000, 78000, 2, '옵션없음', 'sample.jpg'),
       ('더 뉴 스파크', '2021년 출시', '국내', '경형', '경유', '26세 이상', 5, 200000, 70000, 2, '블랙박스, 내비게이션', 'sample.jpg'),
       ('더 뉴 아반떼', '2018년 출시', '국내', '승용', '가솔린', '26세 이상', 5, 200000, 87000, 3,
        '내비게이션, 열선시트, 블랙박스, 선루프, 운전석 에어백, 금연차량', 'sample.jpg'),
       ('쏘나타', '2016년 출시', '국내', '승용', 'LPG', '26세 이상', 5, 180000, 75000, 4, '블랙박스, 내비게이션', 'sample.jpg'),
       ('코나', '2022년 출시', '국내', 'SUV', '가솔린', '21세 이상', 4, 100000, 25000, 5, '옵션없음', 'sample.jpg'),
       ('더 뉴 스타렉스', '2021년 출시', '국내', '승합', '디젤', '26세 이상', 9, 250000, 98000, 6,
        '블랙박스, 내비게이션, 운전석 에어백, 조수석 에어백, 핸들열선, 후방카메라, 후방센서', 'sample.jpg');



INSERT INTO `com_info` (`com_name`, `com_location`, `com_tel`, `com_opentime`)
VALUES ('별빛렌트카', '서울시 강남구 논현로30길', '02-1111-4444', '평일 08:00 - 20:30 주말 08:00 - 20:30 (토) / 08:00 - 20:30 (일)'),
       ('달빛렌트카', '제주특별자치도 제주시 공항로1길', '02-2222-4444', '평일 08:00 - 20:30 주말 08:00 - 20:30 (토) / 08:00 - 20:30 (일)'),
       ('신화렌트카', '강원 강릉시 율곡로 2600', '02-3333-4444', '평일 08:00 - 20:30 주말 08:00 - 20:30 (토) / 08:00 - 20:30 (일)'),
       ('착한렌트카', '부산 동구 중앙대로 206', '02-4444-4444', '평일 08:00 - 20:30 주말 08:00 - 20:30 (토) / 08:00 - 20:30 (일)'),
       ('저렴한렌트카', '전남 여수시 율촌면 여순로 386', '02-5555-4444', '평일 08:00 - 20:30 주말 08:00 - 20:30 (토) / 08:00 - 20:30 (일)'),
       ('우리렌트카', '경북 경주시 건천읍 내외로 2871-40', '02-6666-4444', '평일 08:00 - 20:30 주말 08:00 - 20:30 (토) / 08:00 - 20:30 (일)');