package utils;

import org.junit.jupiter.api.DisplayName;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckPages {
    @DisplayName("Проверяем адрес текущей страницы")
    public void checkCurrentUrl(String expectedUrl) {
        String currentUrl = url();
        assertEquals(expectedUrl, currentUrl);
    }
}