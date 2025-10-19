package calculator.model;

import java.util.regex.Pattern;

import static calculator.common.Constants.DEFAULT_DELIMITER;
import static calculator.common.Exception.RESERVED_WORD_DELIMITER_EXCEPTION;

public class Delimiter {
    private String customDelimiter;
    private String delimiterRegex;

    public Delimiter() {
        delimiterRegex = "";
        customDelimiter = "";
    }

    public void addCustomDelimiter(String customDelimiter) {
        this.customDelimiter = customDelimiter;
    }

    public void buildRegex() {
        StringBuilder stringbuilder = new StringBuilder();

        stringbuilder.append(DEFAULT_DELIMITER.charAt(0));
        for (int i = 1; i < DEFAULT_DELIMITER.length(); i++) {
            stringbuilder.append("|").append(Pattern.quote(String.valueOf(DEFAULT_DELIMITER.charAt(i))));
        }

        for (int i = 0; i < customDelimiter.length(); i++) {
            char ch = customDelimiter.charAt(i);
            if (Character.isDigit(ch) || DEFAULT_DELIMITER.contains(String.valueOf(ch))) { throw new IllegalArgumentException(RESERVED_WORD_DELIMITER_EXCEPTION); }
            stringbuilder.append("|").append(Pattern.quote(String.valueOf(ch)));
        }
        delimiterRegex = stringbuilder.toString();
    }

    public String getDelimiterRegex() {
        return delimiterRegex;
    }

    public String getCustomDelimiter() {
        return customDelimiter;
    }
}
