package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import utils.Specifications;

public class BaseApiTest401 {
    @BeforeAll
    public static void setup() {
        RestAssured.requestSpecification = Specifications.specWithoutAuthRequest();
        RestAssured.responseSpecification = Specifications.spec401();
    }
}