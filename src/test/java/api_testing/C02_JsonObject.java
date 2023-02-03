package api_testing;

import org.json.JSONObject;
import org.junit.Test;

public class C02_JsonObject {


    @Test
    public void JsonObject01(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","R&D");
        jsonObject.put("body","Poyraz");
        jsonObject.put("userId","01");

        System.out.println(jsonObject);
    }

    @Test
    public void JsonObject02(){
        JSONObject innerJsonObject = new JSONObject();

        innerJsonObject.put("checkin","2018-01-01");
        innerJsonObject.put("checkout","2019-01-01");

        JSONObject body = new JSONObject();
        body.put("firstname", "Jim");
        body.put("additionalneeds", "Breakfast");
        body.put("bookingdates", innerJsonObject);
        body.put("totalprice", 111);
        body.put("deposit", true);
        body.put("lastname", "Brown");


        System.out.println(body);
    }
}
