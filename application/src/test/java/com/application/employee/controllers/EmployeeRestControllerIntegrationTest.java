package com.application.employee.controllers;

import com.application.employee.data.EmployeeDataTest;
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
    @WithMockUser(roles = {"DEV"})
    void dev_try_to_create_employee_then_return_forbidden() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(ROOT_URL_TEMPLATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(EmployeeDataTest.defaultEmployeeDto())))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithMockUser(roles = {"MANAGER"})
    void manager_try_to_create_employee_then_return_forbidden() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(ROOT_URL_TEMPLATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(EmployeeDataTest.defaultEmployeeDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    @Test
    @WithMockUser(roles = {"DEV"})
    void dev_try_to_get_all_employees_then_return_ok() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(ROOT_URL_TEMPLATE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser(roles = {"DEV"})
    void dev_try_to_get_non_existing_employee_then_return_not_found() throws Exception {
        long employeeId = 1000L;

        mockMvc.perform(MockMvcRequestBuilders.get(ROOT_URL_TEMPLATE + employeeId))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }


    @Test
    @WithMockUser(roles = {"MANAGER"})
    void manager_try_to_update_employee_then_return_ok() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(ROOT_URL_TEMPLATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(EmployeeDataTest.defaultEmployeeDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        mockMvc.perform(MockMvcRequestBuilders.put(ROOT_URL_TEMPLATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(EmployeeDataTest.defaultUpdatedEmployeeDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}