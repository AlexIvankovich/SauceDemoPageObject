package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AuthTest extends BaseTest {

    private static String passFieldIsEmptyMessage = "Epic sadface: Password is required";

    @Test
    public void UserShouldNotBeAutoriseIfPasswordFieldIsEmpty() {

        authPage.open();
        authPage.inputLoginAnDPassword("standard_user","");
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();

        assertEquals(errorMessage,passFieldIsEmptyMessage);
      
    }

    @Test
    public void UserShouldBeAutoriseWithValidUserNameAndPassword() {

        authPage.open();
        authPage.inputLoginAnDPassword("standard_user","secret_sauce");
        authPage.clickLoginButton();

        assertEquals(inventoryPage,inventoryPageIsOpen ());
    }

}
