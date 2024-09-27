create table if not exists user
(
    user_id     int auto_increment
        primary key,
    username    varchar(50)  not null,
    password    varchar(255) not null,
    role        char         not null,
    email       varchar(100) null,
    phone       varchar(20)  null,
    create_time int          null,
    update_time int          null
);

