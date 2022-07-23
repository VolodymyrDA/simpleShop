create table if not exists products
(
    id    serial
        primary key,
    name  varchar(50) not null,
    price int         not null
);

create unique index products_id_uindex
    on products (id);