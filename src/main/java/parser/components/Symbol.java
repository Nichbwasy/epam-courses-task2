package parser.components;

import java.util.ArrayList;
import java.util.List;

public class Symbol extends Component {
    private String s = "";

    public Symbol(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String c) {
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
}
