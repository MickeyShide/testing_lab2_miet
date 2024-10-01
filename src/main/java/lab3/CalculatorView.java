package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    public final JTextField inputA = new JTextField("", 5);
    public final JTextField inputB = new JTextField("", 5);
    public final JLabel output = new JLabel("", SwingConstants.CENTER);
    public final JLabel equals = new JLabel("=", SwingConstants.CENTER);
    public final JButton plus = new JButton("+");
    public final JButton minus = new JButton("-");
    public final JButton multiply = new JButton("*");
    public final JButton divide = new JButton("/");
    CalculatorController controller = new CalculatorController(new CalculatorModel(), this);

    public CalculatorView() {
        super("Calculator");
        setBounds(100, 100, 650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 1));
        p1.add(new JLabel("Калькулятор :) ПИН-32 Густомясов Никита"));
        inputA.setFont(new Font(equals.getFont().getName(), Font.PLAIN, 40));
        inputA.setHorizontalAlignment(JTextField.CENTER);
        p1.add(inputA);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 4));
        plus.setFont(new Font(equals.getFont().getName(), Font.PLAIN, 40));
        minus.setFont(new Font(equals.getFont().getName(), Font.PLAIN, 40));
        multiply.setFont(new Font(equals.getFont().getName(), Font.PLAIN, 40));
        divide.setFont(new Font(equals.getFont().getName(), Font.PLAIN, 40));
        p2.add(plus);
        p2.add(minus);
        p2.add(multiply);
        p2.add(divide);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1));
        inputB.setFont(new Font(equals.getFont().getName(), Font.PLAIN, 40));
        inputB.setHorizontalAlignment(JTextField.CENTER);
        p3.add(inputB);

        JPanel p4 = new JPanel();
        p4.setLayout(new GridLayout(1, 4));
        equals.setFont(new Font(equals.getFont().getName(), Font.PLAIN, 30));
        p4.add(equals);


        JPanel p5 = new JPanel();
        p5.setLayout(new BorderLayout());
        output.setFont(new Font(equals.getFont().getName(), Font.PLAIN, 30));
        p5.add(output, BorderLayout.CENTER);


        container.setLayout(new GridLayout(5, 5));
        container.add(p1);
        container.add(p2);
        container.add(p3);
        container.add(p4);
        container.add(p5);

        plus.addActionListener(new PlusListener());
        minus.addActionListener(new MinusListener());
        multiply.addActionListener(new MultListener());
        divide.addActionListener(new DivListener());
    }

    public static void main(String[] args) {
        CalculatorView app = new CalculatorView();
        app.setVisible(true);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
        System.out.println(message);
    }

    public double getOperand1() {
        /*displayMessage("Введите первое число: ");
        return scanner.nextDouble();*/
        return Double.parseDouble(inputA.getText());
    }

    public double getOperand2() {
        /*displayMessage("Введите врторое число: ");
        return scanner.nextDouble();*/
        return Double.parseDouble(inputB.getText());
    }

    public void displayResult(double result) {
        //displayMessage("Результат: " + result);
        output.setText(Double.toString(result));
    }

    class PlusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                controller.processInput('+');
            } catch (Exception ex) {
                controller.error(ex.toString());
            }
        }
    }

    class MinusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                controller.processInput('-');
            } catch (Exception ex) {
                controller.error(ex.toString());
            }
        }
    }

    class MultListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                controller.processInput('*');
            } catch (Exception ex) {
                controller.error(ex.toString());
            }
        }
    }

    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                controller.processInput('/');
            } catch (Exception ex) {
                controller.error(ex.toString());
                ;
            }
        }
    }

}