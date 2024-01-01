package org.demo.app.repo;


import org.demo.app.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepo extends BaseRepo<Department> {

    Optional<Department> findByCode(String code);
}
