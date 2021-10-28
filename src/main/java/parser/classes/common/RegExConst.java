package parser.classes.common;

public class RegExConst {
    public static final String TEXT = "\\A[\\s\\S]+\\Z";
    public static final String PARAGRAPH = "\\t?[\\w ();.,-_\\\"'!?]+[\\n|\\r|$]?";
    public static final String SENTENCE = "[А-яA-z0-9 \\t\\,\\(\\)\\_\\-\\:\\;\\\"\\'\\/]+[\\.|?|!]+ ?";
    public static final String WORD = "[\\w\\d]+";
    public static final String PUNCTUATION_MARK = "[ .,;:()'\\\"\\-\\!\\?<>]";
    public static final String SYMBOL = "[\\w\\d]+";
}
