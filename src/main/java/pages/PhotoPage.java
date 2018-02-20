package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class PhotoPage {
    private SelenideElement
            menuPhotos = $x("//ul/li/a[@data-nav='nav=nav_Photos']"),
            menuCouplePhotos = $x("//img[@alt='Couple photos']/parent::figure"),
            choosePhoto = $x("//img [@class='board-asset' and @id='asset_478130948']"),
            addPhoto = $x("//a[@class='add-to-board action ng-scope']"),
            goToBoard = $x("//a[@class='button open-board']"),
            removePhoto = $x("//span[@class='remove']");

    @Step
    public void copyPhotoToBoard(){
        menuPhotos.click();
        menuCouplePhotos.click();
        choosePhoto.click();
        addPhoto.click();
        goToBoard.click();
    }

    @Step
    public String checkPhotoIsCreated(){
        return choosePhoto.getAttribute("id");
    }

    @Step
    public void deletePhoto()  {
        choosePhoto.hover();
        removePhoto.click();
    }
}
