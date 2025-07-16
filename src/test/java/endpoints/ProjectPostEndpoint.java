package endpoints;

import dto.project.ProjectPostRequest;
import dto.project.ProjectResponse;
import io.qameta.allure.Step;
import utils.Specifications;

import static io.restassured.RestAssured.given;

public class ProjectPostEndpoint {
    @Step("Отправка POST-запроса")
    public static ProjectResponse createNewProject(ProjectPostRequest request) {
        return given()
                .queryParam("fields", "id,shortName,name,description")
                .body(request)
                .when()
                .post("api/admin/projects")
                .then()
                .spec(Specifications.spec200())
                .extract()
                .as(ProjectResponse.class);
    }
}