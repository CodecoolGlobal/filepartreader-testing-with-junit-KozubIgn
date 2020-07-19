import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("/home/asus/Pulpit/filepartreader-testing-with-junit-KozubIgn/src/main/resources/text.txt", 1, 1);
        FileWordAnalyser fileWordAnalyser = new FileWordAnalyser(filePartReader);
        System.out.println(fileWordAnalyser.getStringWhichPalindromes());
    }
}
