create table if not exists position
(
    position_id   int auto_increment
        primary key,
    position_name varchar(100) not null,
    department_id int          null,
    emps          int          null comment '员工数量',
    constraint position_ibfk_1
        foreign key (department_id) references department (department_id)
);

create index department_id
    on position (department_id);

