package src.Week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import src.Blueprint;

public class StackQueue extends Blueprint {
    public StackQueue(String optionTitle) {
        super(optionTitle);
    }

    public void run() {
        // create initial array and create queue with it
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Queue<Integer> queue = new LinkedList<>();
        for (int x : arr)
            queue.add(x);

        System.out.println("Queue elements: " + queue);

        // remove items from the queue and add it to the stack until queue is empty
        Stack<Integer> stack = new Stack<>();
        while (queue.size() > 0)
            stack.add(queue.poll());

        // print items of the stack
        System.out.print("Stack elements: ");
        while (stack.size() > 0)
            System.out.print(stack.pop() + " ");

        System.out.println();
    }
}
