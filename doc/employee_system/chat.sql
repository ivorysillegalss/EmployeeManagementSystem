create table if not exists chat
(
    chat_id     int auto_increment
        primary key,
    sender_id   int                                 null,
    receiver_id int                                 null,
    message     text                                null,
    timestamp   timestamp default CURRENT_TIMESTAMP null,
    constraint chat_ibfk_1
        foreign key (sender_id) references user (user_id),
    constraint chat_ibfk_2
        foreign key (receiver_id) references user (user_id)
);

create index receiver_id
    on chat (receiver_id);

create index sender_id
    on chat (sender_id);

