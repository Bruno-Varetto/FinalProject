package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import java.sql.SQLException;

@Listeners(utilities.Listeners.class)
public class GrafanaWebDB extends CommonOps {

    @Test(description = "Test01 - Login to Grafana with DB Credentials")
    @Description("This Test Login to Grafana with DB Credentials and verifies the main header")
    public void test01_verifyLoginDB() throws SQLException {
        WebFlows.loginDB();
        Verifications.verifyTextInElement(grafanaMain.home_title, "Welcome to Grafana");
    }


}
