package driver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class baseTest {

    final static Logger logger = Logger.getLogger(baseTest.class);
    // Holds the WebDriver instance
    public static WebDriver webDriver;

    // Initialize a webDriver instance of required browser
    // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the webDriver
    @BeforeSuite
    public void initializeDriver(){
        webDriver = DriverFactory.getDriver();
    }

    // Close the webDriver instance
    @AfterSuite
    public void closeDriver(){
        //webDriver.quit();
    }

}
