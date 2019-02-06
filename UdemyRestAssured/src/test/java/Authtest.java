import Config.TestConfig;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class Authtest extends TestConfig {
    @BeforeClass
    public static void basicAuth(){
        RestAssured.proxy("localhost", 8888);
    }

    @Test
    public void basicPreemptiveAuthTest(){
        given().
                auth().preemptive().basic("username","password").
        when().
                get("http://localhost:8080/someEndpoint");
    }

    @Test
    public void basichallengedAuthTest(){
        given().
                auth().basic("username","password").
        when().
                get("http://localhost:8080/someEndpoint");
    }

    /*  <dependency>
            <groupId>com.github.scribejava</groupId>
            <artifactId>scribejava-apis</artifactId>
            <version>2.5.3</version>
            <scope>test</scope>
        </dependency>
        This depedancy is required for the OAuth tests*/

    @Test
    public void OAuth1(){
        given().
                auth().oauth("consumerKey", "consumerSecret", "consumerAccessToken", "SecretToken").
        when().
                get("http://localhost:8080/someEndpoint");

    }

    @Test
    public void OAuth2(){
        given().
                auth().oauth2("accessToken").
        when().get("http://localhost:8080/someEndpoint");
    }

    @Test
    public void relaxedHTTPSTest(){
        given().
                relaxedHTTPSValidation().
        when().
                get("http://localhost:8080/someEndpoint");
    }

    @Test
    public void KeyStoreTest(){
        given().
                keyStore("/pathtJKS", "Password").
        when().
                get("http://localhost:8080/someEndpoint");
    }








}
