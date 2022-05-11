package com.cydeo.day3;

import com.cydeo.pojos.Spartan;
import com.cydeo.utilities.SpartanTestBaseAuth;
import com.cydeo.utilities.SpartanUtils;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpartanFlow extends SpartanTestBaseAuth {

       /* As a homework,write a detailed test for Role Base Access Control(RBAC)
               in Spartan Auth app (7000)
               Admin should be able take all CRUD
               Editor should be able to take all CRUD
                   other than DELETE
               User should be able to only READ data
                   not update,delete,create (POST,PUT,PATCH,DELETE)
          --------------------------------------------------------
           Can guest even read data ? 401 for all */

    // post spartan
    @Test
    public void postSpartan() {

        Spartan spartan = SpartanUtils.createSpartan();
        SpartanUtils.postSpartan("admin", "admin", spartan)
                .post("/spartans");

        //get spartan

        //put spartan

        //delete spartan

    }
}