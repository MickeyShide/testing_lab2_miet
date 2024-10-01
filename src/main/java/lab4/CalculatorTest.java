package lab4;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorTest {

    CalculatorModel model = new CalculatorModel();
    CalculatorView view = Mockito.mock(CalculatorView.class);
    CalculatorController controller = new CalculatorController(model, view);

    @Test
    public void testAddition() throws Exception {
        Mockito.when(view.getOperand1()).thenReturn(5.0);
        Mockito.when(view.getOperand2()).thenReturn(3.0);
        assertEquals(8.0, controller.processInput('+'));
        assertEquals(8.0, model.getResult());
    }

    @Test
    public void testSubtraction() throws Exception {
        Mockito.when(view.getOperand1()).thenReturn(5.0);
        Mockito.when(view.getOperand2()).thenReturn(3.0);
        assertEquals(2.0, controller.processInput('-'));
        assertEquals(2.0, model.getResult());
    }

    @Test
    public void testMultiplication() throws Exception {
        Mockito.when(view.getOperand1()).thenReturn(5.0);
        Mockito.when(view.getOperand2()).thenReturn(3.0);
        assertEquals(15.0, controller.processInput('*'));
        assertEquals(15.0, model.getResult());
    }

    @Test
    public void testDivision() throws Exception {
        Mockito.when(view.getOperand1()).thenReturn(6.0);
        Mockito.when(view.getOperand2()).thenReturn(2.0);
        assertEquals(3.0, controller.processInput('/'));
        assertEquals(3.0, model.getResult());
    }

    @Test
    public void testDivisionByZero() {
        Mockito.when(view.getOperand1()).thenReturn(6.0);
        Mockito.when(view.getOperand2()).thenReturn(0.0);
        assertThrows(ArithmeticException.class, () -> controller.processInput('/'));
    }

    @Test
    public void testInvalidOperator() {
        Mockito.when(view.getOperand1()).thenReturn(6.0);
        Mockito.when(view.getOperand2()).thenReturn(2.0);
        assertThrows(Exception.class, () -> controller.processInput('%'));
    }

    @Test
    public void testLargeNumbers() throws Exception {
        Mockito.when(view.getOperand1()).thenReturn(1e100);
        Mockito.when(view.getOperand2()).thenReturn(1e100);
        assertEquals(2e100, controller.processInput('+'));
        assertEquals(2e100, model.getResult());
    }

    @Test
    public void testSmallNumbers() throws Exception {
        Mockito.when(view.getOperand1()).thenReturn(1e-100);
        Mockito.when(view.getOperand2()).thenReturn(1e-100);
        assertEquals(1e-200, controller.processInput('*'));
        assertEquals(1e-200, model.getResult());
    }

    @Test
    public void testZeroes() throws Exception {
        Mockito.when(view.getOperand1()).thenReturn(0.0);
        Mockito.when(view.getOperand2()).thenReturn(0.0);
        assertEquals(0.0, controller.processInput('-'));
        assertEquals(0.0, model.getResult());
    }
}