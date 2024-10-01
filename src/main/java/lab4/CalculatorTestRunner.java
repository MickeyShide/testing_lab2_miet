package lab4;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/lab4/calculator.feature",
        glue = "lab4"
)
public class CalculatorTestRunner {
}