package endpoints;

import dto.issue.IssueCommentRequest;
import dto.issue.IssueCommentResponse;

import static io.restassured.RestAssured.given;

public class IssueCommentPostEndpoint {
    public static IssueCommentResponse addComment(IssueCommentRequest request, String issueId) {
        return given()
                .queryParam("fields", "text,id")
                .body(request)
                .when()
                .post("/api/issues/" + issueId + "/comments")
                .then()
                .extract()
                .as(IssueCommentResponse.class);
    }
}