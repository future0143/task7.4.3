package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pages.ElementsOfPageWithWindows;

import static com.codeborne.selenide.Selenide.$;
import static steps.StepsForAlerts.clickButton;


public class StepsForWindows extends ElementsOfPageWithWindows {

    @Step(value = "Нажатие на кнопку перехода на новую страницу")
    public static void openNewWindow(By selector) {
        clickButton(selector);
        Selenide.switchTo().window(1);
    }

    @Step(value = "Проверка перехода на новую страницу")
    public static void checkTransitionToNewWindow(String urlBeforeSwitch) {
        String currentUrlNewWindow = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertNotEquals(urlBeforeSwitch, currentUrlNewWindow);
    }

    @Step(value = "Проверка перехода на предыдущую страницу")
    public static void checkTransitionToPreviousWindow(String urlBeforeSwitch) {
        String currentUrlNewWindow = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(urlBeforeSwitch, currentUrlNewWindow);
    }

    @Step(value = "Проверка текста на странице")
    public static void checkTextOnPage(String expectedText) {
        $("body").shouldHave(Condition.text(expectedText));
    }

    @Step(value = "Закрытие новой вкладки")
    public static void closeNewWindow() {
        Selenide.closeWindow();
        Selenide.switchTo().window(0);
    }
}