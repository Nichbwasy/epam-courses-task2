package parser.classes.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.classes.common.ComponentTypes;
import parser.classes.components.Component;

import java.util.ArrayList;
import java.util.List;

public class TextComposite extends Component {
    private static  final Logger LOGGER = LoggerFactory.getLogger(TextComposite.class);
    private List<Component> components = new ArrayList<Component>();

    public void add(Component text) {
        this.components.add(text);
        LOGGER.info("Component was added into text composite : {}", text.buildText());
    }

    public String buildText() {
        StringBuilder string = new StringBuilder();
        for (Component c : components) {
            string.append(c.buildText());
        }
        if (this.getType() == ComponentTypes.TEXT)
            string.append("\n");
        LOGGER.info("Text component has been build: {}", string.toString());
        return string.toString();
    }

    public void print() {
        for (Component c : components) {
            c.print();
            LOGGER.info("Text component has been build: {}", c.buildText());

        }
        if(this.getType() == ComponentTypes.TEXT || this.getType() == ComponentTypes.PARAGRAPH)
            System.out.println();
    }

    @Override
    public List<Component> getAll() {
        return components;
    }

}
