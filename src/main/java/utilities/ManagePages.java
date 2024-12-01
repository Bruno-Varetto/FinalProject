package utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {

    public static void initGrafana() {
        grafanaLogin = PageFactory.initElements(driver, pageObjects.grafana.LoginPage.class);
        grafanaMain = PageFactory.initElements(driver, pageObjects.grafana.MainPage.class);
        grafanaLeftMenu = PageFactory.initElements(driver, pageObjects.grafana.LeftMenuPage.class);
        grafanaAdministrationMenu = PageFactory.initElements(driver, pageObjects.grafana.AdministrationMenu.class);
        grafanaUsersPage = PageFactory.initElements(driver, pageObjects.grafana.UsersPage.class);
        grafanaAddNewUser = PageFactory.initElements(driver, pageObjects.grafana.AddNewUser.class);
        grafanaEditUserPage = PageFactory.initElements(driver, pageObjects.grafana.EditUserPage.class);


    }
    public static void initMortgage() {
        mortgageMain = new pageObjects.mortgage.MainPage(mobileDriver);

    }

    public static void initToDo() {
        todoMain = PageFactory.initElements(driver, pageObjects.toDoList.MainPage.class);
    }

    public static void initCalculator() {
        calculatorMain = PageFactory.initElements(driver, pageObjects.Calculator.MainPage.class);
    }


}
