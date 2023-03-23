package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class GetGoRest {

    @Test
    public void verifyPostDetails() {

        // Set the base URI for the API
        RestAssured.baseURI = "https://gorest.co.in/public/v2";

        // Send a GET request and retrieve the response
        Response response = RestAssured.given().get("/posts/174");

        response.prettyPrint();
        // Assert that the status code is 200
        Assert.assertEquals(response.getStatusCode(), 200);

        // Verify the response body
        String expectedTitle = "Tertius valeo sint est vesica doloribus rerum casus cetera nisi sapiente vigor pecus voluptas asperiores et sto vapulus.";
        String expectedBody = "Et demens tergo. Cohors copia adeptio. Cotidie speciosus coaegresco. Concido crastinus degero. Tristis fugit supellex. Sustineo cogo odit. Pel patria crur. Amplus comitatus modi. Ater omnis solutio. Voluptatem acies unde. Taceo delinquo ustilo. Alo possimus vaco. Sit cognomen thesaurus. Appositus vel amicitia. Cetera textus defungo.";
        Assert.assertEquals(response.getBody().jsonPath().get("title"), expectedTitle);
        Assert.assertEquals(response.getBody().jsonPath().get("body"), expectedBody);
    }
}
