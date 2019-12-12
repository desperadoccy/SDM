package pers.desperado.dao;

import pers.desperado.domain.Outpatient_manager;
import pers.desperado.domain.Patient;
import pers.desperado.domain.PatientRecord;

public interface ManagerDao {
    /**
     * 查询用户信息
     */
    Outpatient_manager searchInfo(String username);
    /**
     * 查询电子病历
     */
    PatientRecord searchRecord(String IDnumber,String departmentRoom);
    /**
     * 新建电子病历
     */
    PatientRecord saveRecord(PatientRecord patientRecord);
    /**
     * 更新电子病历
     */
    void updataRecord(PatientRecord patientRecord);
}
