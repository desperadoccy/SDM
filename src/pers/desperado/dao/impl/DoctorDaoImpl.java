package pers.desperado.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pers.desperado.dao.DoctorDao;
import pers.desperado.domain.Doctor;
import pers.desperado.domain.PatientRecord;
import pers.desperado.util.JDBCUtils;

import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Doctor searchInfo(String username) {
        Doctor doctor = null;
        try {
            String sql = "select * from doctor where username = ?";
            doctor = template.queryForObject(sql,new BeanPropertyRowMapper<Doctor>(Doctor.class),username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    @Override
    public boolean findDepart(String department) {
        List<Doctor> doctor = null;
        try {
            String sql = "select * from doctor where department = ?";
            doctor = template.query(sql,new BeanPropertyRowMapper<Doctor>(Doctor.class),department);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        if(doctor.isEmpty()) return false;
        else return true;
    }

    @Override
    public void updateRecord(PatientRecord patientRecord) {
        String sql = "update PatientRecord set symptom = ?,project = ?,iscured = 1 where IDnumber = ?";
        template.update(sql,patientRecord.getSymptom(),patientRecord.getProject(),patientRecord.getIDnumber());
    }
}
