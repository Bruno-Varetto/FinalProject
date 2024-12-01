package sanity;

import extensions.APIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.APIFlows;


@Listeners(utilities.Listeners.class)
public class GrafanaAPI extends CommonOps {

    @Test(description = "Test 01: Get Team From Grafana")
    @Description("This test verify team property")
    public void test01_verifyTeam() {
        Verifications.verifyText(APIFlows.getTeamProperty("teams[0].name"), "test");
    }

    @Test(description = "Test 02: Add Team And Verify")
    @Description("This test add a team to grafana and verify it")
    public void test02_addTeamAndVerify() {
        APIFlows.postTeam("zrunoTeam", "bruno@gmail.com");
        Verifications.verifyText(APIFlows.getTeamProperty("teams[1].name"), "zrunoTeam");
    }

    @Test(description = "Test 03: Update Team And Verify")
    @Description("This test Updates a team in grafana and verify it")
    public void test03_updatesTeamAndVerify() {
        String idTeam = APIFlows.getTeamProperty("teams[1].id");
        APIFlows.updateTeam("yteam", "yteam@gmail.com", idTeam);
        Verifications.verifyText(APIFlows.getTeamProperty("teams[1].name"), "yteam");
    }

    @Test(description = "Test 04: Delete Team And Verify")
    @Description("This test Deletes a team in grafana and verify it")
    public void test04_deleteTeamAndVerify() {
        String idTeam = APIFlows.getTeamProperty("teams[1].id");
        APIFlows.deleteTeam(idTeam);
        Verifications.verifyText(APIFlows.getTeamProperty("totalCount"), "1");
    }

}
