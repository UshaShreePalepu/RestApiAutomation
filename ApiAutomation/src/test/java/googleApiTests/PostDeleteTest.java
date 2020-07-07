package googleApiTests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import resources.payLoadData;
import resources.pathData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class PostDeleteTest {
    Properties prop = new Properties();

    @BeforeTest
    public void getData() throws IOException {
        FileInputStream fis = new FileInputStream("src\\properties\\environment.properties");
        prop.load(fis);
    }

    @Test
    public void postDeleteTest() {

        Response postResponse = given().baseUri(prop.getProperty("baseUri"))
                .queryParam("key", prop.getProperty("key"))
                .body(payLoadData.postPalceData())
                .when().post(pathData.postPath())
                .then().extract().response();

        JsonPath responseBody = postResponse.getBody().jsonPath();
        String placeId = responseBody.get("place_id");
        System.out.println("PlaceId" + placeId);

        Response deleteResponse = given().baseUri(prop.getProperty("baseUri"))
                .queryParam("key", prop.getProperty("key"))
                .body(payLoadData.deletePlaceData(placeId))
                .when().post(pathData.deletePath())
                .then().extract().response();
        JsonPath deleteResponseBody = deleteResponse.getBody().jsonPath();
        String deleteStatus = deleteResponseBody.getString("status");
        Assert.assertEquals(deleteStatus, "OK");
    }
}
