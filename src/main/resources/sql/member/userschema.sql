# CREATE DATABASE if not exists finalproject;
# 어차피 db연결값이 finalproject라 의미없음

use finalproject;


# drop table if exists user;

CREATE TABLE if not exists `user`
(
    `user_number`   int         NOT NULL primary key auto_increment,
    `user_id`       varchar(30) NOT NULL,
    `user_name`     varchar(10) NOT NULL,
    `user_password` varchar(16) NOT NULL,
    `user_phone`    varchar(15) NULL,
    `user_gender`   varchar(1)  NOT NULL,
    `user_date`     date        NOT NULL,
    `user_mbti`     varchar(4)  NULL,
    `user_img`      varchar(20) NULL,
    `user_regdate`      datetime not null

    );

alter table finalproject.user auto_increment = 1;



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

