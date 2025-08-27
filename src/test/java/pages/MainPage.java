package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement
            firstHeaderInMainPage = $("h1", 0),
            menuButtons_aboutCompany = $("#menu-topbar li", 0),
            menuButtons_news = $("#menu-topbar li", 1),
            menuButtons_services = $("#menu-topbar li", 2),
            menuButtons_areas = $("#menu-topbar li", 3),
            menuButtons_awards = $("#menu-topbar li", 4),
            menuButtons_contacts = $("#menu-topbar li", 5),
            menuButtons_career = $("#menu-topbar li", 6),
            menuButtons_habrBlog = $("#menu-topbar li", 7);

    @Step("Открываем главную страницу")
    public MainPage openPage() {
        open("/");
        return new MainPage();
    }

    @Step("Проверяем текст первого заголовка главной страницы")
    public void checkTextInHeader(String textValue) {
        firstHeaderInMainPage.shouldHave(text(textValue));
    }

    @DisplayName("Проверяем текст кнопок меню сайта")
    public void checkTextInMenuButtons() {
        menuButtons_aboutCompany.shouldHave(text("О компании"));
        menuButtons_news.shouldHave(text("Новости"));
        menuButtons_services.shouldHave(text("Услуги"));
        menuButtons_areas.shouldHave(text("Отрасли"));
        menuButtons_awards.shouldHave(text("Награды"));
        menuButtons_contacts.shouldHave(text("Контакты"));
        menuButtons_career.shouldHave(text("Карьера"));
        menuButtons_habrBlog.shouldHave(text("Habr Блог"));
    }

    @Step("Нажимаем на пункт меню - Услуги")
    public MainPage clickToServicesBtn() {
        menuButtons_services.click();
        return new MainPage();
    }

    @Step("Нажимаем на пункт меню - Отрасли")
    public MainPage clickToAreasBtn() {
        menuButtons_areas.click();
        return new MainPage();
    }

    @Step("Нажимаем на пункт меню - Награды")
    public MainPage clickToAwardsBtn() {
        menuButtons_awards.click();
        return new MainPage();
    }

    @Step("Нажимаем на пункт меню - Контакты")
    public MainPage clickToContactsBtn() {
        menuButtons_contacts.click();
        return new MainPage();
    }

    @Step("Нажимаем на пункт меню - Карьера")
    public MainPage clickToCareerBtn() {
        menuButtons_career.click();
        return new MainPage();
    }

    @Step("Нажимаем на пункт меню - Хабр Блог")
    public MainPage clickToHabrBlogBtn() {
        menuButtons_habrBlog.click();
        return new MainPage();
    }
    }