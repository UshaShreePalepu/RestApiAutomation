package libraryApiTests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class addBookPostTest {
    @Test
    public void addBookTest() {
        Response postResponse = given().baseUri("http://216.10.245.166/Library")
                .header("Content-Type", "application/json")
                .body("{" +
                        "\"name\":\"Learn Appium Automation with Java\"," +
                        "\"isbn\":\"asdf\"," +
                        "\"aisle\":\"111\"," +
                        "\"author\":\"John foe\"" +
                        "}")
                .when().post("/Library/Addbook.php")
                .then().extract().response();

        JsonPath jsonResponse = postResponse.getBody().jsonPath();
        String stringResponse = jsonResponse.getString("ID");
        Assert.assertEquals(stringResponse, "asdf111");

    }
}
