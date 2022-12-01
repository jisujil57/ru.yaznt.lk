package UiTests.Page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.io.IOException;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница авторизации тестового контура язанят
 */
public class LoginPage {

    private final SelenideElement inputNumber = $x("/html/body/div/div/section/div/div/div/div/fieldset/div/input");
    private final SelenideElement inputPassword = $x("/html/body/div/div/section/div/div/div/div/fieldset[2]/div/input");
    private final SelenideElement nextButton1 = $x("/html/body/div/div/section/div/div/div/div/div/div[1]/button");
    private final SelenideElement nextButton2 = $x("//button[contains(@class, 'btn-dark')]");
    private final SelenideElement nextButton2Disabled = $x("//button[contains(@class, 'disabled')]");
    private final SelenideElement createAccountButton = $x("//a[text() = 'Создать новый аккаунт']");
    private final SelenideElement fullNameUser = $x("/html/body/div[1]/div/div[2]/div/div/div[1]/div/div[1]/div/span");
    private final SelenideElement fullNameCompany = $x("//div[contains(text(),'ГЛОБАЛ ВИЛАДЖ')]");

    public LoginPage(String url) {
        Selenide.open(url);
    }


    public void authorizationUser(String login, String password){
        inputNumber.sendKeys(login);
        nextButton1.click();
        inputPassword.sendKeys(password);
        nextButton2.click();
    }

    public void authorizationUserWithSmallPassword(String login, String password){
        inputNumber.sendKeys(login);
        nextButton1.click();
        inputPassword.sendKeys(password);
    }

    public void authorizationUser(String login){
        inputNumber.sendKeys(login);
        nextButton1.click();
    }

    public String getFullName (){
        return fullNameUser.getText();
    }
    public String getFullNameCompany (){
        return fullNameCompany.getText();
    }

    public Boolean isCreateButton (){
                return createAccountButton.getText().equals("Создать новый аккаунт");
    }

    public Boolean isEnterButton (){
            return Objects.equals(nextButton2Disabled.getAttribute("class"), "btn btn w-100 btn-dark disabled");

    }








}
