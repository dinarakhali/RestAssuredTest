package tests.projects;

import dto.project.ProjectResponse;
import endpoints.ProjectGetEndpoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseApiTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PositiveGetProjectTest extends BaseApiTest {
    @Test
    @DisplayName("1. Тест получения информации о созданных проектах")
    public void getProjectsTest() {
        List<ProjectResponse> projects = ProjectGetEndpoint.getProjects();
        projects.stream()
                .map(project -> "Проект: " + project.getName() + " (" + project.getId() + ")")
                .forEach(System.out::println);

        assertNotNull(projects, "Провал. Не получен список проектов.");
    }
}