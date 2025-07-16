package tests.issues;

import endpoints.IssueDeleteEndpoint;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseApiTest;

public class NegativeDeleteIssueTest extends BaseApiTest {
    @Epic("Issue Tests")
    @Story("Негативное. Удаление задачи")
    @Test
    @DisplayName("Удаление задачи с несуществующим ID")
    public void deleteIssueNegativeTest() {
        IssueDeleteEndpoint.deleteIssueNegative("ABC-999999");
    }
}