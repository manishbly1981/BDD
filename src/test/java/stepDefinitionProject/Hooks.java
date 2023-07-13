package stepDefinitionProject;

import cucumber.api.DataTable;
import dataManager.Constant;
import gherkin.formatter.model.DataTableRow;
import gherkin.formatter.model.Feature;
import util.CompactUtil;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.PropertyUtil;
import util.ReportUtil;

public class Hooks {
    WebDriver driver;
    util.ReportUtil reportUtil;
    util.DriverUtil driverUtil;
    private DataTable data;

    public Hooks(){
        reportUtil=new util.ReportUtil();
        driverUtil= new util.DriverUtil();
    }

    @Before
    public void setupPrerequisite(Scenario scenario){


        String scenarioName=scenario.getName();
        scenarioName= new CompactUtil().removeSpecialCharacterInFileName(scenarioName);
        reportUtil.initReport();
        reportUtil.initTest(scenarioName);
        reportUtil.getStatus();
        driverUtil.openBrowser();
    }
    @After
    public void setupPostrequisite(Scenario scenario){
//        driverUtil.closeBrowser(scenario);
        if (new PropertyUtil().getJiraUpdate().equalsIgnoreCase("yes")) {
            new util.jira.ZAPI_API().updateJiraStatusWithAttachment(Constant.getTestCaseId(), reportUtil.getStatus(), new util.ZipUtil().createZip(reportUtil.getReportFolder()));
        }
    }
}