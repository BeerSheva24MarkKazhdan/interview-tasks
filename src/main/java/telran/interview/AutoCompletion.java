package telran.interview;

import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class AutoCompletion {
    private final TreeSet<String> words;

    public AutoCompletion() {
        words = new TreeSet<>(String::compareToIgnoreCase);
    }

    public boolean addWord(String word) {
        return words.add(word);
    }

    public String[] getVariants(String prefix) {

        List<String> variants = new ArrayList<>();
        String nextWord = words.ceiling(prefix);
        while (nextWord != null && nextWord.toLowerCase().startsWith(prefix.toLowerCase())) {
            variants.add(nextWord);
            nextWord = words.higher(nextWord);
        }
        return variants.toArray(new String[0]);
    }
}
