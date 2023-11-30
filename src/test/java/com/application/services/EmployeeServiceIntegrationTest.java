package com.application.services;

import com.application.entity.Employee;
import com.application.repository.IEmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class EmployeeServiceIntegrationTest {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void findEmployeeById() {
        // GIVEN
        Employee employee1 = new Employee("Développeur", "Technicien");

        entityManager.persist(employee1);
        entityManager.flush();

        // WHEN
        Optional<Employee> found = employeeRepository.findById(employee1.getId());

        // THEN
        assertThat(found.isPresent()).isTrue();
//        assertThat(found.get().getName()).isEqualTo(employee1.getName());
//        assertThat(found.get().getRole()).isEqualTo(employee1.getRole());
        assertThat(found.get()).isEqualTo(employee1);
    }

    @Test
    void findAllEmployees() {
        // GIVEN
        Employee employee1 = new Employee("Développeur", "Technicien");
        Employee employee2 = new Employee("Lead Dév", "Cadre");

        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.flush();

        // WHEN
        List<Employee> foundAll = employeeRepository.findAll();

        // THEN
        assertThat(foundAll.size()).isNotNull();
        assertThat(foundAll.size()).isEqualTo(2);

    }

    @Test
    void createNewEmployee() {
        // GIVEN
        Employee employee1 = new Employee("Développeur", "Technicien");

        // WHEN
        Employee createdEmployee = employeeRepository.save(employee1);

        // THEN
        assertThat(createdEmployee).isEqualTo(employee1);

    }

}