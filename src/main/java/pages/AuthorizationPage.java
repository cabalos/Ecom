package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage {
    private SelenideElement
            join = $x("//li/a[@data-nav='nav=nav_SignIn']"),
            inputLogin = $(By.id("new_session_username")),
            inputPassword = $(By.id("new_session_password")),
            buttonSignIn = $(By.id("sign_in")),
            buttonAccount = $x("//li[@class='wide-header right-off-canvas-toggle-menu']"),
            buttonSignOut = $(By.id("hypSignOut"));

    @Step
    public void signIn(String email, String pass) {
        join.click();
        inputLogin.val(email);
        inputPassword.val(pass);
        buttonSignIn.click();
    }

    @Step
    public void signOut(){
        buttonAccount.shouldBe(visible).click();
        buttonSignOut.click();
    }

}
