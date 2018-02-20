package ui.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;


public class BaseTestClass {

    @DataProvider(parallel = true)
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{"chrome", "cabalosos@gmail.com", "newpass123"},
                new Object[]{"firefox", "cabalasos@gmail.com", "newPass456"}
        };
    }

    public void openBrowser(String param) {
        switch (param) {
            case "chrome": {
                BrowserWebDriverContainer browser = new BrowserWebDriverContainer()
                        .withDesiredCapabilities(DesiredCapabilities.chrome());
                setDriver(browser);
                open("https://www.istockphoto.com");
                break;
            }
            case "firefox": {
                BrowserWebDriverContainer browser = new BrowserWebDriverContainer()
                        .withDesiredCapabilities(DesiredCapabilities.firefox());
                setDriver(browser);
                open("https://www.istockphoto.com");
                break;
            }
        }
    }

    public void setDriver(BrowserWebDriverContainer browser){
        browser.start();
        RemoteWebDriver driver = browser.getWebDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        close();
    }
}
