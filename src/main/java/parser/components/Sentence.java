package parser.components;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends Component{
    private List<Component> words = new ArrayList<Component>();

    public List<Component> getSymbols() {
        return words;
    }

    public void setSymbols(List<Component> symbols) {
        this.words = symbols;
    }

    public void add(Word word) {
        this.words.add(word);
    }

    public void add(PunctuationMark mark) {
        this.words.add(mark);
    }

    public String get() {
        StringBuilder string = new StringBuilder();
        for(Component c : words){
            string.append(c.get());
        }
        return string.toString();
    }

    public void print() {
        for(Component c : words){
            c.print();
        }
    }
}
