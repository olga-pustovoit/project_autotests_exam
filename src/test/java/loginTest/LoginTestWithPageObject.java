package loginTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Assert;
import org.junit.Test;
import pages.elements.HeaderElement;

public class LoginTestWithPageObject extends BaseTest {

    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterNumberPhoneIntoInputLogin(TestData.VALID_LOGIN);
        loginPage.enterPasswordIntoInputPassword(TestData.VALID_PASSWORD);
        loginPage.clickOnButtonLogin();

        Assert.assertTrue("Button is not displayed", loginPage.getHeaderElement().isButtonMyProfileDisplayed() );
    }

}
