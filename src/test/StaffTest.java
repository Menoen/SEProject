import java.util.Arrays;
import main.java.Staff;

class StaffTest {
    public static void main(String[] args) {
        String[] arrSkills = {"Mental", "Dental"};
        // initialise a new staff
        Staff staff = new Staff();
        // set the course the PTT teaches
        staff.setCourse("Health");
        staff.setSkill(arrSkills);
        // Test for getters
        System.out.println(staff.getName() + "\'s course is " +staff.getCourse());
        System.out.println(staff.getName() + "\'s skills are " +Arrays.toString(staff.getSkill()));
    }
}

