package parser.controls;

import parser.common.RegExConst;
import parser.components.Component;
import parser.components.PunctuationMark;
import parser.components.Symbol;
import parser.components.Text;
import parser.composite.TextComposite;

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

    private static Component parseElement(String element, Integer patternId){
        TextComposite textComposite = new TextComposite();
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
                if (patternId == 1)
                    return new Symbol(element);
                if (patternId == 0)
                    return new PunctuationMark(element);
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

}
