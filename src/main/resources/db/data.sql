-- Insertion des départements réalistes
INSERT INTO department (id, name) VALUES
                                      (8868, 'Human Resources'),
                                      (9838, 'Development'),
                                      (4374, 'Marketing'),
                                      (695, 'Sales'),
                                      (6010, 'Customer Service');

-- Insertion des employés
INSERT INTO employee (id, name, role, hire_date, department_id) VALUES
                                                                    (4950, 'Ann Cannon', 'Retail merchandiser', '2023-11-01', 8868),
                                                                    (9874, 'Steven Murphy', 'Production engineer','2023-01-01',  6010);
-- ... autres employés

-- Insertion des projets
INSERT INTO project (id, name, description, start_date, end_date) VALUES
    (8879, 'envisioneer proactive interfaces', 'Number traditional kind after. Piece offer occur direction price news everything social. Nothing plant force instead instead. Town develop major successful management change right.', '2023-11-03', '2025-07-06'),
    (638, 'empower killer users', 'Actually need but treat care add office. Easy position determine wonder current billion. Somebody message oil tonight. Hot particularly both bar again.', '2022-05-02', '2025-03-16');

-- Insertion des associations employé-projet
INSERT INTO employee_project (employee_id, project_id) VALUES
    (4950, 8879),
    (9874, 638);
-- ... autres associations employé-projet
