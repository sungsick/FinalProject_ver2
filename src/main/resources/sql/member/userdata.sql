INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `user_phone`, `user_gender`, `user_date`, `user_mbti`, `user_img`)
VALUES
    ('john_doe', 'John Doe', 'password123', '01012345678', 'M', '2023-08-21', 'ENTJ', 'default1.png'),
    ('jane_smith', 'Jane Smith', 'pass4321', '01098765432', 'F', '2023-08-21', 'INFP', 'default2.png'),
    ('alex_brown', 'Alex Brown', 'securepwd', '01055555555', 'M', '2023-08-21', 'INTJ', 'default1.png'),
    ('test', 'yeong', '1234', '01012345678', 'M', '2023-08-21', 'INTJ', 'default1.png'),
    ('sample@example.com', '샘플', '1234', '01055555555', 'M', '2023-08-21', 'INTJ', 'default1.png'),
    ('user1', 'User One', 'userpass1', '01011111111', 'F', '2023-08-21', 'ISFJ', 'default2.png'),
    ('user2', 'User Two', 'userpass2', '01022222222', 'M', '2023-08-21', 'ESTP', 'default1.png'),
    ('user3', 'User Three', 'userpass3', '01033333333', 'F', '2023-08-21', 'ENFP', 'default2.png'),
    ('user4', 'User Four', 'userpass4', '01044444444', 'M', '2023-08-21', 'ISTJ', 'default1.png'),
    ('user5', 'User Five', 'userpass5', '01055555555', 'F', '2023-08-21', 'ESFP', 'default2.png');

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



