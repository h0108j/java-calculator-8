package calculator.model;

import static calculator.common.Constants.CUSTOM_END_MARK;
import static calculator.common.Constants.CUSTOM_START_MARK;
import static calculator.common.Exception.EMPTY_CUSTOM_DELIMITER_EXCEPTION;
import static calculator.common.Exception.MISSING_END_MARK_EXCEPTION;

public class Separator {
    private Delimiter delimiter;
    private String customDelimiter;
    private String expression;

    public Separator(Delimiter delimiter) {
        this.delimiter = delimiter;
        this.customDelimiter = "";
        this.expression = "";
    }

    public void separate(String inputString) {
        parseCustomDelimiter(inputString);
    }

    private void parseCustomDelimiter(String inputString) {
        if (!inputString.startsWith(CUSTOM_START_MARK)) {
            expression = inputString;
            return;
        }
        int endIndex = inputString.lastIndexOf(CUSTOM_END_MARK);
        if (endIndex == CUSTOM_START_MARK.length()) {throw new IllegalArgumentException(EMPTY_CUSTOM_DELIMITER_EXCEPTION);}
        if (endIndex == -1) {throw new IllegalArgumentException(MISSING_END_MARK_EXCEPTION);};
        customDelimiter = inputString.substring(CUSTOM_START_MARK.length(), endIndex);
        delimiter.addCustomDelimiter(customDelimiter);
        expression = inputString.substring(endIndex + CUSTOM_END_MARK.length());
    }

    public String getExpression() {
        return expression;
    }
}