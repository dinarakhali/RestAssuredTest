package endpoints;

import dto.userInfo.UserInfoResponse;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.specification.ResponseSpecification;
import utils.Specifications;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserInfoGetEndpoint {
    @Step("Отправка GET-запроса")
    public static UserInfoResponse getCurrentUser() {
        return given()
                .queryParam("fields", "id,login,ringId")
                .when()
                .get("/api/users/me")
                .then()
                .spec(Specifications.spec200())
                .extract()
                .as(UserInfoResponse.class);
    }

    @Step("Отправка GET-запроса")
    public static void getUserWithoutAuth() {
        given()
                .spec(Specifications.specWithoutAuthRequest())
                .queryParam("fields", "id,login,ringId")
                .when()
                .get("/api/users/me")
                .then()
                .spec(Specifications.spec401());
    }

    @Step("Отправка GET-запроса")
    public static List<UserInfoResponse> getAllUsersInfo() {
        return given()
                .queryParam("fields", "id,login,ringId")
                .when()
                .get("/api/users")
                .then()
                .spec(Specifications.spec200())
                .extract()
                .as(new TypeRef<>() {
                });
    }
}