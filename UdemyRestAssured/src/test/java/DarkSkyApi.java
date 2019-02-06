import Config.TestConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.lessThan;


public class DarkSkyApi extends TestConfig {
    @Test
    public void FirstTest() {
        given().
                //log().all().

                        when().
                get("/37.8267,-122.4233").
                then().
                log().all();
    }

    @Test
    public void VerifyTest() {
        given().

                log().all().
                when().
                get("/37.8267,-122.4233").
                then().
                log().all().
                body("currently.summary", equalTo("Clear"));

    }


    @Test
    public void GetResponseBody() {
        String ResponseText = given().when().get("/37.8267,-122.4233").asString();
        System.out.println(ResponseText);
    }

    @Test
    public void GetResponseBody_DoCheckFirst() {
        Response response =
                given().
                        when().
                        get("/37.8267,-122.4233").
                        then().
                        contentType(ContentType.JSON).
                        extract().response();

        String jsonResponseAsString = response.asString();
        System.out.println(jsonResponseAsString);
    }

    @Test
    public void extractHeaders() {
        Response response = given().when().get("/37.8267,-122.4233").then().
                contentType(ContentType.JSON).
                extract().response();

        Headers headers = response.getHeaders();

        String contentType = response.getHeader("Content-Type");

        System.out.println(contentType);
    }


    @Test
    public void extractSummary() {
        String extractSummaryStatus = given().when().get("/37.8267,-122.4233").jsonPath().getString("currently.summary");

        System.out.println(extractSummaryStatus);
    }

    @Test
    public void ExtractHourlySummary() {
        Response response = given().when().get("/37.8267,-122.4233").then().contentType(ContentType.JSON).extract().response();

        List<String> summaries = response.path("hourly.data.summary");

        for (String summary : summaries) {
            System.out.println(summary);
        }

    }

    @Test
    public void GetResponseTime() {
        given().

        when().
                get("/37.8267,-122.4233").
        then().
                time(lessThan(4000L));
    }


}
