package parser.components;

import parser.common.ComponentTypes;

public abstract class Component {
    private ComponentTypes type;

    public ComponentTypes getType() {
        return type;
    }

    public void setType(ComponentTypes type) {
        this.type = type;
    }

    public abstract void print();
    public abstract String buildText();
}
