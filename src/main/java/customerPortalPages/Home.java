package customerPortalPages;

import util.DriverUtil;
import org.openqa.selenium.By;
import util.JSWaiter;

public class Home {
    private DriverUtil driverUtil;
    public Home (){
        driverUtil= new DriverUtil();
    }

    By txtWelcomeMsg= By.xpath("//h2[contains(text(),'Welcome to your dashboard')]");

    //This xpath needs to check in upcoming releases how it is behaving in release to release
    By lblCheckBusinessCommercialMortageProcess= By.xpath("//h2[contains(text(),'Your Products')]//..//img");
//    By startLoanProcess= By.xpath("//*[contains(text(),'Business Commercial Mortgage')]/../..//img");

    By lblMarketPlace= By.xpath("//span[contains(text(),'Marketplace')]");

    public void verifyWelcomeScreenMsg(){
        new JSWaiter().waitAllRequest();
        driverUtil.verifyValue(txtWelcomeMsg, "exist", "", "Welcome to your dashboard");
    }

    public void startProduct_businessCommercialMortage(){
        driverUtil.clickAnElement(lblCheckBusinessCommercialMortageProcess, "Start Business Commercial Mortage link");
    }

    public void navigateMarketPlace(){
//        new JSWaiter().waitAllRequest();
        driverUtil.clickAnElement(lblMarketPlace, "Marketplace link");
    }
}
