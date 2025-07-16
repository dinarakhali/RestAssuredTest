package tests.issues;

import dto.issue.IssuePostRequest;
import dto.issue.IssueResponse;
import endpoints.IssueDeleteEndpoint;
import endpoints.IssuePostEndpoint;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tests.BaseApiTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositivePostIssueTests extends BaseApiTest {
    private String issueIdToDelete;

    @ParameterizedTest
    @MethodSource("loadIssueData")
    @DisplayName("Тест создания новой задачи")
    public void createNewIssueTest(IssuePostRequest request) {
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

    public static Stream<IssuePostRequest> loadIssueData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream data = new FileInputStream("src/test/resources/testdata/issuesData.json");
        List<IssuePostRequest> issuesRequest = Arrays.asList(mapper.readValue(data, IssuePostRequest[].class));
        return issuesRequest.stream();
    }
}