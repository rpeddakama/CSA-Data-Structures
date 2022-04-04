package src.Week3.Algorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;

public class InsertionSort {
    private final int size = 5000;
    private ArrayList<Integer> data = new ArrayList<>(), sorts = new ArrayList<>(), comparisons = new ArrayList<>();
    private ArrayList<Duration> timeElapsed = new ArrayList<>();

    public void run() {
        for (int T = 0; T < 12; T++) {
            Instant start = Instant.now();
            for (int i = 0; i < size; i++)
                data.add((int) (Math.random() * (size + 1)));

            int s = 0, c = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(data.get(0));
            for (int i = 1; i < data.size(); i++) {
                for (int j = 0; j < arr.size(); j++) {
                    c++;
                    if (data.get(i) < arr.get(j)) {
                        arr.add(j, data.get(i));
                        s++;
                        break;
                    }
                }
            }

            Instant end = Instant.now();
            sorts.add(s);
            comparisons.add(c);
            timeElapsed.add(Duration.between(start, end));
            data.clear();
        }
        sorts.sort(Comparator.naturalOrder());
        sorts.remove(0);
        sorts.remove(sorts.size() - 1);

        double sortAverage = 0;
        for (int x : sorts)
            sortAverage += (double) x;

        comparisons.sort(Comparator.naturalOrder());
        comparisons.remove(0);
        comparisons.remove(comparisons.size() - 1);

        double comparisonAverage = 0.0;
        for (int x : comparisons)
            comparisonAverage += (double) x;

        timeElapsed.sort(Comparator.naturalOrder());
        timeElapsed.remove(0);
        timeElapsed.remove(timeElapsed.size() - 1);

        double timeAverage = 0;
        for (Duration x : timeElapsed)
            timeAverage += x.getNano();

        System.out.println("Average # of sorts: " + sortAverage / 10.0);
        System.out.println("Average # of comparisons: " + comparisonAverage / 10.0);
        System.out.println("Average # time spent: " + timeAverage / 10.0 + " nanoseconds");
    }
}
