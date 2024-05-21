create table product
(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255),
    description VARCHAR(10000)
);
insert into product(name, description)
values
('latte','кофейна напиток 1')