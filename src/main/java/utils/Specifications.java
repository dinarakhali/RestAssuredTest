package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static RequestSpecification specRequest() {
        return new RequestSpecBuilder()
                .setBaseUri("https://didzi.youtrack.cloud")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer perm-YWRtaW4=.NDQtMA==.0C5OKGYG8LFDktN9n06JOjc0b0eBRW")
                .build();
    }

    public static RequestSpecification specWithoutAuthRequest() {
        return new RequestSpecBuilder()
                .setBaseUri("https://didzi.youtrack.cloud")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
    }

    public static ResponseSpecification spec200() {
        return new ResponseSpecBuilder()
                .expectContentType("application/json;charset=utf-8")
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification spec200WithoutContentType() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification spec400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }

    public static ResponseSpecification spec401() {
        return new ResponseSpecBuilder()
                .expectStatusCode(401)
                .build();
    }

    public static ResponseSpecification spec404() {
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .build();
    }
}