package parser.components;

import java.util.ArrayList;
import java.util.List;

public class Text extends Component {
    private List<Component> paragraphs = new ArrayList<Component>();

    public List<Component> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Component> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public void add(Paragraph paragraph) {
        this.paragraphs.add(paragraph);
    }

    public String get() {
        StringBuilder string = new StringBuilder();
        for(Component c : paragraphs){
            string.append(c.get());
        }
        return string.toString();
    }

    public void print() {
        for(Component c : paragraphs) {
            c.print();
            System.out.println();
        }
    }
}
