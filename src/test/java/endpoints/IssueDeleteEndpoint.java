package endpoints;

import io.restassured.RestAssured;
import utils.Specifications;

import static io.restassured.RestAssured.given;

public class IssueDeleteEndpoint {
    public static void deleteIssue(String issueId) {
        RestAssured.responseSpecification = null;
        given()
                .when()
                .delete("api/issues/" + issueId)
                .then()
                .spec(Specifications.spec200WithoutContentType())
                .statusCode(200);
    }

    public static void deleteIssueNegative(String issueId) {
        given()
                .when()
                .delete("api/issues/" + issueId)
                .then()
                .statusCode(404);
    }
}