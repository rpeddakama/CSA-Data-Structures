package src.Week3;

import java.util.Scanner;

import src.Blueprint;
import src.Week3.Algorithms.BubbleSort;
import src.Week3.Algorithms.InsertionSort;
import src.Week3.Algorithms.MergeSort;
import src.Week3.Algorithms.SelectionSort;

public class Sorts extends Blueprint {
    public Sorts(String optionTitle) {
        super(optionTitle);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Which sort algorithm would you like to see?\n1: Bubble Sort\n2: Selection Sort\n3: Insertion Sort\n4: Merge Sort");
        int algo = scanner.nextInt();

        switch (algo) {
            case 1:
                // System.out.println("YO1");
                BubbleSort bubbleSort = new BubbleSort();
                bubbleSort.run();
                break;
            case 2:
                // System.out.println("YO2");
                SelectionSort selectionSort = new SelectionSort();
                selectionSort.run();
                break;
            case 3:
                // System.out.println("YO3");
                InsertionSort insertionSort = new InsertionSort();
                insertionSort.run();
                break;
            case 4:
                // System.out.println("YO4");
                MergeSort mergeSort = new MergeSort();
                mergeSort.run();
                break;
        }
    }
}
