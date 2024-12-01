package workflows;

import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.List;

import static com.github.jaiimageio.impl.plugins.tiff.TIFFFaxCompressor.pass;


public class WebFlows extends CommonOps {

    @Step("Business Flow: Login")
    public static void login(String user, String pass) {
        UIActions.updateText(grafanaLogin.txt_username, user);
        UIActions.updateText(grafanaLogin.txt_password, pass);
        UIActions.click(grafanaLogin.btn_login);
        UIActions.click(grafanaLogin.btn_skip);
    }

    @Step("Business Flow: Login from DB")
    public static void loginDB() throws SQLException {
        String query = "SELECT name,password FROM Employees WHERE comments='grafana'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(grafanaLogin.txt_username, cred.get(0));
        UIActions.updateText(grafanaLogin.txt_password, cred.get(1));
        UIActions.click(grafanaLogin.btn_login);
        UIActions.click(grafanaLogin.btn_skip);
    }

    @Step("Business Flow: Go to Users Page")
    public static void clickUserManagementMenu() {

        if (grafanaLeftMenu.btn_Administration.getAttribute("aria-label").equals("Expand section Administration")) {
            UIActions.click(grafanaLeftMenu.btn_Administration);
        }
        if (grafanaAdministrationMenu.users_access.getAttribute("aria-label").equals("Expand section Users and access")) {
            UIActions.click(grafanaAdministrationMenu.users_access);
        }
        if (!(grafanaAdministrationMenu.btn_Users.isSelected()))
            UIActions.click(grafanaAdministrationMenu.btn_Users);
    }

    @Step("Business Flow: Create New User")
    public static void createNewUser(String name, String email, String userName, String password) {
        UIActions.click(grafanaUsersPage.btn_newUser);
        UIActions.updateText(grafanaAddNewUser.txt_name, name);
        UIActions.updateText(grafanaAddNewUser.txt_email, email);
        UIActions.updateText(grafanaAddNewUser.txt_userName, userName);
        UIActions.updateText(grafanaAddNewUser.txt_password, password);
        UIActions.click(grafanaAddNewUser.btn_createUser);
        UIActions.click(grafanaAdministrationMenu.btn_Users);

    }

    @Step("Business Flow: Go to User's Edit Page")
    public static void editUser(String userName) {
        UIActions.actionOnUser(grafanaUsersPage.users_rows, grafanaUsersPage.user_editButton, userName);
    }

    @Step("Business Flow: Delete User")
    public static void deleteUser() {
        UIActions.click(grafanaEditUserPage.btn_deleteUser);
        UIActions.click(grafanaEditUserPage.btn_ConfirmDelete);
    }

    @Step("Business Flow: Search and Verify User")
    public static void searchUser(String userName, String shouldExists) {
        UIActions.updateTextHuman(grafanaUsersPage.searchField, userName);
        if (shouldExists.equalsIgnoreCase("exists"))
            Verifications.existenceOfElement(grafanaUsersPage.users_rows);
        else if (shouldExists.equalsIgnoreCase("not-exists")) {
            Verifications.nonExistenceOfElement(grafanaUsersPage.users_rows);
        } else
            throw new RuntimeException("invalid expected output");
    }


}
