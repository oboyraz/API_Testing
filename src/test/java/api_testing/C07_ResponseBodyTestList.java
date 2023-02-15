package api_testing;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C07_ResponseBodyTestList {

    @Test
    public void get01(){
        // 1 Url

        String url = "http://dummy.restapiexample.com/api/v1/employees";

        // 2 expected data

        // 3 - response 'ı kaydet

        Response response = given().when().get(url);

        response.prettyPrint();

        // 4 Assertion


        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("data.id", hasSize(24),
                        "data.employee_name", hasItem("Ashton Cox"),
                        "data.employee_age", hasItems(61,40,30));



    }
}
