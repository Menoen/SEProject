import main.java.Administrator;
import main.java.ListOfTeachingReq;
import main.java.TeachingRequirement;
import main.java.UserFactory;

import java.io.IOException;
import java.util.ArrayList;

class AdministratorTest {
    public static void main(String[] args) {
        Administrator admin = (Administrator) UserFactory.createUser("admin");
        // set administrator's name
        admin.setName("Lily");
        // get administrator's name
        System.out.println(admin.getName());
        // read the teaching requirements
        System.out.println("Test for reading the teaching requirements");
        readTeachReq(admin);
        System.out.println("Test for reading the teaching requirements");
        checkPtt(admin);
        //
        System.out.println("Test for comparePTTWithReq");
        StringBuilder[][] qualified = comparePttWithReq(admin);
        System.out.println("Test for training PTTs");
        trainingPTT(admin,qualified);
        // Test1 find the correct list of teachers with skills "Java" and "SQL"
        TeachingRequirement rq1 = new TeachingRequirement();
        rq1.setCourseName("PROGRAM_COURSE");
        rq1.setRequirementName("PROGRAM");
        rq1.setRequirementStaffNumber(1);
        // set the array to skill parameter
        rq1.setRequirementSkill(new String[]{"java","sql"});
        // use singleton pattern
        ListOfTeachingReq listOfTeachingReq = ListOfTeachingReq.instance();
        listOfTeachingReq.add(rq1);
        StringBuilder[][] qualified1 = comparePttWithReq(admin);
        try {
            admin.trainingPTT(qualified1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<TeachingRequirement> readTeachReq(Administrator admin) {
        ArrayList<TeachingRequirement> techList = admin.readTeachReq();
        // print out the requirements the admin read
        for (TeachingRequirement t: techList) {
            System.out.println(t);
        }
        return techList;
    }

    static void checkPtt(Administrator admin) {
        admin.checkPtt();
    }
    static  StringBuilder[][] comparePttWithReq(Administrator admin){
        return admin.comparePttWithReq();
    }
    static void trainingPTT(Administrator admin,StringBuilder[][] qualified) {
        System.out.println("Please review the staff_information file for training information");
        try {
            admin.trainingPTT(qualified);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}