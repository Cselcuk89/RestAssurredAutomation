package APITestingFramework.testcases;

import APITestingFramework.setUp.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CreateCustomerTest extends BaseTest {
    @Test(dataProvider = "getData")
    public void validateCreateCustomerAPIWithValidSecretKey(String name,String email,String description){

        Response response = given().auth()
                .basic(config.getProperty("validSecretKey"), "")
                .queryParam("email",email)
                .queryParam( "description", description)
                .post(config.getProperty("customerAPIEndPoint"));
        response.prettyPrint();
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test
    public void validateCreateCustomerAPIWithInValidSecretKey(){

        Response response = given().auth()
                .basic(config.getProperty("inValidSecretKey"), "")
                .queryParam("email","bac@gmail.com")
                .queryParam( "description", "a special customer has been added!")
                .post("/customers");
        response.prettyPrint();
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @DataProvider
    public Object[][] getData(){
        String sheetName = "validateCreateCustomerApi";
        int rows = excelReader.getRowCount(sheetName);
        int colums = excelReader.getColumnCount(sheetName);
        Object[][] data = new Object[rows-1][colums];
        System.out.println("excelReader.getCellData(sheetName,0,1) = " + excelReader.getCellData(sheetName, 0, 1));
        for (int rowNum = 2;rowNum<=rows;rowNum++){
            for (int colNum = 0;colNum<colums;colNum++){
                data[rowNum-2][colNum] = excelReader.getCellData(sheetName,colNum,rowNum);
            }
        }
        return data;

    }
}
