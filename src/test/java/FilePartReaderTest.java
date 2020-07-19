import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class FilePartReaderTest {
    @Test
    public void testReadWhenFilePathWrong() {
        FilePartReader filePartReader = new FilePartReader();
        Assertions.assertThrows(IOException.class, filePartReader::read);
    }

    @Test
    public void testReadLinesWhenFilePathCorrect() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/main/resources/test.txt", 2, 3);
        String actual = filePartReader.readLines();
        String expected = "Hello World !\n" +
                "uuuuuuuuffff booorinng boring stuff";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetupWhenToLineIsSmallerThanFromLine() {
        FilePartReader filePartReader = new FilePartReader();
        Assertions.assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("/home/asus/Pulpit/filepartreader-testing-with-junit-KozubIgn/src/main/resources/text.txt", 2, 1));
    }

    @Test
    void testSetupWhenFromLineIsSmallerThanZero() {
        FilePartReader filePartReader = new FilePartReader();
        Assertions.assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("/home/asus/Pulpit/filepartreader-testing-with-junit-KozubIgn/src/main/resources/text.txt", -1, 2));
    }
}