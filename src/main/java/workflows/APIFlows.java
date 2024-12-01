package workflows;

import extensions.APIActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utilities.CommonOps;

public class APIFlows extends CommonOps {

    @Step("Business Flow: Get Team Property")
    public static String getTeamProperty(String jpath) {
        response = APIActions.get("/api/teams/search");
        return APIActions.extractFromJSON(response, jpath);
    }

    @Step("Business Flow: Create New Team")
    public static void postTeam(String name, String email) {
        params.put("name", name);
        params.put("email", email);
        APIActions.post(params, "/api/teams");
    }

    @Step("Business Flow: Update Existing Team")
    public static void updateTeam(String name, String email, String id) {
        params.put("name", name);
        params.put("email", email);
        APIActions.put(params, "/api/teams/" + id);
    }

    @Step("Business Flow: Delete Existing Team")
    public static void deleteTeam(String id) {
        APIActions.delete(id);
    }


}
