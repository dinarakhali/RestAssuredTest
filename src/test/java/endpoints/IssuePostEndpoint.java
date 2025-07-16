package endpoints;

import dto.issue.IssuePostRequest;
import dto.issue.IssueResponse;
import io.qameta.allure.Step;
import utils.Specifications;

import static io.restassured.RestAssured.given;

public class IssuePostEndpoint {
    @Step("Отправка POST-запроса")
    public static IssueResponse createIssue(IssuePostRequest request) {
        return given()
                .queryParam("fields", "idReadable,summary,description,customFields(name,value(state,name))")
                .body(request)
                .when()
                .post("api/issues")
                .then()
                .spec(Specifications.spec200())
                .extract()
                .as(IssueResponse.class);
    }

    @Step("Отправка POST-запроса")
    public static void createIssueWrongId(IssuePostRequest request) {
        given()
                .spec(Specifications.specRequest())
                .queryParam("fields", "idReadable,summary,description,customFields(name,value(state,name))")
                .body(request)
                .when()
                .post("api/issues")
                .then()
                .spec(Specifications.spec400())
                .extract()
                .as(IssueResponse.class);
    }
}