package pers.desperado.service.impl;

import pers.desperado.dao.PatientDao;
import pers.desperado.dao.impl.PatientDaoImpl;
import pers.desperado.domain.Patient;
import pers.desperado.domain.PatientRecord;
import pers.desperado.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    @Override
    public Patient findInfo(String username) {
        Patient patient = null;
        PatientDao patientDao = new PatientDaoImpl();
        patient = patientDao.searchInfo(username);
        return patient;
    }

    @Override
    public PatientRecord findRecord(String username) {
        PatientRecord patientRecord = null;
        PatientDao patientDao = new PatientDaoImpl();
        patientRecord = patientDao.searchRecord(username);
        return patientRecord;
    }

    @Override
    public List<PatientRecord> findAll(String department) {
        PatientDao patientDao = new PatientDaoImpl();
        return patientDao.findAll(department);
    }

    @Override
    public void update(Patient patient) {
        PatientDao patientDao = new PatientDaoImpl();
        patientDao.update(patient);
    }
}
