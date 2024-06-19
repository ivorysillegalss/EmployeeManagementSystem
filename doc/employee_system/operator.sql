create table if not exists operator
(
    operator_id   int auto_increment
        primary key,
    user_id       int         null,
    operator_role varchar(50) null,
    created_at    int         null,
    updated_at    int         null
);

create index user_id
    on operator (user_id);

