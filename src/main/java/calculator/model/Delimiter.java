package calculator.model;

import java.util.regex.Pattern;

public class Delimiter {
    public static final String DEFAULT_DELIMITER = ",:";

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
            if (String.valueOf(ch).matches("[0-9]|,|:")) {throw new IllegalArgumentException("예약어는 커스텀 구분자로 사용할 수 없습니다.");}
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
