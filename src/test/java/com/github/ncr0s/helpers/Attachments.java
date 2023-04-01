package com.github.ncr0s.helpers;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.sessionId;
import static com.github.ncr0s.config.TestsConfig.PROPERTIES;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attachments {
    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return Selenide.screenshot(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    public static void browserConsoleLogs() {
        attachAsText(
            "Browser console logs",
            String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
            + getVideoUrl()
            + "' type='video/mp4'></video></body></html>";
    }

    public static URL getVideoUrl() {
        String videoUrl = PROPERTIES.getRemoteUrl() + "/video/" + sessionId() + ".mp4";

        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
