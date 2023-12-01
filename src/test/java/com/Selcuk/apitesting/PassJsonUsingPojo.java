package com.Selcuk.apitesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PassJsonUsingPojo {
    public static void main(String[] args) {
        User user = new User("abc@gmail.com","Cagri","Selcuk");
       Response response = given().contentType(ContentType.JSON)
               .body(user).log().all()
               .post("http://localhost:8080/api/users");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }
}
