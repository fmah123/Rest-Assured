import Config.EndPoint;
import Config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class MyFirstTest extends TestConfig
{


    @Test
    public void myFirstTest(){
        given().
                log().all().
                // Line 15: This logs all info on the request header
        when().
                get("videogames/1")
                // get method calling endpoint.
        .then()
                .log().all();
                // Line 20: This logs all info on the response header.
    }

    @Test
    public void getAllGames(){
        given().
                log().all().
        when().
                get(EndPoint.Get_VideoGames).
        then().
                log().all();
    }







}
