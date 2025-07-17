package tests.users;

import dto.userInfo.UserInfoResponse;
import endpoints.UserInfoGetEndpoint;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveGetUserInfoTests {
    @Epic("User Tests")
    @Story("Позитивное. Получение информации о юзере")
    @Test
    @DisplayName("Получение информации о юзере")
    public void getUserInfoTest() {
        UserInfoResponse user = UserInfoGetEndpoint.getCurrentUser();
        String expectedId = "2-1";
        String expectedLogin = "admin";
        assertEquals(expectedId, user.getId());
        assertEquals(expectedLogin, user.getLogin());
    }
}