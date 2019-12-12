package pers.desperado.dao;

import pers.desperado.domain.Doctor;
import pers.desperado.domain.PatientRecord;

public interface DoctorDao {
    /**
     * 查询用户信息
     */
    Doctor searchInfo(String username);
    /**
     * 查询科室所有医生
     */
    boolean findDepart(String department);
    /**
     * 更新电子病历
     */
    void updateRecord(PatientRecord patientRecord);
}
