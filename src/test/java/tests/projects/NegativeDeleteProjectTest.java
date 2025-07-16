package tests.projects;

import endpoints.ProjectDeleteEndpoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseApiTest;

public class NegativeDeleteProjectTest extends BaseApiTest {
    @Test
    @DisplayName("Негативный тест удаления проекта без авторизации")
    public void deleteProjectNegativeTest() {
        ProjectDeleteEndpoint.deleteProjectWithoutAuth("0-84");
    }
}