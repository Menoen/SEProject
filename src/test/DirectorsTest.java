import main.java.Directors;
import main.java.ListOfTeachingReq;
import main.java.TeachingRequirement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  1. Test the process in normal way.
 *  2. When choosing the way to upload, verifying if the different characters we input can lead us to the correct method.
 * 	3. Verifying the upload is successful or not when choosing to upload a file by printing out the list of requirements.
 * 	4. When selecting manual input, verify whether it can be successfully uploaded when input one or two skills by printing out the list of requirements.
 * 	5. When selecting manual input, verify whether it can be successfully uploaded when input more than two skills by printing out the list of requirements.
 */
class DirectorsTest {
    public static void main(String[] args) throws IOException {
        // Test1
        Directors directors = new Directors();
        // Test for setter
        directors.setCourseName("Hisis");
        // Test for getter
        System.out.println(directors.getCourseName());
        // Test chooseInputway()
        directors.chooseInputway(null);
        directors.chooseInputway("1");
        ArrayList<TeachingRequirement> listTeachReq = ListOfTeachingReq.getListTeachingRequirement();
        System.out.println("OUTPUT of the uploadRequirements()");
        for (TeachingRequirement req:listTeachReq) {
            System.out.println(req);
        }
        System.out.println("----------Please input teaching requirements manually----------");
        directors.chooseInputway("0");
        ArrayList<TeachingRequirement> listTeachReq1 = ListOfTeachingReq.getListTeachingRequirement();
        System.out.println("OUTPUT of the inputReq()");
        for (TeachingRequirement req:listTeachReq) {
            System.out.println(req);
        }
        System.out.println("-------If the director enters an incorrect selection, the file is read by default-------");
        directors.chooseInputway("ahsdoas"); // the result should be like wayFlag=="1"
        ArrayList<TeachingRequirement> listTeachReq2 = ListOfTeachingReq.getListTeachingRequirement();
        System.out.println("OUTPUT of the uploadRequirements()");
        for (TeachingRequirement req:listTeachReq) {
            System.out.println(req);
        }
    }
}