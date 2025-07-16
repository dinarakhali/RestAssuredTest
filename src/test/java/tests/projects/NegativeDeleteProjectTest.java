package tests.projects;

import endpoints.ProjectDeleteEndpoint;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseApiTest;

public class NegativeDeleteProjectTest {
    @Epic("Project Tests")
    @Story("Негативное. Удаление проекта")
    @Test
    @DisplayName("Удаление проекта без авторизации")
    public void deleteProjectNegativeTest() {
        ProjectDeleteEndpoint.deleteProjectWithoutAuth("0-84");
    }
}