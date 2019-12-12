package pers.desperado.service.impl;

import pers.desperado.dao.DepartmentDao;
import pers.desperado.dao.impl.DepartmentDaoImpl;
import pers.desperado.domain.Department;
import pers.desperado.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
