package com.familia_em_ritmo.familia_em_ritmo.api;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class ApiTest {
    @Test
    public void testRelativeGetRequest(){
        given()
                .baseUri("http://localhost:8080")
                .when().get("/relative")
                .then().statusCode(200)
                .body("relatives", hasSize(0));
    }
}
