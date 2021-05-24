package main.java;

import java.util.ArrayList;

public class ListOfTeachingReq implements List {
    private static final ArrayList<TeachingRequirement> listTeachingRequirement=new ArrayList<>();
    public static ArrayList<TeachingRequirement> getListTeachingRequirement() {
        return listTeachingRequirement;
    }
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
