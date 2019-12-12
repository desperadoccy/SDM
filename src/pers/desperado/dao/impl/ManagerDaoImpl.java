package pers.desperado.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pers.desperado.dao.ManagerDao;
import pers.desperado.domain.Outpatient_manager;
import pers.desperado.domain.PatientRecord;
import pers.desperado.util.JDBCUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ManagerDaoImpl implements ManagerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Outpatient_manager searchInfo(String username) {
        Outpatient_manager outpatient_manager = null;
        try {
            String sql = "select * from Outpatient_manager where username = ?";
            outpatient_manager = template.queryForObject(sql, new BeanPropertyRowMapper<Outpatient_manager>(Outpatient_manager.class),username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return outpatient_manager;
    }

    @Override
    public PatientRecord searchRecord(String IDnumber, String departmentRoom) {
        PatientRecord patientRecord = null;
        try {
            String sql = "select * from PatientRecord where IDnumber = ?";
            patientRecord = template.queryForObject(sql,new BeanPropertyRowMapper<PatientRecord>(PatientRecord.class),IDnumber);
            if(patientRecord != null)
            {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                Date date=new Date();
                String dateStr=sdf.format(date);
                String sql2 = "update PatientRecord set data = ?, departmentRoom = ? where IDnumber = ?";
                template.update(sql2,dateStr,departmentRoom,IDnumber);
                patientRecord = template.queryForObject(sql,new BeanPropertyRowMapper<PatientRecord>(PatientRecord.class),IDnumber);
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return patientRecord;
    }

    @Override
    public PatientRecord saveRecord(PatientRecord patientRecord) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String dateStr=sdf.format(date);
        String sql = "insert into PatientRecord(name,IDnumber,departmentRoom,data) values(?,?,?,?)";
        template.update(sql,patientRecord.getName(),patientRecord.getIDnumber(),patientRecord.getDepartmentRoom(),dateStr);
        return searchRecord(patientRecord.getIDnumber(),patientRecord.getDepartmentRoom());
    }

    @Override
    public void updataRecord(PatientRecord patientRecord) {
        String msg;
        if(patientRecord.getHistory()!=null)
            msg = patientRecord.getHistory()+"\n"+patientRecord.getSymptom();
        else
            msg = patientRecord.getSymptom();
        String sql = "update PatientRecord set sex=?,age=?,history=? where IDnumber=?";
        template.update(sql,patientRecord.getSex(),patientRecord.getAge(),msg,patientRecord.getIDnumber());
    }
}
