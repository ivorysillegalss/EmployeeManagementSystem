create table if not exists salary
(
    salary_id    int auto_increment
        primary key,
    emp_id       int            null,
    basic_salary decimal(10, 2) null,
    bonus        decimal(10, 2) null,
    deductions   decimal(10, 2) null,
    total_salary decimal(10, 2) null,
    salary_date  int            null
);

create index emp_id
    on salary (emp_id);

