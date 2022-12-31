package techUplabs.CommonUtil.BaseUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class BaseClass {

    static Properties properties = new Properties();

    private static final String CONFIG_PROPERTIES_PATH = "/config/Config.properties";

    public WebDriver driver;

    public static final Logger log = LogManager.getLogger(BaseClass.class);

    private static ObjectMapper mapper = new ObjectMapper();

    public static final String baseURI = "https://samples.openweathermap.org";

    public static void configureRestAssuredFromTestConfiguration() {
        log.info("Configuring Rest Assured... ");
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = baseURI;
    }

    public static <T> T createUsingResource(String resourcePath, Class<T> classType) throws Exception {
        log.info(String.format("Creating %1$s using resource at path '%2$s'",
                classType.getSimpleName(),
                resourcePath));
        String fileContents;
        try
        {
            InputStream resourceAsStream = BaseClass.class.getResourceAsStream(resourcePath);
            if (resourceAsStream == null)
            {
                String errMsg = String.format("Resource '%1$s' was not found!",
                        resourcePath);
                throw new Exception(errMsg);
            }
            fileContents = IOUtils.toString(resourceAsStream, StandardCharsets.UTF_8);
            return mapper.readValue(fileContents, classType);
        }
        catch (Exception ex)
        {
            String errMsg = String.format("%1$s thrown while reading reasource file '%2$s'.",
                    ex.getClass()
                            .getSimpleName(),
                    resourcePath);
            throw new Exception(errMsg);
        }
    }

    public static String getReportConfigPath() throws IOException {
        properties.load(BaseClass.class.getResourceAsStream(CONFIG_PROPERTIES_PATH));
        log.info("Fetching extent config properties from file " + System.getProperty("user.dir") + properties.getProperty("extentreportConfigPath"));
        String reportConfigPath = System.getProperty("user.dir")+properties.getProperty("extentreportConfigPath");
        if(reportConfigPath!= null)
            return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }
}
