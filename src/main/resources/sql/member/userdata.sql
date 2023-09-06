
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
VALUES
    ('2023-09-08','1','2023-09-05','yeong님의 여행일정','0','2023-09-05 18:45:53.227034','4');

INSERT INTO `plan_board_detail` (`pbd_category_group_name`,`pbd_date`,`pbd_place_name`,`pbdx`,`pbdy`,`pb_num`)
VALUES
    ('관광명소','1','올레길 7코스(서귀포-월평 올레)','126.51530966206293','33.23738579332568','1');