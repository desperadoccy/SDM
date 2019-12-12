package pers.desperado.dao;

import pers.desperado.domain.Patient;
import pers.desperado.domain.PatientRecord;

import java.util.List;

public interface PatientDao {
    /**
     * 查询用户信息
     */
    Patient searchInfo(String username);
    /**
     * 查询电子病历
     */
    PatientRecord searchRecord(String username);
    /**
     * 查询所有电子病历
     */
    List<PatientRecord> findAll(String department);
    /**
     * 更新用户信息
     */
    void update(Patient patient);
}
