package parser.components;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends Component{
    private List<Component> sentences = new ArrayList<Component>();

    public List<Component> getSentences() {
        return sentences;
    }

    public void setSentences(List<Component> sentences) {
        this.sentences = sentences;
    }

    public void add(Sentence sentence) {
        this.sentences.add(sentence);
    }

    public String buildText() {
        StringBuilder string = new StringBuilder();
        for(Component c : sentences){
            string.append(c.buildText());
        }
        return string.toString();
    }

    public void print() {
        for(Component c : sentences){
            c.print();
        }
    }

}
