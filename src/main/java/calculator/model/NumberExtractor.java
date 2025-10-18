package calculator.model;

import java.util.LinkedList;

public class NumberExtractor {
    private LinkedList<Integer> numberList;

    public NumberExtractor() {
        numberList = new LinkedList<>();
    }

    public void extractNumbers(Delimiter delimiter, String expression) {
        delimiter.buildRegex();
        String[] arrayOfNumbers = expression.split(delimiter.getDelimiterRegex());
        String number;
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            number = arrayOfNumbers[i];
            if (number.equals("0")) {throw new IllegalArgumentException("0은 양수가 아닙니다.");}
            if (number.equals("")) {number = "0";}
            if (!number.matches("[0-9]+")) {throw new IllegalArgumentException("커스텀 구분자로 등록되지 않은 문자는 사용할 수 없습니다.");}
            numberList.add(Integer.parseInt(number));
        }
    }

    public LinkedList<Integer> getNumberList() {
        return numberList;
    }
}
