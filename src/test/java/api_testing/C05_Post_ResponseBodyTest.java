package api_testing;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C05_Post_ResponseBodyTest {

    @Test
    public void post01(){
        // 1. url- body hazirlama

        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();

        reqBody.put("title", "API");
        reqBody.put("body", "Rest API");
        reqBody.put("userId", 10);

        System.out.println(reqBody);

        // 2. expected data hazirla

        // 3. Response'ı kaydet

        Response response = given().
                            contentType(ContentType.JSON).
                            when().
                            body(reqBody.toString()).
                            post(url);

        response.prettyPrint();


        // 4. assertion

        response.then().assertThat().statusCode(201).contentType("application/json").
                body("title", Matchers.equalTo("API")).
                body("userId", Matchers.lessThan(100)).
                body("body", Matchers.containsString("API"));


    }

    @Test
    public void post02(){
        // 1. url- body hazirlama

        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();

        reqBody.put("title", "API");
        reqBody.put("body", "Rest API");
        reqBody.put("userId", 10);


        // 2. expected data hazirla

        // 3. Response'ı kaydet

        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                post(url);



        // 4. assertion

        response.then().assertThat().statusCode(201).contentType("application/json").
                body("title", equalTo("API"),
                        "userId",lessThan(100),
                        "body", containsString("API"));


    }

}
