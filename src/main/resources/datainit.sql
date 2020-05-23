create table comment
(
    id            bigint       not null auto_increment primary key,
    comment       varchar(255),
    comment_date  date,
    comment_username varchar(255) not null,
    comment_like integer
) engine = InnoDB;

create table user
(
    username   varchar(255) not null primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    password   varchar(255) not null,
    age        integer not null,
    city       varchar(255) not null
) engine = InnoDB;
