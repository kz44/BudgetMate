--liquibase formatted sql
--changeset zkollonay:add_new_transaction splitStatements:true endDelimiter:;

insert into transactions (amount, scheduled_payment, transaction_date, payment_method_type, transaction_type, invoice_id)
values (10000, false, now(), 'CREDIT_CARD', 'INCOME', 1); -- Loans and Debts (IMI)

insert into transactions (amount, scheduled_payment, transaction_date, payment_method_type, transaction_type, invoice_id)
values (5000, false, now(), 'BANK_TRANSFER', 'EXPENSE', 1); -- Loans and Debts (IMI)

insert into transactions (amount, scheduled_payment, transaction_date, payment_method_type, transaction_type, invoice_id)
values (180000, false, now(), 'BANK_TRANSFER', 'EXPENSE', 2); -- Rent (IMI)

insert into transactions (amount, scheduled_payment, transaction_date, payment_method_type, transaction_type, invoice_id)
values (250000, true, '2024-09-10', 'BANK_TRANSFER', 'EXPENSE', 2); -- Scheduled payment for Rent (IMI)

insert into transactions (amount, scheduled_payment, transaction_date, payment_method_type, transaction_type, invoice_id)
values (150000, false, now(), 'MOBILE_PAYMENT', 'INCOME', 3); -- Savings (ZÉ)

insert into transactions (amount, scheduled_payment, transaction_date, payment_method_type, transaction_type, invoice_id)
values (30000, false, now(), 'CASH', 'EXPENSE', 4); -- Holiday (ZÉ)

insert into transactions (amount, scheduled_payment, transaction_date, payment_method_type, transaction_type, invoice_id)
values (400000, false, now(), 'CREDIT_CARD', 'EXPENSE', 5); -- Insurance (Zalántai)

insert into transactions (amount, scheduled_payment, transaction_date, payment_method_type, transaction_type, invoice_id)
values (150000, false, now(), 'MOBILE_PAYMENT', 'INCOME', 6); -- Wedding (Csecse)

insert into transactions (amount, scheduled_payment, transaction_date, payment_method_type, transaction_type, invoice_id)
values (10000, false, now(), 'BANK_TRANSFER', 'EXPENSE', 7); -- Household Expenses (Csecse)
