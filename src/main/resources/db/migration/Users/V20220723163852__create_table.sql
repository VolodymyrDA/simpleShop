create table if not exists users
(
    id            serial
        constraint users_pk
            primary key,
    first_name    varchar(50) not null,
    last_name    varchar(50) not null,
    ammount_money int         not null
);

create unique index users_id_uindex
    on users (id);