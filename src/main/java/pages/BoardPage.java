package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.confirm;

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

    @Step
    public void createNewBoard(){
        boardMenu.click();
        createBoard.hover().click();
        addBoard.shouldBe(visible).val("newBoard");
        buttonCreateBoard.click();
    }

    @Step
    public String checkBoard(){
        boardMenu.click();
        return myBoardName.shouldBe(exist).getText();
    }

    @Step
    public void deleteMyBoard(){
        deleteBoard.click();
        confirm("Are you sure you want to delete this Board?");
    }

    @Step
    public String checkMessageAfterBoardDeleted(){
        return messageAfterDelete.should(visible).getText();
    }

    public void goToMainPage(){
        mainPage.click();
    }
}
