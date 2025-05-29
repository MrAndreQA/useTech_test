package tests;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.List;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeWorkFastDevelopTest extends TestBase {

    final SelenideElement
            firstHeaderInMainPage = $("h1", 0),
            menuButtons_aboutCompany = $("#menu-topbar li", 0),
            menuButtons_news = $("#menu-topbar li", 1),
            menuButtons_services = $("#menu-topbar li", 2),
            menuButtons_areas = $("#menu-topbar li", 3),
            menuButtons_awards = $("#menu-topbar li", 4),
            menuButtons_contacts = $("#menu-topbar li", 5),
            menuButtons_career = $("#menu-topbar li", 6),
            menuButtons_habrBlog = $("#menu-topbar li", 7);

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @Tag("basic_test")
    @DisplayName("UseTech: проверка текста первого заголовка на главной странице сайта")
    @Feature("Раздел - Главная страница ")
    @Story("Главная страница - отображение элементов")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkCorrectFirstHeaderInMainPageTest() {
        open("https://usetech.ru/");
        firstHeaderInMainPage.shouldHave(text("Заказная разработка и сопровождение программного обеспечения"));
    }


    @Tag("basic_test")
    @DisplayName("UseTech: проверка текста кнопок в футере сайта")
    @Feature("Раздел - Главная страница ")
    @Story("Главная страница - отображение элементов")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkCorrectSecondHeaderInMainPageTest() {
        open("https://usetech.ru/");
        menuButtons_aboutCompany.shouldHave(text("О компании"));
        menuButtons_news.shouldHave(text("Новости"));
        menuButtons_services.shouldHave(text("Услуги"));
        menuButtons_areas.shouldHave(text("Отрасли"));
        menuButtons_awards.shouldHave(text("Награды"));
        menuButtons_contacts.shouldHave(text("Контакты"));
        menuButtons_career.shouldHave(text("Карьера"));
        menuButtons_habrBlog.shouldHave(text("Habr Блог"));
    }


    @Tag("basic_test")
    @DisplayName("UseTech: проверка перехода в раздел Услуги")
    // ОР: https://usetech.ru/uslugi/
    @Feature("Раздел - Главная страница ")
    @Story("Главная страница - переход в разделы сайта")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkSwitchingToServicesPageFromMainPageTest() {
        open("https://usetech.ru/");
        menuButtons_services.click();
        // Получить текущий URL
        String currentUrl = url();
        assertEquals("https://usetech.ru/uslugi/", currentUrl);
    }

    @Tag("basic_test")
    @DisplayName("UseTech: проверка перехода на страницу Блога в Хабре")
    @Feature("Раздел - Главная страница ")
    @Story("Главная страница - переход на внешние ресурсы")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkGoingToHabrBlogFromMainPageTest() {
        open("https://usetech.ru/");
        menuButtons_habrBlog.click();
        // Получить текущий URL
        String currentUrl = url();
        assertEquals("https://habr.com/ru/companies/usetech/articles/", currentUrl);
    }

    @Tag("basic_test")
    @DisplayName("UseTech: на странице 'Контакты' отображаются названия всех 6 городов")
    @Feature("Раздел - Контакты ")
    @Story("Главная страница - переход в разделы сайта")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "UseTech - главная", url = "https://usetech.ru/")
    @Owner("Volodin_AS")
    @Test
    void checkAllFilialsIsVisibleTest() {
        open("https://usetech.ru/");
        menuButtons_contacts.click();
        String currentUrl = webdriver().driver().url();
        assertThat(currentUrl)
                .as("Проверка URL после перехода в Контакты")
                .isEqualTo("https://usetech.ru/contacts/");

        List<String> expectedFilials = List.of(
                "Москва",
                "Рязань",
                "Ростов-на-Дону",
                "Томск",
                "Барнаул",
                "Минск"
        );

        $$("h3").shouldHave(size(expectedFilials.size()));
        for (int i = 0; i < expectedFilials.size(); i++) {
            $("h3", i)
                    .shouldBe(visible, Duration.ofSeconds(3))
                    .shouldHave(
                            exactTextCaseSensitive(expectedFilials.get(i)),
                            Duration.ofSeconds(2)
                    );
        }
        $$("h3").shouldHave(textsInAnyOrder(expectedFilials));
    }
}