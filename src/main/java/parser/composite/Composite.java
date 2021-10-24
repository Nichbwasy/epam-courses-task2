package parser.composite;

import parser.components.Component;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private List<Component> components = new ArrayList<Component>();

    public void add(Component component) {
        this.components.add(component);
    }

    public void remove(Component component) {
        this.components.remove(component);
    }

    public void print() {
        for (Component c : components) {
            c.print();
        }
    }
}
