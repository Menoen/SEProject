package main.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        System.out.println("Start directors");
        // process of directors
        processDirector();
        // process of administrator
        processAdmin();
    }

    /**
     * the process using by directors
     */
     static void processDirector() {
        Scanner sc = null;
        // the flag which director choose to upload requirements, null is initial, 0 is manual, other is automatic
        String wayFlag = null;
        while (true) {
            String continueFlag = "";
            if ("no".equals(continueFlag)) {
                break;
            } else {
                Directors directors1 = (Directors) UserFactory.createUser("director");
                try {
                    wayFlag = directors1.chooseInputway(wayFlag);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if ("1".equals(wayFlag)) {
                    // wayFlag is 1 means the director choose uploading by file, so no need to upload continually
                    break;
                }
            }
            System.out.println("Please enter 'no' to exit or any other words to continue: ");
            sc = new Scanner(System.in);
            continueFlag = sc.next();
        }
    }

    /**
     * the process using by the administrator
     */
    static void processAdmin() {
        // initialise the list of teaching requirements
        ArrayList<TeachingRequirement> listTeachReq = ListOfTeachingReq.getListTeachingRequirement();
        System.out.println("------------------------------------");
        System.out.println("OUTPUT requirements");
        for (TeachingRequirement req:listTeachReq) {
            System.out.println(req);
        }
        System.out.println("Finish enter the teaching requirements, now start the administrator");
        Administrator admin = (Administrator) UserFactory.createUser("admin");
        System.out.println("------------------------------------");
        System.out.println("Administrator read the teaching requirement");
        System.out.println("The administrator obtains teaching requirements from the director");
        // the teaching requirement list administrator read
        ArrayList<TeachingRequirement> listTeachReqRead = admin.readTeachReq();
        for (TeachingRequirement req:listTeachReqRead) {
            System.out.println(req);
        }
        System.out.println("------------------------------------");
        // check staff information
        admin.checkPtt();
        for (Staff i:ListOfStaff.getListOfStaffs()) {
            System.out.println(i);
        }
        System.out.println("------------------------------------");

        StringBuilder[][] qualified = admin.comparePttWithReq();
        for (int i = 0; i < listTeachReq.size(); i++) {
            System.out.println(qualified[i][0]+": "+qualified[i][1]);
        }
        System.out.println("------------------------------------");
        System.out.println("Please review the staff_information file for training information");
        try {
            // organise training for PTT
            admin.trainingPTT(qualified);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
