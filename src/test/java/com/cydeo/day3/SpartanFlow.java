package com.cydeo.day3;

import com.cydeo.pojos.Spartan;
import com.cydeo.utilities.SpartanTestBaseAuth;
import com.cydeo.utilities.SpartanUtils;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.*;

import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpartanFlow extends SpartanTestBaseAuth {
    /*
        As a homework,write a detailed test for Role Base Access Control(RBAC)
            in Spartan Auth app (7000)
            Admin should be able take all CRUD
            Editor should be able to take all CRUD
                other than DELETE
            User should be able to only READ data
                not update,delete,create (POST,PUT,PATCH,DELETE)
       --------------------------------------------------------
        Can guest even read data ? 401 for all
    */
    static int postSpartanId;
    static String postSpartanName;
    static String postSpartanGeder;
    static long postSpartanPhone;

    @Order(1)
    //post spartan
    @Test
    public void postSpartan() {
        Spartan spartan = SpartanUtils.createSpartan();
        JsonPath jsonPath = SpartanUtils.postSpartan("admin", "admin", spartan)
                .log().uri()
                .post("/spartans")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("success", is("A Spartan is Born!"))
                .extract().jsonPath();
        postSpartanId = jsonPath.getInt("data.id");
        postSpartanName = jsonPath.getString("data.name");
        postSpartanGeder = jsonPath.getString("data.gender");
        postSpartanPhone = jsonPath.getLong("data.phone");
        System.out.println("postSpartanId = " + postSpartanId);
    }


    @Order(2)
    //get spartan
    @Test
    public void getSpartan() {
        JsonPath jsonPath = SpartanUtils.getSpartan("admin", "admin", postSpartanId)
                .log().uri()
                .get("/spartans/{id}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().jsonPath();

        int getSpartanId = jsonPath.getInt("id");
        System.out.println("getSpartanId = " + getSpartanId);
        String getSpartanName = jsonPath.getString("name");
        String getSpartanGender = jsonPath.getString("gender");
        long getSpartanPhone = jsonPath.getLong("phone");

        Assertions.assertEquals(postSpartanId, getSpartanId);
        Assertions.assertEquals(postSpartanName, getSpartanName);
        Assertions.assertEquals(postSpartanGeder, getSpartanGender);
        Assertions.assertEquals(postSpartanPhone, getSpartanPhone);


    }


    //put spartan


    //delete spartan


}