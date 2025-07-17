package tests.projects;

import dto.project.ProjectResponse;
import endpoints.ProjectGetEndpoint;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PositiveGetProjectTest {
    @Epic("Project Tests")
    @Story("Позитивное. Получение списка проектов")
    @Test
    @DisplayName("Получение информации о созданных проектах")
    public void getProjectsTest() {
        List<ProjectResponse> projects = ProjectGetEndpoint.getProjects();
        assertNotNull(projects, "Провал. Не получен список проектов.");
    }
}