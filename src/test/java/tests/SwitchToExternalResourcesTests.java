package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Раздел - Главная страница ")
@Story("Главная страница - переход на внешние ресурсы")
public class SwitchToExternalResourcesTests extends TestBase{

    @DisplayName("UseTech: проверка перехода на страницу Блога в Хабре")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkGoingToHabrBlogFromMainPageTest() {
        mainPage.openPage()
                .clickToHabrBlogBtn();
        checkPages
                .checkCurrentUrl("https://habr.com/ru/companies/usetech/articles/");
    }

    @DisplayName("UseTech: проверка перехода на страницу Яндекс карт, филиал Москва (из раздела Контакты)")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkGoingToYandexMapsFromContactsPageTest() {
        mainPage.openPage()
                .clickToContactsBtn();
        contactsPage.clickToMoscowMapBtn();
        checkPages
                .checkPartialCurrentUrl("https://yandex.ru");
    }
}