package endpoints;

import dto.issue.IssueCommentRequest;
import dto.issue.IssueCommentResponse;
import io.qameta.allure.Step;
import utils.Specifications;

import static io.restassured.RestAssured.given;

public class IssueCommentPostEndpoint {
    @Step("Отправка POST-запроса")
    public static IssueCommentResponse addComment(IssueCommentRequest request, String issueId) {
        return given()
                .queryParam("fields", "text,id")
                .body(request)
                .when()
                .post("/api/issues/" + issueId + "/comments")
                .then()
                .spec(Specifications.spec200())
                .extract()
                .as(IssueCommentResponse.class);
    }
}