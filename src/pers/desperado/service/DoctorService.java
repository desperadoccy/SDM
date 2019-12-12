package pers.desperado.service;

import pers.desperado.domain.Doctor;
import pers.desperado.domain.PatientRecord;

public interface DoctorService {
    Doctor findInfo(String username);
    void updateRecord(PatientRecord patientRecord);
}
