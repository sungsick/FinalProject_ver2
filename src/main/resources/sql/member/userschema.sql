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

delete from finalproject.ticket_info;

CREATE TABLE if not exists ticket_info (
                             tic_ticket_id bigint not null auto_increment,
                             tic_airline_name varchar(255),
                             tic_fee varchar(255),
                             tic_flight_arrival_date varchar(255),
                             tic_flight_departure_date varchar(255),
                             tic_from_location varchar(255),
                             tic_seat_grade varchar(255),
                             tic_to_location varchar(255),
                             tic_vihicle_id varchar(255),
                             user_number bigint,
                             primary key (tic_ticket_id)
    alter table ticket_info
    add constraint fk_ticket_info_user_number
    foreign key (user_number)
    references user (user_number)
    on delete cascade;
);



