package API;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
public class NewsAPI {
    @Test
    public void testArticlesWithGoogleChrome() {
        Response response = RestAssured.get("https://newsapi.org/v2/everything?q=keyword&apiKey=4ce55033d01245a7915963132a480788"); // API'nin gerçek URL'sini buraya ekleyin
        // JSON yanıtı işle
        List<Map<String, String>> articles = response.jsonPath().getList("articles");

        for (Map<String, String> article : articles) {
            String title = article.get("title");
            String urlToImage = article.get("urlToImage");
            String content = article.get("content");

            if (content.contains("ChatGPT")) {
                System.out.println("title : " + title);
                System.out.println("image : " + urlToImage);
            }
        }
    }
}
