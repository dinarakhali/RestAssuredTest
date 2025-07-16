package tests.projects;

import dto.common.Leader;
import dto.project.ProjectPostRequest;
import dto.project.ProjectResponse;
import endpoints.ProjectDeleteEndpoint;
import endpoints.ProjectPostEndpoint;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tests.BaseApiTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositivePostProjectTests extends BaseApiTest {
    private String projectId;

    @Epic("Project Tests")
    @Story("Позитивное. Создание проектов")
    @ParameterizedTest
    @CsvFileSource(resources = "/testdata/projectsData.csv", numLinesToSkip = 1)
    @DisplayName("Создания нового проекта")
    public void createProjectTest(String name, String shortName, String description) {
        Leader leader = new Leader("2-1");
        ProjectPostRequest request = new ProjectPostRequest(name, shortName, leader, description);
        ProjectResponse project = ProjectPostEndpoint.createNewProject(request);
        projectId = project.getId();

        assertEquals(name, project.getName());
        assertEquals(description, project.getDescription());
    }

    @AfterEach
    public void cleanUpCreatedProject() {
        if (projectId != null) {
            System.out.println("Удаление проекта с ID: " + projectId);
            ProjectDeleteEndpoint.deleteProject(projectId);
            projectId = null;
        }
    }
}