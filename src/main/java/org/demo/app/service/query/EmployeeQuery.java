package org.demo.app.service.query;


import lombok.RequiredArgsConstructor;
import org.demo.app.entity.Employee;
import org.demo.app.repo.BaseRepo;
import org.demo.app.repo.EmployeeRepo;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeQuery extends QueryServiceImpl<Employee> {

    private final EmployeeRepo employeeRepo;

    public Iterable<Employee> findAllEmployees() {
        return findAll();
    }

    public Employee findEmployeeById(Long id) {
        return findById(id);
    }

    public Long countEmployees() {
        return count();
    }

    @Override
    public BaseRepo<Employee> getRepo() {
        return employeeRepo;
    }
}
