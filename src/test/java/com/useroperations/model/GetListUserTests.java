package com.useroperations.model;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetListUserTests {

    @Test
    public void getListUserTest(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().all()
                .statusCode(200);
    }
}
