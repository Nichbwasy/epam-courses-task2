package parser.composete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.classes.components.Component;
import parser.classes.components.Symbol;
import parser.classes.composite.TextComposite;

public class TextCompositeTest {
    @Test
    public void AddTest(){
        TextComposite composite = new TextComposite();
        Component symbol = new Symbol("s");
        composite.add(symbol);
        Assertions.assertEquals(symbol.buildText(), "s");
    }

    @Test
    public void getAll(){
        TextComposite composite = new TextComposite();
        Component symbol1 = new Symbol("1");
        Component symbol2 = new Symbol("2");
        Component symbol3 = new Symbol("3");

        composite.add(symbol1);
        composite.add(symbol2);
        composite.add(symbol3);

        Assertions.assertEquals(composite.buildText(), "123");
    }
}
