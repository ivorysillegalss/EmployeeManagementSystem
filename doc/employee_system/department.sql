create table if not exists department
(
    department_id   int auto_increment
        primary key,
    department_name varchar(100) not null,
    description     text         null,
    emps            int          null comment '员工数量'
);

