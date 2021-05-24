package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Auther: Weiwei Zhao
 * @Matric: 2586561Z
 * @Date: 22:25 2021/5/22
 * @Desc:
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        System.out.println("Start directors");
        Scanner sc = null;
        // the flag which director choose to upload requirements, null is initial, 0 is manual, other is automatic
        String wayFlag = null;
        while(true) {
            System.out.println("Please enter 'no' to exit or any other words to continue: ");
            sc = new Scanner(System.in);
            String continueFlag = sc.next();
            if("no".equals(continueFlag)){
                break;
            } else {
                Directors directors1 = (Directors) UserFactory.createUser("director");
                wayFlag = directors1.chooseInputway(wayFlag);
                if ("1".equals(wayFlag)) {
                    // wayFlag is 1 means the director choose uploading by file, so no need to upload continually
                    break;
                }
            }
        }
        ArrayList<TeachingRequirement> listTeachReq = ListOfTeachingReq.getListTeachingRequirement();
        System.out.println("------------------------------------");
        System.out.println("OUTPUT requirements");
        for (TeachingRequirement req:listTeachReq) {
            System.out.println(req);
        }
        System.out.println("Finish enter the teaching requirements, now start the administrator");
        Administrator admin = new Administrator();
        // Administrator read the teaching requirement
        System.out.println("------------------------------------");
        System.out.println("Administrator read the teaching requirement");
        System.out.println("The administrator obtains teaching requirements from the director");
        ArrayList<TeachingRequirement> listTeachReqRead = admin.readTeachReq();
        for (TeachingRequirement req:listTeachReqRead) {
            System.out.println(req);
        }
        System.out.println("------------------------------------");

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
            admin.trainingPTT(qualified);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
