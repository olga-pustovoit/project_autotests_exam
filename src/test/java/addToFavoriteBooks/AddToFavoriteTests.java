package addToFavoriteBooks;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;

public class AddToFavoriteTests extends BaseTest {
    String nameBook = "Java Spider";
    String nameList = "My Favorite List" + Util.getDateAndTimeFormatted();
    @Test
    public void addToFavoriteTest(){
        homePage.openHomePage()
                .waitSuccessMessage()
                .getHeaderElement().clickOnMyProfileButton()
                .clickOnButtonFavoriteBooks()
                .createListFavoriteBooks(nameList)
                .acceptSuccessesButton()
                .getHeaderElement().enterTextInSearchField(nameBook)
                .clickOnSearchButton()
                .checkWhatBookWasFind(nameBook)
                .clickOnButtonAddToFavorite()
                .chooseFavoriteListCheckBox(nameList)
                .getHeaderElement().clickOnMyProfileButton()
                .clickOnButtonFavoriteBooks()
                .checkWhatBookWasAddToFavoriteList(nameBook)
                .deleteFavoriteList(nameList)
        ;


    }

}
