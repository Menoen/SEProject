import main.java.TeachingRequirement;

import java.util.Arrays;

class TeachingRequirementTest {
    public static void main(String[] args) {
        // init a teaching requirement
        TeachingRequirement teachingRequirement = new TeachingRequirement();
        System.out.println("init a new teaching requirement");
        // tests for set methods
        teachingRequirement.setRequirementName("FE");
        teachingRequirement.setRequirementSkill(new String[]{"Javascript","HTML"});
        teachingRequirement.setRequirementStaffNumber(2);
        teachingRequirement.setCourseName("FrontEnd_course");
        // tests for get methods
        System.out.println("after the changes:");
        System.out.println("courseName: " + teachingRequirement.getCourseName());
        System.out.println("requirementName: " + teachingRequirement.getRequirementName());
        System.out.println("requirementSkills: " + Arrays.toString(teachingRequirement.getRequirementSkill()));
        System.out.println("courseName: " + teachingRequirement.getRequirementStaffNumber());

    }
}

