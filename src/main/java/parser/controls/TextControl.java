package parser.controls;

import parser.common.ComponentTypes;
import parser.common.RegExConst;
import parser.components.Component;
import parser.components.Symbol;
import parser.composite.TextComposite;
import parser.utils.FileToString;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextControl {
    public static TextComposite parseText(String ... texts){
        TextComposite textComposite = new TextComposite();
        for(String text : texts){
           textComposite.add(parseElement(text, 5));
        }
        return textComposite;
    }
    public static TextComposite parseText(File... files) {
        TextComposite textComposite = new TextComposite();
        for(File file : files){
            String text = FileToString.readFile(file);
            textComposite.add(parseElement(text, 5));
        }
        return textComposite;
    }

    private static Component parseElement(String element, Integer patternId){
        TextComposite textComposite = new TextComposite();
        textComposite.setType(getType(patternId));
        Matcher matcher = getPattern(patternId).matcher(element);
        while (matcher.find()){
            if (patternId > 1){
                textComposite.add(parseElement(
                        matcher.group(),
                        patternId - 1
                ));
                if (patternId == 2) {
                    Matcher pctMatcher = getPattern(0).matcher(element);
                    while (pctMatcher.find())
                        if (pctMatcher.start() > matcher.start()) {
                            String s = pctMatcher.group();
                            textComposite.add(parseElement(pctMatcher.group(), 0));
                            Matcher next = getPattern(0).matcher(element);
                            try {
                                next = next.region(pctMatcher.start() + 1, pctMatcher.end() + 1);
                                if (next.find()) {
                                    continue;
                                }
                                else break;
                            } catch (IndexOutOfBoundsException e) {
                                break;
                            }
                        }
                }
            } else {
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
            }
        }
        return textComposite;
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
