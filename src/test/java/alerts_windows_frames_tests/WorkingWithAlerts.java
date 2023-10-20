package alerts_windows_frames_tests;

import com.codeborne.selenide.Selenide;
import config.ConfigSetup;
import config.TestProperties;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.StepsForAlerts;

import static com.codeborne.selenide.Selenide.open;

public class WorkingWithAlerts extends StepsForAlerts implements ConfigSetup {

    private final String urlAlert = TestProperties.getValue("testAlert.url");

    @BeforeEach
    public void openUrl() {
        open(urlAlert);
    }

    @Test
    @DisplayName("Принятие уведомления")
    @Description("Открыть, прочитать и принять уведомление")
    public void acceptAlert() {
        clickButton(buttonJsAlert);

        String textOfAlert = Selenide.confirm();
        String expectedText = "I am a JS Alert";
        checkText(expectedText, textOfAlert);

        String textAfterClosing = "You successfully clicked an alert";
        checkClosingAlert(textAfterClosing);
    }

    @Test
    @DisplayName("Отклонить уведомление")
    @Description("Отказаться от алерта и проверить, что алерт закрылся")
    public void dismissAlert() {
        clickButton(buttonJsConfirm);

        Selenide.dismiss();

        String textAfterClosingAlert = "You clicked: Cancel";
        checkClosingAlert(textAfterClosingAlert);
    }

    @Test
    @DisplayName("Ввести текст в окне алерта")
    @Description("Ввести текст в окне алерта и проверить, что он появился на странице")
    public void inputTextInAlert() {
        clickButton(buttonJsPrompt);

        String textForAlert = "Hello World";
        inputTextIntoAlert(textForAlert);

        String textOnPage = "You entered: Hello World";
        checkClosingAlert(textOnPage);
    }
}