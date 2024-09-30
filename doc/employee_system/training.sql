create table training
(
    training_id   int auto_increment
        primary key,
    emp_id        int          null,
    training_name varchar(100) null,
    training_date int          null,
    result        varchar(100) null
);

create index emp_id
    on training (emp_id);

