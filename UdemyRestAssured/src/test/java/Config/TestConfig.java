package Config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class TestConfig {

    //public static RequestSpecification videogame_request;
    //public static ResponseSpecification videogame_response;
    //public static RequestSpecification requestDarksky;
    //public static ResponseSpecification responseDarksky;


    @BeforeClass
    public static void BaseClass(){
        //RestAssured.baseURI = "http://localhost";
        //RestAssured.port = 8080;
        //RestAssured.basePath = "/app/";

        RestAssured.proxy("localhost", 8888);

        //RequestSpecification requestSpecification = new RequestSpecBuilder().addHeader("Content-Type","application/json").addHeader("Accept", "application/json").build();

        //RestAssured.requestSpecification = requestSpecification;

        //ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).build();

        //RestAssured.responseSpecification = responseSpecification;

        /*RequestSpecification videogame_request = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(8080)
                .setBasePath("/app/")
                .addHeader("Content-Type", "application/xml")
                .addHeader("Accept", "application/xml").build();


        RestAssured.requestSpecification = videogame_request;

        ResponseSpecification videogame_response = new ResponseSpecBuilder().expectStatusCode(200).build();

        RestAssured.responseSpecification = videogame_response;*/


        RequestSpecification requestDarksky = new RequestSpecBuilder()
                .setBaseUri("https://api.darksky.net")
                .setBasePath("/forecast/23cb2fc34adc794c581f7a752eb1cd2b").build();

        RestAssured.requestSpecification = requestDarksky;//This line is called for all tests if each test has different request
        //spec then has to be removed else leave.


        ResponseSpecification responseDarksky = new ResponseSpecBuilder()
                .expectStatusCode(200)
                //.expectResponseTime(lessThan(4500L))
                .build();

        RestAssured.responseSpecification = responseDarksky;























    }



}
