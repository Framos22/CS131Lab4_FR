import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileProcessor {
    private String fileName;
    private int stringLength;
    private ArrayList<String> stringList;
    private Scanner input;

    
    public FileProcessor(String fileName, int stringLength) {
        setFileName(fileName);
        setStringLength(stringLength);
        stringList = new ArrayList<>();
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setStringLength(int stringLength) {
        this.stringLength = stringLength < 5 ? 5 : stringLength;
    }

    public int getStringLength() {
        return stringLength;
    }

    public int getArrayListSize() {
        return stringList.size();
    }

    public void processFile() {
        try {
            input = new Scanner(new File(fileName));
            while (input.hasNext()) {
                String line = input.nextLine();
                if (line.length() > stringLength) {
                    throw new StringTooLongException();
                }
                stringList.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (StringTooLongException e) {
            System.out.println(e.getMessage());
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
}

