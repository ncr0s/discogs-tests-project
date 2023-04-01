package com.github.ncr0s.tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.ncr0s.tests.web.pages.components.GdprComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    GdprComponent gdprComponent = new GdprComponent();
    SelenideElement usernameInput = $("#username");
    SelenideElement passwordInput = $("#password");
    SelenideElement logInButton = $(".btn-success");

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
    public LoginPage submit() {
        logInButton.click();
        return this;
    }

    @Step("Get started module should be shown")
    public void getStartedModuleShouldBeShown() {
        gdprComponent.rejectCookies();
        $(".get_started_module").shouldBe(visible);
    }
}
