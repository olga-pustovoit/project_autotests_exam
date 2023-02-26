package pages;

import libs.TestDate;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

class LoginPage extends ParentPage {
    @FindBy(xpath = "")
    private WebElement inputUserName;

    @FindBy(xpath = "")
    private WebElement inputPassword;

    @FindBy(xpath = "")
    private WebElement buttonLogin;

    @FindBy(id = "")
    private WebElement inputLoginRegistration;

    @FindBy(id = "")
    private WebElement inputEmailRegistration;

    @FindBy(id = "")
    private WebElement inputPasswordRegistration;

    private static final String listOfErrorsLocator = "";

    @FindBy(xpath = listOfErrorsLocator)
    private List<WebElement> listOfErrors;
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/";
    }

    public void openLoginPage() {
        try {
            webDriver.get("https://www.yakaboo.ua/");
            logger.info("MainPage was opened");
            logger.info("https://www.yakaboo.ua/");
        } catch (Exception e) {
            logger.error("Can not open Login Page" + e);
            Assert.fail("Can not open Login Page" + e);
        }
    }

    public void enterUserNameIntoInputLogin(String userName) {
//        try {
////            WebElement inputUserName =
////                    webDriver.findElement(By.xpath(".//input[@name='username' and @placeholder='Username']"));
//            inputUserName.clear();
//            inputUserName.sendKeys(userName);
//            logger.info("login was inputted");
//        } catch (Exception e) {
//            printErrorAndStopTest(e);
//        }
        enterTextIntoElement(inputUserName, userName);
    }

    public LoginPage enterPaswordIntoInputPassword(String password) {
//        try {
////            WebElement inputPassword =
////                    webDriver.findElement(By.xpath(".//input[@placeholder='Password']"));
//            inputPassword.clear();
//            inputPassword.sendKeys(password);
//            logger.info("Password was entered");
//        } catch (Exception e) {
//            printErrorAndStopTest(e);
//        }
        enterTextIntoElement(inputPassword, password);
        return this;
    }

    public void clickOnButtonLogin() {
//        try {
////            WebElement buttonLogin =
////                    webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']"));
//            buttonLogin.click();
//            logger.info("Button was clicked");
//        } catch (Exception e) {
//            printErrorAndStopTest(e);
//        }
        clickOnElement(buttonLogin);
    }

    public HomePage fillingLoginFormWithValidCred() {
        enterUserNameIntoInputLogin(TestDate.VALID_LOGIN);
        enterPaswordIntoInputPassword(TestDate.VALID_PASSWORD);
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


}

