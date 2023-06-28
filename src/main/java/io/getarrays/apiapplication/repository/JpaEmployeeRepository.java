package io.getarrays.apiapplication.repository;
import io.getarrays.apiapplication.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee, Integer> {
    // Define more if need be added
}
