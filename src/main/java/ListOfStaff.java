package main.java;

import java.util.ArrayList;

public class ListOfStaff implements List{
    private static ArrayList<Staff> listOfStaffs=new ArrayList<Staff>();

    public static ArrayList<Staff> getListOfStaffs() {
        return listOfStaffs;
    }
    public static void add(Staff s){
        listOfStaffs.add(s);
    }
}
