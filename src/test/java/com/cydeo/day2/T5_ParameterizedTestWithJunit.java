package com.cydeo.day2;

import com.cydeo.pojos.Spartan;
import com.cydeo.utilities.SpartanTestBase;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;

public class T5_ParameterizedTestWithJunit extends SpartanTestBase {

    int spartanId;

    //======================================
    @DisplayName("Create Spartan")
    @ParameterizedTest
    @CsvSource({"admin,201", "user,403", "editor,201"})
    public void postSpartanWithCSV(String userType, int statusCode) {
        Spartan spartan = createSpartan();

        Response response = given()
                .contentType(ContentType.JSON)
                .auth().basic(userType, userType)
                .and().accept(ContentType.JSON)
                .and().body(spartan)
                .log().all()
                .when()
                .post("/api/spartans")
                .then()
                .statusCode(statusCode)
                .log().all()
                .extract().response();
        if (statusCode == 201) {
            spartanId = response.jsonPath().getInt("data.id");
        }

        System.out.println("spartanId = " + spartanId);
    }

    public static Spartan createSpartan() {
        Faker faker = new Faker();
        String genderCreate = faker.dog().gender();
        String gender = (genderCreate.charAt(0) + "").toUpperCase() + (genderCreate.substring(1)).toLowerCase();
        Spartan spartan = Spartan.builder()
                .name(faker.name().firstName())
                .gender(gender)
                .phone(Long.parseLong(faker.numerify("##########"))).build();
        System.out.println("spartan = " + spartan);
        return spartan;
    }
}