package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Business Flow: Add New Task To The List")
    public static void addNewTask(String taskName) {
        UIActions.updateText(todoMain.text_field, taskName);
        UIActions.insertKey(todoMain.text_field, Keys.RETURN);

    }

    @Step("Business Flow: Count and return number of tasks")
    public static int getNumberOfTasks() {
        return todoMain.list_tasks.size();
    }

    @Step("Business Flow: Empty List of tasks")
    public static void emptyList() {
        for (int i = 0; i < getNumberOfTasks(); i++) {
            UIActions.mouseHover(todoMain.btn_delete);
        }
    }


}
