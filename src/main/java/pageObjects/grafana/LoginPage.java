package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.NAME, using = "user")
    public WebElement txt_username;

    @FindBy(how = How.NAME, using = "password")
    public WebElement txt_password;

    @FindBy(how = How.CLASS_NAME, using = "css-1b7vft8-button")
    public WebElement btn_login;

    @FindBy(how = How.XPATH, using = "(//div[@class='css-i7txp7']/button/span[@class='css-1riaxdn'])[2]")
    public WebElement btn_skip;


}
