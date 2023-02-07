package api_testing;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_PutResponseInfoAssertion {

    @Test
    public void put01(){
        String url = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title","R&D");
        reqBody.put("body","Software");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        System.out.println(reqBody);

        // save response
        Response response = given().
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody.toString()).
                            put(url);

        response.prettyPrint();

        // Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").header("Server","cloudflare").statusLine("HTTP/1.1 200 OK");
    }
}
