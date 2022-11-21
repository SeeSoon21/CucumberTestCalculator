package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorSteps {
    private final SelenideElement closeButton = $x("//input[@value='c']");
    private final SelenideElement inputField = $x("//input[@id='result']");
    private final SelenideElement errorMessage = $x("//span[@id='errorMessage']");
    private final SelenideElement result = $x("//input[@value='=']");

    private final String expressionIsWrongError = "Your expression is wrong!";
    private final String emptyExpressionError = "Expression cannot be empty!";

    @When("all buttons are visible")
    public void allButtonsAreVisible() {
        closeButton.click();
    }

    @Then("Close test")
    public void closeTest() {
        System.out.println("Closed!");
    }

    @When("empty expression is entered")
    public void emptyExpressionIsEntered() {
        inputField.sendKeys("   ");
    }

    @And("press the button")
    public void pressTheButton() {
        result.click();
    }

    @And("error message received")
    public void errorMessageReceived() {
        assertEquals(emptyExpressionError, errorMessage.getText());
    }

    @Then("expression is wrong message")
    public void expressionIsWrongMessage() {
        assertEquals(expressionIsWrongError, errorMessage.getText());
    }

    @And("characters is entered")
    public void charactersIsEntered() {
        inputField.sendKeys("aaa");
    }

    @And("term is entered")
    public void termIsEntered() {
        inputField.sendKeys("123");
    }

    @And("term and action is entered")
    public void termAndActionIsEntered() {
        inputField.sendKeys("123 + ");
    }

    @Then("response received")
    public void responseReceived() {
        //если пользователь ввёл неверно -- inputField будет пустым, на это и проверим.
        String result = inputField.getText();
        System.out.println("RESULT:" + result);
        boolean boo = StringUtils.isEmpty(inputField.getText());
        assertTrue(boo);
    }

    @And("{string}, {string}, {string} is entered")
    public void isEntered(String term1, String action, String term2) {
        String inputExpression = term1 + action + term2;
        inputField.sendKeys(inputExpression);
    }
}
