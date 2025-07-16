package tests.users;

import dto.userInfo.UserInfoResponse;
import endpoints.UserInfoGetEndpoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseApiTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveGetUserInfoTests extends BaseApiTest {
    @Test
    @DisplayName("Тест валидности полей пользователя")
    public void getUserInfoTest() {
        UserInfoResponse user = UserInfoGetEndpoint.getCurrentUser();
        System.out.println("User object: " + user);
        String expectedId = "2-1";
        String expectedLogin = "admin";
        assertEquals(expectedId, user.getId());
        assertEquals(expectedLogin, user.getLogin());
    }
}