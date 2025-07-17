package tests.projects;

import dto.common.Leader;
import dto.project.ProjectPostRequest;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NegativePostProjectTests {
    @Epic("Project Tests")
    @Story("Негативное. Создание проекта")
    @Test
    @DisplayName("Создание проекта с уже существующим shortName")
    public void createProjectNegativeTest() {
        Leader leader = new Leader("2-1");
        ProjectPostRequest request = new ProjectPostRequest("Pr-Negative API Test", "P1A",
                leader, "Описание проекта для негативного теста.");
    }
}