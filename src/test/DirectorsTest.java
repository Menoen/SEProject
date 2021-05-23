import main.java.Directors;
import main.java.ListOfTeachingReq;
import main.java.TeachingRequirement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Auther: Weiwei Zhao
 * @Matric: 2586561Z
 * @Date: 9:08 2021/5/21
 * @Desc:
 */
class DirectorsTest {
    public static void main(String[] args) {
        Directors directors = new Directors();
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter the way you want to use:(1 for auto, other for manual)");
        String num = sc.nextLine();
        // auto is inputting "1"
        final String AUTOFLAG = "1";
        if(AUTOFLAG.equals(num)) {
            // input automatically
            uploadRequirements(directors);
        } else{
            // input manually
            inputReq(directors);
        }

    }
    static void uploadRequirements(Directors directors) {
        directors.uploadRequirements();
        for (TeachingRequirement i:ListOfTeachingReq.getListTeachingRequirement()) {
            System.out.println(i);
        }
    }
    static void inputReq(Directors directors) {
        try {
            directors.inputReq();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}