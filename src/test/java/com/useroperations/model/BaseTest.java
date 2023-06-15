package com.useroperations.model;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class BaseTest {

    protected int creatingUserId(String first_name, String last_name, int id){
        return createUser(first_name, last_name, id).jsonPath().getJsonObject("userid");
    }

    protected Response createUser(String first_name, String last_name, int id){
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(userObject(first_name,last_name,id))
                .post("https://reqres.in/api/users");

        response
                .then()
                .statusCode(201);
        return response;
    };

    protected String userObject(String first_name, String last_name, int id){
        JSONObject body = new JSONObject();
        body.put("first_name", first_name);
        body.put("last_name", last_name);
        body.put("id", id);
        body.put("total_pages", 8);


        JSONObject data = new JSONObject();
        data.put("id",1);
        data.put("email","sema@gmail.com");
        data.put("first_name","Sema Nur");
        data.put("last_name","Kızıl");
        data.put("avatar","https://reqres.in/img/faces/1-image.jpg");

        body.put("data",data);
        return body.toString();
    }

    protected String createToken(){
        JSONObject body = new JSONObject();
        body.put("email","janet.weaver@reqres.in");
        body.put("password", "smnrkzl");

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(body.toString()).log().all()
                .post("https://reqres.in/api/register");

        response.prettyPrint();
        return response.jsonPath().getJsonObject("token");
    }




}
