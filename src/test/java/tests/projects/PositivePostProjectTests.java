package tests.projects;

import dto.common.Leader;
import dto.project.ProjectPostRequest;
import dto.project.ProjectResponse;
import endpoints.ProjectDeleteEndpoint;
import endpoints.ProjectPostEndpoint;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseApiTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositivePostProjectTests extends BaseApiTest {
    private String projectId;

    @Test
    @DisplayName("1. Тест создания нового проекта")
    public void createProjectTest() {
        Leader leader = new Leader("2-1");
        ProjectPostRequest request = new ProjectPostRequest("1 API Project", "1AP",
                leader, "Описание проекта.");
        ProjectResponse project = ProjectPostEndpoint.createNewProject(request);
        projectId = project.getId();

        String expectedName = "1 API Project";
        String expectedDescription = "Описание проекта.";
        assertEquals(expectedName, project.getName());
        assertEquals(expectedDescription, project.getDescription());
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