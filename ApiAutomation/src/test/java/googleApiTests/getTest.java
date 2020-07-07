package googleApiTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getTest {

    @Test
    public void googleApiGetTest(){
        RestAssured.baseURI= "https://maps.googleapis.com";
         Response response =given().queryParam("key", "AIzaSyAyrRB8Do-Niz0LR1v7NqdkUfsj5X44p20")
                .queryParam("location", "-33.8670522,151.1957362")
                .queryParam("radius", "500")
                .when().get("/maps/api/place/nearbysearch/json")
                        .then().extract().response();
        JsonPath responseBody = response.getBody().jsonPath();
        String name = responseBody.get("results[0].name");
        Assert.assertEquals(name, "Sydney");
         System.out.println("Response" + name);
//                 .assertThat()
//                .statusCode(200)
//                .and().contentType(ContentType.JSON)
//                .and().body("results[0].name",equalTo("Sydney"));
    }

}


