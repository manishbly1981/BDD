package stepDefinitionProject;

import static org.testng.AssertJUnit.assertEquals;

import customerPortalPages.Login;
import util.JSWaiter;
import org.openqa.selenium.By;
import dataManager.*;
//import UserPortalPages.Login;
import util.DriverUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.When;
import dataManager.YourBusiness;
import util.ReportUtil;

import java.util.List;

public class StepDefs{
    public WebDriver driver;
    public StepDefs()
    {
        driver=new DriverUtil().getDriver();
    }

    @Given("^Login into '(.*)' application for the (.*)$")
    public void Login_into_application(String portalType, String testCaseId) throws Throwable
    {
        Constant.setTestCaseId(testCaseId);
        if (portalType.equalsIgnoreCase("ncino")) {
            new DriverUtil().navigateURL("ncino");
            new nCinoPages.Login().defaultLogin();
        }else{
            new DriverUtil().navigateURL("cp");
            new customerPortalPages.Login().defaultLogin();

            new customerPortalPages.Home().verifyWelcomeScreenMsg();
        }
    }

    @Given("^Login into '(.*)' application with (.*) and (.*)$")
    public void login_into_application_with_UserName_and_Password(String portalType, String userName,String password) throws Throwable {
        if (portalType.equalsIgnoreCase("ncino")) {
            new DriverUtil().navigateURL("ncino");
            new nCinoPages.Login().specificLogin(userName, password);
        }else{
            new DriverUtil().navigateURL("cp");
            new customerPortalPages.Login().specificLogin(userName, password);
            new customerPortalPages.Home().verifyWelcomeScreenMsg();
        }
    }
    @When("^Navigate to Marketplace$")
    public void navigate_to_Marketplace() throws Throwable {
        new customerPortalPages.Home().navigateMarketPlace();
    }

    @When("^Apply for (.*)$")
    public void apply_for_Mortgage(String mortageType) {
        if(mortageType.trim().equalsIgnoreCase(new util.PropertyUtil().getBusinessText())) {
            new customerPortalPages.MarketPlace().startBusinessCommecialMortageProcess();
        }else if(mortageType.trim().equalsIgnoreCase(new util.PropertyUtil().getIndividualText())) {
            new customerPortalPages.MarketPlace().startIndvSoleTraderCommercialMortageProcess();
        }else{
            new util.ExceptionHandler().customizedException("Need to write the logic for the martage type: "+ mortageType);
        }
    }

    @When("^Signup into Customer Portal$")
    public void Singup(DataTable table){
        new DriverUtil().navigateURL("cp");
        new Login().clickSignUp();
        List<GetYourCommercialLoan> getYourCommercialLoanList= table.asList(GetYourCommercialLoan.class);
        for(GetYourCommercialLoan getYourCommercialLoan: getYourCommercialLoanList) {
            Constant.setTestCaseId(getYourCommercialLoan.getTestCaseId());
            new customerPortalPages.GetYourCommercialLoan().enterGetYourCommercialLoanInfoAndContinue(getYourCommercialLoan);
        }
    }
    @And("^Enter Eligibility Information for (.*)$")
    public void enterEligibility(String loanType, DataTable table){
        List<Eligibility> eligibilityList= table.asList(Eligibility.class);
        for(Eligibility eligibility : eligibilityList) {
            new customerPortalPages.Eligibility().enterEligibilityCriteriaAndContinue(loanType, eligibility);
        }
    }
    @And("^Enter Business Information$")
    public void enterBusinessInformation(DataTable table){
        List<YourBusiness> yourBusinessList= table.asList(YourBusiness.class);
        for(YourBusiness yourBusiness : yourBusinessList){
            new customerPortalPages.YourBusiness().enterYourBusinessAndContinue(yourBusiness);
        }
    }
    @And("^Enter Personal Information for (.*)$")
    public void enterPersonalInformation(String mortageType, DataTable table){
        List<PersonalInfo> personalInfoList= table.asList(PersonalInfo.class);
        for(PersonalInfo personalInfo : personalInfoList){
            new customerPortalPages.PersonalInfo().enterPersonalInfoAndContinue(mortageType, personalInfo);
        }
    }
    @And("^Enter Personal Continued Information for (.*)$")
    public void enterPersonalContinuedInformation(String mortageType, DataTable table){
        List<PersonalContinued> personalContinuedList= table.asList(PersonalContinued.class);
        for (PersonalContinued personalContinued : personalContinuedList){
            new customerPortalPages.PersonalContinued().enterPersonalContinuedAndContinue(mortageType, personalContinued);
        }
    }
    @And ("^Enter Security Information$")
    public void enterSecurityInformation(DataTable table){
        List<Security> securityList = table.asList(Security.class);
        for(Security security : securityList){
            new customerPortalPages.Security().enterSecurityAndContinue(security);
        }
    }

    @And ("^Enter Borrowers & Guarantors Information$")
    public void enterOtherInvolved(DataTable table){
        List<OtherInvolved> otherInvolvedList= table.asList(OtherInvolved.class);
        for(OtherInvolved otherInvolved : otherInvolvedList){
            new customerPortalPages.OthersInvolved().enterOtherInvolvedAndContinue(otherInvolved);
        }
    }

    @And ("^Review the Information for (.*)$")
    public void reviewTheInformation(String mortageType, DataTable table){
        List<ReviewAndSubmit> reviewAndSubmitList= table.asList(ReviewAndSubmit.class);
        for(ReviewAndSubmit reviewAndSubmit : reviewAndSubmitList){
            new customerPortalPages.ReviewAndSubmit().reviewDetails(mortageType, reviewAndSubmit);
        }
    }

    @And("^Submit the Application$")
    public void submitApplication(){
        new customerPortalPages.ReviewAndSubmit().SubmitTheApplication();
    }

    @And ("^Navigate to Existing Application$")
    public void navigateToExistingApplication(){
        new JSWaiter().waitAllRequest();
        driver.findElement(By.xpath("//span[contains(text(),'Incomplete Applications')]")).click();
        new JSWaiter().waitAllRequest();
        driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
        new JSWaiter().waitAllRequest();
    }

}
