package parser.interfaces.control;

import java.util.List;

public interface ITextControl {
    /**
     * Gets all sentences from the text composite, sorting them by count
     * of words in. After builds a sorted sentences in string array and
     * returns it.
     * @return Sorted sentences by count of words
     */
    List<String> getSentencesByWordsAscending();
}
