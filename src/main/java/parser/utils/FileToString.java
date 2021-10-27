package parser.utils;

import java.io.*;

public class FileToString {
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

