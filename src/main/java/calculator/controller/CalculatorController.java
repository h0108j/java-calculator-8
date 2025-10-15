package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run(){
        Calculator calculator = post();
        calculator.calculate();
        get(calculator);
    }

    public Calculator post() {
        return new Calculator(inputView.inputValue());
    }

    public void get(Calculator calculator) {
        outputView.outputValue(calculator);
    }
}
