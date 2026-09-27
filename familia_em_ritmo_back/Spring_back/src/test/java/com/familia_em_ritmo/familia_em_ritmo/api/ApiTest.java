package com.familia_em_ritmo.familia_em_ritmo.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

// Sobe a aplicação numa porta aleatória, em vez de depender de uma instância já rodando em localhost:8080.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {
    @LocalServerPort
    private int port;

    @Test
    public void testRelativeGetRequest(){
        given()
                .baseUri("http://localhost")
                .port(port)
                .when().get("/relative")
                .then().statusCode(200)
                .body("relatives", hasSize(0));
    }
}
