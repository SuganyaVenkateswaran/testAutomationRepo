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
            features = {"@target/failedrerun.txt"},
            glue = {"techUplabs/StepDefs"},
            plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
    )

    public class FailedTestsRunner {
        @AfterClass
        public static void writeExtentReport() throws IOException {
            Reporter.loadXMLConfig(new File(BaseClass.getReportConfigPath()));
        }
    }

