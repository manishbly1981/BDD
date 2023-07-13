package customerPortalPages;

import cucumber.api.DataTable;
import org.openqa.selenium.By;
import util.DriverUtil;

public class GetYourCommercialLoan {
    private DriverUtil driverUtil;
    public GetYourCommercialLoan(){
        driverUtil= new DriverUtil();
    }

    By selWhatProductAreYouInterestedIn= By.xpath("//label[contains(text(),'What product are you interested in?')]/..//select");
    By txtFirstName= By.xpath("//label[contains(text(),'First Name')]/..//input");
    By txtMiddleName= By.xpath("//label[contains(text(),'Middle Name')]/..//input");
    By txtLastName= By.xpath("//label[contains(text(),'Last Name')]/..//input");
    By txtEmail= By.xpath("//label[contains(text(),'Email')]/..//input");
    By txtMobile= By.xpath("//label[contains(text(),'Mobile')]/..//input");
    By btnContinue= By.xpath("//button[contains(text(),'Continue')]");
    By btnLogInAndContinue= By.xpath("//button[contains(text(),'Log In & Continue')]");

    public void selectWhatProductAreYouInterestedIn(String whatProductAreYouInterestedIn){
        driverUtil.performOpration(selWhatProductAreYouInterestedIn, "selectByVal", whatProductAreYouInterestedIn, "What product are you interested in?");
    }
    public void enterFirstName(String firstName){
        driverUtil.performOpration(txtFirstName, "input", firstName, "First Name");
    }
    public void enterMiddleName(String middleName){
        driverUtil.performOpration(txtMiddleName, "input", middleName, "Middle Name");
    }

    public void enterLastName(String lastName){
        driverUtil.performOpration(txtLastName, "input", lastName, "Last Name");
    }

    public void enterEmail(String email, String alias){
        email=email.split("@")[0]+ "+" + alias + "@" + email.split("@")[1];
        driverUtil.performOpration(txtEmail, "input", email, "Email");
    }

    public void enterMobile(String mobile){
        driverUtil.performOpration(txtMobile, "input", mobile, "Mobile");
    }

    public void clickContinue(){
        driverUtil.clickAnElement(btnContinue, "Continue");
    }
    public void clickLogInAndContinue(){
        driverUtil.clickAnElement(btnLogInAndContinue, "Log In & Continue");
    }

    public void enterGetYourCommercialLoanInfo(dataManager.GetYourCommercialLoan getYourCommercialLoan){
        selectWhatProductAreYouInterestedIn(getYourCommercialLoan.getLoanType());
        enterFirstName(getYourCommercialLoan.getFirstName());
        enterMiddleName(getYourCommercialLoan.getMiddleName());
        enterLastName(getYourCommercialLoan.getLastName());
        enterEmail(new util.PropertyUtil().getCp_SignupEmailId(), new util.PropertyUtil().getAliasNo());
        enterMobile(getYourCommercialLoan.getMobile());
    }
    public void enterGetYourCommercialLoanInfoAndContinue(dataManager.GetYourCommercialLoan getYourCommercialLoan){
        enterGetYourCommercialLoanInfo(getYourCommercialLoan);
        clickContinue();
    }
}
