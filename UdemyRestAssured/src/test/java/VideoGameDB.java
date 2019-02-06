import Config.EndPoint;
import Config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class VideoGameDB extends TestConfig {
    @Test
    public void postGame() {
        String VideoGameJson = "{\n" +
                "  \"id\": 14,\n" +
                "  \"name\": \"VideoGame1\",\n" +
                "  \"releaseDate\": \"2018-12-21T16:29:45.912Z\",\n" +
                "  \"reviewScore\": 4,\n" +
                "  \"category\": \"Action\",\n" +
                "  \"rating\": \"Pg13\"\n" +
                "}";

        given().
                body(VideoGameJson).
                when().
                post(EndPoint.Get_VideoGames).
                then();

    }

    @Test
    public void postGameXml() {
        String VideoGameXml = "<videoGame category=\"Shooter\" rating=\"Universal\">\n" +
                "    <id>12</id>\n" +
                "    <name>Shooter </name>\n" +
                "    <releaseDate>2005-10-01T00:00:00+01:00</releaseDate>\n" +
                "    <reviewScore>75</reviewScore>\n" +
                "  </videoGame>";
        given().
                body(VideoGameXml).
        when().
                post(EndPoint.Get_VideoGames).
        then();

    }



    @Test
    public void updateGame() {
        String gameToBeUpdated = "<videoGame category=\"Shooter\" rating=\"Universal\">\n" +
                "    <id>12</id>\n" +
                "    <name>ShooterUpdated </name>\n" +
                "    <releaseDate>2005-10-01T00:00:00+01:00</releaseDate>\n" +
                "    <reviewScore>50</reviewScore>\n" +
                "  </videoGame>";
        given().
                body(gameToBeUpdated).
        when().
                put("videogames/12").
        then();

    }

    @Test
    public void deleteGame() {
        given().
                when().
                delete("videogames/12").
                then();
    }

    @Test
    public void getSingleGame() {
        given().
                pathParam("videoGameId", 5).
                when().
                get(EndPoint.Get_SingleVideoGame);
    }

    @Test
    public void SerialisingJson() {
        VideoGame game = new VideoGame("15", "Shooter", "2018", "Mature", "96", "Halo 5");

        given().
                body(game).
        when().
                post(EndPoint.Get_VideoGames).
        then();

    }

    @Test
    public void ValidatingXMLSchema() {
        given().
                pathParam("videoGameId", 2).
        when().
                get(EndPoint.Get_SingleVideoGame).
        then().body(matchesXsdInClasspath("VideoGame.xsd"));
    }


    @Test
    public void ValidatingJSONSchema() {
        given().
                pathParam("videoGameId", 1).
                when().
                get(EndPoint.Get_SingleVideoGame).
                then().
                body(matchesJsonSchemaInClasspath("VideoGamejsonSchema.json"));
    }




}
