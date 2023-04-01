package com.github.ncr0s.tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.ncr0s.helpers.Attachments;
import com.github.ncr0s.tests.web.pages.LoginPage;
import com.github.ncr0s.tests.web.pages.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.github.ncr0s.config.TestsConfig.PROPERTIES;

public class TestBase {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = PROPERTIES.getBaseUrl();
        Configuration.browser = PROPERTIES.getBrowserName();
        Configuration.browserVersion = PROPERTIES.getBrowserVersion();
        Configuration.browserSize = PROPERTIES.getBrowserSize();
        Configuration.pageLoadTimeout = PROPERTIES.getPageLoadTimeout();
        Configuration.timeout = PROPERTIES.getTimeout();

        if (PROPERTIES.isRemote()) {
            Configuration.remote = PROPERTIES.getRemoteUrl() + "/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void addAttachments() {
        Attachments.screenshotAs("Last screen");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
    }
}
