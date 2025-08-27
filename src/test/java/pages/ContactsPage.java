package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import java.util.List;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ContactsPage {

    private final ElementsCollection filialName = $$("h3");

    List<String> expectedFilials = List.of(
            "Москва",
            "Рязань",
            "Ростов-на-Дону",
            "Томск",
            "Барнаул",
            "Минск"
    );

    @Step("Проверяем количество городов, где есть филиалы и их названия")
    public void checkCountAndNameOfCities() {
        filialName.shouldHave(size(expectedFilials.size()));
        for (int i = 0; i < expectedFilials.size(); i++) {
            filialName.get(i)
                    .shouldBe(visible)
                    .shouldHave(exactTextCaseSensitive(expectedFilials.get(i)));
        }
        filialName.shouldHave(textsInAnyOrder(expectedFilials));
    }
    }