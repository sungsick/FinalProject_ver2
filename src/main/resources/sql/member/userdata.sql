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



INSERT INTO `qna` (`qna_writer`,  `qna_title`, `qna_content`, `qna_answer`, `qna_date`)
VALUES
    ('john_doe','제목1', '내용은 이것입니다1.', '답변은 아직입니다1.', now()),
    ('seokjin','제목2', '내용은 이것입니다2.',  '답변은 아직입니다2.', '2023-08-30'),
    ('john_doe','제목3', '내용은 이것입니다3.',  '답변은 아직입니다3.', '2023-08-30'),
    ('seokjin','제목4', '내용은 이것입니다4.', '답변은 아직입니다4.', '2023-08-30'),
    ('john_doe','제목5', '내용은 이것입니다5.', '답변은 아직입니다5.', '2023-08-30'),
    ('test','제목6', '내용은 이것입니다6.',  '저도 몰라요', '2023-08-30'),
    ('test','제목7', '내용은 이것입니다7.', '저도 몰라요', '2023-08-30');
select * from qna;

