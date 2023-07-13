package util;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    String propertyFilePath;
    InputStream input;

    public PropertyUtil() {
        try{
            this.propertyFilePath = "src/test/resources/Env.properties";
            this.input = new FileInputStream(propertyFilePath);
        }catch(Exception e){
            new ExceptionHandler().unhandledException(e);
        }
    }

    public PropertyUtil(String propertyFilePath) {
        try{
            this.propertyFilePath = propertyFilePath;
            this.input = new FileInputStream(propertyFilePath);
        }catch(Exception e){
            new ExceptionHandler().unhandledException(e);
        }
    }
    public String readPropertyData(String propertyName) {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(this.propertyFilePath));
            return prop.getProperty(propertyName);
        } catch (IOException e) {
            new ExceptionHandler().unhandledException(e);
            return null;
        }
    }

    public void setPropertyData(String propertyName, String propertyVal) {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(this.propertyFilePath));
            prop.setProperty(propertyName, propertyVal);
            prop.store(new FileOutputStream(this.propertyFilePath), null);

        } catch (IOException e) {
            new ExceptionHandler().unhandledException(e);
        }
    }

    // Function to read the property value
    public String readPropertyData(String propertyFilePath, String propertyName) {
        try {
            Properties prop = new Properties();
            InputStream input = new FileInputStream(propertyFilePath);
            prop.load(input);
            return prop.getProperty(propertyName);
        } catch (IOException e) {
            new ExceptionHandler().unhandledException(e);
            return null;
        }
    }

    public String  getBrowser(){
        return this.readPropertyData("browser");
    }

    public String getCP_URL(){
        return this.readPropertyData("cp_url");
    }

    public String getCP_UID(){
        return this.readPropertyData("cp_uid");
    }

    public String  getCP_PWD(){
        return StringUtil.jasyptDecryption(this.readPropertyData("cp_pwd"));
    }

    public String  getnCino_URL(){
        return this.readPropertyData("nCino_url");
    }

    public String  getnCino_UID(){
        return this.readPropertyData("nCino_uid");
    }

    public String  getnCino_PWD(){

        return StringUtil.jasyptDecryption(this.readPropertyData("nCino_pwd"));
    }
    public String  getCurrency(){
        return this.readPropertyData("currency");
    }

    public String getAliasNo(){
        setPropertyData("currentAliasNo",Integer.toString(Integer.parseInt(this.readPropertyData("currentAliasNo"))+1));
        return this.readPropertyData("currentAliasNo");
    }
    public String  getCp_SignupEmailId(){
        return this.readPropertyData("cp_SignupEmailId");
    }

    public String getIndividualText(){
        return this.readPropertyData("src/test/resources/Constant.properties","individual");
    }

    public String getBusinessText(){
        return this.readPropertyData("src/test/resources/Constant.properties","business");
    }

    public String getZephyrBaseUrl(){
        return this.readPropertyData("src/test/resources/Constant.properties","zephyrBaseUrl");
    }
    public String getZapiAccessKey(){

        return StringUtil.jasyptDecryption(this.readPropertyData("src/test/resources/Constant.properties","zapiAccessKey"));
    }
    public String getZapiSecretKey(){
        return StringUtil.jasyptDecryption(this.readPropertyData("src/test/resources/Constant.properties","zapiSecretKey"));
    }
    public String getJiraAccountId(){
        return StringUtil.jasyptDecryption(this.readPropertyData("src/test/resources/Constant.properties","jiraAccountId"));
    }

    public String getJiraBaseURL(){
        return this.readPropertyData("src/test/resources/Constant.properties","jiraBaseURL");
    }

    public String getJiraUid(){
        return StringUtil.jasyptDecryption(this.readPropertyData("src/test/resources/Constant.properties","jiraUID"));
    }

    public String getJiraPwd(){
        return StringUtil.jasyptDecryption(this.readPropertyData("src/test/resources/Constant.properties","jiraPWD"));
    }

    public String getJiraUserName(){
        return StringUtil.jasyptDecryption(this.readPropertyData("src/test/resources/Constant.properties","jiraUserName"));
    }

    public String getJiraProjectKey(){
        return this.readPropertyData("src/test/resources/Constant.properties","jiraProjectKey");
    }
    public String getJiraVersionName(){
        return this.readPropertyData("src/test/resources/Env.properties","jiraVersionName");
    }
    public String getJiraCycleName(){
        return this.readPropertyData("src/test/resources/Env.properties","jiraCycleName");
    }
    //Possible values are
    /*
    * always--> Always on step it will take screenshot
    * onPass--> Will take screenshot on pass, fail and click, info will be ignored
    * onFail--> Will take screenshot on fail and click, info and pass will be ignored
    * onClick--> Will take screenshot on click, info, pass and fail will be ignored
    * never--> Never will take screenshot
     */
    public String getScreenshotOption(){
        return this.readPropertyData("src/test/resources/Env.properties","screenshotInReport");
    }
//    jira update value could be yes and no
    public String getJiraUpdate(){
        return this.readPropertyData("src/test/resources/Env.properties","jiraUpdate");
    }
}
