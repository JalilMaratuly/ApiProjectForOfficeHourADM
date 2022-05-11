package com.cydeo.utilities;

import com.cydeo.pojos.Spartan;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class SpartanUtils {

    public static Spartan createSpartan() {
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String genderCreate = faker.dog().gender();
        //female male  default I want to get Male and Female
        String gender = (genderCreate.charAt(0) + "").toUpperCase() + genderCreate.substring(1);
        long phone = Long.parseLong(faker.numerify("###########"));
        //new way for creating object
        Spartan spartan = Spartan.builder().gender(gender).name(name).phone(phone).build();
        //old way for creating object
        //  Spartan spartan = new Spartan(0, name, gender, phone);

        return spartan;
    }

    private static RequestSpecification login(String username, String password) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .auth().basic(username, password);
    }

    public static RequestSpecification postSpartan(String username, String password, Spartan spartan) {
        return login(username, password)
                .and()
                .body(spartan);

    }

    public static RequestSpecification getSpartan(String username, String password, int postSpartanId) {
        return login(username, password)
                .and()
                .pathParam("id", postSpartanId);
    }


    public static RequestSpecification putSpartan(String username, String password, Spartan spartan, int postSpartanId) {
        return login(username, password)
                .pathParam("id", postSpartanId)
                .body(spartan);
    }

    public static RequestSpecification deleteSpartan(String username, String password, int postSpartanId) {
        return login(username, password)
                .pathParam("id", postSpartanId);
    }
}