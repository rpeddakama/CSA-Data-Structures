package src.Week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import src.Blueprint;

public class QueueAddRemove extends Blueprint {
    public QueueAddRemove(String optionTitle) {
        super(optionTitle);
    }

    public void run() {
        Queue<String> queue = new LinkedList<>();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            // various options for a user to choose from regarding queue operations
            System.out.println("\n-------------------------");
            System.out.println("Choose from these choices");
            System.out.println("-------------------------");
            System.out.println("1 - Enqueue Items to Queue");
            System.out.println("2 - Dequeue Items from Queue");
            System.out.println("3 - Print Current Queue");
            System.out.println("4 - Get Word Count");
            System.out.println("5 - Exit");

            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter a string to add");
                queue.add(scanner.next());
            }
            if (choice == 2) {
                if (queue.size() > 0) {
                    queue.remove();
                    System.out.println("Head of the queue has been popped");
                } else
                    System.out.println("Queue is empty");
            }
            if (choice == 3) {
                System.out.println("See items of the queue below:");
                System.out.println(queue);
            }
            if (choice == 4) {
                System.out.println("Size of queue: " + queue.size());
            }
            // exit this challenge
            if (choice == 5) {
                break;
            }
        }
    }
}
