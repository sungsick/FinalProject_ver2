CREATE DATABASE if not exists finalproject;

use finalproject;

delete from finalproject.user;

CREATE TABLE if not exists `user` (
                        `user_id`	varchar(30)	NOT NULL,
                        `user_number`	int	NOT NULL primary key auto_increment,
                        `user_name`	varchar(10)	NOT NULL,
                        `user_password`	varchar(16)	NOT NULL,
                        `user_phone`	varchar(15)	NULL,
                        `user_gender`	varchar(1)	NOT NULL,
                        `user_date`	date	NOT NULL,
                        `user_mbti`	varchar(4)	NULL,
                        `user_img`	varchar(20)	NULL

);
delete from finalproject.qna;

CREATE TABLE if not exists `qna` (
                        `qna_number`int	NOT NULL primary key auto_increment,
                        `qna_writer`	varchar(30)	NOT NULL,
                        `qna_title`	varchar(100)	NOT NULL,
                        `qna_content`	varchar(1000)	NOT NULL,
                        `qna_date`	date	NULL,
                        `qna_answer`	varchar(500)	NULL
);

