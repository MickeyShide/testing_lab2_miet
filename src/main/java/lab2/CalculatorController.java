package lab2;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel
                                        model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public double processInput() throws Exception {
        double num1 = view.getOperand1();
        char operator = view.getOperator();
        double num2 = view.getOperand2();

        switch (operator) {
            case '+':
                model.add(num1, num2);
                break;
            case '-':
                model.subtract(num1, num2);
                break;
            case '*':
                model.multiply(num1, num2);
                break;
            case '/':
                model.divide(num1, num2);
                break;
            default:
                view.displayMessage("Неверный оператор!");
                throw new Exception("Неверный оператор!");
        }

        double result = model.getResult();
        view.displayResult(result);
        return result;
    }
}