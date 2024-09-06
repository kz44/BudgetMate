--liquibase formatted sql
--changeset zkollonay:create_categories_table splitStatements:true endDelimiter:;

create table categories (
    id serial primary key,
    name varchar(50) not null,
    description text,
    transaction_id bigint unique,
    foreign key (transaction_id) references transactions(id)
);