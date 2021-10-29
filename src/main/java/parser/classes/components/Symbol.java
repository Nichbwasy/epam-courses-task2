package parser.classes.components;

import java.util.Collections;
import java.util.List;

public class Symbol extends Component {
    private String s = "";

    public Symbol(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }

    public void setValue(String c) {
        this.s = s;
    }

    @Override
    public void print() {
        System.out.print(s);
    }

    @Override
    public String buildText() {
        return s;
    }

    @Override
    public List<Component> getAll() {
        return Collections.singletonList(this);
    }
}
