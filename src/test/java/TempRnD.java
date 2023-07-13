import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import util.StringUtil;

public class TempRnD {
    public static void main(String args[]){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "D:/Bdd/UrsaBank_test/drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:/Bdd/UrsaBank_test/drivers/geckodriver.exe");
        System.setProperty("webdriver.ie.driver", "D:/Bdd/UrsaBank_test/drivers/IEDriverServer.exe");
//        driver = new InternetExplorerDriver();
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        System.out.println("Before enter url");

        driver.get("http://www.google.com");
        System.out.println("After enter url");
        driver.navigate().to("http://www.google.com");
        System.out.println("After Navigate");
        driver.quit();
        System.out.println("After quit");
    }


    public static void generator(String strToEncript){
        String strEncripted= StringUtil.jasyptEncryption(strToEncript);
        String str= util.StringUtil.jasyptDecryption(strEncripted);
//        System.out.println(strEncripted);
//        System.out.println(str);
//        System.out.println("*********************************");
    }
}