import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TestRest {
    private String baseURl = RestAssured.baseURI="http://dummy.restapiexample.com/";

    private String employeesEndpoint ="/api/v1/employees";
    private String firstEmployeeEndPoint="api/v1/employee/1";
    private String creatingNewRecordEndPoint="api/v1/create";
    private String updateRecordEndPoint="api/v1/update/21";
    private String deleteRecordEndPoint="api/v1/delete/2";

    @Test
    public void getAllEmployeeData(){
        Response response =RestAssured.given().get(employeesEndpoint).then().assertThat().statusCode(200).extract().response();
     System.out.println(response.asString());
       System.out.println(response.getStatusCode());
    }


    @Test
    public void  getStringEmployeeData(){
        Response response = RestAssured.given().get(firstEmployeeEndPoint).then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
    }

    @Test
    public void createNewRecord(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name","ilyan");
        jsonObject.put("Age","21");
        jsonObject.put("Salary","11000");
        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonObject).when().post(creatingNewRecordEndPoint).then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());

    }

    @Test
    public void updateRecord(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","med");
        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonObject).when().post(creatingNewRecordEndPoint).then().assertThat().statusCode(200).extract().response();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());



    }

    @Test
    public void deleteRecord(){
        Response response =RestAssured.given().when().delete(deleteRecordEndPoint).then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }
}
