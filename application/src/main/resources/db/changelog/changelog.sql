-- changeset Mahdi M'LIK:1 dbms:postgresql

create table base_table
(
    created_at timestamp without time zone,
    created_by varchar(255),
    updated_at timestamp without time zone,
    updated_by varchar(255)
);

create table departments
(
    id   bigserial primary key,
    code varchar(255) not null unique,
    name varchar(255) not null
) INHERITS (base_table);

create table employees
(
    id            bigserial primary key,
    matricule     varchar(20)  not null unique,
    name          varchar(255) not null,
    role          varchar(255) not null,
    hire_date     date         not null,
    department_id bigint,
    foreign key (department_id) references departments (id) on delete set null
) INHERITS (base_table);

create table projects
(
    id          bigserial primary key,
    code        varchar(255) not null unique,
    name        varchar(255) not null,
    description varchar(255),
    start_date  date,
    end_date    date
) INHERITS (base_table);

create table employees_projects
(
    employee_id bigint not null,
    project_id  bigint not null,
    primary key (employee_id, project_id),
    foreign key (employee_id) references employees (id) on delete cascade,
    foreign key (project_id) references projects (id) on delete cascade
);

create table roles
(
    id   bigserial primary key,
    name varchar(255) not null unique
);

create table users
(
    id                      bigserial primary key,
    password                varchar(255) not null,
    username                varchar(255) not null unique,
    enable                  boolean      not null,
    account_non_expired     boolean      not null,
    account_non_locked      boolean      not null,
    credentials_non_expired boolean      not null
);

create table users_roles
(
    users_id bigint not null,
    roles_id bigint not null,
    primary key (users_id, roles_id),
    foreign key (users_id) references users (id),
    foreign key (roles_id) references roles (id)
);
