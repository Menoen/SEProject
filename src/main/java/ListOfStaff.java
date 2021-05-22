package main.java;

import java.util.ArrayList;

public class ListOfStaff {
    /**
     * ArrayList of staffs(PTTs)
     */
    ArrayList<Staff> staffList = new ArrayList<Staff>();

    public ArrayList<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(ArrayList<Staff> staffList) {
        this.staffList = staffList;
    }

}