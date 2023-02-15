package api_testing;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C06_Post_JsonPathBodyTest {


    @Test
    public void post01(){
        String url = "https://restful-booker.herokuapp.com/booking";


        JSONObject innerBody = new JSONObject();
        innerBody.put("checkin", "2021-06-01");
        innerBody.put("checkout", "2021-06-10");


        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname", "Ali");
        reqBody.put("lastname", "Bak");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", innerBody);
        reqBody.put("additionalneeds", "wi-fi");

        // 2- Expected data hazirla

        // 3 - Response'i kaydet

        Response response = given().
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody.toString()).
                                    post(url);

        response.prettyPrint();
        // 4 - Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).body("booking.firstname", equalTo("Ali"),
                        "booking.lastname",equalTo("Bak"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2021-06-01"),
                        "booking.bookingdates.checkout",equalTo("2021-06-10"),
                        "booking.additionalneeds",equalTo("wi-fi"));

    }

}
