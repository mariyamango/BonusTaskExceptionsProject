package org.example;

//Test 1: Write a test shouldBeEmptyInitially that
//creates an instance of the GuestList class
//calls the setGuests method with an empty list
//then calls getGuests (the result should be a list of strings)
//and checks that the result is an empty list

//Test 2: Write a test shouldReadSameGuestsAsWrittenBefore that
//creates an instance of the GuestList class
//calls the setGuests method with "Karl" and "Ute"
//then calls getGuests (the result should be a list of strings)
//and checks that the result contains "Karl" and "Ute"

//Test 3: Write a test shouldWriteToFileSystem that
//creates an instance of the GuestList class
//calls the setGuests method with "Theodor" and "Anette"
//and checks that the file guests.txt has been created and contains the lines "Theodor" and "Anette"
// Hint: Define the file path with Path.of("guests.txt")
// Hint: Read and write using the java.nio.file.Files class

//Test 4: Write a test shouldReadFromFileSystem that
//writes "Stephan" and "Max" (as lines) to the file guests.txt
//creates an instance of the GuestList class
//then calls getGuests
//and checks that "Stephan" and "Max" have been read
// Hint: Define the file path with Path.of("guests.txt")
// Hint: Read and write using the java.nio.file.Files class

//Test 5: Write a test that checks if an exception occurs when reading the file that does not exist

//Test 6: Add an addGuest method that takes a string guest as a parameter and writes it as an additional line to the file.

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuestList list = new GuestList();

        try {
            list.setGuests(List.of("Martha","Margaret"));
        }
        catch (Exception e) {
            System.out.println("Something went wrong while using setGuests method");
        }

        try {
            list.addGuest("Fernando");
            list.addGuest("Julia");
            list.addGuest("Harry");
            list.addGuest("Katherina");
        }
        catch (Exception e) {
            System.out.println("Something went wrong while using addGuest method");
        }

        try {
            System.out.println(list.getGuests());
        }
        catch (Exception e) {
            System.out.println("Something went wrong while using getGuests method");
        }
    }
}