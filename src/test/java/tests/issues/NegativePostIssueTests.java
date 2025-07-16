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

public class NegativePostIssueTests extends BaseApiTest {
    private String issueIdToDelete;

    @Test
    @DisplayName("Негативный тест создания новой задачи")
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
        IssueResponse issue = IssuePostEndpoint.createIssue(request);
        issueIdToDelete = issue.getIdReadable();
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