package ui.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.AutorizationPage;
import pages.PhotoPage;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by OLEX on 17.02.2018.
 */
public class EcomUITest {
   private BoardPage board;
   private PhotoPage photo;
   private AutorizationPage autorization;

    @Test
    public void newTest()  {
        System.setProperty("webdriver.chromedriver.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("selenide.browser","chromedriver");
        ChromeDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();
        open("https://www.istockphoto.com");
        autorization= new AutorizationPage();
        board = autorization.signIn();
        photo = board.createNewBoard();
        Assert.assertEquals(board.checkBoard(),"newBoard");
        photo.copyPhotoToBoard();
        Assert.assertEquals(photo.checkPhotoIsCreated(),"asset_478130948");
        photo.deletePhoto();
        Assert.assertEquals(photo.checkButtonAddIsDisplayed(),"0 files");
        board.deleteMyBoard();
        Assert.assertEquals(board.checkBoardAreDeleted(),"Collect what you love. Start with a search.");
        board.goToMainPage();
        autorization.signOut();
    }
}
