package com.github.ncr0s.tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.ncr0s.tests.web.pages.components.GdprComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    GdprComponent gdprComponent = new GdprComponent();
    SelenideElement usernameInput = $("#username");
    SelenideElement passwordInput = $("#password");
    SelenideElement logInButton = $(".btn-success");
    SelenideElement loginErrorElement = $(".invalid-feedback");

    @Step("Log In page should be shown")
    public void loginFormShouldBeShown() {
        usernameInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        logInButton.shouldBe(visible);
    }

    @Step("Enter username: {username}")
    public LoginPage enterUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    @Step("Enter password: {password}")
    public LoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Press Log In button")
    public void submit() {
        logInButton.click();
    }

    @Step("Get started module should be shown")
    public void getStartedModuleShouldBeShown() {
        gdprComponent.rejectCookies();
        $(".get_started_module").shouldBe(visible);
    }

    @Step("Error message should be shown")
    public void errorMessageShouldBeShown() {
        gdprComponent.rejectCookies();
        loginErrorElement
            .shouldBe(visible)
            .shouldHave(text("Invalid password"));
    }
}
