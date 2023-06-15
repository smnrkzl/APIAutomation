package com.useroperations.model;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTests2 {

    @Test
    public void deleteUserTests2(){
        JSONObject data = new JSONObject();
        data.put("id",15);
        data.put("email","sema@gmail.com");
        data.put("first_name","Sema Nur");
        data.put("last_name","Kızıl");
        data.put("avatar","https://reqres.in/img/faces/2-image.jpg");

        JSONObject support = new JSONObject();
        support.put("url","https://reqres.in/#support-heading");
        support.put("text", "To keep ReqRes free, contributions towards server costs are appreciated!");

        data.put("support",support);

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(data.toString())
                .post("https://reqres.in/api/users/2");
        response.prettyPrint();
    }
}
