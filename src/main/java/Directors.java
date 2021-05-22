package main.java;

import java.io.*;
import java.util.ArrayList;

/*
 * The class Directors extends User and Directors can uploads the teaching requirements
 */
public class Directors extends User {
    private String courseName;
    // Constructor method
    public Directors(String name,String courseName) {
        super(name);
        this.courseName = courseName;
    }

    // The method uploadRequirements can upload the teaching requirements in three arraylists
    public ArrayList<TeachingRequirement> uploadRequirements() {

        FileInputStream f1 = null;
        InputStreamReader i1 = null;
        BufferedReader b1 = null;
        try {
            // TODO
            //f1 = new FileInputStream("src/main/resource/teaching requirement(class directors).txt");
            f1 = new FileInputStream("src/main/resource/teaching_requirements.txt");
            i1 = new InputStreamReader(f1);
            b1 = new BufferedReader(i1);
            String line="";
            String[] arrs=null;
            b1.readLine();
            // Scan each line to read the name, skill and Staff number to store them in arraylists.
            while ((line=b1.readLine())!=null) {
                arrs = line.split(" ");
                // TODO
                TeachingRequirement a = new TeachingRequirement(arrs[0]);
//                a.setCourseName(arrs[0]);
                a.setRequirementName(arrs[1]);
                a.setRequirementStaffNumber(Integer.parseInt(arrs[3]));
                a.setRequirementSkill(arrs[2].split(","));
                listTeachingRequirement.add(a);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try {
                // Close streams
                b1.close();
                i1.close();
                f1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listTeachingRequirement;
    }

    public void inputReq() throws IOException {
        //键盘录入
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new FileWriter("src/main/resource/teaching_requirements.txt"));
        bw.write("courseName requirementName requirementSkills requirementStaffnumber");
        bw.newLine();
        System.out.println("Use spaces to distinguish columns. If more than one skill is required, concatenate them with commas.");
        System.out.println("please input the teaching requirements in the following order:");
        System.out.println("courseName requirementName requirementSkills requirementStaffnumber");
        System.out.println("Use 'end' to terminate the input process!!!");

        String line;
        while(!(line = bfr.readLine()).equals("end")){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //关闭流
        bw.close();
        bfr.close();
    }

    public static void main(String[] args) {
        // TODO
        try {
            new Directors("Linda","Math").inputReq();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO
        ArrayList<TeachingRequirement> list=new Directors("Peter","Japanese").uploadRequirements();
        for (TeachingRequirement i:list) {
            System.out.println(i);
        }
    }
}