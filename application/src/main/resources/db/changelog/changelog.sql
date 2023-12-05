-- changeset Mahdi M'LIK:1
ALTER TABLE employee ADD CONSTRAINT fk_employee_department FOREIGN KEY (department_id) REFERENCES department(id) ON DELETE SET NULL;
ALTER TABLE employee_project
    ADD CONSTRAINT fk_employee_project_employee
        FOREIGN KEY (employee_id) REFERENCES employee(id)
            ON DELETE CASCADE;

ALTER TABLE employee_project
    ADD CONSTRAINT fk_employee_project_project
        FOREIGN KEY (project_id) REFERENCES project(id)
            ON DELETE CASCADE;

-- changeset Mahdi M'LIK:2
INSERT INTO roles (name) VALUES ('USER');
INSERT INTO roles (name) VALUES ('DEV');
INSERT INTO roles (name) VALUES ('ADMIN');

INSERT INTO users (username, password, enable) VALUES ('admin', '$2a$10$IqTJTjn39IU5.7sSCDQxzu3xug6z/LPU6IF0azE/8CkHCwYEnwBX.', '1');
INSERT INTO users (username, password, enable) VALUES ('mahdi', '$2a$10$E6OjKPVC3T64V9pBPpE66.KQAqH9t4cOKLrnhqFSmlwVu8rcHw89K', '1');
INSERT INTO users_roles (users_id, roles_id) VALUES (1, 3); -- user admin has role ADMIN
INSERT INTO users_roles (users_id, roles_id) VALUES (2, 2); -- user mahdi has role DEV