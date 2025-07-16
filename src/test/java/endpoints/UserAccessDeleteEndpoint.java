package endpoints;

import io.restassured.RestAssured;
import utils.Specifications;

import static io.restassured.RestAssured.given;

public class UserAccessDeleteEndpoint {
    public static void deleteUserAccess(String projectId, String userId) {
        RestAssured.responseSpecification = null;
        given()
                .when()
                .delete("hub/api/rest/projects/" + projectId + "/team/users/" + userId)
                .then()
                .spec(Specifications.spec200WithoutContentType())
                .statusCode(200);
    }
}