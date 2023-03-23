package API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class GetGoRestOMapper {
    @Test
    public void getRequestTest() throws JsonProcessingException {
        // Set the base URI for the API
        RestAssured.baseURI = "https://gorest.co.in/public/v2";

        // Send the GET request and retrieve the response
        Response response = RestAssured.given()
                .get("/posts/174");

        // Assert that the status code is 200
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        // Convert the response body to a Java object using ObjectMapper
        String responseBody=response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> responseJson = objectMapper.readValue(responseBody, Map.class);
        System.out.println("rB : "+responseBody);
        System.out.println("rJ : "+responseJson);
        response.prettyPrint();

        // Assert that the converted object matches the expected values
        Map<String, Object> expectedResponseJson = Map.of(
                "id", 174,
                "user_id", 612,
                "title", "Tertius valeo sint est vesica doloribus rerum casus cetera nisi sapiente vigor pecus voluptas asperiores et sto vapulus.",
                "body", "Et demens tergo. Cohors copia adeptio. Cotidie speciosus coaegresco. Concido crastinus degero. Tristis fugit supellex. Sustineo cogo odit. Pel patria crur. Amplus comitatus modi. Ater omnis solutio. Voluptatem acies unde. Taceo delinquo ustilo. Alo possimus vaco. Sit cognomen thesaurus. Appositus vel amicitia. Cetera textus defungo."
        );
        Assert.assertEquals("Response body should match the expected format", responseJson, expectedResponseJson);
    }
}
