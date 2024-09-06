--liquibase formatted sql
--changeset zkollonay:create_invoices_table splitStatements:true endDelimiter:;

create table invoices (
      id serial primary key ,
      name varchar(255) not null ,
      balance decimal(19, 4),
      user_id bigint,
      foreign key (user_id) references users(id)
);