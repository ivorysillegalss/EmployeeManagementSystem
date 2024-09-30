create table purchase
(
    purchase_id  int auto_increment
        primary key,
    entity       varchar(20) null,
    nums         int         null,
    hr_opinion   tinyint(1)  null,
    boss_opinion tinyint(1)  null,
    user_id      int         null
);

