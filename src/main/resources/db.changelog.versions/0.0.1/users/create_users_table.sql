--liquibase formatted sql
--changeset zkollonay:create_users_table splitStatements:true endDelimiter:;

create table users (
        id serial primary key,
        first_name varchar(50) not null,
        last_name varchar(50) not null,
        email varchar(150) not null,
        username varchar(100) not null,
        password varchar(100) not null,
        created_at timestamp not null
);