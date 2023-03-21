package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;
import java.time.Duration;

public class HomePage extends ParentPage{

    @FindBy(xpath = ".//input[@type='search']")
    private WebElement inputSearchField;

    @FindBy(xpath = ".//*[contains(text(),'Знайти')]")
    private WebElement buttonSearch;

    @FindBy(xpath = ".//span[@title='Java Spider']")
    private WebElement locatorBook;

    @FindBy(xpath = ".//button[@class='auth__icon ui-btn-nav-circle ']")
    private WebElement profileButton;

    @FindBy(xpath = ".//button[@class='ui-btn-secondary add-to-cart'][1]")
    private WebElement addToCartButton;

    @FindBy(xpath = ".//*[@class='category-card category-layout expanded']")
    private WebElement imgBook;

    @FindBy(xpath = ".//button[@class='auth__icon ui-btn-nav-circle ']")
    private WebElement webElement;

    @FindBy(xpath = ".//div[@data-testid='notificationMessage']")
    private WebElement successMessage;

    @FindBy(xpath = ".//button[@class='ui-btn-favorite square']")
    private WebElement buttonAddToFavorite;

    @FindBy(xpath = ".//span[@class='h4 pointer ui-filter-checkbox__text'and contains(text(),'My Favorite List') ]")
    private WebElement checkBoxList;

    @FindBy(xpath = ".//*[@class='product-name']")
    private WebElement nameBooklocator;

    @FindBy(xpath = ".//button[@class='ui-btn-shopping-cart']")
    private WebElement buttonCart;

    @FindBy(xpath = ".//span[@class='header-clear-cart']")
    private WebElement deleteBookButton;

    @FindBy(xpath = ".//button[@class='btn--info'][2]")
    private WebElement OKButton;

    @FindBy(xpath = ".//span[@class='microcart-empty-title']")
    private WebElement checkMessageDeleteBookFromCart;
    public HomePage(WebDriver webDriver) {
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


    public HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        logger.info("Login page was open");
        if(!headerElement.isButtonMyProfileDisplayed()) {
            loginPage.fillingLoginFormWithValidCred();
        }
        checkIsRedirectToHomePage();
        logger.info("home");
        return this;
    }

    public HomePage checkIsRedirectToHomePage() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        Assert.assertTrue("HomePage is not loaded", getHeaderElement().isButtonMyProfileDisplayed());
        return this;
    }

    public HomePage enterTextInSearchField(String bookName) {
        enterTextIntoElement(inputSearchField, bookName);
        return this;
    }

    public HomePage clickOnSearchButton() {
        clickOnElement(buttonSearch);
        return new HomePage(webDriver);
    }

    public HomePage checkWhatBookWasFind(String nameBook) {
        Assert.assertEquals("The book with this name wasn't find", nameBook, locatorBook.getText());
        return this;
    }

    public HomePage clickOnButtonAddToCart() {
        clickOnElement(addToCartButton);
        return this;
    }


    public HomePage waitSuccessMessage() {
        isElementDisplayed(successMessage);
        return this;
    }

    public HomePage clickOnButtonAddToFavorite() {
        hoverOnElement(imgBook);
        clickOnElement(buttonAddToFavorite);
        return this;
    }

    public HomePage chooseFavoriteListCheckBox(String nameList) {
        clickOnElement(checkBoxList);
        return this;
    }

    public HomePage hoverOnBook() {
        hoverOnElement(imgBook);
        return this;
    }

    public HomePage checkWhatBookWasAddToCart(String nameBook) {
        Assert.assertEquals("Book was not add to cart",nameBook, nameBooklocator.getText());
        return this;
    }

    public HomePage clickOnButtonCart() {
        clickOnElement(buttonCart);
        return new HomePage(webDriver);
    }

    public HomePage deleteBookFromCart() {
        clickOnElement(deleteBookButton);
        clickOnElement(OKButton);
 return new HomePage(webDriver);
    }

    public HomePage checkWhatCartIsEmpty(String message) {
        Assert.assertEquals("Massage what cart is empty was not display", message, checkMessageDeleteBookFromCart.getText());
        return this;
    }
}
