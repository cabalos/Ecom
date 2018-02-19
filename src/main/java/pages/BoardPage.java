package pages;

import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.confirm;

/**
 * Created by OLEX on 17.02.2018.
 */
public class BoardPage {

    private SelenideElement
    boardMenu = $x("//span[@class='action-label new']"),
    createBoard =$x("//a[@class='board-link create-board-link']"),
    popUpForm =$(By.name("form")),
    addBoard = popUpForm.$(By.name("boardname")),
    buttonCreateBoard = popUpForm.$x("//a[@type='submit']"),
    myBoardName = $x("//ul/li/a[@class='board-item-link']"),
    deleteBoard =$x("//a[@class='delete-board ng-scope']"),
    messageAfterDelete = $x("//h4[@class='message']"),
    mainPage = $x("//img[@alt='iStock logo']");


public PhotoPage createNewBoard(){
    boardMenu.hover().click();
    createBoard.hover().shouldBe(visible).click();
    addBoard.shouldBe(visible).val("newBoard");
    buttonCreateBoard.click();
    return new PhotoPage();
}

public String checkBoard(){
    boardMenu.click();
    String boardName = myBoardName.getText();
    return  boardName;
}

public void deleteMyBoard(){
    deleteBoard.click();
    confirm("Are you sure you want to delete this Board?");
}

public String checkBoardAreDeleted(){
      String message = messageAfterDelete.should(visible).getText();
      return message;
}

public void goToMainPage(){
mainPage.click();
}
}
