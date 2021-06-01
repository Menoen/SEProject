package main.java;

import java.util.Arrays;

public class TeachingRequirement {
    private String courseName;
    private String requirementName;
    private String[] requirementSkill;
    private int requirementStaffNumber;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String[] getRequirementSkill() {
        return requirementSkill;
    }

    public void setRequirementSkill(String[] requirementSkill) {
        this.requirementSkill = requirementSkill;
    }

    public int getRequirementStaffNumber() {
        return requirementStaffNumber;
    }

    public void setRequirementStaffNumber(int requirementStaffNumber) {
        this.requirementStaffNumber = requirementStaffNumber;
    }

    @Override
    public String toString() {
        return  courseName +"\t"+ requirementName +"\t"+ Arrays.toString(requirementSkill) +"\t"+ requirementStaffNumber;
    }
}

