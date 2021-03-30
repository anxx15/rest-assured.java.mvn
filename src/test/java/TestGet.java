import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestGet<endPoint> {
 public static String endPoint = "https://reqres.in/api/users?page=2";
    @Test
    public void test01(){
        Response response = RestAssured.get(endPoint);
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.getHeaders());
    }

    @Test
    public void test02(){
        given().get(endPoint).then().statusCode(200).body("data.id[1]", equalTo(8));
    }
}
