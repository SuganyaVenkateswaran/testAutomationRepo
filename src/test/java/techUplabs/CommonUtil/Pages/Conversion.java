package techUplabs.CommonUtil.Pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Conversion {

    WebDriver driver;

    public Conversion(WebDriver driver) {
        this.driver = driver;
    }

    By Amount = By.xpath("//input[@id='amount']");

    By From = By.id("midmarketFromCurrency");

    By To = By.id("midmarketToCurrency");

    By Convert = By.xpath("//button[text()='Convert']");

    By ConversionRate = By.xpath("//*[contains(@class,'result__Big')]");

    public void enterValuesForConversion(Float amount, String from, String to) {
        driver.findElement(Amount).sendKeys(amount.toString());
        driver.findElement(From).sendKeys(from);
        driver.findElement(From).sendKeys(Keys.ENTER);
        driver.findElement(To).sendKeys(to);
        driver.findElement(To).sendKeys(Keys.ENTER);
    }

    public void convertCurrency() {
        driver.findElement(Convert).click();
    }

    public void assertConversionRate(String expectedValue){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConversionRate));
        String conversionRate = driver.findElement(ConversionRate).getText();
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(conversionRate).contains(expectedValue);
        assertions.assertAll();
    }

}
