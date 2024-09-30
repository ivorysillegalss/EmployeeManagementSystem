create table action_log
(
    action_id   int auto_increment
        primary key,
    userId      int        not null,
    description text       null,
    success     tinyint(1) not null
)
    comment '记录hr操作日志';

