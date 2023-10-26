DROP TABLE IF EXISTS 'event';

CREATE TABLE `event`
(
       `id`        INT         not null    auto_increment,
       `date_time` DATE        not null,
       `user_id`   INT         not null,
       `type`      VARCHAR(20) not null,
       `status`    VARCHAR(10) not null
);

insert into event (id, date_time, user_id, type, status)
values (1, DATE_ADD(DAY, -1, CURRENT_DATE()), 3, 'LOGIN', 'OK'),
       (2, DATE_ADD(DAY, -20, CURRENT_DATE()), 1, 'REGISTRATION', 'OK'),
       (3, DATE_ADD(DAY, -50, CURRENT_DATE()), 4, 'SOLVE_TASK', 'ERROR'),
;