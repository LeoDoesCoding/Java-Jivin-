import java.util.Scanner;
/*
Program description:
Console program with input validation.
uses: Conditional statements, for loops
Allows user to enter a username and if present in list, allows up to 5 password attempts. Matches list indexes to check validity of password->username.
 */

public class login {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String[] usernames = {"Amanda", "Jake", "Daniel"};
        String[] passwords = {"abc", "password", "123"};


        System.out.println("Enter a username:");
        String input = myScanner.nextLine();
        boolean found = false;
        int index = 0;

        //Until username is found, loop
        while (!found){
            //Look for username
            for (int i = 0; i < usernames.length; i++){
                if (usernames[i].equals(input)){
                    found = true;
                    index = i;
                    break;
                }
            }
            //If username not found, ask user to try again and search again
            if (!found){
                System.out.println("Username not found. Please try again:");
                input = myScanner.nextLine();
            }
        }


        //Asks user to enter password
        System.out.println("Username accepted. Enter password:");
        input = myScanner.nextLine();


        //Attempts password, if incorrect, allow 4 more attempts.
        for (int i = 0; i <= 3; i++) {
            //Check if password matches username
            if (passwords[index].equals(input)) {
                System.out.println("Login successful.");
                break;
            } else {
                System.out.println("Incorrect password. You have " + Integer.valueOf(4 - i) + " more attempts.");
                input = myScanner.nextLine();
            }
        }
        //If attempts have run out and the last attempt was unsuccessful, tell user they have run out of attempts
        if (!passwords[index].equals(input)) {
            System.out.println("You have run out of attempts, login failed.");
        }
    }
}