package org.demo.app.service;


import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.demo.app.entity.Department;
import org.demo.app.entity.Employee;
import org.demo.app.exception.AppErrorKeys;
import org.demo.app.exception.AppExceptionResponse;
import org.demo.app.repo.DepartmentRepo;
import org.demo.app.repo.EmployeeRepo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final DepartmentRepo departmentRepo;
    private final EmployeeRepo employeeRepo;

    public Department createDepartment(String name, String code) {
        Department department = Department.builder().name(name).code(code).build();
        return departmentRepo.save(department);
    }

    public Department updateDepartment(Long id, String name) {
        Optional<Department> department = departmentRepo.findById(id);
        if (department.isPresent()) {
            String code = department.get().getCode();
            return departmentRepo.save(Department.builder().id(id).code(code).name(name).build());
        }
        throw new AppExceptionResponse(AppErrorKeys.DEPARTMENT_NOT_FOUND);
    }

    public Employee createEmployee(String firstName, String lastName, String email, BigDecimal salary, Long deptId) {
        Employee employee = Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .joinDate(new Date())
                .salary(salary)
                .department(Department.builder().id(deptId).build())
                .build();
        try {
            return employeeRepo.save(employee);
        } catch (DataIntegrityViolationException ex) {
            throw new AppExceptionResponse(AppErrorKeys.EXIST_EMAIL);
        }

    }

    public Employee updateEmployee(Long id, String firstName, String lastName, String email, Date joinDate, BigDecimal salary, Long deptId) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee emp = optionalEmployee.get();
            Employee employee = Employee.builder()
                    .id(id)
                    .firstName(firstName != null ? firstName : emp.getFirstName())
                    .lastName(lastName != null ? lastName : emp.getLastName())
                    .email(email != null ? email : emp.getEmail())
                    .joinDate(joinDate != null ? joinDate : emp.getJoinDate())
                    .salary(salary != null ? salary : emp.getSalary())
                    .department(deptId != null ? Department.builder().id(deptId).build() : emp.getDepartment())
                    .build();
            return employeeRepo.save(employee);
        }
        throw new AppExceptionResponse(AppErrorKeys.EMPLOYEE_NOT_FOUND);
    }

    public boolean deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            employeeRepo.deleteById(id);
            return true;
        }
        throw new AppExceptionResponse(AppErrorKeys.EMPLOYEE_NOT_FOUND);
    }

    public boolean deleteDepartment(Long id) {
        Optional<Department> department = departmentRepo.findById(id);
        if (department.isPresent()) {
            departmentRepo.deleteById(id);
            return true;
        }
        throw new AppExceptionResponse(AppErrorKeys.DEPARTMENT_NOT_FOUND);
    }

}
