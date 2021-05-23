import main.java.Staff;

/**
 * @Auther: Weiwei Zhao
 * @Matric: 2586561Z
 * @Date: 13:17 2021/5/21
 * @Desc: Staff Test
 */
class StaffTest {
    public static void main(String[] args) {
        String[] arrSkills = {"Mental", "Dental"};
        // initialise a new staff
        Staff staff = new Staff();
        // set the course the PTT teaches
        staff.setCourse("Health");
        System.out.println(staff.getName() + "\'s course is" +staff.getCourse());
        System.out.println(staff.getName() + "\'s skills are" +staff.getSkill());
        // change the skills of the staff
        arrSkills = new String[]{"Mental", "Body"};
        staff.setSkill(arrSkills);
        System.out.println(staff.getName() + "\'s new course are" +staff.getSkill());

    }
}