package parser.classes.components;

import parser.classes.common.ComponentTypes;

import java.util.List;

public abstract class Component {
    private ComponentTypes type;

    public ComponentTypes getType() {
        return type;
    }

    public void setType(ComponentTypes type) {
        this.type = type;
    }

    /**
     * Returns all components from current composite.
     * Also can contains other composites.
     * @return List which contains all components
     */
    public abstract List<Component> getAll();

    /**
     * Recursively prints the contents of the components to the
     * standard input/output stream
     */
    public abstract void print();

    /**
     * Recursively builds the contents of the components in the
     * StringBuilder and returns string contains restored text
     * @return String withs restored text
     */
    public abstract String buildText();
}
