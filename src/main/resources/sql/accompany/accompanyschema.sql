CREATE DATABASE if not exists finalproject;

use finalproject;

delete
from finalproject.accompany;



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


    CREATE TABLE if not exists accompany (
        ac_num INT AUTO_INCREMENT PRIMARY KEY,
        user_number int,
        ac_regdate DATE,
        ac_title VARCHAR(255),
        ac_text TEXT,
        ac_people INT,
        ac_region VARCHAR(255),
        ac_startdate DATE,
        ac_enddate DATE,
        ac_status VARCHAR(50),
        ac_picture VARCHAR(255),
        ac_viewcount INT,
        ac_travelstyle VARCHAR(50),
        ac_personalhash VARCHAR(255),
        FOREIGN KEY (user_number) REFERENCES user(user_number)
        );


create table if not exists `comment`
(
    co_number       INT AUTO_INCREMENT PRIMARY KEY,
    co_content   varchar(3000),
    co_writedate DATETIME,
    user_number       int,
    ac_num       INT,
    FOREIGN KEY (user_number) REFERENCES user (user_number),
    FOREIGN KEY (ac_num) REFERENCES accompany (ac_num)
);




