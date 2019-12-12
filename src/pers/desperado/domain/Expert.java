package pers.desperado.domain;

import java.util.List;

public class Expert extends Doctor {
    private List<String> Honor;
    private String expertiseDomain;

    public List<String> getHonor() {
        return Honor;
    }

    public void setHonor(List<String> honor) {
        Honor = honor;
    }

    public String getExpertiseDomain() {
        return expertiseDomain;
    }

    public void setExpertiseDomain(String expertiseDomain) {
        this.expertiseDomain = expertiseDomain;
    }
}
