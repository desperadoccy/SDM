package pers.desperado.service;

import pers.desperado.domain.Outpatient_manager;
import pers.desperado.domain.PatientRecord;

public interface ManagerService {
    Outpatient_manager findInfo(String username);
    PatientRecord registRecord(PatientRecord patientRecord);
    boolean updataRecord(PatientRecord patientRecord);
}
