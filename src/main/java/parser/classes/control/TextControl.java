package parser.classes.control;

import parser.classes.composite.TextComposite;
import parser.classes.parsers.TextParser;
import parser.interfaces.control.ITextControl;

import java.io.File;
import java.util.List;

public class TextControl implements ITextControl {
    private TextComposite composite;

    public TextControl(String ... texts) {
        this.composite = TextParser.parseText(texts);
    }

    public TextControl(File... files) {
        this.composite = TextParser.parseText(files);
    }

    @Override
    public List<String> getSentencesByWordsAscending() {
        return null;
    }
}
