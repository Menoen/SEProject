package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * The class Directors extends User and Directors can uploads the teaching requirements
 */
public class Directors extends User {
    String courseName;
    public Directors() {
        super();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // The method uploadRequirements can upload the teaching requirements in three arraylists
    public void uploadRequirements() {
        FileInputStream f1 = null;
        InputStreamReader i1 = null;
        BufferedReader b1 = null;
        ListOfTeachingReq lot=new ListOfTeachingReq();
        try {
            // TODO
            f1 = new FileInputStream("src/main/resource/teaching requirement(class directors).txt");
            i1 = new InputStreamReader(f1);
            b1 = new BufferedReader(i1);
            String line = "";
            String[] arrs;
            b1.readLine();
            // Scan each line to read the name, skill and Staff number to store them in arraylists.
            while ((line = b1.readLine()) != null) {
                arrs = line.split(" ");
                // TODO
                TeachingRequirement a = new TeachingRequirement();
                a.setCourseName(arrs[0]);
                a.setRequirementName(arrs[1]);
                a.setRequirementStaffNumber(Integer.parseInt(arrs[3]));
                a.setRequirementSkill(arrs[2].split(","));
                lot.add(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close streams
                b1.close();
                i1.close();
                f1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void inputReq() throws IOException {
        //键盘录入
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resource/teaching_requirements.txt"));
        bw.write("courseName requirementName requirementSkills requirementStaffnumber");
        bw.newLine();
        System.out.println("Use spaces to distinguish columns. If more than one skill is required, concatenate them with commas.");
        System.out.println("please input the teaching requirements in the following order:");
        System.out.println("courseName requirementName requirementSkills requirementStaffnumber");
        System.out.println("Your input will be stored in the file: 'src/main/resource/teaching_requirements.txt'");
        System.out.println("Use 'end' to terminate the input process!!!");

        String line;
        while (!(line = bfr.readLine()).equals("end")) {
            bw.write(line);
            String[] s = line.split(" ");
            TeachingRequirement a =new TeachingRequirement();
            a.setCourseName(s[0]);
            a.setRequirementName(s[1]);
            a.setRequirementStaffNumber(Integer.parseInt(s[3]));
            a.setRequirementSkill(s[2].split(","));
            new ListOfTeachingReq().add(a);
            bw.newLine();
            bw.flush();
        }
        //关闭流
        bw.close();
    }
    public String chooseInputway(String wayFlag) throws IOException {
        final String zero = "0";
        if(wayFlag!=null) {
            // last time the director choosed 1 or 0
            if (zero.equals(wayFlag)) {
                this.inputReq();
            } else {
                this.uploadRequirements();
            }
            return wayFlag;
        }
        System.out.println("Choose one input way:");
        System.out.println("If you want to input by file 'teaching requirement(class directors)'");
        System.out.println("Please input 1");
        System.out.println("If you want to input by yourself");
        System.out.println("Please input 0");
        Scanner s = new Scanner(System.in);
        String nextLine = s.nextLine();
        if(zero.equals(nextLine)) {
            this.inputReq();
        } else {
            this.uploadRequirements();
        }
        // return the system in to make the next director to choose the same input way
        return nextLine;
    }

//    public static void main(String[] args) throws IOException {
//        new Directors("English").chooseInputway(null);
//        ArrayList<TeachingRequirement> listTeachReq = ListOfTeachingReq.getListTeachingRequirement();
//        for (TeachingRequirement req:listTeachReq) {
//            System.out.println(req);
//        }
//    }
}
