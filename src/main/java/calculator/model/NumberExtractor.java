package calculator.model;

import java.util.LinkedList;

import static calculator.common.Exception.NOT_ALLOWED_ZERO_EXCEPTION;
import static calculator.common.Exception.UNREGISTERED_CUSTOM_DELIMITER_EXCEPTION;

public class NumberExtractor {
    private LinkedList<Integer> numberList;

    public NumberExtractor() {
        numberList = new LinkedList<>();
    }

    public void extractNumbers(Delimiter delimiter, String expression) {
        delimiter.buildRegex();
        String[] arrayOfNumbers = expression.split(delimiter.getDelimiterRegex());
        for (String number : arrayOfNumbers) {
            if (number.equals("0")) {throw new IllegalArgumentException(NOT_ALLOWED_ZERO_EXCEPTION);}
            if (number.equals("")) {number = "0";}
            if (!number.matches("[0-9]+")) {throw new IllegalArgumentException(UNREGISTERED_CUSTOM_DELIMITER_EXCEPTION);}
            numberList.add(Integer.parseInt(number));
        }
    }

    public LinkedList<Integer> getNumberList() {
        return numberList;
    }
}
