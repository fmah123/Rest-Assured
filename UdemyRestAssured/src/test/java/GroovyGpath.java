import Config.TestConfig;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.get;

public class GroovyGpath extends TestConfig {
    @Test
    public void ExtractMapOfElement(){
        Response response = get("/37.8267,-122.4233");

        Map<String,?> allsummarydata = response.path("hourly.data.find{it.temperature == 'Clear'}");
        System.out.println(allsummarydata);
    }

    @Test
    public void ExtractApparentTemperature(){
        Response response = get("/37.8267,-122.4233");
        String ApparentTemp = response.path("hourly.data.find{it.summary == \"Clear\"}.icon");
        System.out.println(ApparentTemp);
    }

    @Test
    public void FindMaxTemperature(){
        Response response = get("/37.8267,-122.4233");
        String Summary = response.path("hourly.data.max{ it.temperature }.summary");
        System.out.println(Summary);

    }

    @Test
    public void ExtractMapOfObjectWithFind(){

        Response response = get("/37.8267,-122.4233");
        Map<String, ?> WeatherData = response.path(" hourly.data.findAll{ it.icon == \"partly-cloudy-night\" }.find{ it.summary == \"Mostly Cloudy\" } ");
        System.out.println(WeatherData);
    }









}
