package parser.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.classes.composite.TextComposite;
import parser.classes.parsers.TextParser;

import java.io.File;

public class TextParserTest {
    @Test
    public void ParsingTextTest(){
        String text1 = "Hello, this is line. How are you? I'm fine!!!";
        String text2 = "And this is second line. Ok?";

        TextComposite result = TextParser.parseText(text1, text2);
        String fullText = result.buildText();
        Assertions.assertEquals(fullText,"Hello, this is line. How are you? I'm fine!!!\nAnd this is second line. Ok?\n");
    }

    @Test
    public void ParsingTxtFileTest(){
        File file = new File("src\\test\\resources\\test.txt");

        TextComposite result = TextParser.parseText(file);
        String fullText = result.buildText();
        Assertions.assertEquals(fullText,"This is a first sentence!A second sentence!And this a third sentence in text.\n");
    }
}
