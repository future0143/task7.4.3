package alerts_windows_frames_tests;

import config.ConfigSetup;
import config.TestProperties;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import steps.StepsForFrames;

import static com.codeborne.selenide.Selenide.open;
import static steps.StepsForAlerts.clickButton;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WorkingWithFrames extends StepsForFrames implements ConfigSetup {

    private final String urlFrame = TestProperties.getValue("testFrame.url");

    @BeforeEach
    public void openUrl() {
        open(urlFrame);
    }

    @Test
    @DisplayName("Взаимодействие с элементами внутри фрейма")
    @Description("Скрипт, в котором необходимо взаимодействовать с элементами внутри фрейма")
    public void workWithFramesElements() {
        clickButton(buttonFrame);

        switchToFrame(idOfFrame);

        String textForFramesField = "Hello World";
        inputTextIntoFramesField(textForFramesField, tagNameOfFieldIntoFrame);

        makeTextBold(cssSelectorBoldButton);
    }
}