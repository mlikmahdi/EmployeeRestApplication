package com.application.controllers;

import com.application.department.dto.DepartmentDto;
import com.application.department.entity.Department;
import com.application.employee.dto.EmployeeDto;
import com.application.employee.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class EmployeeRestControllerIntegrationTest {

    private static final String ROOT_URL_TEMPLATE = "/employees";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(username = "admin", roles = {"DEV","MANAGER","ADMIN"})
    void createEmployee() throws Exception {
        EmployeeDto employeeDto = EmployeeDto.builder()
                .name("Toto")
                .role("DEV")
                .hireDate(LocalDate.now())
                .department(DepartmentDto.builder()
                        .id(1L)
                        .name("Ressources Humaines")
                        .build())
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post(ROOT_URL_TEMPLATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeDto)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void getAllEmployees() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(ROOT_URL_TEMPLATE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getNonExistingOneEmployee() throws Exception {
        long employeeId = 1000L;

        mockMvc.perform(MockMvcRequestBuilders.get(ROOT_URL_TEMPLATE + employeeId))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Test
    void updateEmployee() throws Exception {
        Department department = new Department();
        department.setId(1L);

        Employee employee1 = new Employee("Employé 1 Modifié", "Rôle modifié");
        employee1.setId(1L);
        employee1.setDepartment(department);

        String updatedEmployeeJson = objectMapper.writeValueAsString(employee1);

        mockMvc.perform(MockMvcRequestBuilders.put(ROOT_URL_TEMPLATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedEmployeeJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}