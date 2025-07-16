package endpoints;

import dto.userInfo.UserAccessRequest;
import dto.userInfo.UserAccessResponse;

import static io.restassured.RestAssured.given;

public class UserAccessEndpoint {
    public static UserAccessResponse giveAccess(UserAccessRequest request, String projectRingId) {
        return given()
                .queryParam("fields", "type,id,name")
                .body(request)
                .when()
                .post("/hub/api/rest/projects/" + projectRingId + "/team/users")
                .then()
                .extract()
                .as(UserAccessResponse.class);
    }
}