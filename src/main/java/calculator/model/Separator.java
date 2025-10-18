package calculator.model;

public class Separator {
    public static final String CUSTOM_START_MARK = "//";
    public static final String CUSTOM_END_MARK = "\\n";

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
        if (endIndex == CUSTOM_START_MARK.length()) {throw new IllegalArgumentException("빈 문자는 커스텀 구분자로 사용할 수 없습니다.");}
        if (endIndex == -1) {throw new IllegalArgumentException("\\n를 찾을 수 없습니다.");};
        customDelimiter = inputString.substring(CUSTOM_START_MARK.length(), endIndex);
        delimiter.addCustomDelimiter(customDelimiter);
        expression = inputString.substring(endIndex + CUSTOM_END_MARK.length());
    }

    public String getExpression() {
        return expression;
    }
}