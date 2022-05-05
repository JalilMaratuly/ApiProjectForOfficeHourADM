package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class SpartanTestBaseAuth {

    @BeforeAll
    public static void init() {

        // BeforeAll is the same thing with beforeClass in testng

        RestAssured.baseURI = "http://54.226.1.100:7000";

        /*  String dbURL="jdbc:oracle:thin:@3.86.82.161:1521:XE";
        String dbPassword="SP";
        String dbUsername="SP";
        DBUtils.createConnection(dbURL, dbUsername, dbPassword);
        */
    }

    @AfterAll
    public static void close() {
        // DBUtils.destroy();
    }
}
