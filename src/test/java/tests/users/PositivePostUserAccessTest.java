package tests.users;

import dto.project.ProjectResponse;
import dto.userInfo.UserAccessRequest;
import dto.userInfo.UserAccessResponse;
import dto.userInfo.UserInfoResponse;
import endpoints.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseApiTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositivePostUserAccessTest extends BaseApiTest {
    private String projectRingId;
    private String userRingId;

    @Test
    @DisplayName("Тест открытия доступа к проекту")
    public void giveAccessTest() {
        List<ProjectResponse> projects = ProjectGetEndpoint.getProjects();
        projectRingId = projects.stream()
                .filter(project -> "Test Project for RestAssured".equals(project.getName()))
                .findFirst()
                .map(ProjectResponse::getRingId)
                .orElseThrow(() -> new RuntimeException("Проект не найден"));

        List<UserInfoResponse> users = UserInfoGetEndpoint.getAllUsersInfo();
        userRingId = users.stream()
                .filter(user -> "Tester".equals(user.getLogin()))
                .findFirst()
                .map(UserInfoResponse::getRingId)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        UserAccessRequest request = new UserAccessRequest(userRingId);
        UserAccessResponse response = UserAccessEndpoint.giveAccess(request, projectRingId);

        assertEquals(userRingId, response.getId(), "Провал. Предоставление доступа не удалось.");
    }

    @AfterEach
    public void cleanUpUserAccess() {
        if (userRingId != null) {
            System.out.println("Отключение доступа к проекту для ID: " + userRingId);
            UserAccessDeleteEndpoint.deleteUserAccess(projectRingId, userRingId);
            userRingId = null;
        }
    }
}