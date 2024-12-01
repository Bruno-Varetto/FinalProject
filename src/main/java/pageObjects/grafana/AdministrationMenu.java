package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdministrationMenu {

    @FindBy(how = How.XPATH, using = "(//div[@class = 'css-1vx4yny'])[11]/button")
    public WebElement users_access;

    @FindBy(how = How.XPATH, using = "//div[8]/li/ul/li[3]/ul/li[1]/div/div[3]")
    public WebElement btn_Users;
}
