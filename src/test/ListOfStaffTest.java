import main.java.ListOfStaff;
import main.java.Staff;

import java.lang.reflect.Array;

public class ListOfStaffTest {
    public static void main(String[] args) {
        Staff staff = new Staff();
        String[] arrSkills = {"Mental", "Dental"};
        staff.setCourse("Health");
        staff.setSkill(arrSkills);
        System.out.println(staff);
        // test for setter
        ListOfStaff.add(staff);
        // test for getter
        System.out.println(ListOfStaff.getListOfStaffs().toString());
        // test for duplicated add
        ListOfStaff.add(staff);
        System.out.println(ListOfStaff.getListOfStaffs().toString());
    }
}

