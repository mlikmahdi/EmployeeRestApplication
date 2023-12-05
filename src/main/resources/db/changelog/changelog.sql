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