package lab3;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel
                                        model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public double processInput(char operator) {
        double num1 = view.getOperand1();
        double num2 = view.getOperand2();

        try {
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
            }
        } catch (Exception ex) {
            this.error(ex.toString());
            System.out.println("Asdfsldjfngk.jsdfgnbjfdanjkdfgnASJDGNFJSDFGJ");
        }

        double result = model.getResult();
        view.displayResult(result);
        return result;
    }

    public void error(String message) {
        view.displayMessage(message);
        System.out.println("easdasd");
    }
}