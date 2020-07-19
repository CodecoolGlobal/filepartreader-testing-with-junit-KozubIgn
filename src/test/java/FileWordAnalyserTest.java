import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FileWordAnalyserTest {
    public static FilePartReader filePartReader;
    public static FileWordAnalyser fileWordAnalyser;


    @BeforeAll
    public static void setup() {
        filePartReader = new FilePartReader();
        filePartReader.setup("/home/asus/Pulpit/filepartreader-testing-with-junit-KozubIgn/src/main/resources/oneLine.txt", 1, 1);
        fileWordAnalyser = new FileWordAnalyser(filePartReader);
    }

    @Test
    public void testGetWordsOrderedAlphabeticallyWhenListCorrect() throws IOException {
        List<String> expected = new ArrayList<>(Arrays.asList("away", "dad", "from", "mom", "plague", "the", "us"));
        Assertions.assertEquals(expected, fileWordAnalyser.getWordsOrderedAlphabetically());
    }

    @Test
    public void testgetWordsContainingSubstring() throws IOException {
        List<String> expected = new ArrayList<>(Arrays.asList("mom", "from"));
        Assertions.assertEquals(expected, fileWordAnalyser.getWordsContainingSubstring("om"));
    }

    @Test
    void testgetStringsWhichPalindromes() throws IOException {
        List<String> expected = new ArrayList<>(Arrays.asList("mom", "dad"));
        Assertions.assertEquals(expected, fileWordAnalyser.getStringWhichPalindromes());
    }

}