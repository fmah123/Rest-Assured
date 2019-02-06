import Config.EndPoint;
import Config.TestConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.get;

public class GPathXMLTests extends TestConfig {
    @Test
    public void getFirstGameInList(){
        Response response = get(EndPoint.Get_VideoGames);

        String name = response.path("videoGames.videoGame.name[0]");

        System.out.println(name);
    }

    @Test
    public void getAttributeName(){
        Response response = get(EndPoint.Get_VideoGames);

        String category = response.path("vidoeGames.videoGame[0].@category");

        System.out.println(category);
    }

    @Test
    public void getListOfXMLNodes(){
        String responseAsString = get(EndPoint.Get_VideoGames).asString();

        List<Node> allResults = XmlPath.from(responseAsString).get("videoGames.videoGame.findAll { element -> return element }");

        System.out.println(allResults.get(2).get("name").toString());
    }

    @Test
    public void getListOfNodesByFindAllOnAttribute(){
        String responseAsString = get( EndPoint.Get_VideoGames).asString();

        List<Node> allDrivingGames = XmlPath.from(responseAsString).get("videoGames.videoGame.findAll{ videoGame -> def category = videoGame.@category; category = 'Driving' }");

        System.out.println(allDrivingGames.get(0).get("name").toString());
    }

    @Test
    public void getSingleNode(){
        String responseAsString = get(EndPoint.Get_VideoGames).asString();

        Node videoGame = XmlPath.from(responseAsString).get("videoGames.videoGame.find { videoGame -> def name = videoGame.name; name == 'Tetris'}");

        String videogameName = videoGame.get("name").toString();

        System.out.println(videogameName);
        System.out.println();
        System.out.println(videoGame);
        System.out.println();
        System.out.println(responseAsString);
    }

    @Test
    public void getSingleElementDepthFirst(){
        String responseAsString = get(EndPoint.Get_VideoGames).asString();
        //line 66: 'get' response on endpoint this is converted to string and stored in responseAsString.
        int reviewScore = XmlPath.from(responseAsString).getInt("**.find { it.name == 'Gran Turismo 3'}.reviewScore");
        //line 68: XmlPath.from called on responseAsString this acquires all data from database, .getInt called with specific Gpath statement to get reviewscore data from a single XML with element name equal to 'Gran Turismo 3'.
        System.out.println(reviewScore);
    }

    @Test
    public void getAllNodesBasedOnACondition(){
        String responseAsString = get(EndPoint.Get_VideoGames).asString();
        //line 75: calling endpoint via get response and storing as string in responseAsString.
        int reviewScore = 90;
        List<Node> allVideoGamesOverCerainScore = XmlPath.from(responseAsString).get("videoGames.videoGame.findAll { it.reviewScore.toFloat() >= " + reviewScore  + "}");
        //line 78: doing call
        System.out.println(allVideoGamesOverCerainScore);
    }




















}
