package io.getarrays.apiapplication.repository;

import io.getarrays.apiapplication.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryEmployeeRepository {
    private static final List<Employee> DATABASE = new ArrayList<>();
    static {
        DATABASE.add(new Employee(1, "John", "Doe", "john@doe.com"));
        DATABASE.add(new Employee(2, "Mary", "Doe", "mary@doe.com"));
        DATABASE.add(new Employee(3, "Nancy", "Doe", "nancy@doe.com"));

    }

    public Employee addEmployee(Employee employee) {
         DATABASE.add(employee);
        return employee;
    };

    // Get employess
    public List<Employee> getAllEmployees() {
        return List.copyOf(DATABASE);
    };

    // Get one employee
    public Employee findById(Integer id) {
        return DATABASE
                .stream()
                .filter(emp -> id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();
    };

    // Assignment
    public void updateEmployee(Employee employee) {

    };

    // Delete employee
    public Boolean deleteById(Integer id) {
        Employee employee = this.findById(id);
        return DATABASE
                .remove(employee);
    };
}
