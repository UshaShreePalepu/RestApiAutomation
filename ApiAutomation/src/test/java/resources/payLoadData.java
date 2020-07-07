package resources;

public class payLoadData {
    public static String postPalceData() {
         String postBody = "{" +
                "\"location\":{" +
                "\"lat\" : -38.383494," +
                "\"lng\" : 33.427362" +
                "}," +
                "\"accuracy\":50," +
                "\"name\":\"Frontline house\"," +
                "\"phone_number\":\"(+91) 983 893 3937\"," +
                "\"address\" : \"29, side layout, cohen 09\"," +
                "\"types\": [\"shoe park\",\"shop\"]," +
                "\"website\" : \"http://google.com\"," +
                "\"language\" : \"French-IN\"" +
                "}";
         return postBody;
    }

    public static String deletePlaceData(String placeId) {
        String deleteBody = "{"+
                "\"place_id\":\""+placeId+"\""+
                "}";
        return deleteBody;
    }
}
