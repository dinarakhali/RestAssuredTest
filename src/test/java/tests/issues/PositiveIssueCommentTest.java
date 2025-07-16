package tests.issues;

import dto.common.Leader;
import dto.issue.*;
import endpoints.IssueCommentPostEndpoint;
import endpoints.IssueDeleteEndpoint;
import endpoints.IssuePostEndpoint;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseApiTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveIssueCommentTest extends BaseApiTest {
    private String issueId;
    @Epic("Issue Tests")
    @Story("Позитивное. Добавление комментария")
    @Test
    @DisplayName("Добавление комментария к задаче")
    public void addCommentTest() {
        List<CustomFieldRequest> fields = List.of(
                new CustomFieldRequest("State", "StateIssueCustomField", new FieldValue("Open")));

        IssuePostRequest request = new IssuePostRequest(
                new Leader("0-84"),
                "Test summary.",
                "Test description.",
                fields
        );
        IssueResponse issue = IssuePostEndpoint.createIssue(request);
        issueId = issue.getIdReadable();

        String text = "Тестовый комментарий.";
        IssueCommentRequest commentRequest = new IssueCommentRequest(text);
        IssueCommentResponse commentResponse = IssueCommentPostEndpoint.addComment(commentRequest, issueId);

        assertEquals(text, commentResponse.getText(), "Провал. Комментарий не добавлен.");
    }

    @AfterEach
    public void cleanUpCreatedIssue() {
        if (issueId != null) {
            System.out.println("Удаление задачи с ID: " + issueId);
            IssueDeleteEndpoint.deleteIssue(issueId);
            issueId = null;
        }
    }
}