--liquibase formatted sql
--changeset zkollonay:create_invoices_table splitStatements:true endDelimiter:;

create table invoices (
      id bigint primary key ,
      name varchar(255) not null ,
      balance bigint,
      user_id bigint,
      foreign key (user_id) references users(id)
);