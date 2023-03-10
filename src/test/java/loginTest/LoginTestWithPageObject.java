package loginTest;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.elements.HeaderElement;

public class LoginTestWithPageObject extends BaseTest {

    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterNumberPhoneIntoInputLogin("+380937443200");
        loginPage.enterPasswordIntoInputPassword("12021202");
        loginPage.clickOnButtonLogin();

        Assert.assertTrue("Button is not displayed", loginPage.getHeaderElement().isButtonMyProfileDisplayed() );
    }

}
