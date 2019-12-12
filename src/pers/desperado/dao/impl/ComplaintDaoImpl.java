package pers.desperado.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import pers.desperado.dao.ComplaintDao;
import pers.desperado.domain.Complaint;
import pers.desperado.util.JDBCUtils;

public class ComplaintDaoImpl implements ComplaintDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void save(Complaint complaint) {
        String sql = "insert into complaint(name,phone,message) values(?,?,?)";
        template.update(sql,complaint.getName(),complaint.getPhone(),complaint.getMessage());
    }
}
