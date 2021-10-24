package parser.components;

public class PunctuationMark extends Component {
    Character c = ' ';

    public PunctuationMark(Character c) {
        this.c = c;
    }

    public Character getC() {
        return c;
    }

    public void setC(Character c) {
        this.c = c;
    }

    public void print() {
        System.out.println(c);
    }
}
