package org.demo.app.service;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.demo.app.entity.Department;
import org.demo.app.entity.Employee;
import org.demo.app.repo.DepartmentRepo;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeeResolver implements GraphQLResolver<Employee> {

    private final DepartmentRepo departmentRepo;

    public Department getDepartment(Employee employee) {
        Optional<Department> department = departmentRepo.findById(employee.getDepartment().getId());
        if (department.isPresent()) {
            return department.get();
        }
        return null;
    }

}
