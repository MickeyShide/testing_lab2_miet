package lab4;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CalculatorStepDefinitions {

    private CalculatorModel model = new CalculatorModel();
    private CalculatorView view = Mockito.mock(CalculatorView.class);
    private CalculatorController controller = new CalculatorController(model, view);

    private CalculatorView calculatorView;
    private CalculatorController mockController;

    @Given("the first number is {double}")
    public void givenFirstNumber(double num) {
        Mockito.when(view.getOperand1()).thenReturn(num);
    }

    @Given("the second number is {double}")
    public void givenSecondNumber(double num) {
        Mockito.when(view.getOperand2()).thenReturn(num);
    }

    @When("the user presses plus")
    public void userPressesPlus() throws Exception {
        controller.processInput('+');
    }

    @When("the user presses minus")
    public void userPressesMinus() throws Exception {
        controller.processInput('-');
    }

    @When("the user presses multiply")
    public void userPressesMultiply() throws Exception {
        controller.processInput('*');
    }

    @When("the user presses divide")
    public void userPressesDivide() throws Exception {
        controller.processInput('/');
    }

    @Then("the result should be {double}")
    public void resultShouldBe(double expectedResult) {
        assertEquals(expectedResult, model.getResult());
    }

    @Then("an ArithmeticException should be thrown")
    public void arithmeticExceptionShouldBeThrown() {
        verify(view).displayMessage("java.lang.ArithmeticException: Division by zero!");
    }

    @Then("an exception should be thrown")
    public void exceptionShouldBeThrown() {
        assertThrows(Exception.class, () -> controller.processInput('%'));
    }

    @Given("the calculator is initialized")
    public void calculatorIsInitialized() {
        mockController = Mockito.mock(CalculatorController.class);
        calculatorView = new CalculatorView();
        calculatorView.controller = mockController;
        calculatorView.setVisible(true);
    }

    @When("the user clicks the plus button")
    public void userClicksPlusButton() {
        calculatorView.plus.doClick();
    }

    @When("the user clicks the minus button")
    public void userClicksMinusButton() {
        calculatorView.minus.doClick();
    }

    @When("the user clicks the multiply button")
    public void userClicksMultiplyButton() {
        calculatorView.multiply.doClick();
    }

    @When("the user clicks the divide button")
    public void userClicksDivideButton() {
        calculatorView.divide.doClick();
    }

    @Then("the controller's processInput method should be called with '+'")
    public void verifyProcessInputCalledWithPlus() throws Exception {
        verify(mockController).processInput('+');
    }

    @Then("the controller's processInput method should be called with '-'")
    public void verifyProcessInputCalledWithMinus() throws Exception {
        verify(mockController).processInput('-');
    }

    @Then("the controller's processInput method should be called with '*'")
    public void verifyProcessInputCalledWithMultiply() throws Exception {
        verify(mockController).processInput('*');
    }

    @Then("the controller's processInput method should be called with '\\/'")
    public void verifyProcessInputCalledWithDivide() throws Exception {
        verify(mockController).processInput('/');
    }

    @Then("the controller's error method should be called with an error message")
    public void verifyErrorCalledOnDivideByZero() throws Exception {
        doThrow(new RuntimeException("Division by zero!!!")).when(mockController).processInput('/');
        calculatorView.divide.doClick();
        verify(mockController).error("java.lang.RuntimeException: Division by zero!!!");
    }
}