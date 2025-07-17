package tests.issues;

import dto.common.Leader;
import dto.issue.CustomFieldRequest;
import dto.issue.FieldValue;
import dto.issue.IssuePostRequest;
import endpoints.IssuePostEndpoint;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NegativePostIssueTests {
    @Epic("Issue Tests")
    @Story("Негативное. Создание задачи")
    @Test
    @DisplayName("Создание новой задачи")
    public void createNewIssueNegativeTest() {
        List<CustomFieldRequest> fields = List.of(
                new CustomFieldRequest("Type", "SingleEnumIssueCustomField", new FieldValue("Bug")),
                new CustomFieldRequest("State", "StateIssueCustomField", new FieldValue("Open")));

        IssuePostRequest request = new IssuePostRequest(
                new Leader("9-99999999"),
                "Negative test summary",
                "Negative test description.",
                fields
        );
        IssuePostEndpoint.createIssueWrongId(request);
    }
}