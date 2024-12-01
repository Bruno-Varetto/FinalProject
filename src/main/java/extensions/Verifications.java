package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement element, String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getText(), expectedText);
    }
    @Step("Verify number of Elements")
    public static void numberOfElements(List<WebElement> elements, int expectedCount) {
        wait.until(ExpectedConditions.visibilityOf(elements.get(elements.size() - 1)));
        assertEquals(elements.size(), expectedCount);
    }
    @Step("Verify Element Is Clickable")
    public static void verifyElementIsClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    @Step("Verify Visibility of Elements (Soft-Assertions)")
    public static void visibilityOfElements(List<WebElement> elements) {
        for (WebElement element : elements) {
            softAssert.assertTrue(element.isDisplayed(), "Element" + element.getText() + "is not displayed");
        }
        softAssert.assertAll("Some elements were not displayed.");
    }
    @Step("Verify Elements Visually")
    public static void visualElement(String expectedImageName){
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        } catch (FindFailed e) {
            fail("Error Comparing Image File: " + e.getMessage());
        }
    }
    @Step("Verify Element is Displayed")
    public static void existenceOfElement(List<WebElement> elements) {
        assertTrue(elements.size() > 0);
    }
    @Step("Verify Element is Not Displayed")
    public static void nonExistenceOfElement(List<WebElement> elements) {
        assertFalse(elements.size() > 0);
    }
    @Step("Verify Text with Text")
    public static void verifyText(String actualText, String expectedText) {
        assertEquals(actualText, expectedText);
    }
    @Step("Verify Number with Number")
    public static void verifyNumber(int actualText, int expectedText) {
        assertEquals(actualText, expectedText);
    }


}
