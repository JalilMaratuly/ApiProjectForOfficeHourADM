package com.cydeo.day2;

import com.cydeo.pojos.Location;
import com.cydeo.utilities.HRTestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

public class T4_DeserilazitionWithPOJOClasses extends HRTestBase {

    /**
     * USING COLLECTIONS
     * Create a test called getLocation
     * 1. Send request to GET /locations
     * 2. log uri to see
     * 3. Get all Json as a map and print out screen all the things with the
     * help of map
     * System.out.println("=GET FIRST LOCATION WITH JSONPATH =");
     * System.out.println("=GET FIRST LOCATION WITH AS =");
     * System.out.println("=GET FIRST LOCATION LINKS =");
     * System.out.println("=GET ALL LOCATIONS AS LIST OF MAP=");
     * System.out.println("=FIRST LOCATION =");
     * System.out.println("= FIRST LOCATION ID =");
     * System.out.println("=FIRST LOCATION COUNTRY_ID =");
     * System.out.println("=GET FIRST LOCATION FIRST LINK = ");
     * System.out.println("=LAST LOCATION ID =");
     */

    @Test
    public void test() {

        // Create a test called getLocation
        // 1. Send request to GET /locations
        JsonPath jsonPath = RestAssured.given().log()
                //2. log uri to see
                .uri()
                //GET /locations
                .get("/locations").jsonPath();

        //3. Get all Json as a map and print out screen all the things with the
        List<Location> locations = jsonPath.getList("items");
        System.out.println("locations = " + locations);
        //help of map
        //System.out.println("=GET FIRST LOCATION WITH JSONPATH =");

        //System.out.println("=GET FIRST LOCATION WITH AS =");
        //System.out.println("=GET FIRST LOCATION LINKS =");
        System.out.println(locations.get(0));
        //System.out.println("=GET ALL LOCATIONS AS LIST OF MAP=");
        //System.out.println("=FIRST LOCATION =");
        //System.out.println("= FIRST LOCATION ID =");
        //System.out.println("=FIRST LOCATION COUNTRY_ID =");
        //System.out.println("=GET FIRST LOCATION FIRST LINK = ");
        //System.out.println("=LAST LOCATION ID =");
    }
}