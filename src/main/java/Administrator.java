package main.java;

import java.io.*;
import java.util.*;

public class Administrator extends User {
    public Administrator() {
        super();
    }
//    private static StringBuilder[][] qualified = new StringBuilder[10][2];

    public static void main(String[] args){
        try {
            new Directors().chooseInputway();//新增
        } catch (IOException e) {
            e.printStackTrace();
        }

        Administrator admin=new Administrator();
        System.out.println("The administrator obtains teaching requirements from the director");
        ArrayList<TeachingRequirement> listTeachReq = admin.readTeachReq();
        for (TeachingRequirement req:listTeachReq) {
            System.out.println(req);
        }
        System.out.println("------");

        admin.checkPtt();
        for (Staff i:ListOfStaff.getListOfStaffs()) {
            System.out.println(i);
        }
        System.out.println("------");

        StringBuilder[][] qualified = admin.comparePttWithReq();
        for (int i = 0; i < listTeachReq.size(); i++) {
            System.out.println(qualified[i][0]+": "+qualified[i][1]);
        }
        System.out.println("------");

//        System.out.println("The administrator checks the teacher’s information and looks for qualified teachers for each course");
//        StringBuilder[][] qualified = new StringBuilder[listTeachReq.size()][2];
//        qualified= admin.checkPtt();
//        for (int i = 0; i < listTeachReq.size(); i++) {
//            System.out.println(qualified[i][0]+": "+qualified[i][1]);
//        }
//        System.out.println("------");
//
        System.out.println("Please review the staff_information file for training information");
        try {
            admin.trainingPTT(qualified);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<TeachingRequirement> readTeachReq(){
        ArrayList<TeachingRequirement> listTeachReq = ListOfTeachingReq.getListTeachingRequirement();
        return ListOfTeachingReq.getListTeachingRequirement();
    }

    public void checkPtt(){
        //ListOfStaff listOfStaff=new ListOfStaff();
        BufferedReader reader=null;
        try {
            reader = new BufferedReader(new FileReader("src/main/resource/staff_information.csv"));
            reader.readLine();//Read the first line of the file (column header)
            String line;

            while ((line = reader.readLine()) != null) {
                String[] pttInfo = line.split(",");
                Staff s=new Staff();
                s.setName(pttInfo[0]);
                //the first column (index=0) is the teacher's name,
                // now we want to get their skills (index from 1, may more than one)
                String[] skills=new String[pttInfo.length-1];
                int col = 1;
                while (pttInfo.length>col) {
                    skills[col-1]=pttInfo[col];
                    col++;
                }
                s.setSkill(skills);
                ListOfStaff.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public StringBuilder[][] comparePttWithReq(){
        ArrayList<Staff> list=ListOfStaff.getListOfStaffs();
        ArrayList<TeachingRequirement> listTeachReq=readTeachReq();

        StringBuilder[][] qualified=new StringBuilder[listTeachReq.size()][2];

        for (int i = 0; i < listTeachReq.size(); i++) {
            int num = 0;//We use num to represent how many teacher can fulfill each lab's requirements
            StringBuilder qualifiedTeacher = new StringBuilder();

            String course=listTeachReq.get(i).getCourseName();
            String req=listTeachReq.get(i).getRequirementName();
            String[] reqSkill=listTeachReq.get(i).getRequirementSkill();
            int staffNum=listTeachReq.get(i).getRequirementStaffNumber();

            for (int j = 0; j < list.size(); j++) {
                if(equals(reqSkill,list.get(j).getSkill())){//check whether the teacher can fulfill the required skill(s)
                    if(num<staffNum){//if more than the staffNum we need, we only train the teachers who appear early in the file
                        qualifiedTeacher.append(list.get(j).getName()).append("\t");
                    }
                    num++;
                }
            }
            qualified[i][0]=new StringBuilder(course+","+req);//courses' name and lab's name
            qualified[i][1]=qualifiedTeacher;//All teachers who meet the requirements of the course
        }

        return qualified;
    }

    public void trainingPTT(StringBuilder[][] checkResult) throws IOException{

        File tmpFile = File.createTempFile("data", "csv");
        PrintWriter writer= new PrintWriter(new FileWriter(tmpFile));

        File srcFile = new File("src/main/resource/staff_information.csv");
        BufferedReader reader = new BufferedReader(new FileReader(srcFile));

        writer.write(reader.readLine()+"\n");//Read the first line of the file (column header) then write to the file

        String line1;
        while ((line1 = reader.readLine()) != null) {
            boolean flag=false;//flag represents whether this row has been written to the file or not
            String[] pttInfo = line1.split(",");

            //Traverse the array and check to see if it contains the name of the teacher in the current row
            for (int i = 0; i < checkResult.length; i++) {
                String[] courseInfo=checkResult[i][0].toString().split(",");
                //System.out.print(checkResult[i][1].toString());
                //System.out.println(pttInfo[0]);
                if (checkResult[i][1].toString().contains(pttInfo[0])){
                    //System.out.println("peidaole");
                    flag=true;
                    int j=0;
                    while (j<pttInfo.length){//write the teacher's info to this row, more than one column
                        writer.print(pttInfo[j]+",");
                        j++;
                    }
                    if(pttInfo.length==2){//if the teacher only has one skill, this column should be null
                        writer.print("");
                        writer.print(",");
                    }
                    writer.print(courseInfo[0]);//the course name the teacher will teach
                    writer.print(",");
                    writer.print(courseInfo[1]);//the training name the teacher will be trained
                    writer.println();
                }
            }
            if(!flag){
                //System.out.println("meiyou");
                writer.println(line1);//this teacher don't meet the requirement, write his info to the row without change
            }
        }

        reader.close();
        writer.close();
        tmpFile.renameTo(srcFile);
    }

    //The only concern is whether the teacher’s skills meet the requirements,
    // which is independent of the order. For example, “A, B” is the same as "B, A”
    public static boolean equals(Object[] a, Object[] b) {
        return a.length == b.length && Arrays.asList(a).containsAll(Arrays.asList(b));
    }
}
