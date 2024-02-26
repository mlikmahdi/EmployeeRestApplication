-- Insertion des départements réalistes
INSERT INTO departments (code, name) VALUES
                                      (8868, 'Human Resources'),
                                      (9838, 'Development'),
                                      (4374, 'Marketing'),
                                      (695, 'Sales'),
                                      (6010, 'Customer Service');

-- Insertion des employés
INSERT INTO employees (matricule, name, role, hire_date, department_id) VALUES
                                                                    (4950, 'Ann Cannon', 'Retail merchandiser', '2023-11-01', 1),
                                                                    (9874, 'Steven Murphy', 'Production engineer','2023-01-01',  5);
-- ... autres employés

-- Insertion des projets
INSERT INTO projects (code, name, description, start_date, end_date) VALUES
    (8879, 'envisioneer proactive interfaces', 'Number traditional kind after. Piece offer occur direction price news everything social. Nothing plant force instead instead. Town develop major successful management change right.', '2023-11-03', '2025-07-06'),
    (638, 'empower killer users', 'Actually need but treat care add office. Easy position determine wonder current billion. Somebody message oil tonight. Hot particularly both bar again.', '2022-05-02', '2025-03-16');

-- Insertion des associations employé-projet
INSERT INTO employees_projects (employee_id, project_id) VALUES
    (3, 1),
    (4, 2);
-- ... autres associations employé-projet

-- Insertion des roles et users
INSERT INTO roles (name) VALUES ('DEV');
INSERT INTO roles (name) VALUES ('MANAGER');
INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO users (username, password, enable, account_non_expired, account_non_locked, credentials_non_expired) VALUES ('dev', '$2y$10$vAhzfnonCnkIYYqwnJi7e.B4juLAzHiTkr/ScOigmY1xhBMpaXpA6', '1', '1', '1', '1');
INSERT INTO users (username, password, enable, account_non_expired, account_non_locked, credentials_non_expired) VALUES ('manager', '$2y$10$fxTqEGgMnJmiakhrQQ/P0uNPHMrEvIctqofWjtJXNGplEvGT.lMuO', '1', '1', '1', '1');
INSERT INTO users (username, password, enable, account_non_expired, account_non_locked, credentials_non_expired) VALUES ('admin', '$2y$10$GJFWXgPYVPgFIZfG4nsgeO48aiulnB1.HXFV3k30TGF.vAwZUuzK.', '1', '1', '1', '1');
INSERT INTO users_roles (users_id, roles_id) VALUES (1, 1); -- user dev has role DEV
INSERT INTO users_roles (users_id, roles_id) VALUES (2, 1); -- user manager has role DEV
INSERT INTO users_roles (users_id, roles_id) VALUES (2, 2); -- user manager has role MANAGER
INSERT INTO users_roles (users_id, roles_id) VALUES (3, 1); -- user admin has role DEV
INSERT INTO users_roles (users_id, roles_id) VALUES (3, 2); -- user admin has role MANAGER
INSERT INTO users_roles (users_id, roles_id) VALUES (3, 3); -- user admin has role ADMIN


