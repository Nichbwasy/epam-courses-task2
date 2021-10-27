package parser.common;

public class RegExConst {
    public static final String TEXT = "\\A[\\s\\S]+\\Z";
    public static final String PARAGRAPH = "\\t?[[\\w] ();.,-_\\\"'!?]+$";
    public static final String SENTENCE = "[А-яA-z0-9 \\,\\(\\)\\_\\-\\:\\;\\\"\\'\\/]+[\\.|?|!]+ ?";
    public static final String WORD = "[\\w\\d]+";
    public static final String PUNCTUATION_MARK = "[ .,;:()'\\\"\\-\\!\\?<>]";
    public static final String SYMBOL = "[\\w\\d]+";
}
