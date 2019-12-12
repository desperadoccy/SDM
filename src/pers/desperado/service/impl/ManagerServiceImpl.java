package pers.desperado.service.impl;

import pers.desperado.dao.DoctorDao;
import pers.desperado.dao.ManagerDao;
import pers.desperado.dao.PatientDao;
import pers.desperado.dao.impl.DoctorDaoImpl;
import pers.desperado.dao.impl.ManagerDaoImpl;
import pers.desperado.dao.impl.PatientDaoImpl;
import pers.desperado.domain.Doctor;
import pers.desperado.domain.Outpatient_manager;
import pers.desperado.domain.PatientRecord;
import pers.desperado.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
    @Override
    public Outpatient_manager findInfo(String username) {
        Outpatient_manager outpatient_manager = null;
        ManagerDao managerDao = new ManagerDaoImpl();
        outpatient_manager =  managerDao.searchInfo(username);
        return outpatient_manager;
    }

    @Override
    public PatientRecord registRecord(PatientRecord patientRecord) {
        PatientRecord patientRecord1 = null;
        ManagerDao managerDao = new ManagerDaoImpl();
        patientRecord1 = managerDao.searchRecord(patientRecord.getIDnumber(),patientRecord.getDepartmentRoom());
        if(patientRecord == null){
            patientRecord1 = managerDao.saveRecord(patientRecord);
        }
        return patientRecord1;
    }

    @Override
    public boolean updataRecord(PatientRecord patientRecord) {
        DoctorDao doctorDao = new DoctorDaoImpl();
        Boolean flag = doctorDao.findDepart(patientRecord.getDepartmentRoom());
        if(!flag) return flag;
        ManagerDao managerDao = new ManagerDaoImpl();
        managerDao.updataRecord(patientRecord);
        return flag;
    }
}
