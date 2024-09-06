--liquibase formatted sql
--changeset zkollonay:add_new_user splitStatements:true endDelimiter:;

insert into users (first_name, last_name, email, username, password, created_at)
values ('Heckmann', 'Imre', 'Hekimi@gmail.com', 'Hekimi', '1234', now());

insert into users (first_name, last_name, email, username, password, created_at)
values ('Kollonay', 'Zoli', 'zé@gmail.com', 'KZ44', '0000', now());

insert into users (first_name, last_name, email, username, password, created_at)
values ('Zalántai', 'Sándor', 'sanya@gmail.com', 'Zala11', '1111', now());

insert into users (first_name, last_name, email, username, password, created_at)
values ('Szegfi', 'Csenge', 'csecse@gmail.com', 'Szecse', '1844', now());