package api_testing;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_Get_ResponseBodyTest {

    @Test
    public void get01(){

        // 1- URL hazırla

        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2- soruda isteniyorsa expected data hazırla

        // 3- Response'ı kaydet

        Response response = given().when().get(url);

        response.prettyPrint();

        // 4- Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("userId", Matchers.equalTo(5)).
                body("title",Matchers.equalTo("optio dolor molestias sit"));
    }
}
