package customerPortalPages;

import util.DriverUtil;
import org.openqa.selenium.By;
import util.JSWaiter;

public class MarketPlace {
    private DriverUtil driverUtil;
    public MarketPlace (){
        driverUtil= new DriverUtil();
    }

//    By btnBusinessCommecialMortageApply= By.xpath("//a[contains(text(),'Apply')]");
    By btnBusinessCommecialMortageApply= By.xpath("//h2[contains(text(),'Business Commercial Mortgage')]/../../..//a[contains(text(),'Apply')]");
    By btnIndividualSoleTraderCommercialMortageApply= By.xpath("//h2[contains(text(),'Individual/Sole Trader Commercial Mortgage')]/../../..//a[contains(text(),'Apply')]");

    public void startBusinessCommecialMortageProcess(){
        driverUtil.clickAnElement(btnBusinessCommecialMortageApply, "'Business Commercial Mortgage' button");
    }

    public void startIndvSoleTraderCommercialMortageProcess(){
        new JSWaiter().waitAllRequest();
        driverUtil.clickAnElement(btnIndividualSoleTraderCommercialMortageApply, "'Individual/Sole Trader Commercial Mortgage' button");
    }
}
