package calculator.model;

public class Calculator {
    private int sum;
    String inputString;

    public Calculator(String value){
        sum = 0;
        inputString = value;
    }

    public void calculate(){
        Delimiter delimiter = new Delimiter();
        Separator separator = new Separator(delimiter);
        separator.separate(inputString);
        Accumulator accumulator = new Accumulator(delimiter, separator.getExpression());
        sum = accumulator.accumulate();
    }

    public int getSum(){
        return sum;
    }
}
