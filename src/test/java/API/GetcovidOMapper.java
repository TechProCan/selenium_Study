package API;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class GetcovidOMapper {
    @Test
    public void getRequestTest() throws IOException {
        // Set the base URI for the API
        RestAssured.baseURI = "https://api.covid19api.com";

        // Send the GET request and retrieve the response
        Response response = RestAssured.given().get("/world/total");

        // Assert that the status code is 200
        int statusCode = response.getStatusCode();
        Assert.assertEquals( 200, 200);

        // Convert the response body to a JSON object using ObjectMapper
        String responseBody = response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> responseJson = objectMapper.readValue(responseBody, Map.class);
        System.out.println("rB : "+responseBody);
        System.out.println("rJ : "+responseJson);
        response.prettyPrint();

        // Assert that the response body matches the expected format
        Map<String, Object> expectedResponseJson = Map.of(
                "TotalConfirmed", 674300771,
                "TotalDeaths", 6793224,
                "TotalRecovered", 0
        );
        Assert.assertEquals("Response body should match the expected format", responseJson, expectedResponseJson);
    }
}
