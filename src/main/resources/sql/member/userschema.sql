# CREATE DATABASE if not exists finalproject;
# 어차피 db연결값이 finalproject라 의미없음

use finalproject;


drop table if exists user;

CREATE TABLE if not exists `user`
(
    `user_id`       varchar(30) NOT NULL,
    `user_number`   int         NOT NULL primary key auto_increment,
    `user_name`     varchar(10) NOT NULL,
    `user_password` varchar(16) NOT NULL,
    `user_phone`    varchar(15) NULL,
    `user_gender`   varchar(1)  NOT NULL,
    `user_date`     date        NOT NULL,
    `user_mbti`     varchar(4)  NULL,
    `user_img`      varchar(20) NULL

    );

alter table finalproject.user auto_increment = 1;


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


delete
from finalproject.user;

select * from user;


drop table if exists manager;

CREATE TABLE if not exists `manager`
(
    `id`               int         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `manager_id`       varchar(30) NOT NULL,
    `manager_password` varchar(30) NOT NULL

    );

delete from finalproject.manager;


delete from finalproject.qna;

CREATE TABLE if not exists `qna` (
                        `qna_number`int	NOT NULL primary key auto_increment,
                        `qna_writer`	varchar(30)	NOT NULL,
                        `qna_title`	varchar(100)	NOT NULL,
                        `qna_content`	varchar(5000)	NOT NULL,
                        `qna_date`	date	NULL,
                        `qna_answer`	varchar(500)	NULL
);

