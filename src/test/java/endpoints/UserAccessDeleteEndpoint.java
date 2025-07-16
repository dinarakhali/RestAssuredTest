package endpoints;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import utils.Specifications;

import static io.restassured.RestAssured.given;

public class UserAccessDeleteEndpoint {
    @Step("Отправка GET-запроса")
    public static void deleteUserAccess(String projectId, String userId) {
        given()
                .when()
                .delete("hub/api/rest/projects/" + projectId + "/team/users/" + userId)
                .then()
                .spec(Specifications.spec200WithoutContentType());
    }
}