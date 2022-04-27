package com.cydeo.day1;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class T3_SpartanApi_BeforeAll_AfterAll {

    /**
     * Task 3:
     * 1. Send request to Spartan url and save the response
     * 2. GET /spartans
     * 3. Store the response in Response Object that comes from get Request
     * 4. Print out followings
     * - response
     * - Content-Type
     * - Status Code
     * - Get me third spartan
     * - Get me third spartan gender
     * - Get me third spartan name
     * - Get me all spartan name
     */

    // Create BeforeAll method
    @BeforeAll
    public static void init() {
        baseURI = "http://54.226.1.100:8000";
        basePath = "/api";
    }

    @AfterAll
    public static void resetApi() {
        reset();
    }

    @Test
    public void test() {

        // 1. Send request to Spartan url and save the response
        // 2. GET /spartans
        // 3. Store the response in Response Object that comes from get Request
        Response response = RestAssured.get("/spartans");

        // 4. Print out followings

        //      - response
        //response.prettyPrint();

        //      - Content-Type
        System.out.println("==============================");
        System.out.println(response.contentType());

        //      - Status Code
        System.out.println("==============================");
        System.out.println(response.statusCode());

        //      - Get me third spartan
        System.out.println("==============================");
        Object thirdSpartan = response.path("[2]");
        System.out.println("thirdSpartan = " + thirdSpartan);

        //      - Get me third spartan gender
        String gender = response.path("[2].gender");
        Object gender2 = response.path("gender[2]");
        // gender = gender2
        System.out.println("gender = " + gender);

        //      - Get me third spartan name
        System.out.println("==============================");
        String name = response.path("[2].name");
        System.out.println("name = " + name);

        //      - Get me all spartan name
        List<String> names = response.path("name");
        System.out.println("names = " + names);
    }
}