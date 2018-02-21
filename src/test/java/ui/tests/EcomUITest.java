package ui.tests;

import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.AuthorizationPage;
import pages.PhotoPage;
import static org.testng.Assert.*;

public class EcomUITest extends BaseTestClass {
   private BoardPage board;
   private PhotoPage photo;
   private AuthorizationPage authorization;

    @Epic("UI Tests")
    @Test(dataProvider = "testData")
    public void check_Istockphoto_UI(String browser,String email,String pass)  {
        openBrowser(browser);
        authorization = new AuthorizationPage();
        authorization.signIn(email, pass);
        board = new BoardPage();
        board.createNewBoard();
        assertEquals(board.checkBoard(),"newBoard");
        photo = new PhotoPage();
        photo.copyPhotoToBoard();
        assertEquals(photo.checkPhotoByAttributeId(),"asset_478130948");
        photo.deletePhoto();
        board.deleteMyBoard();
        assertEquals(board.checkMessageAfterBoardDeleted(),"Collect what you love. Start with a search.");
        board.goToMainPage();
        authorization.signOut();
    }
}
