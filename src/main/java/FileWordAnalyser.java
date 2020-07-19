import java.io.IOException;
import java.util.*;

public class FileWordAnalyser {
    private final FilePartReader filePartReader;

    public FileWordAnalyser(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String[] arrayOfWords = getWordsArray();
        List<String> list = Arrays.asList(arrayOfWords);
        Collections.sort(list);
        return list;
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        String[] arrayOfWords = getWordsArray();
        List<String> listOfSubstrings = new ArrayList<>();

        for (String word : arrayOfWords) {
            if (word.contains(subString)) {
                listOfSubstrings.add(word);
            }
        }
        return listOfSubstrings;
    }

    public List<String> getStringWhichPalindromes() throws IOException {
        String[] arrayOfWords = getWordsArray();
        List<String> listOfPalindromes = new ArrayList<>();

        for (String s : arrayOfWords) {
            char[] wordInChars = s.toCharArray();
            int firstIndex = 0;
            int lastIndex = wordInChars.length - 1;

            while (lastIndex > firstIndex) {
                if (wordInChars[firstIndex] != wordInChars[lastIndex]) {
                    break;
                }
                ++firstIndex;
                --lastIndex;
            }

            if (lastIndex != wordInChars.length - 1) {
                listOfPalindromes.add(s);
            }
        }
        return listOfPalindromes;
    }

    public String[] getWordsArray() throws IOException {
        String words = filePartReader.readLines();
        return words.split(" ");
    }
}

