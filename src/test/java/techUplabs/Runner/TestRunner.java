package techUplabs.Runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import techUplabs.CommonUtil.BaseUtil.BaseClass;

import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"src/test/resources/Features/"},
            glue = {"techUplabs/StepDefs"},
            tags = {"@WeatherApp"},
            plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
                    "rerun:target/failedrerun.txt"}
    )

    public class TestRunner {
    @AfterClass
    public static void writeExtentReport() throws IOException {
        Reporter.loadXMLConfig(new File(BaseClass.getReportConfigPath()));
    }
}
