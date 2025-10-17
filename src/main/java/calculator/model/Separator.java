package calculator.model;

import java.util.regex.Pattern;

public class Separator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_START_MARK = "//";
    private static final String CUSTOM_END_MARK = "\\n";

    private String delimiter;
    private String customDelimiter;
    private String expression;

    public Separator() {
        this.delimiter = DEFAULT_DELIMITER;
        this.customDelimiter = "";
        this.expression = "";
    }

    public String separate(String inputString) {
        parseCustomDelimiter(inputString);
        buildCustomDelimiter();
        return expression;
    }

    private void parseCustomDelimiter(String inputString) {
        if (!inputString.startsWith(CUSTOM_START_MARK)) {
            expression = inputString;
            return;
        }
        int endIndex = inputString.lastIndexOf(CUSTOM_END_MARK);
        if (endIndex == CUSTOM_START_MARK.length()) {throw new IllegalArgumentException("빈 문자는 커스텀 구분자로 사용할 수 없습니다.");}
        if (endIndex == -1) {throw new IllegalArgumentException("\\n를 찾을 수 없습니다.");};
        customDelimiter = inputString.substring(CUSTOM_START_MARK.length(), endIndex);
        expression = inputString.substring(endIndex + CUSTOM_END_MARK.length());
    }

    private void buildCustomDelimiter() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(delimiter); //예약어 케이스
        for (int i = 0; i < customDelimiter.length(); i++) {
            char ch = customDelimiter.charAt(i);
            if (String.valueOf(ch).matches("[0-9]|,|:")) {throw new IllegalArgumentException("예약어는 커스텀 구분자로 사용할 수 없습니다.");}
            stringbuilder.append("|").append(Pattern.quote(String.valueOf(ch)));
        }
        delimiter = stringbuilder.toString();
    }

    public String getDelimiter() {
        return delimiter;
    }
}