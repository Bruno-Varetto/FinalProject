package pageObjects.toDoList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(how = How.XPATH, using = "//input[@placeholder = 'Create a task']")
    public WebElement text_field;

    @FindBy(how = How.CLASS_NAME, using = "view_2Ow90")
    public List<WebElement> list_tasks;

    @FindBy(how = How.CLASS_NAME, using = "destroy_19w1q")
    public WebElement btn_delete;




}
