package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;

public class HeaderElement extends CommonActionsWithElements {
   @FindBy(xpath = ".//button[@class='auth__icon ui-btn-nav-circle ']")
   private WebElement buttonMyProfile;

//    @FindBy(xpath = ".//*[@data-original-title='My Profile']")
//    private WebElement buttonMyProfile;

    @FindBy(xpath =".//button[text()='Sign Out']")
    private WebElement signOutButton;
    @FindBy(xpath = ".//*[@href='/create-post']")
    private WebElement buttonCreatePost;

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

//    public MyProfilePage clickOnMyProfileButton() {
//        clickOnElement(buttonMyProfile);
//        return new MyProfilePage(webDriver);
//    }
//
    public boolean isButtonMyProfileDisplayed() {
        return isElementDisplayed(buttonMyProfile);
    }
//
//    public CreatePostPage clickOnCreatePostButton() {
//        clickOnElement(buttonCreatePost);
//        return new CreatePostPage(webDriver);
//    }

}

