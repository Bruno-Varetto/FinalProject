package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(how = How.XPATH, using = "//div[@class = 'css-wm6ni6']/h1")
    public WebElement home_title;

    @FindBy(how = How.XPATH, using = "//div[@class = 'css-wm6ni6']")
    public List<WebElement> title_elements;



}
