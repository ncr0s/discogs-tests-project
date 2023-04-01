package com.github.ncr0s.tests.web.pages;

import com.github.ncr0s.tests.web.pages.components.GdprComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    GdprComponent gdprComponent = new GdprComponent();

    @Step("Open discogs main page")
    public MainPage openPage(String relativeUrl) {
        open(relativeUrl);
        gdprComponent.rejectCookies();
        return this;
    }

    @Step("Click on Log In button")
    public MainPage clickOnSignInButton() {
        $("#log_in_link").click();
        return this;
    }
}
