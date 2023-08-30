INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `user_phone`, `user_gender`, `user_date`, `user_mbti`,
                    `user_img`)
VALUES ('john_doe', 'John Doe', 'password123', '01012345678', 'M', '2023-08-21', 'ENTJ', 'default1.png'),
       ('jane_smith', 'Jane Smith', 'pass4321', '987-654-3210', 'F', '2023-08-21', 'INFP', 'default2.png'),
       ('alex_brown', 'Alex Brown', 'securepwd', '555-555-5555', 'M', '2023-08-21', 'INTJ', 'default1.png'),
       ('test', 'yeong', '1234', '01012345678', 'M', '2023-08-21', 'INTJ', 'default1.png'),
       ('sample@example.com', '샘플', '1234', '5555555555', 'M', '2023-08-21', 'INTJ', 'default1.png');


INSERT INTO `manager` (`manager_id`, `manager_password`)
VALUES ('admin', 'admin');



