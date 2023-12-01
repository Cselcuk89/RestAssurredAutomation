package com.Selcuk.apitesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.*;

public class SendPostRequestUsingRestAssured {
    public static void main(String[] args) {
//        Response response = given().auth()
//                .basic("sk_test_51NvO8YDjhy5nweTQFxoxtDkWEQzo5ryT0wjhTsnb2QkZx9mTZiT8JkDttM3tfCA3mbPiAKsr9oGMda8Gd2JWbs0y002y8IKyPA", "")
//                .queryParam("name","Bill Spect")
//                .queryParam("email","def@gmail.com")
//                .queryParam("description","this is a test customer")
//                .when()
//                .post("https://api.stripe.com/v1/customers");
//        response.prettyPrint();
        Response response = given().contentType(ContentType.JSON)
                .body(new File("./users.json"))
                .log().all().post("http://localhost:8080/api/users");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
    }

}
