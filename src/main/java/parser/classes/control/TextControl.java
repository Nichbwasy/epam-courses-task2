package parser.classes.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.classes.common.ComponentTypes;
import parser.classes.components.Component;
import parser.classes.composite.TextComposite;
import parser.classes.parsers.TextParser;
import parser.interfaces.control.ITextControl;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TextControl implements ITextControl {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextControl.class);
    private TextComposite composite;

    public TextControl(String ... texts) {
        this.composite = TextParser.parseText(texts);
    }

    public TextControl(File... files) {
        this.composite = TextParser.parseText(files);
    }

    @Override
    public List<String> getSentencesByWordsAscending() {
        List<String> result = new ArrayList<>();
        List<Component> sentences = getAllSentences(composite.getAll());

        List<Component> sortedSentences = sentences.stream()
                .sorted((Comparator.comparingInt(o -> o.getAll().size())))
                .collect(Collectors.toList());

        sortedSentences.stream()
                .forEach(p -> result.add(p.buildText()));
        LOGGER.info("Text was separated into and sorted by words ascending");
        return result;
    }

    private List<Component> getAllSentences(List<Component> components){
        List<Component> result = new ArrayList<>();
        for(Component c : components) {
            if (!(c.getType() == ComponentTypes.SYMBOL || c.getType() == ComponentTypes.PUNCTUATION_MARK)) {
                if (c.getType() == ComponentTypes.WORD){
                    LOGGER.info("Sentence has been found in text: {}", c.buildText());
                    result.add(c);
                }
                result.addAll(getAllSentences(c.getAll()));
            }
        }
        return result;
    }
}
