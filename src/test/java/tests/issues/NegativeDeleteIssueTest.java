package tests.issues;

import endpoints.IssueDeleteEndpoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseApiTest;

public class NegativeDeleteIssueTest extends BaseApiTest {
    @Test
    @DisplayName("Негативный тест удаления задачи с несуществующим ID")
    public void deleteIssueNegativeTest() {
        IssueDeleteEndpoint.deleteIssueNegative("ABC-999999");
    }
}