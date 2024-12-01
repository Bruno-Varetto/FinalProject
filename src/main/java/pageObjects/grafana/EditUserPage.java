package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditUserPage {

    @FindBy(how = How.XPATH, using = "//div[@class = 'css-3v8xwy']/button[@class = 'css-ttl745-button']")
    public WebElement btn_deleteUser;

    @FindBy(how = How.XPATH, using = "//button[@data-testid = 'data-testid Confirm Modal Danger Button']")
    public WebElement btn_ConfirmDelete;


}
