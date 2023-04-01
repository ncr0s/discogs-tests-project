package com.github.ncr0s.tests.web.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GdprComponent {
    SelenideElement rejectCookiesButton = $("#onetrust-reject-all-handler");

    public void rejectCookies() {
        if (rejectCookiesButton.isDisplayed()) {
            rejectCookiesButton.click();
        }
    }
}
