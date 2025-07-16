package endpoints;

import dto.project.ProjectResponse;
import io.qameta.allure.Step;
import io.restassured.common.mapper.TypeRef;
import utils.Specifications;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProjectGetEndpoint {
    @Step("Отправка GET-запроса")
    public static List<ProjectResponse> getProjects() {
        return given()
                .queryParam("fields", "id,name,shortName,description,ringId")
                .when()
                .get("api/admin/projects")
                .then()
                .spec(Specifications.spec200())
                .extract()
                .as(new TypeRef<>() {
                });
    }
}