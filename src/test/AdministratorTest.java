import main.java.Administrator;
import main.java.ListOfTeachingReq;
import main.java.TeachingRequirement;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @Auther: Weiwei Zhao
 * @Matric: 2586561Z
 * @Date: 8:53 2021/5/21
 * @Desc:
 */
class AdministratorTest {
    public static void main(String[] args) {
        Administrator admin = new Administrator();
        // set administrator's name
        admin.setName("Lily");
        // get administrator's name
        System.out.println(admin.getName());
        // read the teaching requirements
        System.out.println("Test for reading the teaching requirements");
        ArrayList<TeachingRequirement> teachReq = readTeachReq(admin);
        System.out.println("Test for reading the teaching requirements");
        checkPtt(admin);
        System.out.println("Test for comparePTTWithReq");
        StringBuilder[][] qualified = comparePttWithReq(admin);
        System.out.println("Test for training PTTs");
        trainingPTT(admin,qualified);
        // Test1 find the correct list of teachers with skills "Java" and "SQL"
        TeachingRequirement rq1 = new TeachingRequirement();
        rq1.setCourseName("PROGRAM_COURSE");
        rq1.setRequirementName("PROGRAM");
        rq1.setRequirementStaffNumber(1);
        rq1.setRequirementSkill(new String[]{"java","sql"});
        ListOfTeachingReq listOfTeachingReq = new ListOfTeachingReq();
        listOfTeachingReq.add(rq1);
        StringBuilder[][] qulified1 = admin.comparePttWithReq();
        try {
            admin.trainingPTT(qulified1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Test2 find the correct list of teachers with skills "Java" or "SQL"
//        rq1.setRequirementSkill(new String[]{"java","sql"});
        // Test3 if the program will go on if we search the list of teachers with more than 2 skills
        // Test4 if the program will go on if we search the list of teachers with empty skills
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
//        StringBuilder[][] checkResult = admin.checkPtt(qualified);
//        System.out.println("QULIFIED");
//        for (int i = 0; i < 9; i++) {
//            System.out.println(qualified[i][0]+": "+qualified[i][1]);
//        }
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