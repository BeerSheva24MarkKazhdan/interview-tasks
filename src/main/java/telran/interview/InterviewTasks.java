package telran.interview;

import java.time.LocalDate;
import java.util.*;

public class InterviewTasks {
    public static boolean hasSumTwo(int[] array, int sum) {
        HashSet<Integer> helpers = new HashSet<>();
        int index = 0;
        while (index < array.length && !helpers.contains(sum - array[index])) {
            helpers.add(array[index++]);
        }
        return index < array.length;
    }

    static public int getMaxWithNegativePresentation(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        int maxValue = -1;

        for (int num : array) {
            if (set.contains(-num)) {
                maxValue = Math.max(maxValue, Math.abs(num));
            }
            set.add(num);
        }

        return maxValue;
    }

    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
            List<LocalDate> dates) {
        List<DateRole> result = new ArrayList<>();
        int roleIndex = 0;

        for (LocalDate date : dates) {
            while (roleIndex < rolesHistory.size() && rolesHistory.get(roleIndex).getDate().isBefore(date)) {
                roleIndex++;
            }

            String role = (roleIndex > 0 && !rolesHistory.get(roleIndex - 1).getDate().isAfter(date))
                    ? rolesHistory.get(roleIndex - 1).getRole()
                    : null;

            result.add(new DateRole(date, role));
        }
        return result;
    }

    public static boolean isAnagram(String word, String anagram) {
        boolean result = true;
        if (word.length() != anagram.length() || word.equals(anagram) && word.length() > 1) {
            result = false;
        } else {
            int[] charCounts = new int[256];

            for (char c : word.toCharArray()) {
                charCounts[c]++;
            }

            for (char c : anagram.toCharArray()) {
                if (--charCounts[c] < 0) {
                    result = false;
                }
            }
        }

        return result;
    }

}
