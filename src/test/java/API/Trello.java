package API;


import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Trello {

    private final static String baseUrl = "https://api.trello.com/";
    private final static String yourkey = "57d9b658cbed958b7146ccb29a08a0e7";
    private final static String yourtoken = "5d2a4ca448bc14f34cb6130e3c353af2d4e3331debaf83651a8652f6064f666f";
    private final static String Boardname = "test";
    private final static String idList="";
    private final static String cardname="test" ;
    public String boardID="";
    @Test
    public void  CreateBoard1() {

        RestAssured.baseURI = "https://api.trello.com";

        given().log().all().queryParam("key", yourkey)
                .header("Content-type", "application/json")
                .queryParam("token", yourtoken)
                .queryParam("name", Boardname)
                .when().post("/1/boards/")

                .then().log().all().assertThat().statusCode(200);

    }
    @Test
    public void  CreateCard() {

        RestAssured.baseURI = "https://api.trello.com";
        increment(this.boardID);
        given().log().all().queryParam("key", yourkey)
                .header("Content-type", "application/json")
                .queryParam("token", yourtoken)
                .queryParam("idList", "5abbe4b7ddc1b351ef961414")
                .queryParam("name", cardname)
                .when().post("1/cards")
                .then().log().all().assertThat().statusCode(200);

    }
    public String increment(String number) {
        char[] cars = number.toCharArray();
        for (int i = cars.length - 1; i >= 0; i--) {
            if (cars[i] == 'z') {
                cars[i] = 'a';
            } else if (cars[i] == '9') {
                cars[i] = '0';
            } else {
                cars[i]++;
                break;
            }
        }
        return String.valueOf(cars);
    }

}
