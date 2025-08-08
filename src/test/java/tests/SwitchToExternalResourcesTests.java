package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Раздел - Главная страница ")
@Story("Главная страница - переход на внешние ресурсы")
public class SwitchToExternalResourcesTests extends TestBase{

    @DisplayName("UseTech: проверка перехода на страницу Блога в Хабре")
    @Tag("useTech_tests")
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
}