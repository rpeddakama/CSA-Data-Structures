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
import src.Sample;
import src.Week0.Matrix;
import src.Week0.Swap;
import src.Week1.MergeQueue;
import src.Week1.QueueAddRemove;
import src.Week1.StackQueue;
import src.Week2.Calculator;
import src.Week3.Sorts;

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

        // 2D array to signify between weeks and challenges
        ArrayList<ArrayList<Blueprint>> options = new ArrayList<ArrayList<Blueprint>>();
        ArrayList<Blueprint> week0 = new ArrayList<Blueprint>();
        ArrayList<Blueprint> week1 = new ArrayList<Blueprint>();
        ArrayList<Blueprint> week2 = new ArrayList<Blueprint>();
        ArrayList<Blueprint> week3 = new ArrayList<Blueprint>();

        week0.add(new Swap("swap"));
        week0.add(new Matrix("matrix"));

        week1.add(new QueueAddRemove("Queue Add-Remove"));
        week1.add(new MergeQueue("Merge Queues"));
        week1.add(new StackQueue("Stack to Queue"));

        week2.add(new Calculator("RPN Calculator"));

        week3.add(new Sorts("Sorts"));

        options.add(week0);
        options.add(week1);
        options.add(week2);
        options.add(week3);

        // keep running until exit is called
        while (true) {
            menu(options);
        }
    } // close squig ends the method. What did this method do?

    /**
     * menu - method that is activated by main, this will perform Java code
     */
    public static void menu(ArrayList<ArrayList<Blueprint>> options) {
        System.out.println("Which weeks' challenges would you like to access?");
        for (int i = 0; i < options.size(); i++)
            System.out.println("Week: " + i);

        System.out.println("Exit: " + options.size());
        Blueprint exit = new Exit("exit");

        Scanner scanner = new Scanner(System.in);

        // try catch around any function in order to protect against invalid inputs
        // try {
        // scanner gets week and then challenge choice before .run()
        int weekChoice = scanner.nextInt();
        if (weekChoice == options.size())
            exit.run();

        System.out.println("Choose a challenge:");
        for (int i = 0; i < options.get(weekChoice).size(); i++)
            System.out.println("Option " + (int) (i + 1) + ": " + options.get(weekChoice).get(i).getTitle());

        int choice = scanner.nextInt();
        options.get(weekChoice).get(choice - 1).run();

        System.out.println();

        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // System.out.println("Invalid input");
        // }

        // if (scanner != null)
        // scanner.close();
    }

}