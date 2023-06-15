package com.useroperations.model;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {

    @Test
    public void createBookingTests(){
        JSONObject body = new JSONObject();
        body.put("page", 21);
        body.put("per_page", 2);
        body.put("total", 4);
        body.put("total_pages", 8);


       JSONObject data = new JSONObject();
       data.put("id",1);
       data.put("email","sema@gmail.com");
       data.put("first_name","Sema Nur");
       data.put("last_name","Kızıl");
       data.put("avatar","https://reqres.in/img/faces/1-image.jpg");

       body.put("data",data);

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://reqres.in/api/users");
        response.prettyPrint();

    }
}
