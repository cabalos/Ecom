package ui.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.AutorizationPage;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by OLEX on 18.02.2018.
 */
public class BaseTestClass {

    public void openBrowser(String param){
        if (param.equalsIgnoreCase("c")) {
            BrowserWebDriverContainer browser = new BrowserWebDriverContainer();
            browser.withDesiredCapabilities(DesiredCapabilities.chrome());
            open("https://www.istockphoto.com");
            new AutorizationPage().signIn("cabalosos@gmail.com","newpass123");
        }
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        System.setProperty("selenide.browser","marionette");
        FirefoxDriver driver = new FirefoxDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();
        open("https://www.istockphoto.com");
        new AutorizationPage().signIn("cabalasos@gmail.com","newPass456");
    }

    @AfterTest
    public void teatDown(){
        close();
    }
}
