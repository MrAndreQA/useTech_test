package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Раздел - Основное меню сайта")
@Story("Основное меню - отображение элементов")
public class MenuTests extends TestBase{

    @DisplayName("UseTech: проверка текста кнопок меню сайта")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkCorrectSecondHeaderInMainPageTest() {
        mainPage.openPage()
                .checkTextInMenuButtons();
    }

    @DisplayName("UseTech: проверка перехода в раздел Отрасли - через меню сайта")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkSwitchToAreasSectionTest() {
        mainPage.openPage()
                .clickToAreasBtn();
                checkPages.checkCurrentUrl("https://usetech.ru/otrasli/");
    }

    @DisplayName("UseTech: проверка перехода в раздел Награды - через меню сайта")
    @Severity(SeverityLevel.MINOR)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkSwitchToAwardsSectionTest() {
        mainPage.openPage()
                .clickToAwardsBtn();
        checkPages.checkCurrentUrl("https://usetech.ru/awards/");
    }

    @DisplayName("UseTech: проверка перехода в раздел Услуги - через меню сайта")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkSwitchToServicesSectionTest() {
        mainPage.openPage()
                .clickToServicesBtn();
        checkPages.checkCurrentUrl("https://usetech.ru/uslugi/");
    }
}