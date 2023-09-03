--
-- 페이지네이션 하기 위한 db

INSERT INTO accompany (user_number, ac_regdate, ac_title, ac_text, ac_people, ac_region, ac_startdate, ac_enddate,
                       ac_status, ac_picture, ac_viewcount, ac_travelstyle, ac_personalhash)
VALUES (1, '2023-09-03', '가을 나들이 동행자 찾아요', '가을에 함께 나들이를 가실 분을 찾습니다. 어느 지역이든 좋아요.', 2, '서울', '2023-10-15', '2023-10-30',
        '', '', 0, '', ''),
       (2, '2023-09-04', '경주 여행 가고 싶어요', '경주로 여행을 계획 중이에요. 함께 가실 분 찾아요.', 1, '경주', '2023-11-05', '2023-11-15', '', '',
        0, '', ''),
       (3, '2023-09-06', '소박한 마을 여행 동행자 구합니다', '한국의 소박한 마을을 여행하려고 합니다. 함께 가실 분 찾아요.', 2, '전라북도', '2023-10-10',
        '2023-10-25', '', '', '0', '', ''),
       (1, '2023-09-07', '가을 바다 여행 동행 찾아요', '가을에 바다 여행을 함께 하실 분을 찾습니다. 동해, 부산 등 어디든 좋아요.', 3, '강원도', '2023-11-01',
        '2023-11-20', '', '', '0', '', ''),
       (5, '2023-09-08', '역사 여행 친구 찾아요', '한국의 역사적인 장소를 여행하려고 합니다. 함께 가실 분 찾아요.', 2, '경상도', '2023-10-25', '2023-11-05',
        '', '', '0', '', ''),
       (1, '2023-09-09', '산림욕 여행 동행 구합니다', '한국의 아름다운 산림욕을 함께 즐길 동행을 찾습니다.', 1, '강원도', '2023-11-10', '2023-11-25', '',
        '', '0', '', ''),
       (5, '2023-09-10', '한국 전통 마을 여행 동행자 찾아요', '한국의 전통 마을을 여행하려고 합니다. 함께 가실 분 찾아요.', 1, '경기도', '2023-10-15',
        '2023-10-30', '', '', '0', '', ''),
       (4, '2023-09-11', '제주 자연 속 모험 여행 동행', '한국 자연 속 모험 여행을 함께 할 동행을 찾아요.', 2, '제주도', '2023-11-05', '2023-11-15', '',
        '', '0', '', ''),
       (3, '2023-09-12', '제주도 오션뷰 여행 친구 찾아요', '한국의 아름다운 오션뷰를 감상하려고 합니다. 함께 갈 분 찾아요.', 1, '제주도', '2023-10-10',
        '2023-10-25', '', '', '0', '', ''),
       (2, '2023-09-13', '충청도 고즈넉한 여행 파트너', '한국의 고즈넉한 여행지를 방문하려고 합니다. 함께 가실 분 찾아요.', 2, '충청도', '2023-10-20',
        '2023-11-10', '', '', '0', '', ''),
       (1, '2023-09-14', '산책 동행', '충청도의 아름다운 산책 함께 할 동행을 찾습니다.', 1, '충청도', '2023-11-01', '2023-11-20', '', '', '0', '',
        ''),
       (2, '2023-09-15', '가을 풍경 감상', '서울의 가을 풍경을 감상하려고 합니다. 함께 갈 분 찾습니다.', 2, '서울', '2023-11-10', '2023-11-25', '', '',
        '0', '', ''),
       (3, '2023-09-16', '부산 바다 여행', '부산의 멋진 바다를 즐기고 싶어요. 함께 바다 여행하실 분 찾아요.', 3, '부산', '2023-11-20', '2023-12-05', '',
        '', '0', '', ''),
       (4, '2023-09-17', '대구 역사 탐방', '대구의 역사적인 장소를 탐방하려고 합니다. 함께 탐방하실 분 구합니다.', 4, '대구', '2023-11-25', '2023-12-10', '',
        '', '0', '', ''),
       (5, '2023-09-18', '전주 음식 여행', '전주의 다양한 음식을 즐기려고 합니다. 함께 음식 여행하실 분 찾아요.', 5, '전주', '2023-12-01', '2023-12-15', '',
        '', '0', '', ''),
       (5, '2023-09-19', '대전 문화 탐방', '대전의 문화적인 장소를 탐방하려고 합니다. 함께 문화 여행하실 분 찾습니다.', 6, '대전', '2023-12-05', '2023-12-20',
        '', '', '0', '', ''),
       (4, '2023-09-20', '인천 해변 휴식', '인천의 해변을 휴식하며 즐기고 싶습니다. 함께 휴식하실 분 모집합니다.', 7, '인천', '2023-12-10', '2023-12-25', '',
        '', '0', '', ''),
       (3, '2023-09-21', '울산 해양 모험', '울산의 해양 모험을 즐기고 싶어요. 함께 해양 모험하실 분 구합니다.', 8, '울산', '2023-12-15', '2023-12-30', '',
        '', '0', '', ''),
       (2, '2023-09-22', '세종 자연 탐험', '세종의 자연을 탐험하려고 합니다. 함께 자연 탐험하실 분 찾아요.', 9, '세종', '2023-12-20', '2024-01-05', '',
        '', '0', '', ''),
       (1, '2023-09-23', '강원도 여행', '강원도의 아름다운 자연을 즐기려고 합니다. 함께 여행하실 분 찾습니다.', 10, '강원도', '2023-12-25', '2024-01-10',
        '', '', '0', '', ''),
       (5, '2023-09-24', '경기도 가을 풍경', '경기도의 가을 풍경을 감상하려고 합니다. 함께 가실 분 찾아요.', 11, '경기도', '2024-01-01', '2024-01-15', '',
        '', '0', '', ''),
       (4, '2023-09-25', '전라북도 예술 여행', '전라북도에서 예술을 즐기고 싶어요. 함께 예술 여행하실 분 찾습니다.', 12, '전라북도', '2024-01-05',
        '2024-01-20', '', '', '0', '', ''),
       (3, '2023-09-26', '전라남도 해변 휴식', '전라남도의 아름다운 해변에서 휴식하려고 합니다. 함께 휴식하실 분 찾아요.', 13, '전라남도', '2024-01-10',
        '2024-01-25', '', '', '0', '', ''),
       (1, '2023-09-28', '경상남도 해양 모험', '경상남도의 해양 모험을 즐기고 싶어요. 함께 해양 모험하실 분 구합니다.', 15, '경상남도', '2024-01-20',
        '2024-02-05', '', '', '0', '', ''),

-- INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `user_phone`, `user_gender`, `user_date`, `user_mbti`, `user_img`)
-- VALUES
--     ('john_doe', 'John Doe', 'password123', '01012345678', 'M', '2023-08-21', 'ENTJ', 'default1.png'),
--     ('jane_smith', 'Jane Smith', 'pass4321', '01098765432', 'F', '2023-08-21', 'INFP', 'default2.png'),
--     ('alex_brown', 'Alex Brown', 'securepwd', '01055555555', 'M', '2023-08-21', 'INTJ', 'default1.png'),
--     ('test', 'yeong', '1234', '01012345678', 'M', '2023-08-21', 'INTJ', 'default1.png'),
--     ('sample@example.com', '샘플', '1234', '01055555555', 'M', '2023-08-21', 'INTJ', 'default1.png'),
--     ('user1', 'User One', 'userpass1', '01011111111', 'F', '2023-08-21', 'ISFJ', 'default2.png'),
--     ('user2', 'User Two', 'userpass2', '01022222222', 'M', '2023-08-21', 'ESTP', 'default1.png'),
--     ('user3', 'User Three', 'userpass3', '01033333333', 'F', '2023-08-21', 'ENFP', 'default2.png'),
--     ('user4', 'User Four', 'userpass4', '01044444444', 'M', '2023-08-21', 'ISTJ', 'default1.png'),
--     ('user5', 'User Five', 'userpass5', '01055555555', 'F', '2023-08-21', 'ESFP', 'default2.png');
--
--
--


-- article 더미데이터
-- INSERT INTO accompany (user_number, ac_regdate, ac_title, ac_text, ac_people, ac_region, ac_startdate, ac_enddate,
--                        ac_status, ac_picture, ac_viewcount, ac_travelstyle, ac_personalhash)
-- VALUES (1, '2023-08-31', 'Sample Title', 'Sample Text', '2', 'Sample Region', '2023-09-01', '2023-09-10', 'Open',
--         'sample.jpg', '100', 'Adventure', '#travel');
-- INSERT INTO accompany (user_number, ac_regdate, ac_title, ac_text, ac_people, ac_region, ac_startdate, ac_enddate,
--                        ac_status, ac_picture, ac_viewcount, ac_travelstyle, ac_personalhash)
-- VALUES (2, '2023-08-31', 'Sample Title 2', 'Sample Text 2', '3', 'Sample Region 2', '2023-09-02', '2023-09-11', 'Open',
--         'sample2.jpg', '150', 'Relaxation', '#vacation');
-- INSERT INTO accompany (user_number, ac_regdate, ac_title, ac_text, ac_people, ac_region, ac_startdate, ac_enddate,
--                        ac_status, ac_picture, ac_viewcount, ac_travelstyle, ac_personalhash)
-- VALUES (3, '2023-08-31', 'Sample Title 6', 'Sample Text 6', '4', 'Sample Region 3', '2023-09-03', '2023-09-12', 'Open', 'sample6.jpg', '200', 'Exploration', '#adventure');
--

-- Comment 더미데이터
-- 5번 게시물의 댓글
-- INSERT INTO comment( user_number, co_content, co_regdate, ac_num)
-- values (1, '재벌집 막내아들', 2023-08-31, 1);
-- INSERT INTO comment(co_number, user_id, co_content, co_regdate, ac_num)
-- values (2, '두꼬마', '빈센조', 2023-08-31, 1);
-- INSERT INTO comment(co_number, user_id, co_content, co_regdate, ac_num)
-- values (3, '세꼬마', '태양의 후예', 2023-08-31, 1);

-- 6번 게시물의 댓글
-- INSERT INTO comment(co_number, user_id, co_content, co_regdate, ac_num)
-- values (4, '한꼬마', '짜장면', 2023-08-31, 2);
-- INSERT INTO comment(co_number, user_id, co_content, co_regdate, ac_num)
-- values (5, '두꼬마', '짬뽕', 2023-08-31, 2);
-- INSERT INTO comment(co_number, user_id, co_content, co_regdate, ac_num)
-- values (6, '세꼬마', '탕수육', 2023-08-31, 2);
--
-- -- 7번 게시물의 댓글
-- INSERT INTO comment(co_num, user_id, co_content, co_regdate, ac_num)
-- values (7, '한꼬마', '등산', 2023-08-31, 3);
-- INSERT INTO comment(co_num, user_id, co_content, co_regdate, ac_num)
-- values (8, '두꼬마', '바둑', 2023-08-31, 3);
-- INSERT INTO comment(co_num, user_id, co_content, co_regdate, ac_num)
-- values (9, '세꼬마', '낚시', 2023-08-31, 3);
--
