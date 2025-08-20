package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Раздел - Контакты ")
@Story("Главная страница - переход в разделы сайта")
@Owner("Volodin_AS")
@Tag("useTech_tests")
@Link(value = "UseTech - главная", url = "https://usetech.ru/")
@Severity(SeverityLevel.NORMAL)
public class ContactsPageTests extends TestBase {

    @DisplayName("UseTech: на странице 'Контакты' отображаются названия всех 6 городов")
    @Test
    void checkAllFilialsIsVisibleTest() {
        mainPage.openPage()
                .clickToContactsBtn();
        checkPages.checkCurrentUrl("https://usetech.ru/contacts/");
        contactsPage.checkCountAndNameOfCities();
    }
}