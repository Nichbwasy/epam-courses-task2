package parser.composite;

import parser.components.Component;
import parser.components.Text;

import java.util.ArrayList;
import java.util.List;

public class TextComposite extends Component {
    List<Component> texts = new ArrayList<Component>();

    public void add(Component text) {
        this.texts.add(text);
    }

    public String get() {
        StringBuilder string = new StringBuilder();
        for (Component c : texts) {
            string.append(c.get());
        }
        //string.append("\n");
        return string.toString();
    }

    public void print() {
        for (Component c : texts) {
            c.print();
        }
    }
}
