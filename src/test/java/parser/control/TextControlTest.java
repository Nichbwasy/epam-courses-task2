package parser.control;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.classes.control.TextControl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TextControlTest {
    @Test
    public void GetSentencesByWordsAscendingStringTest(){
        List<String> sentences = new ArrayList<>();
        sentences.add("This is a first sentence!");
        sentences.add("A second sentence!");
        sentences.add("And this a third sentence in text.");
        TextControl control = new TextControl(sentences.toString());

        sentences = control.getSentencesByWordsAscending();
        Assertions.assertEquals(sentences.get(0), "A second sentence!");
        Assertions.assertEquals(sentences.get(1), "This is a first sentence!");
        Assertions.assertEquals(sentences.get(2), "And this a third sentence in text.");
    }

    @Test
    public void GetSentencesByWordsAscendingFileTest(){
        File file = new File("src\\test\\resources\\test.txt");
        TextControl control = new TextControl(file);

        List<String> sentences = control.getSentencesByWordsAscending();
        Assertions.assertEquals(sentences.get(0), "A second sentence!");
        Assertions.assertEquals(sentences.get(1), "This is a first sentence!");
        Assertions.assertEquals(sentences.get(2), "And this a third sentence in text.");
    }
}
