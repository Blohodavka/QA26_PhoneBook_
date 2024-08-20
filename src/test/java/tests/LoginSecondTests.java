package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthScreen;

public class LoginSecondTests extends AppiumConfig {

    @Test
    public void loginSuccess(){
        new AuthScreen(driver)
                .fillEmail("blohodavka@mail.ru")
                .fillPassword("Mama123$")
                .submitLogin()
                .isAccountOpened()
                .logout();
    }

    @Test
    public void loginSuccessModel(){
        new AuthScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("blohodavka@mail.ru").password("Mama123$").build())
                .submitLogin()
                .isAccountOpened()
                .logout();
    }
    @Test
    public void loginWrongEmail(){
        new AuthScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("blohodavkamail.ru").password("Mama123$").build())
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");
    }
}
