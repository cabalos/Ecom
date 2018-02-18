package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by OLEX on 17.02.2018.
 */
public class AutorizationPage {

    private SelenideElement
    join = $x("//li/a[@data-nav='nav=nav_SignIn']"),
    inputLogin = $(By.id("new_session_username")),
    inputPassword = $(By.id("new_session_password")),
    buttonSignIn = $(By.id("sign_in")),
    buttonAccount = $x("//li[@class='wide-header right-off-canvas-toggle-menu']"),
    buttonSignOut = $(By.id("hypSignOut"));


    public AutorizationPage() {
    }

    public BoardPage signIn() {
        join.click();
        inputLogin.val("cabalosos@gmail.com");
        inputPassword.val("newpass123");
        buttonSignIn.click();
        return new BoardPage();
    }

    public void signOut(){
        buttonAccount.shouldBe(visible).click();
        buttonSignOut.click();
    }

}
