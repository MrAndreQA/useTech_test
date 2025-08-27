package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Раздел - Главная страница ")
@Story("Главная страница - отображение элементов")
@Tag("useTech_tests")
@Link(value = "UseTech - главная", url = "https://usetech.ru/")
@Owner("Volodin_AS")
@Severity(SeverityLevel.NORMAL)
public class HomePageTests extends TestBase {

    @DisplayName("UseTech: проверка текста первого заголовка на главной странице сайта")
    @Test
    void checkCorrectFirstHeaderInMainPageTest() {
        mainPage.openPage()
                .checkTextInHeader("Заказная разработка и сопровождение программного обеспечения");
    }
    }