package addBookToCart;

import baseTest.BaseTest;
import org.junit.Test;

public class AddBookToCart extends BaseTest {
    String nameBook = "Java Spider";
    String message = "Ваш кошик порожній.";


    @Test
    public void addBookToCart(){
        homePage.openHomePage()
                .waitSuccessMessage()
                .enterTextInSearchField(nameBook)
                .clickOnSearchButton()
                .checkWhatBookWasFind(nameBook)
                .hoverOnBook()
                .clickOnButtonAddToCart()
                .clickOnButtonCart()
                .checkWhatBookWasAddToCart(nameBook)
                .deleteBookFromCart()
                .checkWhatCartIsEmpty(message)
                ;
    }

}
