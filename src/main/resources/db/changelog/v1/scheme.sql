drop table if exists product,
    role,
    users,
    client,
    client_bonus_card cascade;


create table if not exists product (
     id serial primary key,
     name varchar(255) not null,
     description text
);


create table if not exists role
(
    id bigserial not null primary key,
    name varchar(255) not null

);



create table if not exists users
(
    id              bigserial not null primary key,
    role_id         bigint references role (id) on delete cascade,
    username        varchar(255) not null,
    password        varchar(255) not null,
    first_name      varchar(255) not null,
    last_name       varchar(255) not null,
    email           varchar(255) not null,
    phone_number    varchar(255) not null,
    unique (username)
);



create table if not exists client
(
    id                  bigserial not null primary key,
    chat_id             bigint not null unique,
    name                varchar(255),
    birthday            date,
    email               varchar(255),
    registration_state  varchar(255)
);


create table if not exists client_bonus_card (
     id                 bigserial not null primary key,
     client_id          bigint unique references client(id) on delete cascade,
     amount             int not null default 0,
     discount_percent   int not null default 5
);