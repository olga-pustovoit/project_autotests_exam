package registrationTest;

import baseTest.BaseTest;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.CommonActionsWithElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RegistrationErrorsTestWithExcel extends BaseTest {
    String name, surname, phone, email, password, expectedErrors;

    public RegistrationErrorsTestWithExcel(String name, String surname, String phone, String email, String password, String expectedErrors) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.expectedErrors = expectedErrors;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream inputStream = new FileInputStream(CommonActionsWithElements.configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
        return new SpreadsheetData(inputStream, "registrationErrors").getData();
    }
    @Test
    public void checkErrors() {
        loginPage.openLoginPage();
        loginPage.openRegistrationForm()
                .enterUserNameInRegistrationForm(name)
                .enterSurnameInRegistrationForm(surname)
                .enterPhoneInRegistrationForm(phone)
                .enterEmailInRegistrationForm(email)
                .enterPasswordInRegistrationForm(password)
                .checkErrorsMessages(expectedErrors)
        ;

    }

}
