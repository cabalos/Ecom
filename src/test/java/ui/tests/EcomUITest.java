package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.AuthorizationPage;
import pages.PhotoPage;
import static com.codeborne.selenide.Selenide.open;


public class EcomUITest extends BaseTestClass {

   private BoardPage board;
   private PhotoPage photo;
   private AuthorizationPage authorization;


    @Test(dataProvider = "testData")
    public void newTest(String browser,String email,String pass)  {
        openBrowser(browser);
        open("https://www.istockphoto.com");
        authorization = new AuthorizationPage();
        authorization.signIn(email, pass);
        board = new BoardPage();
        board.createNewBoard();
        Assert.assertEquals(board.checkBoard(),"newBoard");
        photo = new PhotoPage();
        photo.copyPhotoToBoard();
        Assert.assertEquals(photo.checkPhotoIsCreated(),"asset_478130948");
        photo.deletePhoto();
        board.deleteMyBoard();
        Assert.assertEquals(board.checkBoardAreDeleted(),"Collect what you love. Start with a search.");
        board.goToMainPage();
        authorization.signOut();
    }
}
