package parser.components;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.classes.common.ComponentTypes;
import parser.classes.components.Component;
import parser.classes.components.Symbol;

public class SymbolTest {
    @Test
    public void TypeTest(){
        Component symbol = new Symbol("s");
        Assertions.assertEquals(symbol.getType(), null);
    }

    @Test
    public void GetTypeTest(){
        Component symbol = new Symbol("s");
        symbol.setType(ComponentTypes.SYMBOL);
        Assertions.assertEquals(symbol.getType(), ComponentTypes.SYMBOL);
    }

    @Test
    public void BuildTextTest(){
        Component symbol = new Symbol("s");
        Assertions.assertEquals(symbol.buildText(), "s");
    }
}
