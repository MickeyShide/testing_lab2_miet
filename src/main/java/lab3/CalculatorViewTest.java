package lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


public class CalculatorViewTest {

    private CalculatorView calculatorView;
    private CalculatorController mockController; // Mock-объект контроллера

    @BeforeEach
    public void setUp() {
        mockController = Mockito.mock(CalculatorController.class);
        calculatorView = new CalculatorView();
        calculatorView.controller = mockController; // Заменяем реальный контроллер на mock-объект
        calculatorView.setVisible(true);
    }

    @Test
    public void testPlusButtonClick() throws Exception {
        calculatorView.plus.doClick();
        verify(mockController).processInput('+'); // Проверяем, что метод processInput вызван с '+'
    }

    @Test
    public void testMinusButtonClick() throws Exception {
        calculatorView.minus.doClick();
        verify(mockController).processInput('-');
    }

    @Test
    public void testMultiplyButtonClick() throws Exception {
        calculatorView.multiply.doClick();
        verify(mockController).processInput('*');
    }

    @Test
    public void testDivideButtonClick() throws Exception {
        calculatorView.divide.doClick();
        verify(mockController).processInput('/');
    }

    @Test
    public void testErrorDisplay() throws Exception {
        doThrow(new RuntimeException("Division by zero!!!")).when(mockController).processInput('/');
        calculatorView.divide.doClick();
        verify(mockController).error("java.lang.RuntimeException: Division by zero!!!");
    }
}