package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class APIActions extends CommonOps {

    @Step("Get Data From Server")
    public static Response get(String path) {
        // GET Request
        response = httpRequest.get(path);
        response.prettyPrint();
        return response;
    }

    @Step("Extract value from JSON Format")
    public static String extractFromJSON(Response response, String path) {
        jsonPath = response.jsonPath();
        return jsonPath.get(path).toString();
    }

    @Step("Post Data to Server")
    public static void post(JSONObject params, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
    }

    @Step("Update Data to Server")
    public static void put(JSONObject params, String resource) {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
        response.prettyPrint();
    }

    @Step("Delete Data to Server")
    public static void delete(String id) {
        response = httpRequest.delete("/api/teams/" + id);
        response.prettyPrint();
    }

}







