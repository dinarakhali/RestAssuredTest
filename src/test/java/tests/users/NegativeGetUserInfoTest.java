package tests.users;

import endpoints.UserInfoGetEndpoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseApiTest;

public class NegativeGetUserInfoTest extends BaseApiTest {
    @Test
    @DisplayName("Тест доступа к инф-ии о юзерах без авторизации")
    public void getUserInfoNegativeTest() {
        UserInfoGetEndpoint.getCurrentUser();
    }
}