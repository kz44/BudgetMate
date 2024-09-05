--liquibase formatted sql
--changeset zkollonay:create_transactions_table splitStatements:true endDelimiter:;

create table transactions (
      id bigint primary key ,
      amount double precision,
      scheduled_payment boolean default false,
      transaction_date timestamp,
      payment_method_type varchar(255),
      transaction_type varchar(255),
      invoice_id bigint,
      foreign key (invoice_id) references invoices(id)
);