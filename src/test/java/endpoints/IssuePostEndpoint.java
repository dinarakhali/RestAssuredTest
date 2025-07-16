package endpoints;

import dto.issue.IssuePostRequest;
import dto.issue.IssueResponse;

import static io.restassured.RestAssured.given;

public class IssuePostEndpoint {
    public static IssueResponse createIssue(IssuePostRequest request) {
        return given()
                .queryParam("fields", "idReadable,summary,description,customFields(name,value(state,name))")
                .body(request)
                .log().all()
                .when()
                .post("api/issues")
                .then()
                .extract()
                .as(IssueResponse.class);
    }
}