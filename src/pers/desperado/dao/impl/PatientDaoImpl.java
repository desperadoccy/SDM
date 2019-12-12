package pers.desperado.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pers.desperado.dao.PatientDao;
import pers.desperado.domain.Patient;
import pers.desperado.domain.PatientRecord;
import pers.desperado.util.JDBCUtils;

import java.util.List;

public class PatientDaoImpl implements PatientDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Patient searchInfo(String username) {
        Patient patient = null;
        try {
            String sql = "select * from patient where username = ?";
            patient = template.queryForObject(sql,new BeanPropertyRowMapper<Patient>(Patient.class),username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public PatientRecord searchRecord(String username) {
        PatientRecord patientRecord = null;
        try {
            String sql = "select * from PatientRecord where name = ?";
            patientRecord = template.queryForObject(sql,new BeanPropertyRowMapper<PatientRecord>(PatientRecord.class),username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return patientRecord;
    }

    @Override
    public List<PatientRecord> findAll(String department) {
        String sql = "select * from PatientRecord where departmentRoom = ? and iscured = 0";
        return template.query(sql,new BeanPropertyRowMapper<PatientRecord>(PatientRecord.class),department);
    }

    @Override
    public void update(Patient patient) {
        String sql = "update patient set IDnumber = ?,phone = ? where username = ?";
        template.update(sql,patient.getIDnumber(),patient.getPhone(),patient.getUsername());
    }
}
