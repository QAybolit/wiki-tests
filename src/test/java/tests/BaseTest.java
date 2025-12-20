package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    private static final ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class);

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = projectConfig.baseUrl();
        Configuration.pageLoadStrategy = projectConfig.pageLoadStrategy();
        Configuration.timeout = projectConfig.timeout();
        Configuration.browser = projectConfig.browser();
        Configuration.browserVersion = projectConfig.browserVersion();
        Configuration.browserSize = projectConfig.browserSize();
//        Configuration.remote = projectConfig.remoteUrl();
        Configuration.remote = System.getProperty("remoteUrl");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void addAllureListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.addVideo();
        closeWebDriver();
    }
}
