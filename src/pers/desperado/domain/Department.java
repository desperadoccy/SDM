package pers.desperado.domain;

public class Department {
    private int id;
    private String department;
    private String CN_department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCN_department() {
        return CN_department;
    }

    public void setCN_department(String CN_department) {
        this.CN_department = CN_department;
    }
}
