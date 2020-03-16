create table permissions
(
    id          bigserial not null
        constraint permissions_pkey primary key,
    name        varchar(255)
        constraint uk_permissions_name unique
);

create table roles
(
    id   bigserial    not null
        constraint roles_pkey
            primary key,
    name varchar(255) not null
        constraint uk_roles_name
            unique
);

create table role_permission
(
    role_id bigint not null
        constraint fk_role_permission_roles
            references roles,
    perm_id bigint not null
        constraint fk_role_permission_permissions
            references permissions
);

create table users
(
    id       bigserial not null
        constraint users_pkey
            primary key,
    email    varchar(255)
        constraint uk_users_name
            unique,
    password varchar(255),
    activation_code varchar(255)
);

create table user_role
(
    user_id bigint not null
        constraint fk_user_role_users
            references users,
    role_id bigint not null
        constraint fk_user_role_role_id
            references roles,
    constraint user_role_pkey
        primary key (user_id, role_id)
);



