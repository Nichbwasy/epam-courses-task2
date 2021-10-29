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

    public abstract List<Component> getAll();
    public abstract void print();
    public abstract String buildText();
}
