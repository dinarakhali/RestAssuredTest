package tests.issues;

import dto.common.Leader;
import dto.issue.CustomFieldRequest;
import dto.issue.FieldValue;
import dto.issue.IssuePostRequest;
import dto.issue.IssueResponse;
import endpoints.IssueDeleteEndpoint;
import endpoints.IssuePostEndpoint;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseApiTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositivePostIssueTests extends BaseApiTest {
    private String issueIdToDelete;

    @Test
    @DisplayName("1. Тест создания новой задачи")
    public void createNewIssueTest() {
        List<CustomFieldRequest> fields = List.of(
                new CustomFieldRequest("Type", "SingleEnumIssueCustomField", new FieldValue("Bug")),
                new CustomFieldRequest("State", "StateIssueCustomField", new FieldValue("Open")));

        IssuePostRequest request = new IssuePostRequest(
                new Leader("0-84"),
                "Test summary.",
                "Test description.",
                fields
        );
        IssueResponse issue = IssuePostEndpoint.createIssue(request);
        issueIdToDelete = issue.getIdReadable();

        assertEquals(request.getSummary(), issue.getSummary());
        assertEquals(request.getDescription(), issue.getDescription());
    }

    @AfterEach
    public void cleanUpCreatedIssue() {
        if (issueIdToDelete != null) {
            System.out.println("Удаление задачи с ID: " + issueIdToDelete);
            IssueDeleteEndpoint.deleteIssue(issueIdToDelete);
            issueIdToDelete = null;
        }
    }
}