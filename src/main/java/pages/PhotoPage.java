package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Selenide.$x;


/**
 * Created by OLEX on 17.02.2018.
 */
public class PhotoPage {
    private SelenideElement
            menuPhotos = $x("//ul/li/a[@data-nav='nav=nav_Photos']"),
            menuCouplePhotos = $x("//img[@alt='Couple photos']/parent::figure"),
            choosePhoto = $x("//img [@class='board-asset' and @id='asset_478130948']"),
            addPhoto = $x("//a[@class='add-to-board action ng-scope']"),
            goToBoard = $x("//a[@class='button open-board']"),
            removePhoto = $x("//span[@class='remove']");



    public void copyPhotoToBoard(){
        menuPhotos.click();
        menuCouplePhotos.click();
        choosePhoto.click();
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
