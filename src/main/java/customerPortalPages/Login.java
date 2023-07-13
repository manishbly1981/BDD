package customerPortalPages;

import util.DriverUtil;
import util.JSWaiter;
import util.PropertyUtil;
import org.openqa.selenium.By;
import util.ReportUtil;

public class Login {
    DriverUtil driverUtil;
    public Login(){
        driverUtil= new DriverUtil();
    }
    By txtUserId=By.name("email");
    By txtPassword=By.name("password");
    By btnLogin=By.xpath("//button[contains(text(),'Log In')]");
    By lnkForgotPassword=By.xpath("//a[contains(text(),'Forgot password?')]");
    By lnkSignUp= By.xpath("//a[contains(text(),'Sign Up')]");


    public void enterUserName(String userName){
        driverUtil.performOpration(txtUserId, "input", userName,"User Name");
    }

    public void enterPassword(String password){
        driverUtil.performOpration(txtPassword, "input", password,"Password");
    }

    public void clickLogIn(){
        driverUtil.clickAnElement(btnLogin, "Log In");
    }

    public void clickForgotPassword(){
        driverUtil.clickAnElement(lnkForgotPassword, "Forgot Password");
    }

    public void clickSignUp(){
        driverUtil.clickAnElement(lnkSignUp, "Sign Up");
    }

    public void defaultLogin(){
//        new ReportUtil().logFail("It is testing msg");
        PropertyUtil objProperties= new PropertyUtil();
        String userName=objProperties.getCP_UID();
        String password=objProperties.getCP_PWD();
        specificLogin(userName, password);

    }

    public void specificLogin(String userName, String password){
//        System.out.println(userName + " : " + password);
        new JSWaiter().waitAllRequest();
        enterUserName(userName);
        enterPassword(password);
        clickLogIn();
    }
}
