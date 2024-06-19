create table if not exists title
(
    title_id    int auto_increment
        primary key,
    title_name  varchar(100) not null,
    description text         null
);

