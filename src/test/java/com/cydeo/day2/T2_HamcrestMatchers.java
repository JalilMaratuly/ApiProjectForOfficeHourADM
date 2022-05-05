package com.cydeo.day2;

import com.cydeo.utilities.HRTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class T2_HamcrestMatchers extends HRTestBase {

    @Test
    public void test() {

        //Given
        RestAssured.given()
                //accept type is application/json
                .accept(ContentType.JSON)
                //When
                .when()
                //user sends get request to /regions Then
                .get("/regions")
                //then
                .then()
                //response status code must be 200 verify
                .statusCode(200)
                //Date has values
                .header("Date", is(notNullValue()))
                //first region name is Europe
                .and()
                .body("items[0].region_name", is("Europe"))
                //Regions name should be same order as

                //  .body("items.region_name",
                //         containsInRelativeOrder("Europe", "Americas", "Asia", "Middle East and Africa"));
                .body("items.region_name",
                        containsInAnyOrder("Americas", "Europe", "Asia", "Middle East and Africa"));
        //"Europe","Americas","Asia","Middle East and Africa" region ids needs to be 1,2,3,4
    }
}