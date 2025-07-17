package endpoints;


import io.qameta.allure.Step;
import utils.Specifications;

import static io.restassured.RestAssured.given;

public class ProjectDeleteEndpoint {
    @Step("Отправка DELETE-запроса")
    public static void deleteProject(String projectId) {
        given()
                .spec(Specifications.specRequest())
                .when()
                .delete("api/admin/projects/" + projectId)
                .then()
                .spec(Specifications.spec200WithoutContentType());
    }

    @Step("Отправка DELETE-запроса")
    public static void deleteProjectWithoutAuth(String projectId) {
        given()
                .spec(Specifications.specWithoutAuthRequest())
                .when()
                .delete("api/admin/projects/" + projectId)
                .then()
                .spec(Specifications.spec401());
    }
}