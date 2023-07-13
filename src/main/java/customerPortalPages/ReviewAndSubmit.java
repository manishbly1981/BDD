package customerPortalPages;

import org.openqa.selenium.By;
import util.DriverUtil;
import util.PropertyUtil;
import util.StringUtil;
public class ReviewAndSubmit{
    private DriverUtil driverUtil;
    public ReviewAndSubmit (){
        driverUtil= new DriverUtil();
    }
    //Eligibility
    By lblLoanAmount= By.xpath("//span[contains(text(),'Loan Amount')]/../div");
    By lblLoanPurpose= By.xpath("//span[contains(text(),'Loan Purpose')]/../div");
    By lblLoanTermMonths= By.xpath("//span[contains(text(),'Loan Term (Months)')]/../div");
    By lblRepaymentTypes= By.xpath("//span[contains(text(),'Repayment Types')]/../div");
    By lblAmortizedTermMonths= By.xpath("//span[contains(text(),'Amortized Term (Months)')]/../div");
    By lblCaptialRepaymentHolidayMonths= By.xpath("//span[contains(text(),'Capital Repayment Holiday (Months)')]/../div");

    //Business Info
    By lblClientName= By.xpath("//span[contains(text(),'Client Name')]/../div");
    By lblCRN= By.xpath("//span[contains(text(),'CRN')]/../div");
    By lblDateOfIncorporation= By.xpath("//span[contains(text(),'Date of Incorporation')]/../div");
    By lblClientType= By.xpath("//span[contains(text(),'Client Type')]/../div");
    By lblIndsutry= By.xpath("//span[contains(text(),'Industry')]/../div");
    By lblBillingAddress= By.xpath("//span[contains(text(),'Billing Address')]/../div");
    By lblShippingAddress= By.xpath("//span[contains(text(),'Shipping Address')]/../div");

    //New Fields are added on 3rd June, 19
    By lblTotalNoOfProperties=By.xpath("//span[contains(text(),'Total No. of Properties')]/../div");
    By lblEstimatedPortfolioValue=By.xpath("//span[contains(text(),'Estimated Portfolio Value (£)')]/../div");
    By lblTotalOutStandingMortgageBalance=By.xpath("//span[contains(text(),'Total Outstanding Mortgage Balance (£)')]/../div");
    By lblTotalMonthlyRentalIncome=By.xpath("//span[contains(text(),'Total Monthly Rental Income (£)')]/../div");
    By lblTotalMonthlyMortgagePayment=By.xpath("//span[contains(text(),'Total Monthly Mortgage Payment (£)')]/../div");

    //Personal Info
    By lblRole= By.xpath("//span[contains(text(),'Role')]/../div");
    By lblTitle= By.xpath("//span[contains(text(),'Title')]/../div");
    By lblDateOfAppointment= By.xpath("//span[contains(text(),'Date of Appointment')]/../div");
    By chkShareholding20OrGreater=By.xpath("//span[contains(text(),'Shareholding 20% or greater')]/../div//input");
    By lblPercentShare= By.xpath("//span[contains(text(),'% Share')]/../div");
    By lblNationality= By.xpath("//span[contains(text(),'Nationality')]/../div");
    By lblMaritalStatus= By.xpath("//span[contains(text(),'Marital Status')]/../div");
    By lblDOB= By.xpath("//span[contains(text(),'DOB')]/../div");
    By lblNINumber= By.xpath("//span[contains(text(),'NI Number')]/../div");
    By lblPermanentRightsToResideInTheUK= By.xpath("//span[contains(text(),'Permanent Rights to Reside in the UK')]/../div");
    By chkFromBirth= By.xpath("//span[contains(text(),'From Birth')]/../div//input");
    By lblLengthOfResidencyYears= By.xpath("//span[contains(text(),'Length of Residency (years)')]/../div");
    By lblLengthOfResidencyMonths= By.xpath("//span[contains(text(),'Length of Residency (months)')]/../div");
    By lblPreviousTitle= By.xpath("//span[contains(text(),'Previous Title')]/../div");
    By lblPreviousFirstName= By.xpath("//span[contains(text(),'Previous First Name')]/../div");
    By lblPreviousMiddleName= By.xpath("//span[contains(text(),'Previous Middle Name')]/../div");
    By lblPreviousLastName= By.xpath("//span[contains(text(),'Previous Last Name')]/../div");

    By lblHomePhone= By.xpath("//span[contains(text(),'Home Phone')]/../div");
    By lblMobileNumber= By.xpath("//span[contains(text(),'Mobile Phone')]/../div");
    By lblMarketingPreference= By.xpath("//span[contains(text(),'Marketing Preference')]/../div");
    By chkByEmail= By.xpath("//span[contains(text(),'By email')]/../div//input");
    By chkByTelephone= By.xpath("//span[contains(text(),'By telephone')]/../div//input");
    By chkBySms= By.xpath("//span[contains(text(),'By SMS')]/../div//input");

    //Personal Continued
    By lblResidentialStatus= By.xpath("//span[contains(text(),'Residential Status')]/../div");
    By lblMailingAddress= By.xpath("//span[contains(text(),'Mailing Address')]/../div");
    By lblPreviousStreet= By.xpath("//span[contains(text(),'Previous Street')]/../div");
    By lblPreviousCity= By.xpath("//span[contains(text(),'Previous City')]/../div");
    By lblPreviousCountry= By.xpath("//span[contains(text(),'Previous County')]/../div");
    By lblPreviousPostalCode= By.xpath("//span[contains(text(),'Previous Postal Code')]/../div");

    //Collateral
//    By lblSecurityName= By.xpath("//span[contains(text(),'Security Name')]/../div");
    By lblEstimatedvalue= By.xpath("//span[contains(text(),'Estimated Value')]/../div");
    By lblPurchasePrice= By.xpath("//span[contains(text(),'Purchase Price')]/../div");
    By lblLocation= By.xpath("//span[contains(text(),'Location')]/../div");
    By lblCountry= By.xpath("//h4[contains(text(),'Collateral')]/..//span[contains(text(),'County')]/../div");
//    By lblPropertyType= By.xpath("//span[contains(text(),'Property Type')]/../div");
//    By lblYearBuilt= By.xpath("//span[contains(text(),'Year Built')]/../div");
//    By lblCondition= By.xpath("//span[contains(text(),'Condtion')]/../div");
//    By lblTenure= By.xpath("//span[contains(text(),'Tenure')]/../div");
    By lblAddress= By.xpath("//span[starts-with(text(),'Address')]/../div");

    //    Others Involved
    By lblBorrowerRoleOnLoan=By.xpath("(//span[@ng-bind='::other.borrowerType'])[1]");
    By lblBorrowerName= By.xpath("(//span[@ng-bind='::other.borrowerType'])[1]/..//Div");

//    By btnPrivacyPolicy_ViewAndAccept= By.xpath("//a[contains(text(),'Privacy Policy')]/../../..//button[contains(text(),'View and Accept')]");
//    By btnTermAndCondition_ViewAndAccept= By.xpath("//a[contains(text(),'Terms and Conditions')]/../../..//button[contains(text(),'View and Accept')]");

    By btnPrivacyPolicy_ViewAndAccept= By.xpath("(//button[contains(text(),'View and Accept')])[1]");
    By btnTermAndCondition_ViewAndAccept= By.xpath("(//button[contains(text(),'View and Accept')])[2]");

    By btnSubmitApplication= By.xpath("//button[contains(text(),'Submit Application')]");

    //Eligibility
    public void verifyLoanAmount(String expectedAmount){
        driverUtil.verifyValue(lblLoanAmount,"verifyText",expectedAmount,"Loan Amount");
    }
    public void verifyLoanPurpose(String expectedLoanPurpose){
        driverUtil.verifyValue(lblLoanPurpose,"verifyText",expectedLoanPurpose,"Loan Purpose");
    }
    public void verifyLoanTermMonths(String expectedLoanTermMonths){
        driverUtil.verifyValue(lblLoanTermMonths,"verifyText",expectedLoanTermMonths,"Loan Term (Months)");
    }
    public void verifyRepaymentTypes(String expectedRepaymentTypes){
        driverUtil.verifyValue(lblRepaymentTypes,"verifyText",expectedRepaymentTypes,"Repayment Types");
    }

    public void verifyAmortizedTermMonths(String expectedAmortizedTermMonths){
        driverUtil.verifyValue(lblAmortizedTermMonths,"verifyText",expectedAmortizedTermMonths,"Amortized Term (Months)");
    }

    public void verifyCaptialRepaymentHolidayMonths(String expectedCaptialRepaymentHolidayMonths){
        driverUtil.verifyValue(lblCaptialRepaymentHolidayMonths,"verifyText",expectedCaptialRepaymentHolidayMonths,"Capital Repayment Holiday (Months)");
    }

    //Business Info
    public void verifyClientName(String expectedClientName){
        driverUtil.verifyValue(lblClientName,"verifyText",expectedClientName,"Client Name");
    }
    public void verifyCRN(String expectedCRN){
        driverUtil.verifyValue(lblCRN,"verifyText",expectedCRN,"CRN");
    }

    public void verifyDateOfIncorporation(String expectedDateOfIncorporation){
        driverUtil.verifyValue(lblDateOfIncorporation,"verifyText",expectedDateOfIncorporation,"Date of Incorporation");
    }
    public void verifyClientType(String expectedClientType){
        driverUtil.verifyValue(lblClientType,"verifyText",expectedClientType,"Client Type");
    }
    public void verifyIndsutry(String expectedIndsutry){
        driverUtil.verifyValue(lblIndsutry,"verifyText",expectedIndsutry,"Indsutry");
    }
    public void verifyBillingAddress(String expectedBillingAddress){
        driverUtil.verifyValue(lblBillingAddress,"verifyText",expectedBillingAddress,"Billing Address");
    }
    public void verifyShippingAddress(String expectedShippingAddress){
        driverUtil.verifyValue(lblShippingAddress,"verifyText",expectedShippingAddress,"Shipping Address");
    }
    public void verifyTotalNoOfProperties(String noOfProperties){
        driverUtil.verifyValue(lblTotalNoOfProperties,"verifyText",noOfProperties,"Total No. of Properties");
    }
    public void verifyEstimatedPortfolioValue(String estimatedPortfolioValue){
        driverUtil.verifyValue(lblEstimatedPortfolioValue,"verifyText",estimatedPortfolioValue,"Estimated Portfolio Value (£)");
    }
    public void verifyTotalOutstandingMortgageBalance(String totalOutstandingMortgageBalance){
        driverUtil.verifyValue(lblTotalOutStandingMortgageBalance,"verifyText",totalOutstandingMortgageBalance,"Total Outstanding Mortgage Balance (£)");
    }
    public void verifyTotalMonthlyRentalIncome(String totalMonthlyRentalIncome){
        driverUtil.verifyValue(lblTotalMonthlyRentalIncome,"verifyText",totalMonthlyRentalIncome,"Total Monthly Rental Income (£)");
    }
    public void verifyTotalMontlyMortgagePayment(String totalMonthlyMortgagePayment){
        driverUtil.verifyValue(lblTotalMonthlyMortgagePayment,"verifyText",totalMonthlyMortgagePayment,"Total Monthly Mortgage Payment (£)");
    }

    //Personal Info
    public void verifyRole(String expectedRole){
        driverUtil.verifyValue(lblRole,"verifyText",expectedRole,"Role");
    }

    public void verifyTitle(String expectedTitle){
        driverUtil.verifyValue(lblTitle,"verifyText",expectedTitle,"Title");
    }
    public void verifyDateOfAppointment(String expectedDateOfAppointment){
        driverUtil.verifyValue(lblDateOfAppointment,"verifyText",expectedDateOfAppointment,"Date of Appointment");
    }

    public void verifyShareholding20OrGreater(String expectedShareholding20OrGreater){
        driverUtil.verifyValue(chkShareholding20OrGreater,"verifyChkBox", expectedShareholding20OrGreater,"Shareholding 20% or greater");
    }

    public void verifyPercentShare(String expectedPercentShare){
        driverUtil.verifyValue(lblPercentShare,"verifyText", new StringUtil().getPercentSharePattern(expectedPercentShare),"Percent Share");
    }
    public void verifyNationality(String expectedNationality){
        driverUtil.verifyValue(lblNationality,"verifyText",expectedNationality,"Nationality");
    }
    public void verifyMaritalStatus(String expectedMaritalStatus){
        driverUtil.verifyValue(lblMaritalStatus,"verifyText",expectedMaritalStatus,"MaritalStatus");
    }
    public void verifyDOB(String expectedDOB){
        driverUtil.verifyValue(lblDOB,"verifyText",expectedDOB,"DOB");
    }

    public void verifyNINumber(String expectedNINumber){
        driverUtil.verifyValue(lblNINumber,"verifyText",expectedNINumber,"NI Number");
    }

    public void verifyPermanentRightToResideInUK(String expectedPermanentRightToResideInUK){
        driverUtil.verifyValue(lblPermanentRightsToResideInTheUK,"verifyText",expectedPermanentRightToResideInUK,"Permanent Right to Reside in UK");
    }

    public void verifyFromBirth(String expectedFromBirth){
        driverUtil.verifyValue(chkFromBirth,"verifyChkBox", expectedFromBirth,"From Birth");
    }

    public void verifyLengthOfResidencyYears(String expectedLengthOfResidencyYears){
        driverUtil.verifyValue(lblLengthOfResidencyYears,"verifyText",expectedLengthOfResidencyYears,"Length of Residency (years)");
    }
    public void verifyLengthOfResidencyMonths(String expectedLengthOfResidencyMonths){
        driverUtil.verifyValue(lblLengthOfResidencyMonths,"verifyText",expectedLengthOfResidencyMonths,"Length of Residency (months)");
    }
    public void verifyPreviousTitle(String expectedPreviousTitle){
        driverUtil.verifyValue(lblPreviousTitle,"verifyText",expectedPreviousTitle,"Previous Title");
    }
    public void verifyPreviousFirstName(String expectedPreviousFirstName){
        driverUtil.verifyValue(lblPreviousFirstName,"verifyText",expectedPreviousFirstName,"Previous First Name");
    }
    public void verifyPreviousMiddleName(String expectedPreviousMiddleName){
        driverUtil.verifyValue(lblPreviousMiddleName,"verifyText",expectedPreviousMiddleName,"Previous Middle Name");
    }
    public void verifyPreviousLastName(String expectedPreviousLastName){
        driverUtil.verifyValue(lblPreviousLastName,"verifyText",expectedPreviousLastName,"Previous Last Name");
    }

    public void verifyHomePhone(String expectedHomePhone){
        driverUtil.verifyValue(lblHomePhone,"verifyText",expectedHomePhone,"HomePhone");
    }

    public void verifyMobileNumber(String expectedMobileNumber){
        driverUtil.verifyValue(lblMobileNumber,"verifyText",expectedMobileNumber,"Mobile Number");
    }


    public void verifyMarketingPreference(String expectedMarketingPreference){
        driverUtil.verifyValue(lblMarketingPreference,"verifyText",expectedMarketingPreference,"Marketing Preference");
    }

    public void verifyByEmail(String expectedByEmail){
        driverUtil.verifyValue(chkByEmail,"verifyChkBox", expectedByEmail,"By Email");
    }

    public void verifyByTelephone(String expectedByTelephone){
        driverUtil.verifyValue(chkByTelephone,"verifyChkBox", expectedByTelephone,"By Telephone");
    }

    public void verifyBySms(String expectedBySms){
        driverUtil.verifyValue(chkBySms,"verifyChkBox", expectedBySms,"By SMS");
    }

    public void verifyResidentialStatus(String expectedResidentialStatus){
        driverUtil.verifyValue(lblResidentialStatus,"verifyText",expectedResidentialStatus,"Residential Status");
    }

    public void verifyMailingAddress(String expectedMailingAddress){
        driverUtil.verifyValue(lblMailingAddress,"verifyText",expectedMailingAddress,"Mailing Address");
    }

    public void verifyPreviousStreet(String expectedPreviousStreet){
        driverUtil.verifyValue(lblPreviousStreet,"verifyText",expectedPreviousStreet,"Previous Street");
    }
    public void verifyPreviousCity(String expectedPreviousCity){
        driverUtil.verifyValue(lblPreviousCity,"verifyText",expectedPreviousCity,"Previous City");
    }
    public void verifyPreviousCountry(String expectedPreviousCountry){
        driverUtil.verifyValue(lblPreviousCountry,"verifyText",expectedPreviousCountry,"Previous Country");
    }
    public void verifyPreviousPostalCode(String expectedPreviousPostalCode){
        driverUtil.verifyValue(lblPreviousPostalCode,"verifyText",expectedPreviousPostalCode,"Previous Postal Code");
    }

    public void verifyEstimatedvalue(String expectedEstimatedvalue){
        driverUtil.verifyValue(lblEstimatedvalue,"verifyText",expectedEstimatedvalue,"Esitmated Value");
    }

    public void verifyPurchasePrice(String expectedPurchasePrice){
        driverUtil.verifyValue(lblPurchasePrice,"verifyText",expectedPurchasePrice,"PurchasePrice");
    }

    public void verifyLocation(String expectedLocation){
        driverUtil.verifyValue(lblLocation,"verifyText",expectedLocation,"Location");
    }

    public void verifyCountry(String expectedCountry){
        driverUtil.verifyValue(lblCountry,"verifyText",expectedCountry,"Country");
    }

    public void verifyAddress(String expectedAddress){
        driverUtil.verifyValue(lblAddress,"verifyText",expectedAddress,"Address");
    }

    public void verifyBorrowerRoleOnLoan(String expectedBorrowerRoleOnLoan){
        driverUtil.verifyValue(lblBorrowerRoleOnLoan,"verifyText",expectedBorrowerRoleOnLoan,"Borrower Role on Loan");
    }

    public void verifyBorrowerName(String expectedBorrowerName){
        driverUtil.verifyValue(lblBorrowerName,"verifyText",expectedBorrowerName,"Borrower Name");
    }

    public void clickPrivacyPolicy_ViewAndAccept(){
        driverUtil.clickAnElement(btnPrivacyPolicy_ViewAndAccept,"Privacy Policy: View and Accept button");
        new CommonUtil().peformAcceptOperation1();
    }

    public void clickTermAndCondition_ViewAndAccept(){
        driverUtil.clickAnElement(btnTermAndCondition_ViewAndAccept,"Term and Conditions: View and Accept button");
        new CommonUtil().peformAcceptOperation2();
    }

    public void clickSubmitApplication(){
        driverUtil.clickAnElement(btnSubmitApplication, "Submit button ");
    }

    public void reviewDetails(String mortageType, dataManager.ReviewAndSubmit testData){
        PropertyUtil propertyUtil= new PropertyUtil();
        StringUtil stringUtil= new StringUtil();

        //Eligibility
        verifyLoanAmount(stringUtil.returnCurrency(testData.getLoanAmount()));
        verifyLoanPurpose(testData.getLoanPurpose());
        verifyLoanTermMonths(testData.getLoanTermMonths());
        verifyRepaymentTypes(testData.getRepaymentTypes());
        verifyAmortizedTermMonths(testData.getAmortizedTermMonths());
        verifyCaptialRepaymentHolidayMonths(testData.getCaptialRepaymentHolidayMonths());

        //Business Info
        verifyClientName(testData.getLegalBusinessName());
        verifyCRN(testData.getcRN());
        verifyDateOfIncorporation(testData.getDateOfIncorporation());
        verifyClientType(testData.getApplicationType());
        verifyIndsutry(testData.getIndustryDoesBusinessBelongTo());

        String billingAddress=testData.getRegAddress() + " " + testData.getRegCity() + ", " + testData.getRegCntry() + " " + testData.getRegPostCode();
        verifyBillingAddress(billingAddress);
        String shippingAddress=testData.getTradingAddress()+ " " + testData.getTradingCity()+ ", " + testData.getTradingCntry()+ " " + testData.getTradingPostCode();
        verifyShippingAddress(shippingAddress);
        verifyTotalNoOfProperties(testData.getTotalNoOfProperties());
        verifyEstimatedPortfolioValue(stringUtil.returnCurrency(testData.getEstimatedPortfolioValue()));
        verifyTotalOutstandingMortgageBalance(stringUtil.returnCurrency(testData.getTotalOutstandingMortgageBalance()));
        verifyTotalMonthlyRentalIncome(stringUtil.returnCurrency(testData.getTotalMontlyRentalIncome()));
        verifyTotalMontlyMortgagePayment(stringUtil.returnCurrency(testData.getTotalMonthlyMortgagePayment()));

        //Personal Info
        verifyRole(testData.getRole());
        verifyTitle(testData.getTitle());
        verifyDateOfAppointment(testData.getDateOfAppointment());
        verifyShareholding20OrGreater(testData.getShareholding20OrGreater());
        verifyPercentShare(testData.getPercentShare());
        verifyNationality(testData.getNationality());
        verifyMaritalStatus(testData.getMaritalStatus());
        verifyDOB(testData.getdOB());
        verifyNINumber(testData.getnINumber());
        verifyPermanentRightToResideInUK(testData.getPermanentRightToResideInsideUK());
        verifyFromBirth(testData.getFromBirth());
        verifyLengthOfResidencyYears(testData.getLengthOfResidencyYears());
        verifyLengthOfResidencyMonths(testData.getLengthOfResidencyMonths());
        verifyPreviousTitle(testData.getPreviousTitle());
        verifyPreviousFirstName(testData.getPreviousFirstName());
        verifyPreviousMiddleName(testData.getPreviousMiddleName());
        verifyPreviousLastName(testData.getPreviousLastName());
        verifyHomePhone(testData.getHomePhone());
        verifyMobileNumber(testData.getMobileNumber());
        verifyMarketingPreference(testData.getMarketingPreference());
        verifyByEmail(testData.getByEmail());
        verifyByTelephone(testData.getByTelephone());
        verifyBySms(testData.getBySms());

        //Personal Continued
        verifyResidentialStatus(testData.getResidentialStatus());
        String mailingAddress=testData.getMailingStreet() + " " + testData.getCity() + ", " + testData.getCountry()+ " " + testData.getPostCode();
        verifyMailingAddress(mailingAddress);
        verifyPreviousStreet(testData.getPreviousStreet());
        verifyPreviousCity(testData.getPreviousCity());
        verifyPreviousCountry(testData.getPreviousCountry());
        verifyPreviousPostalCode(testData.getPreviousPostCode());

        //Security
        verifyEstimatedvalue(stringUtil.returnCurrency(testData.getSecurityEstimatedValue()));
        verifyPurchasePrice(stringUtil.returnCurrency(testData.getSecurityPurchasePrice()));
        verifyLocation(testData.getSecurityLocation());
        verifyCountry(testData.getSecurityCountry());
        String securityAddress= testData.getSecurityStreetAddress() +" " + testData.getSecurityCity()+ " " + testData.getSecurityPostCode();
        verifyAddress(securityAddress);

        //VerifyBorrower Information
        verifyBorrowerRoleOnLoan(testData.getBorrowerRoleOnLoan());
        verifyBorrowerName(testData.getBorrowerFirstName() + " "+ testData.getBorrowerLastName());

        clickPrivacyPolicy_ViewAndAccept();
        clickTermAndCondition_ViewAndAccept();
    }
    public void SubmitTheApplication(){

        clickSubmitApplication();
    }
}


//if(mortageType.trim().equalsIgnoreCase(new util.PropertyUtil().getBusinessText())) {
//        }else if(mortageType.trim().equalsIgnoreCase(new util.PropertyUtil().getIndividualText())) {
//        }else{
//        new util.ExceptionHandler().customizedException("Need to write the logic for the martage type: "+ mortageType);
//        }