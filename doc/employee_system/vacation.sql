create table vacation
(
    vacation_id  int auto_increment
        primary key,
    user_id      int        null,
    hr_opinion   tinyint(1) null,
    boss_opinion tinyint(1) null,
    time         int        null
);

