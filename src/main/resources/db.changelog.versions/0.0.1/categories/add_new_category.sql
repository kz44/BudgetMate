--liquibase formatted sql
--changeset zkollonay:add_new_category splitStatements:true endDelimiter:;

insert into categories (name, description, transaction_id)
values ('Utilities', 'Monthly utility bills', 1); -- Loans and Debts (IMI)

insert into categories (name, description, transaction_id)
values ('Groceries', 'Monthly grocery expenses', 2); -- Loans and Debts (IMI)

insert into categories (name, description, transaction_id)
values ('Salary', 'Monthly salary deposit', 5); -- Savings (ZÉ)

insert into categories (name, description, transaction_id)
values ('Travel', 'Expenses for travel and accommodation', 6); -- Holiday (ZÉ)

insert into categories (name, description, transaction_id)
values ('Health Insurance', 'Monthly health insurance payment', 7); -- Insurance (Zalántai)

insert into categories (name, description, transaction_id)
values ('Wedding Gifts', 'Expenses for wedding gifts', 8); -- Wedding (Csecse)

insert into categories (name, description, transaction_id)
values ('House Repairs', 'Expenses for home repairs', 9); -- Household Expenses (Csecse)