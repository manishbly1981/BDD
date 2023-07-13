package nCinoPages;

import util.DriverUtil;
import util.PropertyUtil;
import org.openqa.selenium.By;

public class Login {
    DriverUtil driverUtil;
    public Login(){
        driverUtil= new DriverUtil();
    }
    By txtUserId=By.id("username");
    By txtPassword=By.id("password");
    By btnLogin=By.id("Login");

    public void enterUserName(String userName){
        driverUtil.performOpration(txtUserId, "input", userName,"User Name");
    }

    public void enterPassword(String password){
        driverUtil.performOpration(txtPassword, "input", password,"Password");
    }

    public void clickLogIn(){
        driverUtil.clickAnElement(btnLogin, "Log In");
    }

    public void defaultLogin(){
        PropertyUtil objProperties= new PropertyUtil();
        String userName=objProperties.getnCino_UID();
        String password=objProperties.getnCino_PWD();
        specificLogin(userName, password);

    }

    public void specificLogin(String userName, String password){
//        System.out.println(userName + " : " + password);
        enterUserName(userName);
        enterPassword(password);
        clickLogIn();
    }
}
