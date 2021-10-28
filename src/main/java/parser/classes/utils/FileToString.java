package parser.classes.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FileToString {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileToString.class);

    public static String readFile(File file){
        StringBuilder result = new StringBuilder();
        if (isTxtFile(file)) {
            try (FileReader fileReader = new FileReader(file)) {
                int c;
                while ((c =  fileReader.read()) != -1){
                    result.append((char)c);
                }
            } catch (FileNotFoundException e){
                System.out.println("aaa");
                return result.toString();
            } catch (IOException e) {
                System.out.println();
                return result.toString();
            }
        }
        return result.toString();
    }

    private static boolean isTxtFile(File file){
        String fileName = file.getName();
        return fileName.contains(".txt");
    }

}

