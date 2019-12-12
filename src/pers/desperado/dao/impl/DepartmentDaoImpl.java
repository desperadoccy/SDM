package pers.desperado.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pers.desperado.dao.DepartmentDao;
import pers.desperado.domain.Department;
import pers.desperado.util.JDBCUtils;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Department> findAll() {
        String sql = "select * from department";
        return template.query(sql,new BeanPropertyRowMapper<Department>(Department.class));
    }
}
