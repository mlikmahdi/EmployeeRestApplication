package com.application.services;

import com.application.dto.EmployeeDto;
import com.application.entity.Employee;
import com.application.mapper.employee.IEmployeeMapper;
import com.application.repository.IEmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final IEmployeeRepository employeeRepository;

    private final IEmployeeMapper employeeMapper;

    public Optional<EmployeeDto> getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(employeeMapper::toDto);

    }

    public Set<EmployeeDto> findAllEmployees() {
        return employeeMapper.toEmployeeDtos(new HashSet<>(employeeRepository.findAll()));
    }

    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.save(employeeMapper.toEmployee(employeeDto));
        return employeeMapper.toDto(employee);
    }

    public Optional<EmployeeDto> deleteEmployeeByID(Long id) {
        Optional<EmployeeDto> employeeById = getEmployeeById(id);
        if (employeeById.isPresent()) {
            employeeRepository.deleteById(id);
            return employeeById;
        }

        return Optional.empty();
    }

    public Optional<EmployeeDto> updateEmployee(EmployeeDto employeeDto) {
        Optional<Employee> employeeFromDatabase = employeeRepository.findById(employeeDto.getId());

        if (employeeFromDatabase.isPresent()) {
            Employee employeeToUpdate = employeeFromDatabase.get();
            employeeToUpdate.setName(employeeDto.getName());
            employeeToUpdate.setRole(employeeDto.getRole());

            Employee updatedEmployee = employeeRepository.save(employeeToUpdate);

            return Optional.of(employeeMapper.toDto(updatedEmployee));
        }

        return Optional.empty();
    }
}
