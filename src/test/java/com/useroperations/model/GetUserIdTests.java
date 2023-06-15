package com.useroperations.model;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetUserIdTests {

    @Test
    public void getBookingIdTest(){
        Response response = given()
                .when()
                .get("https://reqres.in/api/users/3")
                ;

        response
                .then()
                .statusCode(200);


        response.prettyPrint();
        String email = response.jsonPath().getJsonObject("data.email").toString();
        String first_name = response.jsonPath().getJsonObject("data.first_name").toString();
        String last_name = response.jsonPath().getJsonObject("data.last_name").toString();

        Assertions.assertEquals("emma.wong@reqres.in",email);
        Assertions.assertEquals("Emma", first_name);
        Assertions.assertEquals("Wong",last_name);
    }
}
