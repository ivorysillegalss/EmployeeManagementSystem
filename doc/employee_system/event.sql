create table event
(
    event_id int auto_increment
        primary key,
    name     varchar(20) null,
    time     int         null,
    status   int         null,
    location varchar(20) null,
    hr_id    int         null
);

