package endpoints;

import io.qameta.allure.Step;
import utils.Specifications;

import static io.restassured.RestAssured.given;

public class UserAccessDeleteEndpoint {
    @Step("Отправка GET-запроса")
    public static void deleteUserAccess(String projectId, String userId) {
        given()
                .spec(Specifications.specRequest())
                .when()
                .delete("hub/api/rest/projects/" + projectId + "/team/users/" + userId)
                .then()
                .spec(Specifications.spec200WithoutContentType());
    }
}