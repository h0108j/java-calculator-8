package calculator.model;

import java.util.LinkedList;

public class Accumulator {
    private int sum;
    private Delimiter delimiter;
    private String expression;

    public Accumulator(Delimiter delimiter, String expression) {
        this.sum = 0;
        this.delimiter = delimiter;
        this.expression = expression;
    }

    public int accumulate() {
        NumberExtractor numberExtractor = new NumberExtractor();
        numberExtractor.extractNumbers(delimiter, expression);
        addNumbers(numberExtractor.getNumberList());
        return sum;
    }

    private void addNumbers(LinkedList<Integer> numberList) {
        for (int i = 0; i < numberList.size(); i++) {
            sum += numberList.get(i);
        }
    }
}
