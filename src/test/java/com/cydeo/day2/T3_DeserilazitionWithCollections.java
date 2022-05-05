package com.cydeo.day2;

import com.cydeo.utilities.HRTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class T3_DeserilazitionWithCollections extends HRTestBase {

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

        // USING COLLECTIONS
        //Create a test called getLocation
        //1. Send request to GET /locations
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .and()
                .get("/locations");
        //BY USING JSONPATH
        JsonPath jsonPath = response.jsonPath();
        //Map<String, Object> map = jsonPath.getMap("");
        // System.out.println("map = " + map);
        //BY USING AS METHOD
        Map<String, Object> items = response.as(Map.class);

        //2. log uri to see
        //3. Get all Json as a map and print out screen all the things with the
        //help of map
        // System.out.println("=GET FIRST LOCATION WITH JSONPATH =");

        System.out.println("=GET FIRST LOCATION WITH AS =");
        List<Object> locations = (java.util.List) items.get("items");
        System.out.println("locations.get(0) = " + locations.get(0));
        //System.out.println("=GET FIRST LOCATION LINKS =");
        System.out.println(jsonPath.get("items[0].links[0]").toString());
        //System.out.println("=GET ALL LOCATIONS AS LIST OF MAP=");
        List<Map<String, Object>> items1 = jsonPath.getList("items");
        System.out.println("items1 = " + items1);
        //System.out.println("=FIRST LOCATION =");
        System.out.println(items1.get(0));
        //System.out.println("= FIRST LOCATION ID =");
        System.out.println("items1.get(0).get(\"location_id\") = " + items1.get(0).get("location_id"));
        //System.out.println("=FIRST LOCATION COUNTRY_ID =");
        System.out.println("items1.get(0).get(\"country_id\") = " + items1.get(0).get("country_id"));
        //System.out.println("=GET FIRST LOCATION FIRST LINK = ");
        List<Map<String, Object>> firstLinkMap = (List) items1.get(0).get("links");
        System.out.println("firstLinkMap = " + firstLinkMap);
        //System.out.println("=LAST LOCATION ID =");
        System.out.println("items1.get(items.size()-1).get(\"location_id\") = " + items1.get(items.size() - 1).get("location_id"));
    }
}