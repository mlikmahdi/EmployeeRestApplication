package com.application.employee.data;

import com.application.employee.dto.EmployeeDto;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class EmployeeDataTest {

    public static EmployeeDto defaultEmployeeDto() {
        return EmployeeDto.builder()
                .role("Technicien")
                .name("Steven Steven")
                .matricule("1234")
                .hireDate(LocalDate.now())
                .build();
    }

    public static EmployeeDto defaultUpdatedEmployeeDto() {
        return EmployeeDto.builder()
                .role("Technicien")
                .name("Steven Spielberg")
                .matricule("1234")
                .hireDate(LocalDate.now())
                .build();
    }
}
