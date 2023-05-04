/**
 * Name(s): Maison Hollander
 * Programming Assignment: RPG
 * Section 003 
 * May 3, 2023
 */

import java.util.ArrayList;

public class Room {
    String name;
    String description;
    ArrayList<String> exits = new ArrayList<String>();
    
    /**
     * Initialize a room
     * @param name the name of the room
     * @param description the description of the room
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
    /* Generate getters and setters for the naems and descriptions */
    //Sets name of the room
    public void setName(String name) {
        this.name = name;
    }

    //Gets name of the room
    public String getName() {
        return this.name;
    }

    //Sets description
    public void setDescription(String name) {
        this.description = description;
    }

    //Gets description
    public String getDescription() {
        return this.description;
    }

    /**
     * Adds an exit to the room
     * @param exit room name of the exit to be added to the room
     */
    public void addExit(String exit) {
        this.exits.add(exit);
    }

    /**
     * List all of the rooms as a string
     * @return returns all of the names of the rooms on new lines
     */
    public String listExits() {
        //Empty string to add list of exits to
        String listOfExits = "";
        //Loops through arraylist of exits
        for (String exit : exits) {
            //Adds exit to a new line
            listOfExits += (exit + "\n");
        }
        //Returns updated list
        return listOfExits;
    }

    /**
     * Generates a string representation of the room using the name and description and lists all of the exits.
     */
    public String toString() {
        //Empty string to add room information to
        String stringInfo = "";
        //Adds all necessary information to empty string
        stringInfo = this.name + ": " + this.description + "\nExits:\n" + this.listExits();
        //returns updated string
        return stringInfo;
    }
    
}
