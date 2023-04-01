package com.github.ncr0s.tests.web;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class LoginTests extends TestBase {
    @Test
    void openLoginPageFromMain() {
        mainPage
            .openPage("/")
            .clickOnSignInButton();

        loginPage.loginFormShouldBeShown();
    }

    @Test
    void successfulLogin() {
        mainPage
            .openPage("/login");

        loginPage
            .enterUsername("ncr0s-test-user")
            .enterPassword("test123TEST")
            .submit();

        loginPage.getStartedModuleShouldBeShown();
    }
}
