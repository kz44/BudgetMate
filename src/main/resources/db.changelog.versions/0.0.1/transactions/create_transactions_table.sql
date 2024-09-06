--liquibase formatted sql
--changeset zkollonay:create_transactions_table splitStatements:true endDelimiter:;

create table transactions (
      id serial primary key ,
      amount decimal(19, 4),
      scheduled_payment boolean default false,
      transaction_date timestamp,
      payment_method_type varchar(255),
      transaction_type varchar(255),
      invoice_id bigint,
      foreign key (invoice_id) references invoices(id)
);