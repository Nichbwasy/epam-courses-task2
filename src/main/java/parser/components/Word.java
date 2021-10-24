package parser.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word extends Component {
    List<Symbol> word = new ArrayList<Symbol>();

    public Word(Symbol ... word) {
        this.word = Arrays.asList(word);
    }

    public List<Symbol> getWord() {
        return word;
    }

    public void setWord(Symbol ... word) {
        this.word = Arrays.asList(word);
    }

    public void print() {
        for (Symbol s : word) s.print();
    }
}
