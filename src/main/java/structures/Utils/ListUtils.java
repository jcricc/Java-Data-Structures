package structures.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListUtils {
    public static List<Integer> add1ToAll(List<Integer> xs) {
        List<Integer> ys = new ArrayList<>();
        for (int x : xs) {
            ys.add(x + 1);
        }
        return ys;
    }

    public static void add1ToEach(List<Integer> xs) {
        for (int i = 0; i < xs.size(); i++) {
            xs.set(i, xs.get(i) + 1);
        }
    }

    public static List<Integer> countOccurrences(List<Integer> xs) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int x : xs) {
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int x : xs) {
            result.add(countMap.get(x));
        }
        return result;
    }

    public static int secondLargest(List<Integer> xs) {
        if (xs.size() < 2) throw new IllegalArgumentException("List must have at least 2 elements");

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int x: xs) {
            if (x > largest) {
                secondLargest = largest;
                largest = x;
            }
            else if (x > secondLargest && x < largest){
                secondLargest = x;
            }
        }
        return secondLargest;
    }
}
