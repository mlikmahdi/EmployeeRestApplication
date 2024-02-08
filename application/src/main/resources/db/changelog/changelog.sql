-- Liquibase formatted sql

-- changeset Mahdi M'LIK:1
create table departments
(
    id   bigserial
        primary key,
    name varchar(255)
);

create table employees
(
    id            bigint not null
        primary key,
    hire_date     date   not null,
    name          varchar(255),
    role          varchar(255),
    department_id bigint
        constraint fk_employees_departments
            references departments
            on delete set null
);

create table projects
(
    id          bigserial
        primary key,
    description varchar(255),
    end_date    date,
    name        varchar(255),
    start_date  date
);

create table employees_projects
(
    employee_id bigint not null
        constraint fk_employees_projects_employees
            references employees
            on delete cascade,
    project_id  bigint not null
        constraint fk_employees_projects_projects
            references projects
            on delete cascade,
    primary key (employee_id, project_id)
);

create table roles
(
    id   bigint not null
        primary key,
    name varchar(255)
);

create table users
(
    id       bigint  not null
        primary key,
    enable   boolean not null,
    password varchar(255),
    username varchar(255)
);

create table users_roles
(
    users_id bigint not null
        constraint fk_users_roles_users
            references users,
    roles_id bigint not null
        constraint fk_users_roles_roles
            references roles,
    primary key (users_id, roles_id)
);

-- changeset Mahdi M'LIK:2
INSERT INTO roles (id, name) VALUES (1, 'DEV');
INSERT INTO roles (id, name) VALUES (2, 'MANAGER');
INSERT INTO roles (id, name) VALUES (3, 'ADMIN');

INSERT INTO users (id, username, password, enable) VALUES (1, 'dev', '$2y$10$vAhzfnonCnkIYYqwnJi7e.B4juLAzHiTkr/ScOigmY1xhBMpaXpA6', '1');
INSERT INTO users (id, username, password, enable) VALUES (2, 'manager', '$2y$10$fxTqEGgMnJmiakhrQQ/P0uNPHMrEvIctqofWjtJXNGplEvGT.lMuO', '1');
INSERT INTO users (id, username, password, enable) VALUES (3, 'admin', '$2y$10$GJFWXgPYVPgFIZfG4nsgeO48aiulnB1.HXFV3k30TGF.vAwZUuzK.', '1');

INSERT INTO users_roles (users_id, roles_id) VALUES (1, 1); -- user dev has role DEV
INSERT INTO users_roles (users_id, roles_id) VALUES (2, 1); -- user manager has role DEV
INSERT INTO users_roles (users_id, roles_id) VALUES (2, 2); -- user manager has role MANAGER
INSERT INTO users_roles (users_id, roles_id) VALUES (3, 1); -- user admin has role DEV
INSERT INTO users_roles (users_id, roles_id) VALUES (3, 2); -- user admin has role MANAGER
INSERT INTO users_roles (users_id, roles_id) VALUES (3, 3); -- user admin has role ADMIN