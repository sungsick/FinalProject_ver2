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

