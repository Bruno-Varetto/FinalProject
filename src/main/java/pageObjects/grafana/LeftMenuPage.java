package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftMenuPage {

    @FindBy(how = How.XPATH, using = "(//div[@class = 'css-1vx4yny'])[8]/button")
    public WebElement btn_Administration;

}
