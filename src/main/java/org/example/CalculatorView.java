package org.example;

import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner;

    public CalculatorView() {
        scanner = new Scanner(System.in);
    }

    public
    void displayMessage(String message) {
        System.out.println(message);
    }

    public double getOperand1() {
        displayMessage("Введите первое число: ");
        return scanner.nextDouble();
    }

    public double getOperand2() {
        displayMessage("Введите врторое число: ");
        return scanner.nextDouble();
    }

    public char getOperator() {
        displayMessage("Введите оператор (+, -, *, /): ");
        return scanner.next().charAt(0);
    }

    public void displayResult(double result) {
        displayMessage("Результат: " + result);
    }
}