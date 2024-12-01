package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

    @Step("Click on element")
    public static void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Updates text on element")
    public static void updateText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    @Step("Updates text on element as human")
    public static void updateTextHuman(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        for (char ch : text.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            element.sendKeys(ch + "");
        }

    }

    @Step("Updates DropDown element")
    public static void updateDropDown(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    @Step("Mouse Hover on element")
    public static void mouseHover(WebElement element1, WebElement element2) {
        action.moveToElement(element1).moveToElement(element2).click().build().perform();
    }

    @Step("Mouse Hover on element")
    public static void mouseHover(WebElement element1) {
        action.moveToElement(element1).click().build().perform();
    }

    @Step("Insert Key")
    public static void insertKey(WebElement element1, Keys value) {
        element1.sendKeys(value);
    }

    @Step("Perform action on specific element")
    public static void actionOnUser(List<WebElement> rows, List<WebElement> actions, String textToFind) {
        wait.until(ExpectedConditions.visibilityOfAllElements(rows));
        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> elements = row.findElements(By.tagName("td"));
            for (WebElement element : elements) {
                String currentText = element.getText();
                if (currentText.equalsIgnoreCase(textToFind)) {
                    WebElement actionButton = actions.get(i);
                    actionButton.click();
                    return;
                }

            }
        }
        throw new NoSuchElementException("No element found containing text: " + textToFind);
    }
}



