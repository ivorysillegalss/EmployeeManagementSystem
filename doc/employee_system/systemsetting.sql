create table if not exists systemsetting
(
    setting_id    int auto_increment
        primary key,
    setting_name  varchar(100)                        not null,
    setting_value varchar(255)                        null,
    updated_at    timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

