package com.application.controllers;

import com.application.entity.Department;
import com.application.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createEmployee() throws Exception {
        String createEmployeeJson = objectMapper.writeValueAsString(new Employee("Développeur", "Technicien"));

        mockMvc.perform(MockMvcRequestBuilders.post("/employee/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createEmployeeJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void getAllEmployees() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/employee/all"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getNonExistingOneEmployee() throws Exception {
        long employeeId = 1000L;

        mockMvc.perform(MockMvcRequestBuilders.get("/employee/" + employeeId))
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

        mockMvc.perform(MockMvcRequestBuilders.put("/employee/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedEmployeeJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}