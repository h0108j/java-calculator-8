package calculator.model;

import java.util.LinkedList;

public class Accumulator {
    private int sum;
    private String delimiter;
    private String expression;
    private LinkedList<Integer> numberList;

    public Accumulator(String delimiter, String expression) {
        this.sum = 0;
        this.delimiter = delimiter;
        this.expression = expression;
        this.numberList = new LinkedList<Integer>();
    }

    public int accumulate() {
        extractNumbers();
        addNumbers();
        return sum;
    }

    private void extractNumbers() {
        String[] arrayOfNumbers = expression.split(delimiter);
        String number;
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            number = arrayOfNumbers[i];
            if (number.equals("0")) {throw new IllegalArgumentException("0은 양수가 아닙니다.");}
            if (number.equals("")) {number = "0";}
            if (!number.matches("[0-9]+")) {throw new IllegalArgumentException("커스텀 구분자로 등록되지 않은 문자는 사용할 수 없습니다.");}
            numberList.add(Integer.parseInt(number));
        }
    }

    private void addNumbers() {
        for (int i = 0; i < numberList.size(); i++) {
            sum += numberList.get(i);
        }
    }
}
