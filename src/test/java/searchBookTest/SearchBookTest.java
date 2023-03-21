package searchBookTest;

import baseTest.BaseTest;
import org.junit.Test;

public class SearchBookTest extends BaseTest {
String nameBook = "Java Spider";
    @Test
    public void  searchBookTest (){
        homePage.openHomePage()
                .waitSuccessMessage()
                .enterTextInSearchField(nameBook)
                .clickOnSearchButton()
                .checkWhatBookWasFind(nameBook)
        ;
    }

}
