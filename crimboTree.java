import java.util.Scanner;
/*
Program description:
Console program.
Recieves an integer from the user and outputs an ASCII tree with the height recieved, getting wider towards the bottom.
 */

public class crimboTree {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a height:");
        String myTree = christmasTree(Integer.valueOf(myScanner.nextLine()));
        System.out.println(myTree);
    }

    //Returns string of height entered
    public static String christmasTree(int height){
     String output = "";

     //Loop for number of stars
     for (int i = 1; i <= height+1; i++){
         output += spaces(height-i); //Add spaces

         //Stars (start at 2, incerase by 1 until at layerx2 - 1)
         for (int k = 2; k < i*2-1; k++){
             output += "*";
         }

         output += "\n";
     }
     //Trunk
     for (int i = 0; i < 3; i++){
        output += spaces(height-3) + "***\n";
     }
     return (output);
    }

    //Adding spaces
    public static String spaces(int spaces){
        String output = "";
        //Spaces = number of stars - i
        for (int j = 0; j <= spaces; j++){
            output += " ";
        }
        return(output);
    }
}
