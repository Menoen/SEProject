import main.java.Administrator;
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
    private static StringBuilder[][] qualified = new StringBuilder[10][2];
    public static void main(String[] args) {
        Administrator admin = new Administrator("John");
        // set administrator's name
        admin.setName("Lily");
        // get administrator's name
        System.out.println(admin.getName());
        // read the teaching requirements
        System.out.println("Test for reading the teaching requirements");
        ArrayList<TeachingRequirement> teachReq = readTeachReq(admin);
        System.out.println("Test for reading the teaching requirements");
        StringBuilder[][] checkResult = checkPtt(admin);
        System.out.println("Test for training PTTs");
        trainingPTT(admin,checkResult);
    }

    static ArrayList<TeachingRequirement> readTeachReq(Administrator admin) {
        ArrayList<TeachingRequirement> techList = admin.readTeachReq();
        // print out the requirements the admin read
        for (TeachingRequirement t: techList) {
            System.out.println(t);
        }
        return techList;
    }

    static StringBuilder[][] checkPtt(Administrator admin) {
        StringBuilder[][] checkResult = admin.checkPtt(qualified);
        System.out.println("QULIFIED");
        for (int i = 0; i < 9; i++) {
            System.out.println(qualified[i][0]+": "+qualified[i][1]);
        }
        return checkResult;
    }

    static void trainingPTT(Administrator admin,StringBuilder[][] checkResult) {
        try {
            admin.trainingPTT(checkResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}