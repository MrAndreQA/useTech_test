package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import utils.CheckPages;

public class HomeWorkFastDevelopTest extends RemoteTestBase {

    public MainPage mainPage = new MainPage();
    public CheckPages checkPages = new CheckPages();

    @DisplayName("UseTech: проверка текста первого заголовка на главной странице сайта")
    @Feature("Раздел - Главная страница ")
    @Story("Главная страница - отображение элементов")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkCorrectFirstHeaderInMainPageTest() {
        mainPage.openPage()
                .checkTextInHeader("Заказная разработка и сопровождение программного обеспечения");
    }


    @DisplayName("UseTech: проверка текста кнопок меню сайта")
    @Feature("Раздел - Главная страница ")
    @Story("Главная страница - отображение элементов")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkCorrectSecondHeaderInMainPageTest() {
        mainPage.openPage()
                .checkTextInMenuButtons();
    }


    @DisplayName("UseTech: проверка перехода в раздел Услуги")
    @Feature("Раздел - Главная страница ")
    @Story("Главная страница - переход в разделы сайта")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkSwitchingToServicesPageFromMainPageTest() {
        mainPage.openPage()
                .clickToServicesBtn();
        checkPages.checkCurrentUrl("https://usetech.ru/uslugi/");
    }


    @DisplayName("UseTech: проверка перехода на страницу Блога в Хабре")
    @Feature("Раздел - Главная страница ")
    @Story("Главная страница - переход на внешние ресурсы")
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


    @DisplayName("UseTech: на странице 'Контакты' отображаются названия всех 6 городов")
    @Feature("Раздел - Контакты ")
    @Story("Главная страница - переход в разделы сайта")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkAllFilialsIsVisibleTest() {
        mainPage.openPage()
                .clickToContactsBtn();
        checkPages.checkCurrentUrl("https://usetech.ru/contacts/");
        mainPage.checkCountAndNameOfCities();
    }
}