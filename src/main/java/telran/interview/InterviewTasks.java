package telran.interview;

import java.util.*;

public class InterviewTasks {
    public static boolean hasSumTwo(int[] array, int sum) {
        Set<Integer> complements = new HashSet<>();
        int length = array.length;
        int i = 0;
        boolean result = false;
        while (i < length && !result) {
            if (!complements.contains(array[i])) {
                complements.add(sum - array[i]);
            } else {
                result = true;
            }
            i++;
        }
        return result;
    }
}
