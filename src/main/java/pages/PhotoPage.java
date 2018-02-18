package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.refresh;

/**
 * Created by OLEX on 17.02.2018.
 */
public class PhotoPage {
    private SelenideElement
    menuPhotos = $x("//ul/li/a[@data-nav='nav=nav_Photos']"),
    menuCouplePhotos = $x("//img[@alt='Couple photos']/parent::figure"),
    choosePhoto = $(By.id("asset_478130948")),
    addPhoto = $x("//a[@class='add-to-board action ng-scope']"),
    goToBoard = $x("//a[@class='button open-board']"),
    removePhoto = $x("//span[@class='remove']");



    public void copyPhotoToBoard(){
        menuPhotos.click();
        menuCouplePhotos.click();
        choosePhoto.shouldBe(visible).click();
        addPhoto.click();
        goToBoard.click();
    }

    public String checkPhotoIsCreated(){
        String id = choosePhoto.getAttribute("id");
        return id;
    }

    public void deletePhoto()  {
        choosePhoto.hover();
        removePhoto.click();
    }

}
