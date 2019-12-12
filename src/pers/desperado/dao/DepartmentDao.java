package pers.desperado.dao;

import pers.desperado.domain.Department;

import java.util.List;

public interface DepartmentDao {
    List<Department> findAll();
}
