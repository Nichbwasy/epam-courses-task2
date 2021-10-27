package parser.components;

public class Symbol extends Component {
    private String s = "";

    public Symbol(String s) {
        this.s = s;
    }

    public String getC() {
        return s;
    }

    public void setC(String c) {
        this.s = s;
    }

    public void print() {
        System.out.print(s);
    }

    public String get() {
        return s;
    }
}
