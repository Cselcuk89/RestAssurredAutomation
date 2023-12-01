package APITestingFramework.setUp;

import APITestingFramework.utils.ExcelReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class BaseTest {
    public Properties config = new Properties();
    private FileInputStream fileInputStream;
    public static ExcelReader excelReader = new ExcelReader("C:\\Users\\P3153404\\RestAssurredAutomation\\ApiFrameworkDevelopment\\src\\test\\resources\\excel\\testdatas.xlsx");

    @BeforeSuite
    public void setUp(){
        try {
            fileInputStream = new FileInputStream("C:\\Users\\P3153404\\RestAssurredAutomation\\ApiFrameworkDevelopment.\\src\\test\\resources\\properties\\config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            config.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseURI = config.getProperty("baseURI");
        basePath = config.getProperty("basePath");

    }
    @AfterSuite
    public void tearDown(){

    }
}
