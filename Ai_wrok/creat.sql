create table user
(
    id bigint
        primary key
        auto_increment,
    username varchar(255),
    password varchar(255),
    status varchar(255)
);

create table chatContent
 (
     id bigint
     primary key
     auto_increment,
     role varchar(255),
     userId bigint,
     uuid bigint,
     time datetime,
     content varchar(255)
 );

create table uuid
(
    id bigint
        primary key
        auto_increment,
    userId bigint,
    uuid bigint,
    title varchar(255)
);