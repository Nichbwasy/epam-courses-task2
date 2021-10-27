package parser.composite;

import parser.common.ComponentTypes;
import parser.components.Component;

import java.util.ArrayList;
import java.util.List;

public class TextComposite extends Component {
    List<Component> components = new ArrayList<Component>();

    public void add(Component text) {
        this.components.add(text);
    }

    public String buildText() {
        StringBuilder string = new StringBuilder();
        for (Component c : components) {
            string.append(c.buildText());
        }
        if (this.getType() == ComponentTypes.TEXT)
            string.append("\n");
        return string.toString();
    }

    public void print() {
        for (Component c : components) {
            c.print();
        }
        if(this.getType() == ComponentTypes.TEXT || this.getType() == ComponentTypes.PARAGRAPH)
            System.out.println("\n");
    }
}
