//package pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import pages.elements.HeaderElement;
//
//public class MyProfilePage extends ParentPage {
//
//    @FindBy(xpath = ".//*[contains(text(),'Бажані книги')]")
//    private WebElement favoriteBooksButton;
//
//    public MyProfilePage(WebDriver webDriver) {
//        super(webDriver);
//    }
//
//    @Override
//    String getRelativeURL() {
//        return "";
//    }
//    HeaderElement headerElement = new HeaderElement(webDriver);
//
//    public MyProfilePage clickOnFavoriteBooksButton (){
//        clickOnElement(favoriteBooksButton);
//        return new MyProfilePage(webDriver);
//    }
//
//}
package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class MyProfilePage extends ParentPage {
    @FindBy(xpath = ".//button[@class=\"ui-btn-close ui-btn-close\" and @data-v-27fe0636 ]")
    private WebElement xButton;

    @FindBy(xpath = ".//*[contains(text(),'Бажані книги')]")
    private WebElement favoriteBooks;

    @FindBy(xpath = ".//button[@class=\"btn btn--create\"]")
    private WebElement createList;

    @FindBy(xpath = ".//input[@name='createWishlist']")
    private WebElement nameList;

    @FindBy(xpath = ".//button[@class=\"ui-btn-primary\"and contains(text(),'Зберегти')]")
    private WebElement saveListButton;

    @FindBy(xpath = ".//span[@title=\"Java Spider\"]")
    private WebElement nameBookLocator;

    @FindBy(xpath = ".//button[@class='btn--info response']")
    private WebElement successButtonAddList;

    @FindBy(xpath = ".//button[@class='ui-btn-secondary']")
    private WebElement notAddRightNow;

    @FindBy(xpath = ".//div[@class='wishlist__aside-item _active']")
    private WebElement hoverToList;

    @FindBy(xpath = ".//div[@class='correct__item']")
    private WebElement deliteListButton;

    @FindBy(xpath = ".//button[@class='btn--info']")
    private WebElement buttonDeletePopUp;

    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
    }
    private HeaderElement headerElement = new HeaderElement(webDriver);
    public HeaderElement getHeaderElement() {
        return headerElement;
    }
    @Override
    String getRelativeURL() {
        return "";
    }

    public MyProfilePage checkIsRedirectToMyProfilePage() {
        Assert.assertTrue("MyProfilePage is not loaded ", isElementDisplayed(xButton));
        return this;
    }

    public MyProfilePage clickOnButtonFavoriteBooks() {
        clickOnElement(favoriteBooks);
        return this;
    }

    public MyProfilePage createListFavoriteBooks(String nameListFavoriteBooks) {
        clickOnElement(createList);
        enterTextIntoElement(nameList, nameListFavoriteBooks);
        clickOnElement(saveListButton);
        return this;
    }

    public MyProfilePage checkWhatBookWasAddToFavoriteList(String nameBook) {
        Assert.assertEquals("Book with this name was not display",nameBook, nameBookLocator.getText());
        return this;
    }

    public MyProfilePage acceptSuccessesButton() {
        clickOnElement(successButtonAddList);
        clickOnElement(notAddRightNow);
        return new MyProfilePage(webDriver);
    }

    public MyProfilePage deleteFavoriteList(String nameList) {
        hoverOnElement(hoverToList);
        clickOnElement(deliteListButton);
        clickOnElement(buttonDeletePopUp);
        logger.info(nameList + " was delete");
        return this;
    }
}