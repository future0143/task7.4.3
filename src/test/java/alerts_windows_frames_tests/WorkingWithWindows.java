package alerts_windows_frames_tests;

import com.codeborne.selenide.WebDriverRunner;
import config.ConfigSetup;
import config.TestProperties;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import steps.StepsForWindows;

import static com.codeborne.selenide.Selenide.open;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WorkingWithWindows extends StepsForWindows implements ConfigSetup {

    private static final String urlWindow = TestProperties.getValue("testWindow.url");

    @BeforeEach
    public void openUrl() {
        open(urlWindow);
    }

    @Test
    @DisplayName("Переключение между окнами")
    @Description("Скрипт, который открывает новое окно или вкладку, переключается между ними и затем закрывает новое окно")
    public void scriptForWorkWithWindows() {
        String urlBeforeSwitch = WebDriverRunner.getWebDriver().getCurrentUrl();

        openNewWindow(buttonClickHere);

        checkTransitionToNewWindow(urlBeforeSwitch);

        String expectedText = "New Window";
        checkTextOnPage(expectedText);

        closeNewWindow();

        checkTransitionToPreviousWindow(urlBeforeSwitch);
    }
}