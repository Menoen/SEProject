package main.java;

import java.util.ArrayList;

public class ListOfTeachingReq implements List {
    private static ArrayList<TeachingRequirement> listTeachingRequirement=new ArrayList<>();
    public static ArrayList<TeachingRequirement> getListTeachingRequirement() {
        return listTeachingRequirement;
    }
    public void add(TeachingRequirement a) {
        this.listTeachingRequirement.add(a);
    }
}
