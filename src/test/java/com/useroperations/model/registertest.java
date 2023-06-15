package com.useroperations.model;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class registertest {
    @Test
    public void getRegisterTest(){
        JSONObject body = new JSONObject();
        //body.put("page", 1);
        //body.put("per_page", 6);
        //body.put("total", 12);
        //body.put("total_pages", 2);
        body.put("email", "emma.wong@reqres.in");
        body.put("password","smnrkzl");




       /* JSONObject data = new JSONObject();
        data.put("id",1);
        data.put("name","cerulean");
        data.put("year",2000);
        data.put("color","#98B2D1");
        data.put("pantone_value","15-4020");


        body.put("data",data);*/

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://reqres.in/api/register");
        response.prettyPrint();

    }
}
