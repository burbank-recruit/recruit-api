package com.burbank.recruit;

public class CatalogueItem {

    private String jobRole;

    private String jobLevel;

    public CatalogueItem(String jobRole, String jobLevel) {
        this.jobRole = jobRole;
        this.jobLevel = jobLevel;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(String jobLevel) {
        this.jobLevel = jobLevel;
    }
}
