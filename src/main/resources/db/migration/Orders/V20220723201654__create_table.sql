create table if not exists orders
(
    id         serial
        primary key,
    user_id    integer not null,
    CONSTRAINT fk_users
        FOREIGN KEY (user_id)
            REFERENCES users (id),
    product_id integer not null,
    CONSTRAINT fk_products
        FOREIGN KEY (product_id)
            REFERENCES products (id)
);

create unique index orders_id_uindex
    on orders (id);
