package customerPortalPages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import util.DriverUtil;
import util.JSWaiter;
import util.ReportUtil;

public class CommonUtil {
    private DriverUtil driverUtil;
    public CommonUtil (){
        driverUtil= new DriverUtil();
    }

    By btnNext= By.xpath("//button[contains(text(),'Next')]");
    By btnSaveAndComeBackLater= By.xpath("//button[contains(text(),'Save and come back later')]");
    By canvas1=By.xpath("//canvas");
    By canvas2=By.xpath("(//canvas)[2]");
    By btnAgree1= By.xpath("(//button[contains(text(),'Agree')])[1]");
    By btnAgree2= By.xpath("(//button[contains(text(),'Agree')])[2]");


    public void clickNext() {
//        new JSWaiter().waitAllRequest();
        driverUtil.clickAnElement(btnNext, "Next button ");
        new JSWaiter().waitAllRequest();
    }

    public void clickSaveAndComeBackLater(){

        driverUtil.clickAnElement(btnSaveAndComeBackLater, "Save and Come Back Later button ");
    }

    public void scrollCanvas(By canvas, String logicalName){
        WebElement ele= driverUtil.getElement(canvas);
//        try {
            ele.click();
//        }catch(Exception e){
//            ele= driverUtil.getElement(canvas2);
//            ele.click();
//        }

        JavascriptExecutor js = (JavascriptExecutor) driverUtil.getDriver();
        driverUtil.explicitWait(4);
        js.executeScript("arguments[0].scrollIntoView(0, 2000);", ele);
//        driverUtil.wheel_element(ele, 4500, 0, 200);
        Actions action= new Actions(driverUtil.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
//        driverUtil.getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//        driverUtil.getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//        driverUtil.getDriver().switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
        new ReportUtil().logInfo("Scroll down the term and condition screen");
    }

    public void clickAgree1(){
        driverUtil.clickAnElement(new DriverUtil().getElement(btnAgree1), "Agree");
    }
    public void peformAcceptOperation1(){
        new CommonUtil().scrollCanvas( canvas1, "Term and Condition");
        new CommonUtil().clickAgree1();
    }

    public void clickAgree2(){
        driverUtil.clickAnElement(new DriverUtil().getElement(btnAgree2), "Agree");
    }
    public void peformAcceptOperation2(){
        new CommonUtil().scrollCanvas(canvas2, "Term and Condition");
        new CommonUtil().clickAgree2();
    }


}
