package parser.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.classes.utils.FileToString;

import java.io.File;

public class FileToStringTest {
    @Test
    public void TxtFileText(){
        File file = new File("src\\test\\resources\\test.txt");
        String result = FileToString.readFile(file);
        Assertions.assertEquals(result, "    This is a first sentence!\r\n    A second sentence!\r\n    And this a third sentence in text.");
    }

    @Test
    public void NotTxtFileText(){
        File file = new File("src\\test\\resources\\notTxtFile.bin");
        String result = FileToString.readFile(file);
        Assertions.assertEquals(result, "");
    }

    @Test
    public void FileNotFoundText(){
        File file = new File("src\\test\\resources\\notExist.txt");
        String result = FileToString.readFile(file);
        Assertions.assertEquals(result, "");
    }

}
