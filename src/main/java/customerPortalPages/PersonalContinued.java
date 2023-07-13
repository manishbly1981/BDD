package customerPortalPages;

import org.openqa.selenium.By;
import util.DriverUtil;

public class PersonalContinued {
    private DriverUtil driverUtil;
    public PersonalContinued (){
        driverUtil= new DriverUtil();
    }

    By selResidentialStatus=By.xpath("//label[contains(text(),'Residential Status')]/..//select");
    By txtMailingStreet= By.xpath("//label[contains(text(),'Mailing Street')]/..//input");
    By txtCity= By.xpath("//label[contains(text(),'City')]/..//input");
    By txtCntry= By.xpath("(//label[contains(text(),'County')]/..//input)[1]");
    By txtPostCode=By.xpath("(//label[contains(text(),'Postcode')]/..//input)[1]");

    By txtPrvsStreet= By.xpath("//label[contains(text(),'Previous Street')]/..//input");
    By txtPrvsCity= By.xpath("//label[contains(text(),'Previous City')]/..//input");
    By txtPrvsCntry= By.xpath("(//label[contains(text(),'County')]/..//input)[2]");
    By txtPrvsPostCode=By.xpath("(//label[contains(text(),'Postcode')]/..//input)[2]");

    public void selectResidentialStatus(String residentialStatus){
        driverUtil.performOpration(selResidentialStatus, "selectByVal", residentialStatus, "Residential Status");
    }
    public void enterMailingStreet(String mailingStreet){
        driverUtil.performOpration(txtMailingStreet, "input", mailingStreet, "Mailing Street");
    }
    public void enterCity(String city){
        driverUtil.performOpration(txtCity, "input", city, "City");
    }
    public void enterCountry(String country){
        driverUtil.performOpration(txtCntry, "input", country, "Country");
    }
    public void enterPostCode(String postCode){
        driverUtil.performOpration(txtPostCode, "input", postCode, "Postcode");
    }

    public void enterPreviousStreet(String previousStreet){
        driverUtil.performOpration(txtPrvsStreet, "input", previousStreet, "Previous Street");
    }
    public void enterPreviousCity(String city){
        driverUtil.performOpration(txtPrvsCity, "input", city, "Previous City");
    }
    public void enterPreviousCountry(String country){
        driverUtil.performOpration(txtPrvsCntry, "input", country, "Previous Country");
    }
    public void enterPreviousPostCode(String postCode){
        driverUtil.performOpration(txtPrvsPostCode, "input", postCode, "Previous Postcode");
    }

    public void clickNext(){
        new CommonUtil().clickNext();
    }
    public void clickSaveAndComeBackLater(){
        new CommonUtil().clickSaveAndComeBackLater();
    }

    public void enterPersonalContinued(dataManager.PersonalContinued personalContinued){
        selectResidentialStatus(personalContinued.getResidentialStatus());
        enterMailingStreet(personalContinued.getMailingStreet());
        enterCity(personalContinued.getCity());
        enterCountry(personalContinued.getCountry());
        enterPostCode(personalContinued.getPostCode());
        enterPreviousStreet(personalContinued.getPreviousStreet());
        enterPreviousCity(personalContinued.getPreviousCity());
        enterPreviousCountry(personalContinued.getPreviousCountry());
        enterPreviousPostCode(personalContinued.getPreviousPostCode());
    }
    public void enterPersonalContinuedAndContinue(String mortageType, dataManager.PersonalContinued personalContinued){
        if(mortageType.trim().equalsIgnoreCase(new util.PropertyUtil().getBusinessText())) {
            enterPersonalContinued(personalContinued);
            clickNext();
        }else if(mortageType.trim().equalsIgnoreCase(new util.PropertyUtil().getIndividualText())) {
            //Do Nothing as screen is not available for individual
        }else{
            new util.ExceptionHandler().customizedException("Need to write the logic for the martage type: "+ mortageType);
        }
    }
}
