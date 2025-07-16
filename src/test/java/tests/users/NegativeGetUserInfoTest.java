package tests.users;

import endpoints.UserInfoGetEndpoint;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NegativeGetUserInfoTest{
    @Epic("User Tests")
    @Story("Негативное. Получение списка юзеров")
    @Test
    @DisplayName("Получение инф-ии о юзерах без авторизации")
    public void getUserInfoNegativeTest() {
        UserInfoGetEndpoint.getUserWithoutAuth();
    }
}