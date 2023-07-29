import java.util.Scanner;
import java.util.Scanner;
/*
Program description:
Console program with input validation.
Uses: conditional statements, int validation, switch cases
Recieves a number from user and outputs various calculations and facts.
 */

public class numberGenie {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        //Asks user for a number
        System.out.println("Enter a whole number:");
        String myInput = myScanner.nextLine();
        boolean success = false;

        //Checks if input is a number, if not, ask for intput until it is.
        while (!success) {
            success = true;
            try { //Try to convert input to double
                int myNumber = Integer.parseInt(myInput);
            } catch (NumberFormatException nfe) { //If it throws a format error, print "not a number"
                System.out.println("Hey, that's not a whole number. Try again:");
                myInput = myScanner.nextLine();
                success = false;
            }
        }

        int myNumber = Integer.valueOf(myInput);
        quip(myNumber);


        System.out.println("I can tell you some things about this number:");

        //Checks if input is even
        if (myNumber % 2 == 0) {
            System.out.println(myNumber + " is an even number.");
        } else {
            System.out.println(myNumber + " is an odd number.");
        }


        //Finds square root
        System.out.println("The square root of " + myNumber + " is " + Math.sqrt(myNumber) + ".");


        //Find the factorial (n!) of the number
        if (myNumber < 15) {
            int factorial = 1;
            for (int i = 1; i < (myNumber + 1); i++) {
                factorial *= i;
            }
            System.out.println("The factorial of " + myNumber + " is " + factorial + ".");
        }


        //Checks if input is leap year
        //If value is divisible by 4 AND not divisible by 100, but if it is divisible by 100, must also be by 400
        if (myNumber % 4 == 0 && myNumber % 100 != 0 || (myNumber % 100 == 0 && myNumber % 400 == 0)) {
            System.out.println(myNumber + " is a leap year.");
        }


    }

    //Prints a cultural fact or reference about the number.
    static public void quip(int myNumber){
        switch(myNumber){
            case 3:
                System.out.println("Good things come in 3s! Unless you are the third person in the middle of a photo, according to some superstition.");
                break;
            case 4:
                System.out.println("4 is an unlucky number in Japanese and Chinese culture, as it is the same word for death.");
                break;
            case 7:
                System.out.println("7 is a common lucky number.");
                break;
            case 8:
                System.out.println("8 is a lucky number in China.");
                break;
            case 9:
                System.out.println("9 is my favourite number! Or 12.");
                break;
            case 12:
                System.out.println("12 is my favourite number! Or 9.");
                break;
            case 13:
                System.out.println("13 is a common unlucky number, hence Friday the 13th which falls on one month a year.");
            case 21:
                System.out.println("21 is the sum of 9 + 10.");
                break;
            case 42:
                System.out.println("42 is the meaning of life.");
                break;
            case 62:
                System.out.println("nice.");
                break;
            case 420:
                System.out.println("It feels stale to say 'blaze it!', but you are the one who entered that number.");
                break;
            case 666:
                System.out.println("You're en edge-lord, huh?");
                break;
            default:
                System.out.println(myNumber + " is a good number.");
        }
    }
}
