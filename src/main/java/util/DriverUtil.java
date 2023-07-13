package util;

import cucumber.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.util.concurrent.TimeUnit;
import util.StringUtil;
public class DriverUtil {
    private static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver openBrowser(){
        PropertyUtil objProperties= new PropertyUtil();
        String browserType=objProperties.getBrowser();
        try {
            if (browserType.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                /******************************************************************************/
                CompactUtil.closeSpecificProcess("chrome.exe");
                ChromeOptions cromeOptions= new ChromeOptions();
//                cromeOptions.addArguments("user-data-dir=chromeProfileAutomation");  //In case of facing any challange with default profile in future will use this line where after launching the browser needs to login once manually into the browser
                File file= new File(System.getenv("APPDATA")+ "/../Local/Google/Chrome/User Data");
                cromeOptions.addArguments("user-data-dir="+ file.getCanonicalPath());
                /******************************************************************************/
                driver = new ChromeDriver(cromeOptions);
                new ReportUtil().logInfo("Chrome browser is launched");
            }else if (browserType.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//                capabilities.setCapability("marionette",true);
//                driver= new FirefoxDriver(capabilities);

                driver = new FirefoxDriver();
                new ReportUtil().logInfo("FF browser is launched");
            }else if (browserType.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                new ReportUtil().logInfo("IE browser is launched");
            }else {

                new ExceptionHandler().customizedException(browserType + " not been automated yet");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public void closeBrowser(Scenario scenario) {
        new ReportUtil().logInfo("Last screen of current scenario",true);
        driver.quit();
        new ReportUtil().logInfo("Browser Closed successfully");

    }

    public void navigateURL(String portalType){
        if (portalType.equalsIgnoreCase("ncino")) {
            driver.get(new PropertyUtil().getnCino_URL());
            new ReportUtil().logInfo("nCino application launched");
        }else{
            driver.get(new PropertyUtil().getCP_URL());
            new ReportUtil().logInfo("Customer Portal application launched");
        }
    }

    public WebElement getElement(By by){
        WebElement we= null;
        try {
            we= driver.findElement(by);
        }catch(Exception e){
            new ExceptionHandler().unhandledException(e);
        }
        return we;
    }

    public void performOpration(By by, String operation, String value, String logicalName){
        util.PropertyUtil propertyUtil= new util.PropertyUtil();
        WebElement ele=getElement(by);
        if (ele==null){
            new ExceptionHandler().customizedException(logicalName + " not found in application");
        }else if (operation.equalsIgnoreCase("input")) {
            try {
                ele.clear();
                ele.click();
                ele.sendKeys(value);
                int i= 1;
                while(ele.getAttribute("value").trim().equalsIgnoreCase("") && i++<30) {
                    explicitWait(1);
                    ele.click();
                    ele.sendKeys(value);

                }
                new ReportUtil().logInfo(value + " has been entered in " + logicalName);
            }catch(Exception e){
                new ExceptionHandler().customizedException(value + " cannot be entered in " + logicalName);
            }
        }else if(operation.equalsIgnoreCase("selectByVal")) {
            try {
//                System.out.println("value is : " +value);
                if(!value.equalsIgnoreCase("")) {
                    Select sel = new Select(ele);
                    sel.selectByVisibleText(value);
                    new ReportUtil().logInfo(value + " has been selected for " + logicalName);
                }
            }catch(Exception e){
                new ExceptionHandler().customizedException(value + " cannot be select for " + logicalName);
            }
        }else if(operation.equalsIgnoreCase("checkbox")) {
            try {
                if(value.equalsIgnoreCase("yes")) {
                    if (!ele.isSelected()){

                        ele.click();
                    }
                    new ReportUtil().logInfo("'"+ logicalName + "' has been checked");
                }else if(value.equalsIgnoreCase("no")) {
                    if (ele.isSelected()) {
                        ele.click();
                    }
                    new ReportUtil().logInfo("'" + logicalName + "' has been un-checked");
                }else if(!value.equalsIgnoreCase("")){
                    new util.ExceptionHandler().customizedException(value + " is not valid for "+ logicalName);
                }
            }catch(Exception e){
                new ExceptionHandler().customizedException(logicalName + " cannot be checked/unchecked");
            }
        }else if(operation.equalsIgnoreCase("Click")) {
            try{
                if (propertyUtil.getScreenshotOption().equalsIgnoreCase("always")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onPass")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onFail")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onClick")) {
                    new ReportUtil().logInfo("Before clicked " + logicalName, true);
                }else{
                    new ReportUtil().logInfo("Before clicked " + logicalName, false);
                }
                ele.click();
                new util.JSWaiter().waitAllRequest();
//                new ReportUtil().logInfo(logicalName + " clicked");
            }catch(Exception e){
                new ExceptionHandler().customizedException(logicalName + " cannot be clicked");
            }
        }

    }
    public void performOpration(By by, By by1, String operation, String value, String logicalName){
        util.PropertyUtil propertyUtil= new util.PropertyUtil();
        WebElement ele=getElement(by);
        WebElement ele1=getElement(by1);
        if (ele==null & ele1==null){
            new ExceptionHandler().customizedException(logicalName + " not found in application");
        }else if (operation.equalsIgnoreCase("input")) {
            try {
                ele.clear();
                ele.click();
                ele.sendKeys(value);
                new ReportUtil().logInfo(value + " has been entered in " + logicalName);
            }catch(Exception e){
                new ExceptionHandler().customizedException(value + " cannot be entered in " + logicalName);
            }
        }else if(operation.equalsIgnoreCase("selectByVal")) {
            try {
//                System.out.println("value is : " +value);
                if(!value.equalsIgnoreCase("")) {
                    Select sel = new Select(ele);
                    sel.selectByVisibleText(value);
                    new ReportUtil().logInfo(value + " has been selected for " + logicalName);
                }
            }catch(Exception e){
                new ExceptionHandler().customizedException(value + " cannot be select for " + logicalName);
            }
        }else if(operation.equalsIgnoreCase("checkbox")) {
            try {
                if(value.equalsIgnoreCase("yes")) {
                    if (!ele.isSelected()){

                        ele1.click();
                    }
                    new ReportUtil().logInfo("'"+ logicalName + "' has been checked");
                }else if(value.equalsIgnoreCase("no")) {
                    if (ele.isSelected()) {
                        ele1.click();
                    }
                    new ReportUtil().logInfo("'" + logicalName + "' has been un-checked");
                }else if(!value.equalsIgnoreCase("")){
                    new util.ExceptionHandler().customizedException(value + " is not valid for "+ logicalName);
                }
            }catch(Exception e){
                new ExceptionHandler().customizedException(logicalName + " cannot be checked/unchecked");
            }
        }else if(operation.equalsIgnoreCase("Click")) {
            try{
                if (propertyUtil.getScreenshotOption().equalsIgnoreCase("always")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onPass")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onFail")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onClick")) {
                    new ReportUtil().logInfo("Before clicked " + logicalName, true);
                }else{
                    new ReportUtil().logInfo("Before clicked " + logicalName, false);
                }
//                new ReportUtil().logInfo("Before clicked "+ logicalName, true);
                ele.click();
                new util.JSWaiter().waitAllRequest();
//                new ReportUtil().logInfo(logicalName + " clicked");
            }catch(Exception e){
                new ExceptionHandler().customizedException(logicalName + " cannot be clicked");
            }
        }

    }

    public void clickAnElement(By by, String logicalName){
        PropertyUtil propertyUtil= new PropertyUtil();
        WebElement ele=getElement(by);
        if (ele==null){
            new ExceptionHandler().customizedException("'" + logicalName + "' not found in application");
        }else {
            try {
//                new ReportUtil().logInfo("Before clicked on '" + logicalName + "'", true);
                if (propertyUtil.getScreenshotOption().equalsIgnoreCase("always")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onPass")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onFail")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onClick")) {
                    new ReportUtil().logInfo("Before clicked " + logicalName, true);
                }else{
                    new ReportUtil().logInfo("Before clicked " + logicalName, false);
                }

                ele.click();
                new util.JSWaiter().waitAllRequest();
//                new ReportUtil().logInfo("After clicked on '"+ logicalName + "'", true);
            } catch (Exception e) {
                new ExceptionHandler().customizedException("'" + logicalName + "' cannot be clicked");
            }
        }
    }

    public void clickAnElement(WebElement ele, String logicalName){
        PropertyUtil propertyUtil= new PropertyUtil();
        if (ele==null){
            new ExceptionHandler().customizedException("'" + logicalName + "' not found in application");
        }else {
            try {
                if (propertyUtil.getScreenshotOption().equalsIgnoreCase("always")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onPass")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onFail")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onClick")) {
                    new ReportUtil().logInfo("Before clicked " + logicalName, true);
                }else{
                    new ReportUtil().logInfo("Before clicked " + logicalName, false);
                }
//                new ReportUtil().logInfo("Before clicked on '" + logicalName + "'", true);
                ele.click();
                new util.JSWaiter().waitAllRequest();
//                new ReportUtil().logInfo("After clicked on '"+ logicalName + "'", true);
            } catch (Exception e) {
                new ExceptionHandler().customizedException("'" + logicalName + "' cannot be clicked");
            }
        }
    }

    public void verifyValue(By by, String propertyName, String valToVerify, String logicalName){
        WebElement ele=getElement(by);
        if (ele==null){
            new ExceptionHandler().customizedException(logicalName + " not found in application");
        }else if (propertyName.equalsIgnoreCase("exist")) {
            if (ele.isDisplayed()){
                new ReportUtil().logPass("Element : '" + logicalName + "'<BR>Actual: Element should present in application<BR>Expected: Element present in application");
            }else{
                new ReportUtil().logFail("Element : '" + logicalName + "'<BR>Actual: Element should present in application<BR>Expected: Element not present in application");
            }
        }else if (propertyName.equalsIgnoreCase("verifyText")) {
                new ReportUtil().compareResult(logicalName, valToVerify, new StringUtil().removeWhiteSpaces(ele.getText()), false);
        }else if (propertyName.equalsIgnoreCase("verifyChkBox")) {
            if (valToVerify.equalsIgnoreCase("yes")) {
                new ReportUtil().compareResult(logicalName, "true", Boolean.toString(ele.isSelected()), false);
            }else if (valToVerify.equalsIgnoreCase("no")) {
                new ReportUtil().compareResult(logicalName, "false", Boolean.toString(ele.isSelected()), false);
            }
        }
    }

    public void clickJS(By by, String logicalName){
        PropertyUtil propertyUtil= new PropertyUtil();
        WebElement ele=getElement(by);
        if (ele==null){
            new ExceptionHandler().customizedException(logicalName + " not found in application");
        }else {
//            highlightElement(ele);
            if (propertyUtil.getScreenshotOption().equalsIgnoreCase("always")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onPass")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onFail")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onClick")) {
                new ReportUtil().logInfo("Before clicked " + logicalName, true);
            }else{
                new ReportUtil().logInfo("Before clicked " + logicalName, false);
            }

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);
            new util.JSWaiter().waitAllRequest();
//            new ReportUtil().logInfo(logicalName + " clicked", true);
        }
    }

    public void wheel_element(WebElement element, int deltaY, int offsetX, int offsetY) {
        try {
            String script = "var element = arguments[0];"
                    + "var deltaY = arguments[1];"
                    + "var box = element.getBoundingClientRect();"
                    + "var clientX = box.left + (arguments[2] || box.width / 2);"
                    + "var clientY = box.top + (arguments[3] || box.height / 2);"
                    + "var target = element.ownerDocument.elementFromPoint(clientX, clientY);"
                    + "for (var e = target; e; e = e.parentElement) {"
                    + "if (e === element) {"
                    + "target.dispatchEvent(new MouseEvent('mouseover', {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY}));"
                    + "target.dispatchEvent(new MouseEvent('mousemove', {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY}));"
                    + "target.dispatchEvent(new WheelEvent('wheel',     {view: window, bubbles: true, cancelable: true, clientX: clientX, clientY: clientY, deltaY: deltaY}));"
                    + "return;"
                    + "}"
                    + "}";

            WebElement parent = (WebElement) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].parentNode;", element);
            ((JavascriptExecutor) getDriver()).executeScript(script, parent, deltaY, offsetX, offsetY);
        } catch (WebDriverException e) {
            System.out.println("Exception caught in Catch block");
        }
    }
    public void highlightElement(WebElement ele){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
    }


    public void explicitWait(int time) {
        try {
            Thread.sleep((1000*time));
        }catch(Exception e){

        }
    }
}
