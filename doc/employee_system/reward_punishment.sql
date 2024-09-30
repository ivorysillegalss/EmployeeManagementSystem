create table reward_punishment
(
    rp_id       int auto_increment
        primary key,
    emp_id      int  null,
    type        char not null,
    description text null,
    date        int  null
);

create index emp_id
    on reward_punishment (emp_id);

