insert into users (email, password) values ('admin@example.com', '{noop}adminpass');
insert into users (email, password) values ('user@example.com', '{noop}userpass');

insert into user_role (name, description) values ('ADMIN', 'pełne uprawnienia');
insert into user_role (name, description) values ('USER', 'podstawowe uprawnienia');

insert into user_roles (user_id, role_id) values (1, 1);
insert into user_roles (user_id, role_id) values (2, 2);
