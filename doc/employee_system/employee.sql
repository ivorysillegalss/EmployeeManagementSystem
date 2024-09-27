create table if not exists employee
(
    emp_id          int auto_increment
        primary key,
    name            varchar(50)  not null,
    emp_time        int          null,
    gender          tinyint(1)   null,
    address         varchar(255) null,
    phone           varchar(20)  null,
    email           varchar(100) null,
    department_id   int          null,
    department_name char(20)     null,
    position_id     int          null,
    title_id        int          null,
    status          char         null,
    user_id         int          null
);

