package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class BeforeStep {
    @Given("Open site {string}")
    public void openSite(String arg0) {
        Configuration.timeout = 10000;
        open(arg0);
    }
}
