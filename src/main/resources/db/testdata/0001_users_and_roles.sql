insert into users (email, password, phone_number) values ('user0@example.com', '{noop}userpass','888-999-333');
insert into users (email, password, phone_number) values ('user@example.com', '{noop}userpass','777-999-333');
insert into user_role (name, description) values ('USER', 'podstawowe uprawnienia');
insert into user_roles (user_id, role_id) values (1, 1);
insert into user_roles (user_id, role_id) values (2, 1);
