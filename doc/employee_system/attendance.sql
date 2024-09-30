create table attendance
(
    attendance_id int auto_increment
        primary key,
    emp_id        int  null,
    date          int  null,
    status        char not null
);

create index emp_id
    on attendance (emp_id);

