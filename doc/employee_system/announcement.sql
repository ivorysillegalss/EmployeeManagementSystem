create table if not exists announcement
(
    announcement_id int auto_increment
        primary key,
    title           varchar(100)                        not null,
    content         text                                null,
    created_at      timestamp default CURRENT_TIMESTAMP null,
    updated_at      timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

