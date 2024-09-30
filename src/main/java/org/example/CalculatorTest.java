package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorTest {
//f
    CalculatorModel model = new CalculatorModel();
    CalculatorView view = Mockito.mock(CalculatorView.class);
    CalculatorController controller = new CalculatorController(model, view);

    @Test
    public void testAddition() throws Exception {
        Mockito.when(view.getOperand1()).thenReturn(5.0);
        Mockito.when(view.getOperator()).thenReturn('+');
        Mockito.when(view.getOperand2()).thenReturn(3.0);
        assertEquals(8.0, controller.processInput());
    }

    @Test
    public void testSubtraction() throws Exception {
        Mockito.when(view.getOperand1()).thenReturn(5.0);
        Mockito.when(view.getOperator()).thenReturn('-');
        Mockito.when(view.getOperand2()).thenReturn(3.0);
        assertEquals(2.0, controller.processInput());
    }

    @Test
    public void testMultiplication() throws Exception {
        Mockito.when(view.getOperand1()).thenReturn(5.0);
        Mockito.when(view.getOperator()).thenReturn('*');
        Mockito.when(view.getOperand2()).thenReturn(3.0);
        assertEquals(15.0, controller.processInput());
    }

    @Test
    public void testDivision() throws Exception {
        Mockito.when(view.getOperand1()).thenReturn(6.0);
        Mockito.when(view.getOperator()).thenReturn('/');
        Mockito.when(view.getOperand2()).thenReturn(2.0);
        assertEquals(3.0, controller.processInput());
    }

    @Test
    public void testDivisionByZero() {
        Mockito.when(view.getOperand1()).thenReturn(6.0);
        Mockito.when(view.getOperator()).thenReturn('/');
        Mockito.when(view.getOperand2()).thenReturn(0.0);
        assertThrows(ArithmeticException.class, () -> controller.processInput());
    }

    @Test
    public void testInvalidOperator() {
        Mockito.when(view.getOperand1()).thenReturn(6.0);
        Mockito.when(view.getOperator()).thenReturn('%');
        Mockito.when(view.getOperand2()).thenReturn(2.0);
        assertThrows(Exception.class, () -> controller.processInput());
    }

    @Test
    public void testLargeNumbers() throws Exception {
        Mockito.when(view.getOperand1()).thenReturn(1e100);
        Mockito.when(view.getOperator()).thenReturn('+');
        Mockito.when(view.getOperand2()).thenReturn(1e100);
        assertEquals(2e100, controller.processInput());
    }

    @Test
    public void testSmallNumbers() throws Exception {
        Mockito.when(view.getOperand1()).thenReturn(1e-100);
        Mockito.when(view.getOperator()).thenReturn('*');
        Mockito.when(view.getOperand2()).thenReturn(1e-100);
        assertEquals(1e-200, controller.processInput());
    }

    @Test
    public void testZeroes() throws Exception {
        Mockito.when(view.getOperand1()).thenReturn(0.0);
        Mockito.when(view.getOperator()).thenReturn('-');
        Mockito.when(view.getOperand2()).thenReturn(0.0);
        assertEquals(0.0, controller.processInput());
    }
}