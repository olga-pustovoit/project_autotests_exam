package pages.elements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.HomePage;
import pages.MyProfilePage;

public class HeaderElement extends CommonActionsWithElements {
   @FindBy(xpath = ".//button[@class='auth__icon ui-btn-nav-circle ']")
   private WebElement buttonMyProfile;

//    @FindBy(xpath =".//button[text()='Sign Out']")
//    private WebElement signOutButton;
//    @FindBy(xpath = ".//*[@href='/create-post']")
//    private WebElement buttonCreatePost;

    @FindBy(xpath = ".//input[@type='search']")
    private WebElement inputSearchField;

    @FindBy(xpath = ".//*[contains(text(),'Знайти')]")
    private WebElement buttonSearch;

    private String nameOfBook = ".//*[@class='product-listing view-search']";

    @FindBy(xpath = ".//span[@title='Java Spider']")
    private WebElement locatorBook;

    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }
    public MyProfilePage clickOnMyProfileButton() {
        clickOnElement(buttonMyProfile);
        return new MyProfilePage(webDriver);
    }

    public boolean isButtonMyProfileDisplayed() {
        return isElementDisplayed(buttonMyProfile);
    }
//
//    public CreatePostPage clickOnCreatePostButton() {
//        clickOnElement(buttonCreatePost);
//        return new CreatePostPage(webDriver);
//    }

    public HomePage enterTextInSearchField(String bookName) {
        enterTextIntoElement(inputSearchField, bookName);
        return new HomePage(webDriver);
    }

    public HomePage clickOnSearchButton() {
        clickOnElement(buttonSearch);
        return new HomePage(webDriver);
    }

    public HomePage checkWhatBookWasFind(String nameBook) {
        Assert.assertEquals("The book with this name wasn't find",nameBook, locatorBook.getText());
        return new HomePage(webDriver);
    }

}

