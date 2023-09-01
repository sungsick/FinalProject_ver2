# CREATE DATABASE if not exists finalproject;
# 어차피 db연결값이 finalproject라 의미없음

use finalproject;

delete from finalproject.area_tourism;
delete from finalproject.ticket_info;
# delete from finalproject.user;
delete from finalproject.manager;
delete from finalproject.qna;



alter table finalproject.user auto_increment = 1;
alter table finalproject.user auto_increment = 1;
alter table finalproject.manager auto_increment = 1;
alter table finalproject.ticket_info auto_increment = 1;
alter table finalproject.area_tourism auto_increment = 1;

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


CREATE TABLE if not exists `ticket_info`
(
    `tic_ticket_id`             bigint       NOT NULL,
    `tic_flight_departure_date` varchar(100) NOT NULL,
    `tic_flight_arrival_date`   varchar(100) NOT NULL,
    `tic_seat_grade`            varchar(100) NOT NULL,
    `tic_airline_name`          varchar(100) NOT NULL,
    `tic_fee`                   int          NOT NULL,
    `tic_from_location`         varchar(100) NOT NULL,
    `tic_to_location`           varchar(100) NOT NULL,
    `tic_vihicle_id`            varchar(100) NOT NULL,
    `user_number`               bigint       NOT NULL
);

CREATE TABLE if not exists `area_tourism`(
    `area_id` bigint not null primary key auto_increment,
    `area_name` varchar(100) not null ,
    `area_name_ko` varchar(100) not null ,
    `place_id` int not null ,
    `place_name` varchar(100) not null
);


CREATE TABLE if not exists `manager`
(
    `id`               int         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `manager_id`       varchar(30) NOT NULL,
    `manager_password` varchar(30) NOT NULL

    );



CREATE TABLE if not exists `qna` (
                        `qna_number`int	NOT NULL primary key auto_increment,
                        `qna_writer`	varchar(30)	NOT NULL,
                        `qna_title`	varchar(100)	NOT NULL,
                        `qna_content`	varchar(5000)	NOT NULL,
                        `qna_date`	date	NULL,
                        `qna_answer`	varchar(500)	NULL
);

