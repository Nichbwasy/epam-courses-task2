package parser.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word extends Component {
    private List<Component> symbols = new ArrayList<Component>();

    public Word(Component ... symbols) {
        this.symbols = Arrays.asList(symbols);
    }

    public List<Component> getWord() {
        return symbols;
    }

    public void add(Symbol symbol) {
        this.symbols.add(symbol);
    }

    public void setWord(Component ... symbols) {
        this.symbols = Arrays.asList(symbols);
    }

    public void print() {
        for (Component s : symbols) s.print();
    }

    public String buildText() {
        StringBuilder string = new StringBuilder();
        for(Component c : symbols){
            string.append(c.buildText());
        }
        return string.toString();
    }
}

