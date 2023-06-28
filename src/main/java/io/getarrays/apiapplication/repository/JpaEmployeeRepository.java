package io.getarrays.apiapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.getarrays.apiapplication.model.Employee;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee, Integer> {
    // Define more if need be added
}
