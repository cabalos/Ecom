package ui.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import static com.codeborne.selenide.Selenide.close;


/**
 * Created by OLEX on 18.02.2018.
 */
public class BaseTestClass {

    @DataProvider(parallel = true)
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{"c", "cabalosos@gmail.com", "newpass123"},
                new Object[]{"f", "cabalasos@gmail.com", "newPass456"}
        };
    }

    public void openBrowser(String param){
        if (param.equalsIgnoreCase("c")) {
            BrowserWebDriverContainer browser = new BrowserWebDriverContainer()
                    .withDesiredCapabilities(DesiredCapabilities.chrome());
            browserSettings(browser);
        } else {

            BrowserWebDriverContainer browser = new BrowserWebDriverContainer()
                    .withDesiredCapabilities(DesiredCapabilities.firefox());
            browserSettings(browser);
        }
    }

    public void browserSettings(BrowserWebDriverContainer myBrowser){
        myBrowser.start();
        RemoteWebDriver driver = myBrowser.getWebDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        close();
    }
}
