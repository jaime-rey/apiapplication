package io.getarrays.apiapplication.service.impl;

import io.getarrays.apiapplication.model.Employee;
import io.getarrays.apiapplication.repository.JpaEmployeeRepository;
import io.getarrays.apiapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
@Qualifier(value = "mySQLEmployeeService")
public class JpaEmployeeServiceImpl implements EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return jpaEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return jpaEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return jpaEmployeeRepository.findById(id).orElseThrow();
    }
//Assignment
    @Override
    public void updateEmployee(Employee employee) {
    }

    @Override
    public Boolean deleteById(Integer id) {
        jpaEmployeeRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
