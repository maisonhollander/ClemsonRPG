/**
 * Name(s): Maison Hollander
 * Programming Assignment: RPG
 * Section 003 
 * May 3, 2023
 */

import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Driver {
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);  

        //Creates text file
        String fileName = String.format("ListOfRooms.txt");
        FileOutputStream fileStream = null;
        //Catches exception
        try {
            fileStream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find " + fileName);
        }
        PrintWriter outFS = new PrintWriter(fileStream);
        
        //Creates map object
        AdventureMap map = new AdventureMap();
        //Initializes arraylist and will add to it throughout game
        ArrayList<String> roomsLookedIn = new ArrayList<String>();

        //Creates dog object, Luna
        Dog dog = new Dog("Luna");
        dog.setName();
        dog.setDescription();

        //Creates each room in the map
        Room room1 = new Room("Kitchen", "Whenever I'm cooking in the kitchen, Luna will stare and beg until I give her some food. Watch out! Luna likes to jump up on the counter and steal your food if you're not looking.");
        room1.addExit("Living Room");
        room1.addExit("Bedroom");
        map.addRoom(room1);

        Room room2 = new Room("Living Room", "The living room is Luna's favorite place to rest after a long walk. She likes to sleep on the couch and underneath the couch.");
        room2.addExit("Kitchen");
        room2.addExit("Bathroom");
        map.addRoom(room2);

        Room room3 = new Room("Bathroom", "Luna loves bath time! She likes to splash in the water; however, make sure to have a towel on hand after, or else she will get you soaked when she shakes herself dry!");
        room3.addExit("Living Room");
        room3.addExit("Bedroom");
        map.addRoom(room3);

        Room room4 = new Room("Bedroom", "Luna loves to jump up on the bed and snuggle with her favorite toy.");
        room4.addExit("Kitchen");
        room4.addExit("Bathroom");
        map.addRoom(room4);


        //Start of game
        System.out.println("\n*Lost and Found*\nHi, My name is Maison and my dog, Luna, is hiding somewhere in my house.");
        //Ask user if they want to help me find Luna
        System.out.println("Will you help me find Luna? (Yes/No)");
        String willHelp = scnr.nextLine();
        boolean inputNotValid = true;

        //Validates user's input
        while (inputNotValid) {
            //If user says yes, system continues
            if (willHelp.equalsIgnoreCase("yes")) {
                System.out.println("\nGreat! Let's start looking for Luna.");
                //If user wants to end the game before finding Luna, user can enter give up when looking for a room
                System.out.println("If you want to give up during the game, enter Give Up when choosing an exit.");
                inputNotValid = false;
            }
            //If user says no, then system quits
            else if (willHelp.equalsIgnoreCase("no")) {
                System.out.println("Shucks, I guess I'll have to find her by myself. Thanks for nothing.");
                inputNotValid = false;
                System.exit(0);
            }
            //Loops through until user enters valid input
            else {
                System.out.println("Please enter yes or no.");
                willHelp = scnr.nextLine();
                inputNotValid = true;
            }
        }

        //Ask user what room they want to start looking in first for Luna
        System.out.println("\nWhat room would you like to look in first?\nWe can look in the living room, bathroom, kitchen, or the bedroom.");
        String userInput = scnr.nextLine();
        //Adds the room looked in to an arraylsit
        roomsLookedIn.add(userInput);

        boolean notWantToGiveUp = true;
        //Traverses map until boolean is false
        
        while (notWantToGiveUp) {
            String lookForLuna = "";
            inputNotValid = true;

            //Validates user's input
            if (userInput.equalsIgnoreCase("Bathroom")) {
                //Creates object for current room user is in
                Room bathroom = map.getRoom(userInput);

                //Prints room's description and list of exits
                System.out.println("\n" + bathroom.toString());

                //Asks user if they want to look in the bathtub for Luna
                System.out.println("Do you want to look in the bathtub for Luna? (yes/no)");
                lookForLuna = scnr.nextLine();

                //Validates user's input 
                while (inputNotValid) {
                    //If user looks in bathtub, Luna is not found
                    if (lookForLuna.equalsIgnoreCase("yes")) {
                        //Prints Luna's information
                        System.out.println(dog.dogToString());
                        System.out.println("\nIt doesn't look like she's hiding in the bathtub. Let's look in another room.");
                        inputNotValid = false;
                    }
                    //Moves on to the next room
                    else if (lookForLuna.equalsIgnoreCase("no")) {
                        //Prints Luna's information
                        System.out.println(dog.dogToString());
                        System.out.println("\nOkay, we can look in another room!");
                        inputNotValid = false;
                    }
                    //Asks user to try again if input is not valid
                    else {
                        System.out.println("Please enter yes or no.");
                        lookForLuna = scnr.nextLine();
                        inputNotValid = true;
                    }
                }

                //Asks user to pick an exit
                System.out.println("Please choose an exit");
                userInput = scnr.nextLine();
                roomsLookedIn.add(userInput);
            }
            else if (userInput.equalsIgnoreCase("Kitchen")) {
                //Creates object for current room user is in
                Room kitchen = map.getRoom(userInput);
                //Prints room's description and list of exits
                System.out.println("\n" + kitchen.toString());

                //Asks the user if they want to look for Luna behind the counter
                System.out.println("Do you want to look for Luna behind the counter? (yes/no)");
                lookForLuna = scnr.nextLine();

                //Validates the user's input
                while (inputNotValid) {
                    //If user enters yes, then look in behind counter
                    if (lookForLuna.equalsIgnoreCase("yes")) {
                        //Prints Luna's information
                        System.out.println(dog.dogToString());
                        System.out.println("\nI don't see Luna behind the counter. Let's look in another room.");
                        inputNotValid = false;
                    }
                    //If user enters no, move onto next room
                    else if (lookForLuna.equalsIgnoreCase("no")) {
                        //Prints Luna's information
                        System.out.println(dog.dogToString());
                        System.out.println("\nOkay, we can look in another room!");
                        inputNotValid = false;
                    }
                    //Asks user to try again if input not valid
                    else {
                        System.out.println("Please enter yes or no.");
                        lookForLuna = scnr.nextLine();
                        inputNotValid = true;
                    }
                }

                //Asks user to pick an exit
                System.out.println("Please choose an exit");
                userInput = scnr.nextLine();
                roomsLookedIn.add(userInput);
            }
            else if (userInput.equalsIgnoreCase("Living Room")) {
                //Creates object for current room user is in
                Room livingRoom = map.getRoom(userInput);
                //Prints room's description and list of exits
                System.out.println("\n" + livingRoom.toString());

                System.out.println("Should we check for Luna underneath the couch? (yes/no)");
                lookForLuna = scnr.nextLine();

                while (inputNotValid) {
                    //If user enters yes, checks under couch
                    if (lookForLuna.equalsIgnoreCase("yes")) {
                        //Prints Luna's information
                        System.out.println(dog.dogToString());
                        System.out.println("\nI don't see her under the couch. Let's look in another room.");
                        inputNotValid = false;
                    }
                    //if user enters no, then move on to next room
                    else if (lookForLuna.equalsIgnoreCase("no")) {
                        //Prints Luna's information
                        System.out.println(dog.dogToString());
                        System.out.println("\nOkay, we can look in another room!");
                        inputNotValid = false;
                    }
                    //Asks user to try again if input not valid
                    else {
                        System.out.println("Please enter yes or no.");
                        lookForLuna = scnr.nextLine();
                        inputNotValid = true;
                    }
                }

                //Asks user to pick an exit
                System.out.println("Please choose an exit");
                userInput = scnr.nextLine();
                roomsLookedIn.add(userInput);
            }
            else if (userInput.equalsIgnoreCase("Bedroom")) {
                //Creates object for current room user is in
                Room bedroom = map.getRoom(userInput);
                //Prints room's description and list of exits
                System.out.println("\n" + bedroom.toString());

                System.out.println("Do you want to look for Luna in the closet? (yes/no)");
                lookForLuna = scnr.nextLine();

                while (inputNotValid) {
                    //Luna is hiding in the closet
                    if (lookForLuna.equalsIgnoreCase("yes")) {
                        //Luna's state is updated to found when the user looks
                        dog.updateState("found");
                        //Outputs Luna's information
                        System.out.println(dog.dogToString());
                        notWantToGiveUp = false;
                        inputNotValid = false;
                    }
                    else if (lookForLuna.equalsIgnoreCase("no")) {
                        //If user does not look in the clost, then Luna's state is not updated
                        //Outputs Luna's information
                        System.out.println(dog.dogToString());
                        System.out.println("\nOkay, we can look in another room!");
                        inputNotValid = false;

                        //Asks user to pick an exit
                        System.out.println("Please choose an exit");
                        userInput = scnr.nextLine();
                        roomsLookedIn.add(userInput);
                    }
                    //Asks user to try again if input not valid
                    else {
                        System.out.println("Please enter yes or no.");
                        lookForLuna = scnr.nextLine();
                        inputNotValid = true;
                    }
                }
            }
            //If user wants to give up, game ends
            else if (userInput.equalsIgnoreCase("Give up")) {
                notWantToGiveUp = false;
                System.out.println("Thanks for trying to help me find Luna.");

                //Removes "give up" from the arraylist since thats not a room
                roomsLookedIn.remove(roomsLookedIn.size() - 1);
                //Prints rooms looked in to text file
                outFS.println("Rooms looked in: " + roomsLookedIn);
                outFS.close();
                System.exit(0);
            }
            //If user input is not a valid room, user tries again
            else {
                System.out.println("\nInvalid exit. Please try again.");
                userInput = scnr.nextLine();
            }

        }
        //Congratulates user on finding Luna
        System.out.println("\nYAY! We found Luna! Thank you so much for helping me find her.");
        
        //Asks user if they want to give Luna a treat before ending game
        System.out.println("Before you go, would like to give Luna a treat?");
        System.out.println("A) Give Luna a treat \nB) Don't give Luna a treat");
        String giveTreat = scnr.nextLine();

        inputNotValid = true;
        //Validates user's input
        while (inputNotValid) {
            //If user wants to give Luna a treat 
            if (giveTreat.charAt(0) == 'A' || giveTreat.charAt(0) == 'a') {
                //Update user's state
                dog.updateState("wagging tail");
                //Outputs Luna's updated information
                System.out.println(dog.dogToString());
                System.out.println("Her tail is wagging! That means she's happy.");
                inputNotValid = false;
            }
            //If user does not want to give Luna a treat
            else if (giveTreat.charAt(0) == 'B' || giveTreat.charAt(0) == 'b') {
                //Update Luna's state
                dog.updateState("whimpering");
                //Output Luna's information
                System.out.println(dog.dogToString());
                System.out.println("\nAw, now Luna is sad because she doesn't get a treat.");
                inputNotValid = false;
            }
            //Prompts user to try again
            else {
                System.out.println("Please enter A or B.");
                giveTreat = scnr.nextLine();
                inputNotValid = true;
            }
        }
        
        System.out.println("\nHave a good day!");
        //Print's rooms looked in to text file
        outFS.println("Rooms looked in: " + roomsLookedIn);
        outFS.close();
    }

}

