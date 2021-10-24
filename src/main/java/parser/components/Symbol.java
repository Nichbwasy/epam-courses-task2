package parser.components;

public class Symbol extends Component {
    Character c = ' ';

    public Symbol(Character c) {
        this.c = c;
    }

    public Character getC() {
        return c;
    }

    public void setC(Character c) {
        this.c = c;
    }

    public void print() {
        System.out.print(c);
    }
}
