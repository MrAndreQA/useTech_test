package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import configs.ProjectConfig;
import configs.WebConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import helpers.Attach;
import java.util.Map;
import java.util.UUID;
import configs.WebProvider;
import pages.ContactsPage;
import pages.MainPage;
import utils.CheckPages;

public class TestBase {

    protected MainPage mainPage;
    protected CheckPages checkPages;
    protected ContactsPage contactsPage;

    public static final WebConfig webConfig = WebProvider.getWebConfig();

    private void initPages() {
        mainPage = new MainPage();
        checkPages = new CheckPages();
        contactsPage = new ContactsPage();
    }

    @BeforeAll
    static void setupConfig(){
        ProjectConfig projectConfig = new ProjectConfig(webConfig);
        projectConfig.setConfig();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true,
                "name", "Test: " + UUID.randomUUID()
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void setupConfigBeforeEach(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        initPages();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Take screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}