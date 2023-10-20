package steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.ElementsOfPageWithFrames;

import static com.codeborne.selenide.Selenide.$;

public class StepsForFrames extends ElementsOfPageWithFrames {

    @Step(value = "Переключение на фрейм")
    public static void switchToFrame(String id) {
        Selenide.switchTo().frame(id);
    }

    @Step(value = "Ввод текста в поле фрейма")
    public static void inputTextIntoFramesField(String textForFramesField, By selector) {
        $(selector).setValue(textForFramesField);
        $(selector).sendKeys(Keys.COMMAND + "A");
    }

    @Step(value = "Сделать текст жирным через кнопку B в окне фрейма")
    public static void makeTextBold(By selector) {
        Selenide.switchTo().defaultContent();
        $(selector).click();
    }
}