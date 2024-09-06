--liquibase formatted sql
--changeset zkollonay:add_new_invoice splitStatements:true endDelimiter:;

insert into invoices (name, balance, user_id) --IMI
values ('Loans and Debts', '100', 1);

insert into invoices (name, balance, user_id) --IMI
values ('Rent', '180000', 1);

insert into invoices (name, balance, user_id) --ZÉ
values ('Savings', '1000000', 2);

insert into invoices (name, balance, user_id) --ZÉ
values ('Holiday', '500000', 2);

insert into invoices (name, balance, user_id) --Zalántai
values ('Insurance', '440000', 3);

insert into invoices (name, balance, user_id) --Csecse
values ('Wedding', '2875000', 4);

insert into invoices (name, balance, user_id) --Csecse
values ('Household Expenses', '325000', 4);