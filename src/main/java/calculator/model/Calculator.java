package calculator.model;

public class Calculator {
    private int sum;
    String inputString;

    public Calculator(String value){
        sum = 0;
        inputString = value;
    }

    public void calculate(){
        Separator separator = new Separator();
        inputString = separator.separate(inputString);
        Accumulator accumulator = new Accumulator(separator.getDelimiter(), inputString);
        sum = accumulator.accumulate();
    }

    public int getSum(){
        return sum;
    }
}
