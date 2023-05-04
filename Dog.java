/**
 * Name(s): Maison Hollander
 * Programming Assignment: RPG
 * Section 003 
 * May 3, 2023
 */

public class Dog {
    String name;
    String description; 
    String state;

    //Constructor for dog class
    public Dog(String name) {
        this.name = name;
        this.description = "Bark! Bark!"; 
        this.state = "hiding";
    }

    //Set dog's name
    public void setName() {
        this.name = name;
    }

    //Get dog's name
    public String getName(String name) {
        return this.name;
    }

    //get dog's description
    public String getDescription(String description) {
        return this.description;
    }

    //Set dog's description
    public void setDescription() {
        this.description = description;
    }

    //Update dog's state
    public void updateState(String update) {
        state = update;
    }

    //toString method to return dog's information
    public String dogToString() {
        //Empty string to add dog information to
        String stringInfo = "";
        //Adds all necessary information to empty string
        stringInfo = this.name + ": " + "'" + this.description + "'" + "\nState: " + this.state;
        //returns updated string
        return stringInfo;
    }



}