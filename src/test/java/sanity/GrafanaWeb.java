package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {

    @Test(description = "Test01 - Verify Header")
    @Description("This Test login and verifies the main header")
    public void test01_verifyHeader() {
        WebFlows.login(getData("UserName"), getData("Password"));
        Verifications.verifyTextInElement(grafanaMain.home_title, "Welcome to Grafana");
    }

    @Test(description = "Test02 - Verify default users")
    @Description("This Test Verify default users")
    public void test02_userSection() {
        WebFlows.clickUserManagementMenu();
        Verifications.numberOfElements(grafanaUsersPage.users_rows, 1);
    }

    @Test(description = "Test03 - Verify new user")
    @Description("This Test Verify creation of new users")
    public void test03_verifyNewUser() {
        WebFlows.clickUserManagementMenu();
        WebFlows.createNewUser("bruno", "alon@gmail.com", "bruno123", "password");
    }

    @Test(description = "Test04 - Verify User deletion")
    @Description("This Test Verify deletion of a user")
    public void test04_verifyUserDeletion() {
        WebFlows.clickUserManagementMenu();
        WebFlows.editUser("bruno123");
        Verifications.verifyElementIsClickable(grafanaEditUserPage.btn_deleteUser);
        WebFlows.deleteUser();
        Verifications.numberOfElements(grafanaUsersPage.users_rows, 1);
    }

    @Test(description = "Test05 - Verify Header Elements")
    @Description("This Test Verify the visibility of the header elements")
    public void test05_verifyTitleElements() {
        Verifications.visibilityOfElements(grafanaMain.title_elements);
    }

    @Test(description = "Test06 - Verify Logo Image")
    @Description("This Test Verify the visibility of Grafana Logo")
    public void test06_verifyLogoImage() {
        Verifications.visualElement("GrafanaLogo");
    }
    @Test(description = "Test07 - Search Users", dataProvider = "data-provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test Searched Users in a table using DDT")
    public void test07_searchUsers(String userName, String shouldExists) {
        WebFlows.clickUserManagementMenu();
        WebFlows.searchUser(userName, shouldExists);
    }



}
