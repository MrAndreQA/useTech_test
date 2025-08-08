package utils;

import org.junit.jupiter.api.DisplayName;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPages {
    @DisplayName("Проверяем адрес текущей страницы (полное соответствие)")
    public void checkCurrentUrl(String expectedUrl) {
        String currentUrl = url();
        assertEquals(expectedUrl, currentUrl);
    }
    @DisplayName("Проверяем адрес текущей страницы (частичное соответствие)")
    public void checkPartialCurrentUrl(String expectedSubUrl) {
        String currentUrl = url();
        assertTrue(currentUrl.contains(expectedSubUrl));
    }
}