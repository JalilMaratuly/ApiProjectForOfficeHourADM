package com.cydeo.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class HRTestBase {

    @BeforeAll
    public static void init() {
        baseURI = "http://54.226.1.100:1000";
        basePath = "/ords/hr";

    }

    @AfterAll
    public static void resetApi() {
        reset();
    }
}
