package com.github.ncr0s.tests.web;

import com.github.javafaker.Faker;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.github.ncr0s.config.TestsConfig.PROPERTIES;

public class LoginTests extends TestBase {
    static Faker faker = new Faker();

    static Stream<Arguments> testData() {
        return Stream.of(
          Arguments.of(PROPERTIES.getUsername(), "randomPass"),
          Arguments.of("randomUser", PROPERTIES.getPassword()),
          Arguments.of(faker.name(), faker.space())
        );
    }
    @Test
    @DisplayName("Open login page from main test")
    @Severity(SeverityLevel.NORMAL)
    void openLoginPageFromMain() {
        mainPage
            .openPage("/")
            .clickOnSignInButton();

        loginPage.loginFormShouldBeShown();
    }

    @Test
    @DisplayName("Success login test")
    @Severity(SeverityLevel.BLOCKER)
    void successfulLogin() {
        mainPage
            .openPage("/login");

        loginPage
            .enterUsername(PROPERTIES.getUsername())
            .enterPassword(PROPERTIES.getPassword())
            .submit();

        loginPage.getStartedModuleShouldBeShown();
    }

    @ParameterizedTest(name = "Unsuccessful login with username: {0} and password: {1}")
    @MethodSource("testData")
    @Severity(SeverityLevel.BLOCKER)
    void failedLogin(String username, String password) {
        mainPage
            .openPage("/login");

        loginPage
            .enterUsername(username)
            .enterPassword(password)
            .submit();

        loginPage.errorMessageShouldBeShown();
    }
}
