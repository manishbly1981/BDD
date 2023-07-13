package customerPortalPages;

import util.DriverUtil;
import org.openqa.selenium.*;

public class PersonalInfo {
    private DriverUtil driverUtil;
    public PersonalInfo (){
        driverUtil= new DriverUtil();
    }

    By txtRole= By.xpath("//label[contains(text(),'Role')]/..//input");
    By txtTitle= By.xpath("//label[contains(text(),'Title')]/..//input");
    By txtDateOfAppointment= By.xpath("//label[contains(text(),'Date of Appointment')]/..//input");
    By chkShareholding20OrGreater= By.xpath("//label[contains(text(),'Shareholding 20% or greater')]/..//input");
    By chkShareholding20OrGreaterInteractible= By.xpath("//label[contains(text(),'Shareholding 20% or greater')]/..//span");
    By txtPercentShare= By.xpath("//label[contains(text(),'% Share')]/..//input");
    By selNationality= By.xpath("//label[contains(text(),'Nationality')]/..//Select");
    By selMaritialStatus= By.xpath("//label[contains(text(),'Marital Status')]/..//Select");
    By txtDob= By.xpath("//label[contains(text(),'DOB')]/..//input");
    By txtNINumber= By.xpath("//label[contains(text(),'NI Number')]/..//input");

    /***************************************Fields are added in application as on 3rd Jun, 19 start*******************************************/
    By selPermanentRightToResideInsideUK=By.xpath("//label[contains(text(),'Permanent Rights to Reside in the UK')]/..//select");
    By chkFromBirth= By.xpath("//label[contains(text(),'From Birth')]/..//input");
    By chkFromBirthInteractible= By.xpath("//label[contains(text(),'From Birth')]/..//span");
    By txtLengthOfResidencyYears= By.xpath("//label[contains(text(),'Length of Residency (years)')]/..//input");
    By txtLengthOfResidencyMonths= By.xpath("//label[contains(text(),'Length of Residency (months)')]/..//input");
    By txtPreviousTitle= By.xpath("//label[contains(text(),'Previous Title')]/..//input");
    By txtPreviousFirstName= By.xpath("//label[contains(text(),'Previous First Name')]/..//input");
    By txtPreviousMiddleName= By.xpath("//label[contains(text(),'Previous Middle Name')]/..//input");
    By txtPreviousLastName= By.xpath("//label[contains(text(),'Previous Last Name')]/..//input");

    /***************************************Fields are added in application as on 3rd Jun, 19 end**********************************************/
    By txtHomePhone= By.xpath("//label[contains(text(),'Home Phone')]/..//input");
    By txtMbNo= By.xpath("//label[contains(text(),'Mobile Phone')]/..//input");// Label change in application as on 3rd Jun, 19
    /***************************************Fields are added in application as on 3rd Jun, 19 start*******************************************/
    By selPreferredContactMethod=By.xpath("//label[contains(text(),'Preferred Contact Method')]/..//select");
    /***************************************Fields are added in application as on 3rd Jun, 19 end**********************************************/
    /***************************************Fields are removed in application as on 3rd Jun, 19 start*******************************************/
//    By txtMailingStreet= By.xpath("//label[contains(text(),'Mailing Street')]/..//input");
//    By txtCity= By.xpath("//label[contains(text(),'City')]/..//input");
//    By txtCntry= By.xpath("//label[contains(text(),'County')]/..//input");
//    By txtPostCode=By.xpath("//label[contains(text(),'Postcode')]/..//input");
    /***************************************Fields are removed in application as on 3rd Jun, 19 end**********************************************/
    By selMarketingPreference=By.xpath("//label[contains(text(),'Marketing Preference')]/..//select");

    By chkByEmail= By.xpath("//label[contains(text(),'By email')]/..//input");
    By chkByEmailInteractible= By.xpath("//label[contains(text(),'By email')]/..//span");
    By chkByTelephone= By.xpath("//label[contains(text(),'By telephone')]/..//input");
    By chkByTelephoneInteractible= By.xpath("//label[contains(text(),'By telephone')]/..//span");
    By chkBySms= By.xpath("//label[contains(text(),'By SMS')]/..//input");
    By chkBySmsInteractible= By.xpath("//label[contains(text(),'By SMS')]/..//span");
    By btnViewAndAccept=By.xpath("//button[contains(text(),'View and Accept')]");


    public void enterRole(String role){
        driverUtil.performOpration(txtRole, "input", role, "Role");
    }
    public void enterTitle(String title){
        driverUtil.performOpration(txtTitle, "input", title, "Title");
    }
    public void enterDateOfAppointment(String dateOfappointment){
        driverUtil.performOpration(txtDateOfAppointment, "input", dateOfappointment, "Date of Appointment");
    }
    public void setShareholding20OrGreater(String checkedStatus){
        driverUtil.performOpration(chkShareholding20OrGreater, chkShareholding20OrGreaterInteractible, "checkbox", checkedStatus, "Shareholding 20% or greater");
    }

    public void enterPercentShare(String percentShare){
        driverUtil.performOpration(txtPercentShare, "input", percentShare, "% Share");
    }

    public void selectNationality(String nationality){
        driverUtil.performOpration(selNationality, "selectByVal", nationality, "Nationality");
    }
    public void selectMaritialStatus(String maritalStatus){
        driverUtil.performOpration(selMaritialStatus, "selectByVal", maritalStatus, "Marital Status");
    }
    public void enterDOB(String dob){
        driverUtil.performOpration(txtDob, "input", dob, "DOB");
    }
    public void enterNINumber(String niNumber){
        driverUtil.performOpration(txtNINumber, "input", niNumber, "NI Number");
    }
    /***************************************Fields are added in application as on 3rd Jun, 19 start*******************************************/
    public void selectPermanentRightToResideInsideUK(String permanentRightToResideInsideUK){
        driverUtil.performOpration(selPermanentRightToResideInsideUK,  "selectByVal", permanentRightToResideInsideUK, "Permanent Right to Reside in the UK");
    }

    public void setFromBirth(String checked){
        driverUtil.performOpration(chkFromBirth, chkFromBirthInteractible, "checkbox", checked, "From Birth");
    }
    public void enterLengthOfResidencyYears(String years){
        driverUtil.performOpration(txtLengthOfResidencyYears, "input", years, "Length of Residency (years)");
    }
    public void enterLengthOfResidencyMonths(String months){
        driverUtil.performOpration(txtLengthOfResidencyMonths, "input", months, "Length of Residency (months)");
    }

    public void enterPreviousTitle(String title){
        driverUtil.performOpration(txtPreviousTitle, "input", title, "Previous title");
    }

    public void enterPreviousFirstName(String firstName){
        driverUtil.performOpration(txtPreviousFirstName, "input", firstName, "Previous First Name");
    }

    public void enterPreviousMiddleName(String middleName){
        driverUtil.performOpration(txtPreviousMiddleName, "input", middleName, "Previous Middle Name");
    }

    public void enterPreviousLastName(String lastName){
        driverUtil.performOpration(txtPreviousLastName, "input", lastName, "Previous Last Name");
    }

    public void selectPreferredContactMethod(String preferredContactMethod){
        driverUtil.performOpration(selPreferredContactMethod, "selectByVal", preferredContactMethod, "Preferred Contact Method");
    }
    /***************************************Fields are added in application as on 3rd Jun, 19 End*******************************************/



    public void enterHomePhone(String homePhone){
        driverUtil.performOpration(txtHomePhone, "input", homePhone, "Home Phone");
    }
    public void enterMbNo(String mbNo){
        driverUtil.performOpration(txtMbNo, "input", mbNo, "Mobile Phone Number");
    }
//    public void enterMailingStreet(String mailingStreet){
//        driverUtil.performOpration(txtMailingStreet, "input", mailingStreet, "Mailing Street");
//    }
//    public void enterCity(String city){
//        driverUtil.performOpration(txtCity, "input", city, "City");
//    }
//    public void enterCountry(String country){
//        driverUtil.performOpration(txtCntry, "input", country, "County");
//    }
//    public void enterPostCode(String postCode){
//        driverUtil.performOpration(txtPostCode, "input", postCode, "Postcode");
//    }
    public void selectMarketingPreference(String marketingPreference){
        driverUtil.performOpration(selMarketingPreference, "selectByVal", marketingPreference, "Marketing Preference");
    }


    public void setByEmail(String checkedStatus){
        driverUtil.performOpration(chkByEmail, chkByEmailInteractible, "checkbox", checkedStatus, "By email");
    }


    public void setByTelephone(String checkedStatus){
        driverUtil.performOpration(chkByTelephone, chkByTelephoneInteractible, "checkbox", checkedStatus, "By telephone");
    }


    public void setBySms(String checkedStatus){
        driverUtil.performOpration(chkBySms, chkBySmsInteractible, "checkbox", checkedStatus, "By SMS");
    }
    public void clickViewAndAccept(){
        driverUtil.clickAnElement(btnViewAndAccept,"View and Accept");
        new CommonUtil().peformAcceptOperation1();
    }
    public void clickNext(){
        new CommonUtil().clickNext();
    }
    public void clickSaveAndComeBackLater(){
        new CommonUtil().clickSaveAndComeBackLater();
    }

    public void enterPersonalInfo(dataManager.PersonalInfo personalInfo){
//        new util.JSWaiter().waitAllRequest();
        new util.DriverUtil().explicitWait(15);
        enterRole(personalInfo.getRole());
        new util.DriverUtil().explicitWait(2);
        enterTitle(personalInfo.getTitle());
        enterDateOfAppointment(personalInfo.getDateOfAppointment());
        setShareholding20OrGreater(personalInfo.getShareholding20OrGreater());
        enterPercentShare(personalInfo.getPercentShare());
        selectNationality(personalInfo.getNationality());
        selectMaritialStatus(personalInfo.getMaritalStatus());
        enterDOB(personalInfo.getdOB());
        enterNINumber(personalInfo.getnINumber());
        //Residency Information
        selectPermanentRightToResideInsideUK(personalInfo.getPermanentRightToResideInsideUK());
        setFromBirth(personalInfo.getFromBirth());
        enterLengthOfResidencyYears(personalInfo.getLengthOfResidencyYears());
        enterLengthOfResidencyMonths(personalInfo.getLengthOfResidencyMonths());
        //Previous Name
        enterPreviousTitle(personalInfo.getPreviousTitle());
        enterPreviousFirstName(personalInfo.getPreviousFirstName());
        enterPreviousMiddleName(personalInfo.getPreviousMiddleName());
        enterPreviousLastName(personalInfo.getPreviousLastName());
        //Contact Information
        enterHomePhone(personalInfo.getHomePhone());
        enterMbNo(personalInfo.getMobileNumber());
        selectMarketingPreference(personalInfo.getMarketingPreference());
        setByEmail(personalInfo.getByEmail());
        setByTelephone(personalInfo.getByTelephone());
        setBySms(personalInfo.getBySms());
    }

    public void enterPersonalInfoAndContinue(String mortageType, dataManager.PersonalInfo personalInfo){
        if(mortageType.trim().equalsIgnoreCase(new util.PropertyUtil().getBusinessText())) {
            enterPersonalInfo(personalInfo);
            clickViewAndAccept();
            clickNext();
        }else if(mortageType.trim().equalsIgnoreCase(new util.PropertyUtil().getIndividualText())) {
            enterPersonalInfo(personalInfo);
            clickViewAndAccept();
            clickNext();
        }else{
            new util.ExceptionHandler().customizedException("Need to write the logic for the martage type: "+ mortageType);
        }
    }

//    public void peformAcceptOperation(){
//        new CommonUtil().scrollCanvas("Term and Condition");
//        new CommonUtil().clickAgree();
//    }
}
