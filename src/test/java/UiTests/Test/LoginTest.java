package UiTests.Test;

import UiTests.Page.LoginPage;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginTest extends BaseTest {

    private final static String AUTHORIZATION_PAGE = BASE_URL +"login";
    private final static String NAME_SMZ = "Грохочущий Аврелиевич Оберег";
    private final static String NAME_COMPANY = "ГЛОБАЛ ВИЛАДЖ";
    private final static String ERROR_PHONE_NUMBER = "Пользователь с таким номером не зарегистрирован";

    private final static String NUMBER_SMZ = "9996020655";
    private final static String NUMBER_SMZ_INVALID = "9632587412";
    private final static String PASSWORD_SMZ = "123456";
    private final static String PASSWORD_SMZ_INVALID = "12345216";

    private final static String NUMBER_COMPANY = "1111111111";
    private final static String PASSWORD_COMPANY = "123456";

    @Test
    public void logInSmzInvalidPhoneNumber(){

        LoginPage loginPage = new LoginPage(AUTHORIZATION_PAGE);
        loginPage.authorizationUser(NUMBER_SMZ_INVALID);
        SelenideElement errorPhoneMassage = $x("/html/body/div/div/section/div/div/div/div/fieldset/div/span").shouldBe(visible).shouldHave(text("Пользователь с таким номером не зарегистрирован"));
        Assert.assertEquals(ERROR_PHONE_NUMBER, errorPhoneMassage.getText());

    }

    @Test
    public void logInSmzInvalidPassword(){

        LoginPage loginPage = new LoginPage(AUTHORIZATION_PAGE);
        loginPage.authorizationUser(NUMBER_SMZ, PASSWORD_SMZ_INVALID);
        SelenideElement errorPasswordMassage = $x("//*[text()='Неверный пароль']").shouldBe(visible);
        Assert.assertEquals("Неверный пароль", errorPasswordMassage.shouldBe(visible).getText());

    }

    @Test
    public void logInSmzSmallNumber(){

        LoginPage loginPage = new LoginPage(AUTHORIZATION_PAGE);
        loginPage.authorizationUser("756544565");
        Assert.assertEquals(true,loginPage.isCreateButton());

    }

    @Test
    public void logInSmzSmallPassword(){

        LoginPage loginPage = new LoginPage(AUTHORIZATION_PAGE);
        loginPage.authorizationUserWithSmallPassword(NUMBER_SMZ, "12345");
        Assert.assertEquals(true,loginPage.isEnterButton());


    }

    ///////////////////////Тест СМЗ////////////////////////////////////
    @Test
    public void logInSmz(){

        LoginPage loginPage = new LoginPage(AUTHORIZATION_PAGE);
        loginPage.authorizationUser(NUMBER_SMZ, PASSWORD_SMZ);
        Assert.assertEquals(NAME_SMZ, loginPage.getFullName());

    }


    ///////////////////////Тест компании ////////////////////////////////////
    @Test
    public void logInCompany(){

        LoginPage loginPage = new LoginPage(AUTHORIZATION_PAGE);
        loginPage.authorizationUser(NUMBER_COMPANY, PASSWORD_COMPANY);
        Assert.assertEquals(NAME_COMPANY, loginPage.getFullNameCompany());

    }


}
