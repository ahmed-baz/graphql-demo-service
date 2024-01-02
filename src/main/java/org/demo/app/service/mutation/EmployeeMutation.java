package org.demo.app.service.mutation;


import lombok.RequiredArgsConstructor;
import org.demo.app.entity.Department;
import org.demo.app.entity.Employee;
import org.demo.app.mapper.BaseMapper;
import org.demo.app.mapper.EmployeeMapper;
import org.demo.app.repo.BaseRepo;
import org.demo.app.repo.EmployeeRepo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;


@Component
@RequiredArgsConstructor
public class EmployeeMutation extends MutationServiceImpl<Employee> {

    private final EmployeeRepo employeeRepo;
    private final EmployeeMapper employeeMapper;

    public Employee createEmployee(String firstName, String lastName, String email, BigDecimal salary, Long deptId) {
        Employee employee = Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .joinDate(new Date())
                .salary(salary)
                .department(Department.builder().id(deptId).build())
                .build();

        return create(employee);
    }

    public Employee updateEmployee(Long id, String firstName, String lastName, String email, BigDecimal salary, Long deptId) {
        Employee employee = Employee.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .salary(salary)
                .department(Department.builder().id(deptId).build())
                .build();

        return update(id, employee);
    }

    public boolean deleteEmployee(Long id) {
        return delete(id);
    }

    @Override
    public BaseRepo<Employee> getRepo() {
        return employeeRepo;
    }

    @Override
    public BaseMapper<Employee> getMapper() {
        return employeeMapper;
    }
}
