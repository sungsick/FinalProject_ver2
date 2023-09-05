# CREATE DATABASE if not exists finalproject;
# 어차피 db연결값이 finalproject라 의미없음

use finalproject;

delete from finalproject.plan_board_detail;
delete from finalproject.plan_board;
--delete from finalproject.area_tourism;
--delete from finalproject.ticket_info;
--delete from finalproject.qna;
--delete from finalproject.accompany;
--delete from finalproject.comment;
delete from finalproject.user;
--delete from finalproject.manager;



alter table finalproject.user auto_increment = 1;
--alter table finalproject.manager auto_increment = 1;
--alter table finalproject.ticket_info auto_increment = 1;
--alter table finalproject.area_tourism auto_increment = 1;
--alter table finalproject.qna auto_increment = 1;
--alter table finalproject.accompany auto_increment = 1;
--alter table finalproject.comment auto_increment = 1;
alter table finalproject.plan_board auto_increment = 1;
alter table finalproject.plan_board_detail auto_increment = 1;


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


-- CREATE TABLE if not exists `ticket_info`
-- (
--     `tic_ticket_id`             bigint       NOT NULL,
--     `tic_flight_departure_date` varchar(100) NOT NULL,
--     `tic_flight_arrival_date`   varchar(100) NOT NULL,
--     `tic_seat_grade`            varchar(100) NOT NULL,
--     `tic_airline_name`          varchar(100) NOT NULL,
--     `tic_fee`                   int          NOT NULL,
--     `tic_from_location`         varchar(100) NOT NULL,
--     `tic_to_location`           varchar(100) NOT NULL,
--     `tic_vihicle_id`            varchar(100) NOT NULL,
--     `user_number`               bigint       NOT NULL
--     );
--
-- CREATE TABLE if not exists `area_tourism`(
--                                              `area_id` bigint not null primary key auto_increment,
--                                              `area_name` varchar(100) not null ,
--     `area_name_ko` varchar(100) not null ,
--     `place_id` int not null ,
--     `place_name` varchar(100) not null
--     );
--
--
-- CREATE TABLE if not exists `manager`
-- (
--     `id`               int         NOT NULL PRIMARY KEY AUTO_INCREMENT,
--     `manager_id`       varchar(30) NOT NULL,
--     `manager_password` varchar(30) NOT NULL
--
--     );
--
--
--
-- CREATE TABLE if not exists `qna` (
--                                      `qna_number`int	NOT NULL primary key auto_increment,
--                                      `qna_writer`	varchar(30)	NOT NULL,
--     `qna_title`	varchar(100)	NOT NULL,
--     `qna_content`	varchar(5000)	NOT NULL,
--     `qna_date`	date	NULL,
--     `qna_answer`	varchar(500)	NULL
--     );
--
--
--
-- CREATE TABLE if not exists accompany (
--                                          ac_num INT AUTO_INCREMENT PRIMARY KEY,
--                                          user_number int,
--                                          ac_regdate DATE,
--                                          ac_title VARCHAR(255),
--     ac_text TEXT,
--     ac_people INT,
--     ac_region VARCHAR(255),
--     ac_startdate DATE,
--     ac_enddate DATE,
--     ac_status VARCHAR(50),
--     ac_picture VARCHAR(255),
--     ac_viewcount INT,
--     ac_travelstyle VARCHAR(50),
--     ac_personalhash VARCHAR(255),
--     FOREIGN KEY (user_number) REFERENCES user(user_number)
--     );
--
--
-- create table if not exists `comment`
-- (
--     co_number       INT AUTO_INCREMENT PRIMARY KEY,
--     co_content   varchar(3000),
--     co_writedate DATETIME,
--     user_number       int,
--     ac_num       INT,
--     FOREIGN KEY (user_number) REFERENCES user (user_number),
--     FOREIGN KEY (ac_num) REFERENCES accompany (ac_num)
--     );