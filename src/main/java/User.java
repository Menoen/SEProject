package main.java;

/*
* This class User is the father class of all the employees classes in the company.
*/
public class User {
    // Define the User's name as a private attribute.
    private String name;
    // Constructor
    public User(){
        super();
    }
    // Get the name.
    public String getName() {
        return name;
    }
    // Set the name.
    public void setName(String name) {
        this.name = name;
    }
}
