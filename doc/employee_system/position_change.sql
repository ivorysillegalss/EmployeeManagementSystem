create table position_change
(
    position_change_id int auto_increment
        primary key,
    user_id            int         null,
    hr_id              int         null,
    status             tinyint(1)  null,
    formal_position    varchar(20) null,
    after_position     varchar(20) null
);

