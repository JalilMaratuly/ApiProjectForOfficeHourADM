package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class SpartanTestBaseAuth {

    // beforeAll is the same thing with beforeClass in testng
    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://54.226.1.100:7000";
        RestAssured.basePath = "/api";
    }

    @AfterAll
    public static void close() {

        RestAssured.reset();
    }
}