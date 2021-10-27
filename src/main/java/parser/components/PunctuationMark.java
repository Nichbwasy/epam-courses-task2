package parser.components;

public class PunctuationMark extends Component {
    private String s = "";

    public PunctuationMark(String s) {
        this.s = s;
    }

    public String getC() {
        return s;
    }

    public void setC(String c) {
        this.s = s;
    }

    public void print() {
        System.out.println(s);
    }


    public String get() {
        return s;
    }
}
