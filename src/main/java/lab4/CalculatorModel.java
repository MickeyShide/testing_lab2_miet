package lab4;

public class CalculatorModel {
    private double result = -9999.0;

    public void add(double num1, double num2) {
        result = num1 + num2;
    }

    public void subtract(double num1, double num2) {
        result = num1 - num2;
    }

    public void multiply(double num1, double num2) {
        result = num1 * num2;
    }

    public void divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        result = num1 / num2;
    }

    public double getResult() {
        return result;
    }
}