package pers.desperado.service.impl;

import pers.desperado.dao.DoctorDao;
import pers.desperado.dao.impl.DoctorDaoImpl;
import pers.desperado.domain.Doctor;
import pers.desperado.domain.PatientRecord;
import pers.desperado.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {
    @Override
    public Doctor findInfo(String username) {
        Doctor doctor = null;
        DoctorDao doctorDao = new DoctorDaoImpl();
        doctor = doctorDao.searchInfo(username);
        return doctor;
    }

    @Override
    public void updateRecord(PatientRecord patientRecord) {
        DoctorDao doctorDao = new DoctorDaoImpl();
        doctorDao.updateRecord(patientRecord);
    }
}
