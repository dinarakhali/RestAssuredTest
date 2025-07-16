package tests.projects;

import dto.common.Leader;
import dto.project.ProjectPostRequest;
import dto.project.ProjectResponse;
import endpoints.ProjectPostEndpoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseApiTest400;

public class NegativePostProjectTests extends BaseApiTest400 {
    @Test
    @DisplayName("1. Тест создания проекта с уже существующим shortName")
    public void createProjectNegativeTest() {
        Leader leader = new Leader("2-1");
        ProjectPostRequest request = new ProjectPostRequest("Pr-Negative API Test", "P1A",
                leader, "Описание проекта для негативного теста.");
        ProjectResponse project = ProjectPostEndpoint.createNewProject(request);
    }
}