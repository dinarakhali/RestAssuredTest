package tests.users;

import endpoints.UserInfoGetEndpoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseApiTest401;

public class NegativeGetUserInfoTest extends BaseApiTest401 {
    @Test
    @DisplayName("1. Тест доступа к инф-ии о юзерах без авторизации")
    public void getUserInfoNegativeTest() {
        UserInfoGetEndpoint.getCurrentUser();
    }
}