package pageObjects;

import baseInit.TestNgHooks;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import common.ExtentReporterInit;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class RestAPI {

    ExtentReports extentReports = null;

    public RestAPI(ExtentReports extent) {
        this.extentReports = extent;
    }

    public void basicAuth(String uName, String pwd) {
        String url = "https://postman-echo.com/basic-auth";
        ExtentTest test = extentReports.createTest("PostMan Basic Auth", "Perform Basic Auth for Postman");
        Response s = given().auth().basic(uName, pwd)
                .when().get(url);
        int statCode = s.getStatusCode();
        String statResp = s.getBody().prettyPrint();

        test.pass("URL used for basic Auth : " + url);
        if (statCode != 200) {
            test.fail("Status Code not 200, Found : " + statCode + "\n" + s.getStatusLine());
        } else{
            test.pass("Status Code : " + statCode + "\n" + s.getStatusLine()+ " as Expected");
            test.pass(MarkupHelper.createCodeBlock(statResp, CodeLanguage.JSON));
        }


    }

    public void getRest() {

        String url = "https://postman-echo.com/get?foo1=bar1&foo2=bar2";
        ExtentTest test = extentReports.createTest("PostMan Get Resp", "Perform postman get Request");
        Response s =
                RestAssured.get(url);

        int statCode = s.getStatusCode();
        String statResp = s.getBody().prettyPrint();
        test.pass("URL used for Get : " + url);
        if (statCode != 200) {
            test.fail("Status Code not 200, Found : " + statCode+ "\n" + s.getStatusLine());
        } else {
            test.pass("Status Code : " + statCode + "\n" + s.getStatusLine() + " as Expected");
            test.pass(MarkupHelper.createCodeBlock(statResp, CodeLanguage.JSON));
        }

    }


    public void postRest() {
        String url = "https://postman-echo.com/post";
        ExtentTest test = extentReports.createTest("PostMan Post Req", "Perform postman Post Request");
        Response s = given().body("").contentType(ContentType.XML).
                when().post(url);
        int statCode = s.getStatusCode();
        String statResp = s.getBody().prettyPrint();
        test.pass("URL used for post : " + url);
        if (statCode != 200) {
            test.fail("Status Code not 200, Found : " + statCode+ "\n" + s.getStatusLine());
        } else {
            test.pass("Status Code : " + statCode + "\n" + s.getStatusLine() + " as Expected");
            test.pass(MarkupHelper.createCodeBlock(statResp, CodeLanguage.JSON));
        }

    }

    public void putRest() {
        String url = "https://postman-echo.com/put";
        ExtentTest test = extentReports.createTest("PostMan Put Req", "Perform postman put Request");
        Response s = given().body("").contentType(ContentType.XML).
                when().put(url);

        int statCode = s.getStatusCode();
        String statResp = s.getBody().prettyPrint();
        test.pass("URL used for Put : " + url);
        if (statCode != 200) {
            test.fail("Status Code not 200, Found : " + statCode + "\n" + s.getStatusLine());
        } else {
            test.pass("Status Code : " + statCode + "\n" + s.getStatusLine() + " as Expected");
            test.pass(MarkupHelper.createCodeBlock(statResp, CodeLanguage.JSON));
        }


    }

    public void delRest() {
        String url = "https://postman-echo.com/delete";
        ExtentTest test = extentReports.createTest("PostMan Delete Req", "Perform postman Delete Request");
        Response s = given().body("").contentType(ContentType.XML).
                when().delete(url);

        int statCode = s.getStatusCode();
        String statResp = s.getBody().prettyPrint();
        test.pass("URL used for Delete : " + url);
        if (statCode != 200) {
            test.fail("Status Code not 200, Found : " + statCode + "\n" + s.getStatusLine());
        } else {
            test.pass("Status Code : " + statCode + "\n" + s.getStatusLine() + " as Expected");
            test.pass(MarkupHelper.createCodeBlock(statResp, CodeLanguage.JSON));
        }


    }
}
