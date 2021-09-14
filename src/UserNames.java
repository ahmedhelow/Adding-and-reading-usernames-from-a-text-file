/*
Ahmed Helow
ahmedhelow@live.com
SID: 950719096.
03/03/2020
First thing the program do, it prints all the user names in the file, then it adds a new username from the user into the file and it has to achieve 6 conditions,
if one of the conditions is wrong it prints out on the screen which of the 6 conditions is not achieved, and repeat the same process again,
if the username achieve all the conditions that means its valid, and then add the new username into the file for another use, and print out all the user names again on the screen.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.PrintStream;
public class UserNames {
    static String[] errmsg = new String[7];
    static int numberOfusers=0;
    static int max=60;
    static String[] usernames= new String[max] ;
    static String username;
    public static void main(String[] args)  throws FileNotFoundException{
        File file = new File("users.txt");
        Scanner input= new Scanner(file);

        while (input.hasNext()){ //Add the user names from the file to an array.
            usernames[numberOfusers]=input.next();
            numberOfusers++;
        }
        System.out.println("List of usernames: ");
        for (int i = 0; i <numberOfusers ; i++) { // The for loop print out the array on screen.
            System.out.println(usernames[i]);
        }
        System.out.println("");
        LoadErrorMessage();
        boolean correct = false;
        while (correct == false) {
            Scanner console = new Scanner(System.in);
            System.out.print("Enter a new user: ");
            username = console.next();

            if (checknumber(username)==false || checklength(username)==false || checkspecialchar(username)==false || checksmall(username)==false || checkcapital(username)==false || checkvalid(username)==false || checkstart(username)==false){
                System.out.println("Invalid name.");
                correct=false; // make the while loop repeat again if one of the conditions not achieved.
            }
            else {
                System.out.println("User \""+ username + "\" added successfully.") ;
                correct=true; // make the while loop end and not repeat again.
            }
            if (checkstart(username)==false){
                System.out.println(errmsg[6]);
            }
            if (checklength(username)==false){
                System.out.println(errmsg[0]);
            }
            if (checknumber(username)==false){
                System.out.println(errmsg[1]);
            }
            if (checkspecialchar(username)==false){
                System.out.println(errmsg[2]);
            }
            if (checkcapital(username)==false){
                System.out.println(errmsg[3]);
            }
            if (checksmall(username)==false){
                System.out.println(errmsg[4]);
            }
            if (checkvalid(username)==false){
                System.out.println(errmsg[5]);
            }
            System.out.println("");
        }
        usernames[numberOfusers]=username; // Add the new valid username to the array.
        System.out.println("list of usernames: ");
        PrintStream out= new PrintStream(new File("users.txt")); // To add the new username into the file.
        for (int i = 0; i <numberOfusers+1 ; i++) {
            System.out.println(usernames[i]); // print out the array with all the user names.
            out.println(usernames[i]); //to add all the user names into the file.
        }
    }
    public static void LoadErrorMessage() {
        errmsg[0] = "Username must be between 4 and 7 characters.";
        errmsg[1] = "Username must contain at least one number.";
        errmsg[2] = "Username must contain a special character.";
        errmsg[3] = "Username must have upper-case letter.";
        errmsg[4] = "Username must have lower-case letter.";
        errmsg[5] = "Name already in use.";
        errmsg[6] = "Username must start with a letter.";
    }

    public static boolean checklength(String username) {
        if (username.length()>=4 && username.length()<=7){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean checknumber(String username){
        for (int i = 0; i <username.length() ; i++) {
            if (Character.isDigit(username.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean checkspecialchar(String username){
        for (int i = 0; i <username.length() ; i++) {
            if (username.charAt(i) == '!' || username.charAt(i) == '?' || username.charAt(i) == '#' || username.charAt(i) == '%') {
                return true;
            }
        }
        return false;
    }

    public static boolean checkcapital(String username){
        for (int i = 0; i <username.length() ; i++) {
            if (Character.isUpperCase(username.charAt(i))){
                return true;
            }}
        return false;
    }

    public static boolean checksmall(String username){
        for (int i = 0; i <username.length() ; i++) {
            if (Character.isLowerCase(username.charAt(i))){
                return true;
            }}
        return false;
    }

    public static boolean checkvalid(String username){
        for (int i = 0; i <numberOfusers ; i++) {
            if (username.equals(usernames[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkstart(String username){
        username=username.toUpperCase();
        if (username.charAt(0)>=65 && username.charAt(0)<=90){
            return true;
        }
        else return false;
    }
}


