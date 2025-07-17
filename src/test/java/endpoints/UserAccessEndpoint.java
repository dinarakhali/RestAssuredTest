package endpoints;

import dto.userInfo.UserAccessRequest;
import dto.userInfo.UserAccessResponse;

import io.qameta.allure.Step;
import utils.Specifications;

import static io.restassured.RestAssured.given;

public class UserAccessEndpoint {
    @Step("Отправка POST-запроса")
    public static UserAccessResponse giveAccess(UserAccessRequest request, String projectRingId) {
        return given()
                .spec(Specifications.specRequest())
                .queryParam("fields", "type,id,name")
                .body(request)
                .when()
                .post("/hub/api/rest/projects/" + projectRingId + "/team/users")
                .then()
                .spec(Specifications.spec200())
                .extract()
                .as(UserAccessResponse.class);
    }
}