package src.Week1;

import java.util.LinkedList;
import java.util.Queue;

import src.Blueprint;

public class MergeQueue extends Blueprint {
    public MergeQueue(String optionTitle) {
        super(optionTitle);
    }

    public void run() {
        int[] arr1 = { 1, 4, 7, 8, 12, 15, 99, 210, 867, 991 };
        Queue<Integer> q1 = new LinkedList<>();
        for (int x : arr1)
            q1.add(x);

        int[] arr2 = { 2, 5, 6, 28, 33, 40, 88, 199, 870, 999 };
        Queue<Integer> q2 = new LinkedList<>();
        for (int x : arr2)
            q2.add(x);

        System.out.println("Queue 1 before: " + q1);
        System.out.println("Queue 2 before: " + q2);

        Queue<Integer> merged = new LinkedList<>();
        int qSize = q1.size();
        for (int i = 0; i < qSize; i++) {
            if (q1.peek() < q2.peek()) {
                merged.add(q1.poll());
                merged.add(q2.poll());
            } else {
                merged.add(q2.poll());
                merged.add(q1.poll());
            }
        }

        System.out.println("Sorted Merged Queues: " + merged);

    }
}
