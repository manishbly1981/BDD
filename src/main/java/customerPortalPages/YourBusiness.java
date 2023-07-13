package customerPortalPages;

import util.DriverUtil;
import org.openqa.selenium.By;
import util.JSWaiter;

public class YourBusiness {
    private DriverUtil driverUtil;
    public YourBusiness (){
        driverUtil= new DriverUtil();
    }

    By txtLegalBusinessName= By.xpath("//label[contains(text(),'Legal Business Name')]/..//input");
    By txtCRN= By.xpath("//label[contains(text(),'CRN')]/..//input");
    By txtDateOfIncorporation= By.xpath("//label[contains(text(),'Date of Incorporation')]/..//input");
    By selApplicationType= By.xpath("//label[contains(text(),'Application Type')]/..//select");
    By selIndustryYourBusinessBelongTo= By.xpath("//label[contains(text(),'What industry does your business belong to?')]/..//select");
//    Where is your business located?
    By txtRegisteredAddress= By.xpath("//label[contains(text(),'Registered Address')]/..//input");
    By txtRegisteredCity= By.xpath("(//label[contains(text(),'City')]/..//input)[1]");
    By txtRegisteredCountry= By.xpath("(//label[contains(text(),'County')]/..//input)[1]");
    By txtRegisteredPostCode= By.xpath("(//label[contains(text(),'Postcode')]/..//input)[1]");
    By txtTradingAddress= By.xpath("//label[contains(text(),'Trading Address')]/..//input");
    By TxtTradingCity= By.xpath("(//label[contains(text(),'City')]/..//input)[2]");
    By txtTradingCountry= By.xpath("(//label[contains(text(),'County')]/..//input)[2]");
    By txtTradingPostCode= By.xpath("(//label[contains(text(),'Postcode')]/..//input)[2]");
//Investment Portfolio added on 3rd June
    By txtTotalNoOfProperties= By.xpath("//label[contains(text(),'Total No. of Properties')]/..//input");
    By txtEstimatedPortfolioValue= By.xpath("//label[contains(text(),'Estimated Portfolio Value (£)')]/..//input");
    By txtTotalOutstandingMortgageBalance= By.xpath("//label[contains(text(),'Total Outstanding Mortgage Balance (£)')]/..//input");
    By txtTotalMontlyRentalIncome= By.xpath("//label[contains(text(),'Total Monthly Rental Income (£)')]/..//input");
    By txtTotalMonthlyMortgagePayment= By.xpath("//label[contains(text(),'Total Monthly Mortgage Payment (£)')]/..//input");

    By btnMakeADifferentSelection= By.xpath("//button[contains(text(),'Make a Different Selection')]");


    public void enterLegalBusinessName(String legalBusinessName){
        driverUtil.performOpration(txtLegalBusinessName, "input", legalBusinessName, "Legal Business Name");
    }

    public void enterCRN(String crnNo){
        driverUtil.performOpration(txtCRN, "input", crnNo, "CRN");
    }
    public void enterDateOfIncorporation(String dateOfIncorporation){
        driverUtil.performOpration(txtDateOfIncorporation, "input", dateOfIncorporation, "Date of Incorporation");
    }

    public void selectApplicationType(String applicationType){
        driverUtil.performOpration(selApplicationType, "selectByVal", applicationType, "Application Type");
    }
    public void selectIndustryYourBusinessBelongTo(String industryYourBusinessBelongTo){
        driverUtil.performOpration(selIndustryYourBusinessBelongTo, "selectByVal", industryYourBusinessBelongTo, "What Industry Your Business Belong To");
    }
    public void enterRegisteredAddress(String registeredAddress){
        driverUtil.performOpration(txtRegisteredAddress, "input", registeredAddress, "Registered Address");
    }
    public void enterRegisteredCity(String registeredCity){
        driverUtil.performOpration(txtRegisteredCity, "input", registeredCity, "Registered City");
    }
    public void enterRegisteredCtry(String registeredCtry){
        driverUtil.performOpration(txtRegisteredCountry, "input", registeredCtry, "Registered Country");
    }

    public void enterRegisteredPostCode(String registeredPostCode){
        driverUtil.performOpration(txtRegisteredPostCode, "input", registeredPostCode, "Registered Postcode");
    }
    public void enterTradingAddress(String tradingAddress){
        driverUtil.performOpration(txtTradingAddress, "input", tradingAddress, "Trading Address");
    }
    public void enterTradingCity(String tradingCity){
        driverUtil.performOpration(TxtTradingCity, "input", tradingCity, "Trading City");
    }
    public void enterTradingCtry(String tradingCtry){
        driverUtil.performOpration(txtTradingCountry, "input", tradingCtry, "Trading Country");
    }
    public void enterTradingPostCode(String postCode){
        driverUtil.performOpration(txtTradingPostCode, "input", postCode, "Trading Postcode");
    }

    public void enterTotalNoOfProperties(String totalNoOfProperties){
        driverUtil.performOpration(txtTotalNoOfProperties, "input", totalNoOfProperties, "Total No. of Properties");
    }
    public void enterEstimatedPortfolioValue(String estimatedPortfolioValue){
        driverUtil.performOpration(txtEstimatedPortfolioValue, "input", estimatedPortfolioValue, "Estimated Portfolio Value (£)");
    }
    public void enterTotalOutstandingMortgageBalance(String totalOutstandingMortgageBalance){
        driverUtil.performOpration(txtTotalOutstandingMortgageBalance, "input", totalOutstandingMortgageBalance, "Total Outstanding Mortgage Balance (£)");
    }
    public void enterTotalMontlyRentalIncome(String totalMontlyRentalIncome){
        driverUtil.performOpration(txtTotalMontlyRentalIncome, "input", totalMontlyRentalIncome, "Total Monthly Rental Income (£)");
    }
    public void enterTotalMonthlyMortgagePayment(String totalMonthlyMortgagePayment){
        driverUtil.performOpration(txtTotalMonthlyMortgagePayment, "input", totalMonthlyMortgagePayment, "Total Monthly Mortgage Payment (£)");
    }
    public void clickNext(){
        new CommonUtil().clickNext();
    }

    public void clickSaveAndComeBackLater(){
        new CommonUtil().clickSaveAndComeBackLater();
    }

    public void clickMakeADifferentSelection(){
        driverUtil.clickAnElement(btnMakeADifferentSelection, "Make a Different Selection");
    }

    public void enterYourBusiness(dataManager.YourBusiness yourBusiness){
        new JSWaiter().waitAllRequest();
        enterLegalBusinessName(yourBusiness.getLegalBusinessName());
        enterCRN(yourBusiness.getCrn());
        enterDateOfIncorporation(yourBusiness.getDateOfIncorporation());
        selectApplicationType(yourBusiness.getApplicationType());
        selectIndustryYourBusinessBelongTo(yourBusiness.getIndustryYourBusinessBelongTo());
        //Where is your business located?
        enterRegisteredAddress(yourBusiness.getRegAddress());
        enterRegisteredCity(yourBusiness.getRegCity());
        enterRegisteredCtry(yourBusiness.getRegCntry());
        enterRegisteredPostCode(yourBusiness.getRegPostCode());
        enterTradingAddress(yourBusiness.getTradingAddress());
        enterTradingCity(yourBusiness.getTradingCity());
        enterTradingCtry(yourBusiness.getTradingCntry());
        enterTradingPostCode(yourBusiness.getTradingPostCode());
        enterTotalNoOfProperties(yourBusiness.getTotalNoOfProperties());
        enterEstimatedPortfolioValue(yourBusiness.getEstimatedPortfolioValue());
        enterTotalOutstandingMortgageBalance(yourBusiness.getTotalOutstandingMortgageBalance());
        enterTotalMontlyRentalIncome(yourBusiness.getTotalMontlyRentalIncome());
        enterTotalMonthlyMortgagePayment(yourBusiness.getTotalMonthlyMortgagePayment());

    }

    public void enterYourBusinessAndContinue(dataManager.YourBusiness yourBusiness){
        enterYourBusiness(yourBusiness);
        clickNext();
    }
}
