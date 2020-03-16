INSERT INTO permissions (id, name)
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO roles (id, name)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

INSERT INTO users (id, email, password)
VALUES (1, 'v@mail.ru', '123456');

INSERT INTO role_permission(role_id, perm_id)
VALUES (1, 1),
       (1, 2),
       (2, 2);

INSERT INTO user_role(user_id, role_id)
VALUES (1, 1),
       (1, 2);

-- SEQUENCE
ALTER SEQUENCE permissions_id_seq restart 3;
ALTER SEQUENCE roles_id_seq restart 4;
ALTER SEQUENCE users_id_seq restart 2;
-- /SEQUENCE