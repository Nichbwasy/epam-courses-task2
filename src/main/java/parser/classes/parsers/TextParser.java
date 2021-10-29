package parser.classes.parsers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.classes.common.ComponentTypes;
import parser.classes.common.RegExConst;
import parser.classes.components.Component;
import parser.classes.components.Symbol;
import parser.classes.composite.TextComposite;
import parser.classes.utils.FileToString;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextParser.class);

    public static TextComposite parseText(String ... texts){
        TextComposite textComposite = new TextComposite();
        for(String text : texts){
            LOGGER.info("Starts text parsing: {}", text);
            textComposite.add(parseElement(text, 5));
        }
        return textComposite;
    }
    public static TextComposite parseText(File... files) {
        TextComposite textComposite = new TextComposite();
        for(File file : files){
            LOGGER.info("Starts parsing file: {}", file.getName());
            String text = FileToString.readFile(file);
            textComposite.add(parseElement(text, 5));
        }
        return textComposite;
    }

    private static Component parseElement(String element, Integer patternId){
        TextComposite textComposite = new TextComposite();
        textComposite.setType(getType(patternId));
        Matcher matcher = getPattern(patternId).matcher(element);
        LOGGER.info("Starts parsing element: {}", element);
        while (matcher.find()){
            LOGGER.info("New component [{}] has been found at [{}, {}] position in element {}",
                    element.substring(matcher.start(), matcher.end()),
                    matcher.start(),
                    matcher.end(),
                    element);
            if (patternId > 1){
                textComposite.add(parseElement(matcher.group(),patternId - 1));
                if (patternId == 2) {
                    CheckNextElement(element, textComposite, matcher);
                }
            } else {
                return generateComponent(element, patternId);
            }
        }
        return textComposite;
    }

    private static Component generateComponent(String element, Integer patternId) {
        if (patternId == 1) {
            Symbol symbol = new Symbol(element);
            symbol.setType(ComponentTypes.SYMBOL);
            return symbol;
        }
        if (patternId == 0) {
            Symbol symbol = new Symbol(element);
            symbol.setType(ComponentTypes.PUNCTUATION_MARK);
            return symbol;
        }
        return null;
    }

    private static void CheckNextElement(String element, TextComposite textComposite, Matcher matcher) {
        Matcher pctMatcher = getPattern(0).matcher(element);
        while (pctMatcher.find()) {
            if (pctMatcher.start() > matcher.start()) {
                textComposite.add(parseElement(pctMatcher.group(), 0));
                Matcher next = getPattern(0).matcher(element);
                try {
                    next = next.region(pctMatcher.start() + 1, pctMatcher.end() + 1);
                    if (next.find()) {
                        continue;
                    } else break;
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
        }
    }

    private static Pattern getPattern(Integer i){
        switch (i) {
            case 5 :
                return Pattern.compile(RegExConst.TEXT);
            case 4 :
                return Pattern.compile(RegExConst.PARAGRAPH);
            case 3 :
                return Pattern.compile(RegExConst.SENTENCE);
            case 2 :
                return Pattern.compile(RegExConst.WORD);
            case 1 :
                return Pattern.compile(RegExConst.SYMBOL);
             case 0 :
                return Pattern.compile(RegExConst.PUNCTUATION_MARK);
            default: return Pattern.compile(RegExConst.SYMBOL);
        }
    }

    private static ComponentTypes getType(Integer i){
        switch (i) {
            case 5 :
                return ComponentTypes.TEXT;
            case 4 :
                return ComponentTypes.PARAGRAPH;
            case 3 :
                return ComponentTypes.SENTENCE;
            case 2 :
                return ComponentTypes.WORD;
            case 1 :
                return ComponentTypes.SYMBOL;
            case 0 :
                return ComponentTypes.PUNCTUATION_MARK;
            default: return ComponentTypes.SYMBOL;
        }
    }

}
