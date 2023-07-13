package customerPortalPages;

import util.DriverUtil;
import util.JSWaiter;
import org.openqa.selenium.By;

public class Security {
    private DriverUtil driverUtil;
    public Security (){
        driverUtil= new DriverUtil();
    }

    By btnAddNew= By.xpath("//button[contains(text(),'Add New')]");
    By selSecurityType=By.xpath("//*[contains(text(),'Security Type')]/..//select");
//    By txtSecurityName=By.xpath("//*[contains(text(),'Security Name')]/..//input"); //Removed as on 3rd Jun, 19
    By txtEstimatedValue=By.xpath("//*[contains(text(),'Estimated Value')]/..//input");
    By txtPurchasePrice= By.xpath("//*[contains(text(),'Purchase Price')]/..//input"); //Added as on 3rd Jun, 19
    By selLocation= By.xpath("//*[contains(text(),'Location')]/..//select"); //Added as on 3rd Jun, 19
    By txtStreetAddrerss=By.xpath("//*[contains(text(),'Street Address')]/..//input");
    By txtCity=By.xpath("//*[contains(text(),'City')]/..//input");
    By txtCountry=By.xpath("//*[contains(text(),'County')]/..//input");
    By txtPostCode=By.xpath("//*[contains(text(),'Postcode')]/..//input");

    //Property Details
    By selPropertyType=By.xpath("//*[contains(text(),'Property Type')]/..//select");

//    By txtYearBuilt=By.xpath("//*[contains(text(),'Year Built')]/..//input"); //Removed as on 3rd Jun, 19
//    By selCondition=By.xpath("//*[contains(text(),'Condition')]/..//select"); //Removed as on 3rd Jun, 19
    By selPropertyDescription=By.xpath("//*[contains(text(),'Property Description')]/..//select"); //added as on 3rd Jun, 19
    By selUseOfProperty=By.xpath("//*[contains(text(),'Use of Property')]/..//select"); //added as on 3rd Jun, 19
    By selTenure=By.xpath("//*[contains(text(),'Tenure')]/..//select");

    //Leasehold Details
    By txtYearRemainingOnLease=By.xpath("//*[contains(text(),'Years Remaining on Lease')]/..//input"); //added as on 3rd Jun, 19
    By txtRentReviewDate=By.xpath("//*[contains(text(),'Rent Review Date')]/..//input"); //added as on 3rd Jun, 19
    By txtServiceCharge=By.xpath("//*[contains(text(),'Service Charge (£)')]/..//input"); //added as on 3rd Jun, 19
    By txtGroundRent=By.xpath("//*[contains(text(),'Ground Rent (£)')]/..//input"); //added as on 3rd Jun, 19


    By btnCancel=By.xpath("(//button[contains(text(),'Cancel')])[2]");

    public void clickAddNew(){
        driverUtil.clickAnElement(btnAddNew, "Add New");
    }


    public void selectSecurityType(String securityType){
        driverUtil.performOpration(selSecurityType, "selectByVal", securityType, "Security Type");
    }
//Remove as on 3rd June, 19
//    public void enterSecurityName(String securityName){
//        driverUtil.performOpration(txtSecurityName, "input", securityName, "Security Name");
//    }

    public void enterEstimateValue(String estimateValue){
        driverUtil.performOpration(txtEstimatedValue, "input", estimateValue, "Estimate Value");
    }
    public void enterPurchasePrice(String purchasePrice){
        driverUtil.performOpration(txtPurchasePrice, "input", purchasePrice, "Purchase Price");
    }
    public void selectLocation(String location){
        driverUtil.performOpration(selLocation, "selectByVal", location, "Location");
    }

    public void enterStreetAddress(String streetAddress){
        driverUtil.performOpration(txtStreetAddrerss, "input", streetAddress, "Street Address");
    }

    public void enterCity(String city){
        driverUtil.performOpration(txtCity, "input", city, "City");
    }

    public void enterCountry(String country){
        driverUtil.performOpration(txtCountry, "input", country, "Country");
    }

    public void enterPostCode(String postCode){
        driverUtil.performOpration(txtPostCode, "input", postCode, "Post code");
    }

    public void selectPropertyType(String propertyType){
        driverUtil.performOpration(selPropertyType, "selectByVal", propertyType, "Property Type");
    }
    public void selectPropertyDescription(String propertyDescription){
        driverUtil.performOpration(selPropertyDescription, "selectByVal", propertyDescription, "Property Description");
    }
    public void selectUseOfProperty(String useOfProperty){
        driverUtil.performOpration(selUseOfProperty, "selectByVal", useOfProperty, "Use of Property");
    }
//Remove as on 3rd June, 19
//    public void enterYearBuilt(String yearBuilt){
//        driverUtil.performOpration(txtYearBuilt, "input", yearBuilt, "Year Built");
//    }
//Remove as on 3rd June, 19
//    public void selectCondition(String condition){
//        driverUtil.performOpration(selCondition, "selectByVal", condition, "Condition");
//    }

    public void selectTenure(String tenure){
        driverUtil.performOpration(selTenure, "selectByVal", tenure, "Tenure");
    }

    public void enterYearsRemainingOnLease(String yearsRemainingOnLease){
        driverUtil.performOpration(txtYearRemainingOnLease, "input", yearsRemainingOnLease, "Years Remaining on Lease");
    }
    public void enterRentReviewDate(String rentReviewDate){
        driverUtil.performOpration(txtRentReviewDate, "input", rentReviewDate, "Rent Review Date");
    }
    public void enterServiceCharge(String serviceCharge){
        driverUtil.performOpration(txtServiceCharge, "input", serviceCharge, "Service Charge");
    }
    public void enterGroundRent(String groundRent){
        driverUtil.performOpration(txtGroundRent, "input", groundRent, "Ground Rent");
    }

    public void clickNext(){
        new CommonUtil().clickNext();
    }

    public void clickSaveAndComeBackLater(){
        new CommonUtil().clickSaveAndComeBackLater();
    }

    public void enterSecurity(dataManager.Security securityData){
        selectSecurityType(securityData.getSecurityType());
//        enterSecurityName(securityName);
        new JSWaiter().waitAllRequest();
        enterEstimateValue(securityData.getSecurityEstimatedValue());
        enterPurchasePrice(securityData.getSecurityPurchasePrice());
        selectLocation(securityData.getSecurityLocation());
        enterStreetAddress(securityData.getSecurityStreetAddress());
        enterCity(securityData.getSecurityCity());
        enterCountry(securityData.getSecurityCountry());
        enterPostCode(securityData.getSecurityPostCode());
        selectPropertyType(securityData.getSecurityPropertyType());
//        enterYearBuilt(yearBuilt);
//        selectCondition(condition);
        selectPropertyDescription(securityData.getSecurityPropertyDescription());
        selectUseOfProperty(securityData.getSecurityUseOfProperty());
        selectTenure(securityData.getSecurityTenure());
        enterYearsRemainingOnLease(securityData.getYearsRemainingOnLease());
        enterRentReviewDate(securityData.getRentReviewDate());
        enterServiceCharge(securityData.getServiceCharge());
        enterGroundRent(securityData.getGroundRent());
    }

    public void enterSecurityAndContinue(dataManager.Security securityData){
//        if(mortageType.trim().equalsIgnoreCase(new util.PropertyUtil().getBusinessText())) {
            clickAddNew();
            enterSecurity(securityData);
            clickNext();//to submit current data enter in security screen
            new util.DriverUtil().explicitWait(5);
            clickNext();//To continue from security screen
//        }else if(mortageType.trim().equalsIgnoreCase(new util.PropertyUtil().getIndividualText())) {
//            clickAddNew();
//            enterSecurity(securityData);
//            clickNext();//to submit current data enter in security screen
//            new util.DriverUtil().explicitWait(5);
//            clickNext();
//        }else{
//            new util.ExceptionHandler().customizedException("Need to write the logic for the martage type: "+ mortageType);
//        }
    }
}
