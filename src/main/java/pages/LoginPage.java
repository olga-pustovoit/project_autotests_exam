package pages;

import libs.TestDate;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.elements.HeaderElement;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends ParentPage {

    HeaderElement headerElement = new HeaderElement(webDriver);
    @FindBy(xpath = ".//input[@name='auth_login']")
    private WebElement inputNumberPhone;

    @FindBy(xpath = ".//input[@name='auth_password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class='ui-btn-primary' and contains(text(), '  Увійти')]")
    private WebElement buttonLogin;

    @FindBy(id = ".//input[@name='reg_firstname']")
    private WebElement inputLoginRegistration;

    @FindBy(id = ".//input[@name='reg_email']")
    private WebElement inputEmailRegistration;

    @FindBy(id = ".//input[@name='reg_password']")
    private WebElement inputPasswordRegistration;

    private static final String listOfErrorsLocator = "";

    @FindBy(xpath = listOfErrorsLocator)
    private List<WebElement> listOfErrors;
    @FindBy(xpath = ".//button[@class='ui-btn-account']")
    private WebElement buttonSignInRegistration;

    @FindBy(xpath = ".//button[@class='ui-btn-link']")
    private WebElement buttonRedirectToSignIn;

    @FindBy(xpath = ".//input[@name='reg_lastname']")
    private WebElement inputSurnameIntoRegistration;

    @FindBy(xpath = ".//input[@type='tel']")
    private WebElement inputPhoneIntoRegistrationForm;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderElement getHeaderElement() {
        return headerElement;
    }
    @Override
    String getRelativeURL() {
        return "/";
    }

    public void openLoginPage() {
        try {
            webDriver.get("https://www.yakaboo.ua/");
            clickOnElement(buttonSignInRegistration);
            logger.info("MainPage was opened");
            logger.info("https://www.yakaboo.ua/");
        } catch (Exception e) {
            logger.error("Can not open Login Page" + e);
            Assert.fail("Can not open Login Page" + e);
        }
    }

    public void enterNumberPhoneIntoInputLogin(String numberPhone) {
        enterTextIntoElement(inputNumberPhone, numberPhone);
    }

    public LoginPage enterPasswordIntoInputPassword(String password) {
        enterTextIntoElement(inputPassword, password);
        return this;
    }

    public void clickOnButtonLogin() {
        clickOnElement(buttonLogin);
    }

    public HomePage fillingLoginFormWithValidCred() {
        enterNumberPhoneIntoInputLogin(TestDate.VALID_LOGIN);
        enterPasswordIntoInputPassword(TestDate.VALID_PASSWORD);
        clickOnButtonLogin();
        return new HomePage(webDriver);
    }

    public boolean isButtonSignInDisplayed() {
        return isElementDisplayed(buttonLogin);
    }

    public LoginPage enterUserNameInRegistrationForm(String userName) {
        enterTextIntoElement(inputLoginRegistration, userName);
        return this;
    }

    public LoginPage enterEmailInRegistrationForm(String email){
        enterTextIntoElement(inputEmailRegistration, email);
        return this;
    }

    public LoginPage enterPasswordInRegistrationForm(String password){
        enterTextIntoElement(inputPasswordRegistration, password);
        return this;
    }

    public LoginPage checkErrorsMessages(String expectedErrors) {
        String[] expectedErrorsArray =  expectedErrors.split(",");
        webDriverWait10
                .withMessage("Number of messages should be " + expectedErrorsArray.length)
                .until(ExpectedConditions
                        .numberOfElementsToBe(By.xpath(listOfErrorsLocator),expectedErrorsArray.length));

        ArrayList<String> actualTextFromErrors = new ArrayList<>();
        for (WebElement element:listOfErrors) {
            actualTextFromErrors.add(element.getText());
        }

        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < expectedErrorsArray.length; i++) {
            softAssertions.assertThat(expectedErrorsArray[i]).as("Message is not equals").isIn(actualTextFromErrors);
        }
        softAssertions.assertAll();

        return this;
    }


    public LoginPage openRegistrationForm() {
        clickOnElement(buttonRedirectToSignIn);
        logger.info("Registration form was opened");
        return new LoginPage(webDriver);
    }

    public LoginPage enterSurnameInRegistrationForm(String surname) {
        enterTextIntoElement(inputSurnameIntoRegistration, surname);
        return this;
    }

    public LoginPage enterPhoneInRegistrationForm(String phone) {
        enterTextIntoElement(inputPhoneIntoRegistrationForm, phone);
        return this;
    }
}

