package endpoints;

import dto.userInfo.UserInfoResponse;
import io.restassured.common.mapper.TypeRef;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserInfoGetEndpoint {
    public static UserInfoResponse getCurrentUser() {
        return given()
                .queryParam("fields", "id,login,ringId")
                .when()
                .get("/api/users/me")
                .then()
                .extract()
                .as(UserInfoResponse.class);
    }

    public static List<UserInfoResponse> getAllUsersInfo() {
        return given()
                .queryParam("fields", "id,login,ringId")
                .when()
                .get("/api/users")
                .then()
                .extract()
                .as(new TypeRef<>() {
                });
    }
}