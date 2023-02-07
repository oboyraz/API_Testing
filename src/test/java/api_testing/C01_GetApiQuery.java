package api_testing;

import io.restassured.response.Response;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetApiQuery {

    @Test
    public void get01(){

        String url = "https://restful-booker.herokuapp.com/booking/2505"; // id based book request

        Response response = given().when().get(url);

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","Cowboy").
                statusLine("HTTP/1.1 200 OK");
    }
}
