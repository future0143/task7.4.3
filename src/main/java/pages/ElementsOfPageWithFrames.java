package pages;

import org.openqa.selenium.By;

public class ElementsOfPageWithFrames {

    public static By buttonFrame = By.cssSelector("a[href='/iframe']");
    public static String idOfFrame = "mce_0_ifr";
    public static By tagNameOfFieldIntoFrame = By.tagName("body");
    public static By cssSelectorBoldButton = By.cssSelector("button[aria-label='Bold']");
}