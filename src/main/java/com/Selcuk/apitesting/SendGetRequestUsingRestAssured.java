package com.Selcuk.apitesting;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SendGetRequestUsingRestAssured {


    public static void main(String[] args) {

            Response response = given().auth()
                    .basic("sk_test_51NvO8YDjhy5nweTQFxoxtDkWEQzo5ryT0wjhTsnb2QkZx9mTZiT8JkDttM3tfCA3mbPiAKsr9oGMda8Gd2JWbs0y002y8IKyPA", "")
//                    .formParams("limit", 3)
//                    .formParam("email", "def@gmail.com")
                    .get("https://api.stripe.com/v1/customers");


            //response.prettyPrint();
            String jsonResponse = response.asString();
            System.out.println(jsonResponse);

            System.out.println("Response code --> "+response.statusCode());
        }




}
