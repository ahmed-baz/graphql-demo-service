package org.demo.app.service;


import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.demo.app.entity.Department;
import org.demo.app.entity.Employee;
import org.demo.app.exception.AppErrorKeys;
import org.demo.app.exception.AppExceptionResponse;
import org.demo.app.repo.DepartmentRepo;
import org.demo.app.repo.EmployeeRepo;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final DepartmentRepo departmentRepo;
    private final EmployeeRepo employeeRepo;

    public Iterable<Department> findAllDepartments() {
        return departmentRepo.findAll();
    }

    public Long countDepartments() {
        return departmentRepo.count();
    }

    public Iterable<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new AppExceptionResponse(AppErrorKeys.EMPLOYEE_NOT_FOUND));
    }

    public Department findDepartmentById(Long id) {
        return departmentRepo.findById(id).orElseThrow(() -> new AppExceptionResponse(AppErrorKeys.DEPARTMENT_NOT_FOUND));
    }

    public Department findDepartmentByCode(String code) {
        return departmentRepo.findByCode(code).orElseThrow(() -> new AppExceptionResponse(AppErrorKeys.DEPARTMENT_NOT_FOUND));
    }

    public Long countEmployees() {
        return employeeRepo.count();
    }

}
