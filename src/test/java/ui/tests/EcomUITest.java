package ui.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.AutorizationPage;
import pages.PhotoPage;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by OLEX on 17.02.2018.
 */
public class EcomUITest extends BaseTestClass {

   private BoardPage board;
   private PhotoPage photo;


    @Test(dataProvider = "testData")
    public void newTest(String browser,String email,String pass)  {
        openBrowser(browser);
        open("https://www.istockphoto.com");
        AutorizationPage autorization = new AutorizationPage();
        board = autorization.signIn(email, pass);
        photo = board.createNewBoard();
        Assert.assertEquals(board.checkBoard(),"newBoard");
        photo.copyPhotoToBoard();
        Assert.assertEquals(photo.checkPhotoIsCreated(),"asset_478130948");
        photo.deletePhoto();
        board.deleteMyBoard();
        Assert.assertEquals(board.checkBoardAreDeleted(),"Collect what you love. Start with a search.");
        board.goToMainPage();
        autorization.signOut();
    }
}
