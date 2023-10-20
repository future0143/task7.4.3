package pages;

import org.openqa.selenium.By;

public class ElementsOfPageWithAlerts {

    public static By buttonJsAlert = By.cssSelector("button[onclick='jsAlert()']");
    public static By buttonJsConfirm = By.cssSelector("button[onclick='jsConfirm()']");
    public static By buttonJsPrompt = By.cssSelector("button[onclick='jsPrompt()']");
}