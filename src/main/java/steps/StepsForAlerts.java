package steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pages.ElementsOfPageWithAlerts;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class StepsForAlerts extends ElementsOfPageWithAlerts {

    @Step(value = "Нажатие на кнопку")
    public static void clickButton(By selector) {
        $(selector).click();
    }

    @Step(value = "проверка закрытия алерта")
    public static void checkClosingAlert(String textAfterClosing) {
        $("body").shouldHave(text(textAfterClosing));
    }

    @Step(value = "Ввод текста в текстовое поле алерта")
    public static void inputTextIntoAlert(String textForAlert) {
        Selenide.prompt(textForAlert);
    }

    @Step(value = "Проверка текста алерта")
    public static void checkText(String expectedText, String actualText) {
        Assertions.assertEquals(expectedText, actualText);
    }
}