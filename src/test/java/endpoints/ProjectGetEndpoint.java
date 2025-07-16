package endpoints;

import dto.project.ProjectResponse;
import io.restassured.common.mapper.TypeRef;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProjectGetEndpoint {
    public static List<ProjectResponse> getProjects() {
        return given()
                .queryParam("fields", "id,name,shortName,description,ringId")
                .when()
                .get("api/admin/projects")
                .then()
                .extract()
                .as(new TypeRef<List<ProjectResponse>>() {
                });
    }
}