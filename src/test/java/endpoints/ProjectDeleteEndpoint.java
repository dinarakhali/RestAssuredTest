package endpoints;

import io.restassured.RestAssured;
import utils.Specifications;

import static io.restassured.RestAssured.given;

public class ProjectDeleteEndpoint {
    public static void deleteProject(String projectId) {
        given()
                .when()
                .delete("api/admin/projects/" + projectId)
                .then()
                .spec(Specifications.spec200WithoutContentType());
    }

    public static void deleteProjectWithoutAuth(String projectId) {
        given()
                .when()
                .delete("api/admin/projects/" + projectId)
                .then()
                .spec(Specifications.spec401());
    }
}