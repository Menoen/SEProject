package main.java;

import java.util.Arrays;

/*
 * The class Staff extends User and Staff is PTT with attributes course and skill.
 */
public class Staff extends User {
    // Define a String attribute course to store which course the Staff teaches.
    private String course;
    // Define the String array skill to store the Staff's skills.
    private String[] skill;
    // Define the String training to store the Staff's skills.
    private String training;
    // Constructor.
    public Staff(){
        super();
    }
    // Define the get method of course.
    public String getCourse() {
        return course;
    }
    // Define the set method of course.
    public void setCourse(String course) {
        this.course = course;
    }
    // Define the get method of skill.
    public String[] getSkill() {
        return skill;
    }
    // Define the set method of skill.
    public void setSkill(String[] skill) {
        this.skill = skill;
    }
    // Define the get method of training.
    public String getTraining() {
        return training;
    }
    // Define the set method of training.
    public void setTraining(String training) {
        this.training = training;
    }

    @Override
    public String toString() {
        return getName()+"\t"+Arrays.toString(skill)+"\t"+course+"\t"+training;
    }
}

