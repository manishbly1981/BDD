package util;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReportUtil {
    private static util.PropertyUtil propertyUtil= new util.PropertyUtil();
    static ExtentHtmlReporter htmlReporter;
    static ExtentReports extent;
    static ExtentTest logger;
    static String extentReportPath="";
    public String getReportFolder(){
        return extentReportPath;
    }
    public void initReport(){
        if (new PropertyUtil().getJiraUpdate().equalsIgnoreCase("yes")) {
            extentReportPath = System.getProperty("user.dir") + "/test-output/" + new CompactUtil().getCurrentTimeStemp("yyyy_MM_dd_HH_mm_ss");
        }else{
            if(new ReportUtil().extentReportPath.equalsIgnoreCase("")){
                extentReportPath = System.getProperty("user.dir") + "/test-output/" + new CompactUtil().getCurrentTimeStemp("yyyy_MM_dd_HH_mm_ss");
            }
        }
        new CompactUtil().createFolder(extentReportPath);
        htmlReporter = new ExtentHtmlReporter(extentReportPath+ "/ExecutionSummaryReport" + ".html");
        htmlReporter.setAppendExisting(true);
//        String htmlpath = htmlReportPath+ "/ExecutionSummaryReport" + ".html";
        extent = new ExtentReports ();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Host Name", new CompactUtil().getSystemName());
        extent.setSystemInfo("Environment", "SIT");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        htmlReporter.config().setDocumentTitle("URSA Bank Execution Report");
        htmlReporter.config().setReportName("Automation Regression Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    public void initTest(String testName){
        logger= extent.createTest(testName);
        extent.flush();
    }

    public String getStatus(){
        return logger.getStatus().toString().toLowerCase();
    }

    public void logEvent(Status status,String description, boolean img){
        if(img)
            logger.log(status, description + captureScreenShot());
        else
            logger.log(status, description);
        extent.flush();
    }

    public void logInfo(String msgToPrint){
        if(propertyUtil.getScreenshotOption().equalsIgnoreCase("always")) {
            logger.log(Status.INFO, MarkupHelper.createLabel(msgToPrint+ captureScreenShot(), ExtentColor.BLUE));
        }else{
            logger.log(Status.INFO, MarkupHelper.createLabel(msgToPrint, ExtentColor.BLUE));
        }
        extent.flush();
    }

    public void logPass(String msgToPrint){
        if(propertyUtil.getScreenshotOption().equalsIgnoreCase("always")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onPass")) {
            logger.log(Status.PASS, MarkupHelper.createLabel(msgToPrint + captureScreenShot(), ExtentColor.GREEN));
        }else{
            logger.log(Status.PASS, MarkupHelper.createLabel(msgToPrint, ExtentColor.GREEN));
        }
        extent.flush();
    }

    public void logFail(String msgToPrint){
        if(propertyUtil.getScreenshotOption().equalsIgnoreCase("always")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onPass")|propertyUtil.getScreenshotOption().equalsIgnoreCase("onFail")) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(msgToPrint + captureScreenShot(), ExtentColor.RED));
        }else{
            logger.log(Status.FAIL, MarkupHelper.createLabel(msgToPrint, ExtentColor.RED));
        }
        extent.flush();
    }

    public void compareResult(String logicalName, String expectedVal, String actualVal, boolean caseSensitive){
        String msgToPrint="Verify <B>'"+ logicalName + "'</B> value:<BR>Expected: <B>'"+ expectedVal +"'</B><BR>Actual: <B>'" + actualVal + "'</B>";
        if(caseSensitive){
            if(expectedVal==actualVal){
                logPass(msgToPrint);
            }else{
                logFail(msgToPrint);
            }
        }else{
            if(expectedVal.equalsIgnoreCase(actualVal)){
                logPass(msgToPrint);
            }else{
                logFail(msgToPrint);
            }
        }
    }

    public void logInfo(String msgToPrint, boolean takeScreenshot){
        if(takeScreenshot){
            logger.log(Status.INFO, MarkupHelper.createLabel(msgToPrint + captureScreenShot(), ExtentColor.BLUE));
        }else{
            logger.log(Status.INFO, MarkupHelper.createLabel(msgToPrint, ExtentColor.BLUE));
        }
        extent.flush();
    }

    public void logWarning(String msgToPrint){
        logger.log(Status.WARNING, MarkupHelper.createLabel(msgToPrint, ExtentColor.AMBER));
        extent.flush();
    }

    public void logSkipped(String msgToPrint){
        logger.log(Status.SKIP, MarkupHelper.createLabel(msgToPrint, ExtentColor.ORANGE));
        extent.flush();
    }
    public String captureScreenShot(WebElement ele) {
        try {
            String filePath = extentReportPath + File.separator + "Screenshots" + File.separator;
            new CompactUtil().createFolder(filePath);
            String fileName = new CompactUtil().getCurrentTimeStemp("yyyyMMdd_hhmmss") + ".png";
            BufferedImage bf= Shutterbug.shootPage(new DriverUtil().getDriver(), ScrollStrategy.WHOLE_PAGE, true).highlight(ele, Color.RED, 4).getImage();
            File outputfile = new File(filePath + fileName);
            ImageIO.write(bf, "png", outputfile);
            return filePath + fileName;
        } catch (Exception e) {
            new ExceptionHandler().unhandledException(e);
            e.printStackTrace();
            return "";
        }
    }
    public String captureScreenShot() {
        try {
            String filePath=extentReportPath+ File.separator + "Screenshots" + File.separator;
            new CompactUtil().createFolder(filePath);
            String fileName= new CompactUtil().getCurrentTimeStemp("yyyyMMdd_hhmmss") + ".png";
            BufferedImage bf= Shutterbug.shootPage(new DriverUtil().getDriver(), ScrollStrategy.WHOLE_PAGE, true).withName(filePath+fileName).getImage();
            File outputfile = new File(filePath+fileName);
            ImageIO.write(bf, "png", outputfile);
            bf.flush();
            return "<div align='right' style='float:right'><a "+ NewWindowPopUpHTMLCode() + " target='_blank' href= "+ "."+File.separator + "Screenshots" + File.separator+ fileName + ">Screenshot</a></div>";
        }catch(Exception e){
            new ExceptionHandler().unhandledException(e);
            e.printStackTrace();
            return "";
        }

        //Inbuilt Selenium code
//        File src= ((TakesScreenshot)new DriverUtil().getDriver()).getScreenshotAs(OutputType.FILE);
//            try {
//                String filePath=extentReportPath+ File.separator + "Screenshots" + File.separator;
//                new CompactUtil().createFolder(filePath);
//                String fileName= new CompactUtil().getCurrentTimeStemp("yyyyMMdd_hhmmss") + ".png";
//                FileUtils.copyFile(src, new File(filePath + fileName));
//                return "."+ File.separator + "Screenshots" + File.separator + fileName;
//            }
//
//            catch (IOException e){
//                new ExceptionHandler().unhandledException(e);
//                return "";
//            }
    }
//public static void takeScreenshot() {

//    String filePath="D:/temp" + File.separator;
//    String fileName= "123.png";
//    try {
//        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
//                .takeScreenshot(new DriverUtil().getDriver());
//        ImageIO.write(screenshot.getImage(), "PNG", new File(filePath + fileName));
//    }catch(Exception e){
//        e.printStackTrace();
//    }
//}
    public static String NewWindowPopUpHTMLCode() {
        return "onclick = \"window.open(this.href,'newwindow', 'width=1000" + ",height=500');return false;\"";

    }
}