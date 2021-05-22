//import main.java.TeachingRequirement;
//
//import java.util.Arrays;
//
///**
// * @Auther: Weiwei Zhao
// * @Matric: 2586561Z
// * @Date: 9:49 2021/5/22
// * @Desc: TeachingRequirement Test
// */
//class TeachingRequirementTest {
//    public static void main(String[] args) {
//        // init a teaching requirement
//        TeachingRequirement teachingRequirement = new TeachingRequirement("FE_course");
//        System.out.println("init a new teaching requirement");
//        System.out.println(teachingRequirement);
//        // change the elements(tests for set methods)
//        teachingRequirement.setRequirementName("FE");
//        teachingRequirement.setRequirementSkill(new String[]{"Javascript","HTML"});
//        teachingRequirement.setRequirementStaffNumber(2);
//        teachingRequirement.setCourseName("FrontEnd_course");
//        // tests for get methods
//        System.out.println("after the changes:");
//        System.out.println("courseName: " + teachingRequirement.getCourseName());
//        System.out.println("requirementName: " + teachingRequirement.getRequirementName());
//        System.out.println("courseName: " + Arrays.toString(teachingRequirement.getRequirementSkill()));
//        System.out.println("courseName: " + teachingRequirement.getRequirementStaffNumber());
//
//    }
//}