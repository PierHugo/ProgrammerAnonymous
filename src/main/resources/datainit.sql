create table comment
(
    id            bigint       not null auto_increment primary key,
    comment       varchar(255),
    comment_date  date,
    user_username varchar(255) not null
) engine = InnoDB;

create table user
(
    username   varchar(255) not null primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    password   varchar(255) not null,
    age        varchar(255) not null,
    city       varchar(255) not null
) engine = InnoDB;

ALTER TABLE comment
    ADD CONSTRAINT FOREIGN KEY (user_username) REFERENCES user (username);

INSERT INTO user
VALUES ('user0', 'user0', 'user0', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 20, 'Paris');
-- password : password
INSERT INTO user
VALUES ('user1', 'user1', 'user1', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 25, 'Tours');
-- password : password

INSERT INTO comment
VALUES (0, 'com0', NOW(), 'user0');
INSERT INTO comment
VALUES (0, 'com1', NOW(), 'user1');