package techUplabs.StepDefs;

import com.aventstack.extentreports.GherkinKeyword;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import techUplabs.CommonUtil.BaseUtil.BaseClass;
import techUplabs.CommonUtil.Pages.Conversion;

public class CurrencyConvertStepDefs {

    private BaseClass base;

    public CurrencyConvertStepDefs(BaseClass base) {
        this.base = base;
    }

    @Given("^Configure WebDriver instance$")
    public void configureWebDriverInstance() {
        base.log.info("Configuring Webdriver instance");
        WebDriverManager.chromedriver().setup();
        base.driver = new ChromeDriver();
    }

    Conversion conversion;

    @Given("^User navigates to xe website$")
    public void user_navigates_to_xe_website() throws Throwable {
        base.driver.navigate().to("https://www.xe.com/");
    }

    @And("^Enter amount (\\d+) from \"([^\"]*)\" and To \"([^\"]*)\"$")
    public void enterAmountFromAndTo(float amount, String fromVal, String toVal) throws Throwable {
        conversion = new Conversion(base.driver);
        conversion.enterValuesForConversion(amount, fromVal, toVal);
    }

    @And("^Clicks on convert button$")
    public void clicksOnConvertButton() {
        conversion.convertCurrency();
    }

    @Then("^Converted value should be \"([^\"]*)\"$")
    public void convertedValueShouldBe(String convertedAmount) {
        conversion.assertConversionRate(convertedAmount);
        base.log.info("Assertion Completed");
        base.driver.close();
    }

}
