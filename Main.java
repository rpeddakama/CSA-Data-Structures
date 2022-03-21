/*
Creator: Rishi Peddakama
*/

/* 
Imports allow you to use code already written by others.  
Java has many standard libraries. The names around the dots in import often give you a hint to the originator of the code.
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner; //java library for user input
import src.Blueprint;
import src.Exit;
import src.Matrix;
import src.Sample;
import src.Swap;

/**
 * Main - entry point class for this project
 * 1.'C' and Java have a main function/method that is the ENTRY into code
 * execution. Both languages need a file to contain that ENTRY method/function.
 * Common convention for 'C': main.c. Convention for Java: Main.java.
 * 2. Replit requires a "Main.java" file and a main class ("public Class Main").
 * Inside the class it expects a method named "public static void main(String[]
 * args)"."
 * 3. Conventions and structures are part of a programming language and the
 * tools you use. Python people like to pick on these Java conventions, saying
 * they are difficult. What do you think?
 */
public class Main { // Everything in Java is inside a class, Squigs, Squigalies, or Curly brackets
                    // denote a code block in Java. This is the beginning of class code block.

    /**
     * main - entry point method for this project
     * main is the entry or pri·mor·di·al code block for Java
     */

    static public void main(String[] args) { // open squig begins the method
        ArrayList<ArrayList<Blueprint>> options = new ArrayList<ArrayList<Blueprint>>();
        ArrayList<Blueprint> week0 = new ArrayList<Blueprint>();
        ArrayList<Blueprint> week1 = new ArrayList<Blueprint>();

        week0.add(new Swap("swap"));
        week0.add(new Matrix("matrix"));
        week0.add(new Exit("exit"));

        while (true) {
            menu(options);
        }
    } // close squig ends the method. What did this method do?

    /**
     * menu - method that is activated by main, this will perform Java code
     */
    public static void menu(ArrayList<ArrayList<Blueprint>> options) {
        System.out.println("Which Weeks Challenges Would You Like to Access?");
        for (int i = 0; i < options.size(); i++)
            System.out.println("Week " + i);

        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            options.get(choice - 1).run();
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Invalid input");
        }

        // if (scanner != null)
        // scanner.close();
    }

}