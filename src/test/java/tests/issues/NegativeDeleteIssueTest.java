package tests.issues;

import endpoints.IssueDeleteEndpoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseApiTest404;

public class NegativeDeleteIssueTest extends BaseApiTest404 {
    @Test
    @DisplayName("1. Негативный тест удаления задачи с несуществующим ID")
    public void deleteIssueNegativeTest() {
        IssueDeleteEndpoint.deleteIssueNegative("ABC-999999");
    }
}