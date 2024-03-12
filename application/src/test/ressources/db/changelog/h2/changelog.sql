-- changeset Mahdi M'LIK:1 dbms:h2
create table departments
(
    id   bigint auto_increment primary key,
    department_code varchar(255) unique,
    name varchar(255),
    created_at timestamp without time zone,
    created_by varchar(255),
    updated_at timestamp without time zone,
    updated_by varchar(255)
);

create table employees
(
    id            bigint auto_increment primary key,
    matricule     varchar(255) unique,
    hire_date     date not null,
    name          varchar(255),
    role          varchar(255),
    department_id bigint,
    created_at timestamp without time zone,
    created_by varchar(255),
    updated_at timestamp without time zone,
    updated_by varchar(255),
    foreign key (department_id) references departments(id) on delete set null
);

create table projects
(
    id bigint primary key,
    description varchar(255),
    end_date    date,
    name        varchar(255),
    start_date  date,
    created_at timestamp without time zone,
    created_by varchar(255),
    updated_at timestamp without time zone,
    updated_by varchar(255)
);

create table employees_projects
(
    employee_id bigint not null,
    project_id  bigint not null,
    primary key (employee_id, project_id),
    foreign key (employee_id) references employees(id) on delete cascade,
    foreign key (project_id) references projects(id) on delete cascade
);

create table roles
(
    id   bigint auto_increment primary key,
    name varchar(255)
);

create table users
(
    id       bigint auto_increment primary key,
    enable   boolean not null,
    account_non_expired     boolean not null,
    account_non_locked      boolean not null,
    credentials_non_expired boolean not null,
    password varchar(255),
    username varchar(255)
);

create table users_roles
(
    users_id bigint not null,
    roles_id bigint not null,
    primary key (users_id, roles_id),
    foreign key (users_id) references users(id),
    foreign key (roles_id) references roles(id)
);

