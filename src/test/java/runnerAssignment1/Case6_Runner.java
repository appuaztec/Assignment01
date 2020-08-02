package runnerAssignment1;

import baseInit.BaseSession;
import baseInit.TestNgHooks;
import common.PropertyReader;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DatePickerPage;
import pageObjects.SelectablePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Case6_Runner {

    TestNgHooks testNgHooks = null;
    SelectablePage selectablePage = null;
    BaseSession session = null;
    PropertyReader propertyReader =
            new PropertyReader(
                    System.getProperty("user.dir") +
                            "\\src\\main\\resources\\properties\\Assignment1.properties");


    @BeforeMethod
    public void before() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("reportFileName", "Selectable");
        params.put("reportTestName", "Selectable");
        params.put("reportTestDesc", "");
        params.put("browser", "chrome");
        params.put("url", propertyReader.readProperty("case6_url"));
        this.testNgHooks = new TestNgHooks();
        testNgHooks.before(params);
        this.session = testNgHooks.session;
        this.selectablePage = testNgHooks.selectablePage;

    }

    @Test(enabled = true)
    public void defaultSelect() throws Exception {
        String s = "Sakinalium - Extent Reports";
        selectablePage.defaultList(s);
    }

    @Test(enabled = true)
    public void syncSelect() throws Exception {

        List<String> listData = new ArrayList<>();
        listData.add("Sakinalium - Extent Reports");
        listData.add("Sakinalium - Functional Testing");
        selectablePage.serialList(listData);

    }

    @AfterMethod
    public void after(ITestResult result) {
        testNgHooks.after(result);
    }
}



