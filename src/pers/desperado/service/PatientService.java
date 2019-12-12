package pers.desperado.service;

import pers.desperado.domain.Patient;
import pers.desperado.domain.PatientRecord;

import java.util.List;

public interface PatientService {
    Patient findInfo(String username);
    PatientRecord findRecord(String username);
    List<PatientRecord> findAll(String department);
    void update(Patient patient);
}
