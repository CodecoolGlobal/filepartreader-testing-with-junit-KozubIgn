import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {
    private String filePath;
    private Integer formLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "/home/asus/Pulpit/filepartreader-testing-with-junit-KozubIgn/src/main/resources/text.txt";
        this.formLine = 0;
        this.toLine = -1;
    }

    public void setup(String filePath, Integer formLine, Integer toLine) {

        if (toLine < formLine || formLine < 1) {
            throw new IllegalArgumentException("Illegal argument !");
        }
    }

    public String read() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    public String readLines() throws IOException {
        String[] splittedText = read().split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = formLine; i <= toLine; i++) {
            stringBuilder.append(splittedText);
            stringBuilder.append("\n");
        }
        return splittedText.toString();
    }
}