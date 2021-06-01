package main.java;

import java.util.ArrayList;

public class ListOfTeachingReq implements List {
    // the listTeachingRequirement is an arraylist contains teaching requirements
    private static final ArrayList<TeachingRequirement> listTeachingRequirement=new ArrayList<>();
    public static ArrayList<TeachingRequirement> getListTeachingRequirement() {
        return listTeachingRequirement;
    }
    // using singleton pattern
    public void add(TeachingRequirement t) {
        listTeachingRequirement.add(t);
    }
    private ListOfTeachingReq() {
        super();
    }
    private static ListOfTeachingReq lf = new ListOfTeachingReq();
    public  static ListOfTeachingReq instance() {
        return lf;
    }
}

