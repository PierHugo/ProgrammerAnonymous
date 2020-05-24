create table member
(
    username   varchar(255) not null primary key,
    password   varchar(255) not null,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    city       varchar(255) not null
) engine = InnoDB;

create table comment
(
    author       varchar(255) not null primary key,
    comment      varchar(500),
    comment_date varchar(20),
    likes        bigint default 0
) engine = InnoDB;

INSERT INTO member
VALUES ('member0', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'member0', 'member0', 'Paris');
-- password : password
INSERT INTO member
VALUES ('member1', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 'member1', 'member1', 'Tours');
-- password : password

INSERT INTO comment
VALUES ('author0',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget eleifend urna. Pellentesque ex eros, condimentum ut luctus eget, mattis eget nisl. Morbi elementum sit amet nisl a venenatis. Nam eu eros sit amet nulla suscipit rutrum. Mauris ornare eu quam vel sagittis. Maecenas eu justo neque. Sed mattis mi eu erat tincidunt molestie.',
        now(), 10);
INSERT INTO comment
VALUES ('author1',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget eleifend urna. Pellentesque ex eros, condimentum ut luctus eget, mattis eget nisl. Morbi elementum sit amet nisl a venenatis. Nam eu eros sit amet nulla suscipit rutrum. Mauris ornare eu quam vel sagittis. Maecenas eu justo neque. Sed mattis mi eu erat tincidunt molestie.',
        now(), 5);
INSERT INTO comment
VALUES ('author2',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eget eleifend urna. Pellentesque ex eros, condimentum ut luctus eget, mattis eget nisl. Morbi elementum sit amet nisl a venenatis. Nam eu eros sit amet nulla suscipit rutrum. Mauris ornare eu quam vel sagittis. Maecenas eu justo neque. Sed mattis mi eu erat tincidunt molestie.',
        now(), 2);
