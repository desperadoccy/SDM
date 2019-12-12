package pers.desperado.domain;

import java.util.List;

public class Prescription {
    private int id;
    private int medicineCount;
    private int projectCount;
    private List<String> medicine;
    private List<String> project;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedcineCount() {
        return medicineCount;
    }

    public void setMedcineCount(int medcineCount) {
        this.medicineCount = medcineCount;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    public List<String> getMedcine() {
        return medicine;
    }

    public void setMedcine(List<String> medcine) {
        this.medicine = medcine;
    }

    public List<String> getProject() {
        return project;
    }

    public void setProject(List<String> project) {
        this.project = project;
    }

}
