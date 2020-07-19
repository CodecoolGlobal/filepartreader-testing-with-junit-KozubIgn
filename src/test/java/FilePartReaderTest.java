import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    @Test
    public void testReadWhenFilePathWrong() {
        FilePartReader filePartReader = new FilePartReader();
       Assertions.assertThrows(IOException.class, filePartReader::read);
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