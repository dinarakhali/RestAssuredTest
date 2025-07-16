package endpoints;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import utils.Specifications;

import static io.restassured.RestAssured.given;

public class IssueDeleteEndpoint {
    @Step("Отправка DELETE-запроса")
    public static void deleteIssue(String issueId) {
        given()
                .when()
                .delete("api/issues/" + issueId)
                .then()
                .spec(Specifications.spec200WithoutContentType());
    }

    @Step("Отправка DELETE-запроса")
    public static void deleteIssueNegative(String issueId) {
        given()
                .when()
                .delete("api/issues/" + issueId)
                .then()
                .spec(Specifications.spec404());
    }
}