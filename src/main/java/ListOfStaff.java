package main.java;

import java.util.ArrayList;

public class ListOfStaff implements List{
    private static ArrayList<Staff> listOfStaffs = new ArrayList<>();

    public static ArrayList<Staff> getListOfStaffs() {
        return listOfStaffs;
    }
    public static void add(Staff s){
        listOfStaffs.add(s);
    }
    private ListOfStaff() {
        super();
    }
    private static ListOfStaff lf = new ListOfStaff();
    public  static ListOfStaff instance() {
        return lf;
    }
}
