package org.demo.app.service.query;


import lombok.RequiredArgsConstructor;
import org.demo.app.entity.Department;
import org.demo.app.exception.AppErrorKeys;
import org.demo.app.exception.AppExceptionResponse;
import org.demo.app.repo.BaseRepo;
import org.demo.app.repo.DepartmentRepo;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentQuery extends QueryServiceImpl<Department> {

    private final DepartmentRepo departmentRepo;

    public Iterable<Department> findAllDepartments() {
        return findAll();
    }

    public Department findDepartmentById(Long id) {
        return findById(id);
    }

    public Department findDepartmentByCode(String code) {
        return departmentRepo.findByCode(code).orElseThrow(() -> new AppExceptionResponse(AppErrorKeys.DEPARTMENT_NOT_FOUND));
    }

    public Long countDepartments() {
        return count();
    }

    @Override
    public BaseRepo<Department> getRepo() {
        return departmentRepo;
    }
}
