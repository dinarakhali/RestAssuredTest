package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import utils.Specifications;

public class BaseApiTest400 {
    @BeforeAll
    public static void setup() {
        RestAssured.requestSpecification = Specifications.specRequest();
        RestAssured.responseSpecification = Specifications.spec400();
    }
}