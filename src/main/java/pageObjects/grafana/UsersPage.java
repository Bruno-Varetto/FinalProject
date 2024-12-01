package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class UsersPage {

    @FindBy(how = How.XPATH, using = "//tr[@class = 'css-1e8ylo6-row']")
    public List<WebElement> users_rows;

    @FindBy(how = How.XPATH, using = "//a[@class = 'css-td06pi-button']")
    public WebElement btn_newUser;

//    @FindBy(how = How.XPATH, using = "//a[@class = 'css-1qmcwme']")
//    public List<WebElement> user_userName;

    @FindBy(how = How.XPATH, using = "//a[@class = 'css-1tgagwo-button']")
    public List<WebElement> user_editButton;

    @FindBy(how = How.XPATH, using = "//input[@class = 'css-8tk2dk-input-input']")
    public WebElement searchField;

}
