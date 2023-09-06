
INSERT INTO `user` (`user_id`,  `user_name`, `user_password`, `user_phone`, `user_gender`, `user_date`, `user_mbti`,`user_img`)
VALUES
    ('john_doe','John Doe', 'password123', '123-456-7890', 'M', '2023-08-21', 'ENTJ','default1.png'),
    ('jane_smith', 'Jane Smith', 'pass4321', '987-654-3210', 'F', '2023-08-21', 'INFP','default2.png'),
    ('alex_brown', 'Alex Brown', 'securepwd', '555-555-5555', 'M', '2023-08-21', 'INTJ','default1.png'),
    ('test', 'yeong', '1234', '555-555-5555', 'M', '2023-08-21', 'INTJ','default1.png'),
    ('sample@example.com', '샘플', '1234', '555-555-5555', 'M', '2023-08-21', 'INTJ','default1.png');


select * from user;

-- PLAN 더미데이터
INSERT INTO `plan_board` (`pb_end_date`,`pb_region`,`pb_start_date`,`pb_title`,`pb_view_count`,`pb_write_date`,`user_number`)
-- 게시글번호(자동생성), 돌아오는날, 여행지역, 떠나는날, 글제목, 조회수, 작성일자, 유저번호
VALUES
    ('2023-09-08','7','2023-09-05','yeong님의 여행일정','0','2023-09-05 18:45:53.227034','4');

INSERT INTO `plan_board_detail` (`pbd_category_group_name`,`pbd_date`,`pbd_place_name`,`pbdx`,`pbdy`,`pb_num`)
-- 세부일정번호(자동생성), 장소분류명, 일자번호(여행일 1일차 2일차), 장소명, x좌표, y좌표, 게시글번호
VALUES
    ('관광명소','1','올레길 7코스(서귀포-월평 올레)','126.51530966206293','33.23738579332568','1');