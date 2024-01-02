package org.demo.app.service.mutation;


import lombok.RequiredArgsConstructor;
import org.demo.app.entity.Department;
import org.demo.app.mapper.BaseMapper;
import org.demo.app.mapper.DepartmentMapper;
import org.demo.app.repo.BaseRepo;
import org.demo.app.repo.DepartmentRepo;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DepartmentMutation extends MutationServiceImpl<Department> {

    private final DepartmentRepo departmentRepo;
    private final DepartmentMapper departmentMapper;

    public Department createDepartment(String name, String code) {
        Department department = Department.builder().name(name).code(code).build();
        return create(department);
    }

    public Department updateDepartment(Long id, String name) {
        Department department = Department.builder().id(id).name(name).build();
        return update(id, department);
    }

    public boolean deleteDepartment(Long id) {
        return delete(id);
    }

    @Override
    public BaseRepo<Department> getRepo() {
        return departmentRepo;
    }

    @Override
    public BaseMapper<Department> getMapper() {
        return departmentMapper;
    }
}
