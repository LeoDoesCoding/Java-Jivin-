package fileReader;

import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Paths;
/*
Program description:
Console program.
uses: File reading, conditional statements, objects, override methods
Reads info from a text file and creates objects from this data.
 */


public class fileReader {
    public static void main(String[] args) {
        ArrayList<People> people = new ArrayList<>();

        //Get text file path of the same directory
        URL path = fileReader.class.getResource("people.txt");

        //Obtain file and create objects from data
        try(Scanner myScanner = new Scanner(Paths.get(path.toString().replace("file:/", "")))){
            while (myScanner.hasNextLine()){
                people.add(new People(myScanner.nextLine().split(":")));
            }
        } catch (Exception e){
            System.out.println("File doesn't exist innit.");
        }

        //Print info from file
        for (People person : people){
            System.out.println(person);
        }
    }
}
