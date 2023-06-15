package com.useroperations.model;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTests extends BaseTest{

    @Test
    public void deleteUserTest(){
        String id = createToken();
        int userId = creatingUserId("Sema Nur","Kızıl",2);

        Response response = given()
                .contentType(ContentType.JSON)
                .header("id=",userId)
                .delete("https://reqres.in/api/users/2"+userId);

        response
                .then()
                .statusCode(204);

        response.prettyPrint();
    }
}
