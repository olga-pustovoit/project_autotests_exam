package addToFavoriteBooks;

import baseTest.BaseTest;
import org.junit.Test;

public class AddToFavoriteTests extends BaseTest {
    String nameBook = "Java Spider";
    String nameList = "My Favorite List";
    @Test
    public void addToFavoriteTest(){
        homePage.openHomePage()
                .waitSuccessMessage()
//                .clickProfileButton()
                .getHeaderElement().clickOnMyProfileButton()
                .clickOnButtonFavoriteBooks()
                .createListFavoriteBooks(nameList)
                .acceptSuccessesButton()
                .getHeaderElement().enterTextInSearchField(nameBook)
                .clickOnSearchButton()
                .checkWhatBookWasFind(nameBook)
//                .openPageWithBook()
                .clickOnButtonAddToFavorite()
                .chooseFavoriteListCheckBox(nameList)
//                .closePageWithBook()
                .getHeaderElement().clickOnMyProfileButton()
                .clickOnButtonFavoriteBooks()
                .checkWhatBookWasAddToFavoriteList(nameBook)
                .deleteFavoriteList(nameList)
        ;


    }

}
