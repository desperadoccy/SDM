package pers.desperado.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pers.desperado.dao.UserDao;
import pers.desperado.domain.Doctor;
import pers.desperado.domain.Outpatient_manager;
import pers.desperado.domain.Patient;
import pers.desperado.domain.User;
import pers.desperado.util.JDBCUtils;

import javax.print.Doc;
import javax.sql.DataSource;
import java.io.OutputStream;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            String sql = "select * from user where username = ? and identity = 'patient'";
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);
        } catch (DataAccessException e) {

        }

        return user;
    }

    @Override
    public User findByUsername(String username, String password, String identity) {
        User user = null;
        try {
            String sql = "select * from user where username = ? and password = ? and identity = ?";
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password,identity);
        } catch (DataAccessException e) {

        }
        return user;
    }

    @Override
    public void save(User user) {
        String sql1 = "insert into user(username,password,identity ) values(?,?,'patient')";
        template.update(sql1,user.getUsername(),user.getPassword());
        String sql2 = "insert into patient(username) values(?)";
        template.update(sql2,user.getUsername());
    }
}
