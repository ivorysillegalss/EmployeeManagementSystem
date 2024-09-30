create table operation_log
(
    log_id      int auto_increment
        primary key,
    operator_id int          null,
    action      varchar(255) null,
    log_time    int          null
);

create index operator_id
    on operation_log (operator_id);

