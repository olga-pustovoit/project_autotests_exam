package registrationTest;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RegistrationErrorsTest extends BaseTest {
    final static String ERROR_EMAIL = "Неправильний формат електронної пошти";
    final static String ERROR_NAME = "Використовуйте лише літери.";
    final static String ERROR_SURNAME = "Використовуйте лише літери.";
    final static String ERROR_PHONE = "Будь ласка, введіть правильний номер.";
    final static String ERROR_PASSWORD = "Мінімум різних типів символів у паролі становить 3. Типи символів: нижній регістр, верхній регістр, цифри, спеціальні символи";
    final static String ERROR_SHORT_PASSWORD = "Будь ласка, введіть 8 або більше знаків.";
    final static String SEMICOLON = ";";


    @Test
    @Parameters(method = "provideParameters")
    @TestCaseName("registrationErrors : name = {0}, surname = {1}, phone = {2}, email = {3}, password = {4}")
    public void checkErrors(String name, String surname, String phone, String email, String password, String expectedErrors) {
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

    public static Object[][] provideParameters() {
        return new Object[][]{
                new Object[]{"1","2","n","3","11111111",ERROR_NAME + SEMICOLON + ERROR_SURNAME + SEMICOLON+ ERROR_PHONE+ SEMICOLON + ERROR_EMAIL+ SEMICOLON + ERROR_PASSWORD},
                new Object[]{"1", "2", "n", "30", "11", ERROR_NAME + SEMICOLON + ERROR_SURNAME + SEMICOLON + ERROR_PHONE + SEMICOLON + ERROR_EMAIL + SEMICOLON + ERROR_SHORT_PASSWORD}
        };
    }
}
