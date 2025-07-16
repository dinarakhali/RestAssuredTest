package endpoints;

import dto.project.ProjectPostRequest;
import dto.project.ProjectResponse;

import static io.restassured.RestAssured.given;

public class ProjectPostEndpoint {
    public static ProjectResponse createNewProject(ProjectPostRequest request) {
        return given()
                .queryParam("fields", "id,shortName,name,description")
                .body(request)
                .when()
                .post("api/admin/projects")
                .then()
                .extract()
                .as(ProjectResponse.class);
    }
}