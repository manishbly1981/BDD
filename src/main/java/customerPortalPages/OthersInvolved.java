package customerPortalPages;

import org.openqa.selenium.By;
import util.DriverUtil;
import util.JSWaiter;

public class OthersInvolved {
    private DriverUtil driverUtil;
    public OthersInvolved (){
        driverUtil= new DriverUtil();
    }

    By btnAddABorrowerOrGuarantor= By.xpath("//span[contains(text(),'Add a Borrower or Guarantor')]");
    By txtFirstName= By.xpath("//label[contains(text(),'First Name')]/..//input");
    By txtLastName= By.xpath("//label[contains(text(),'Last Name')]/..//input");
    By txtEmail= By.xpath("//label[contains(text(),'Email')]/..//input");
    By txtMbNo= By.xpath("//label[contains(text(),'Mobile Phone Number')]/..//input");
    By selRole= By.xpath("//label[contains(text(),'Role')]/..//select");
    By selRoleOnLoan= By.xpath("//label[contains(text(),'Role on Loan')]/..//select");
    By btnRemove= By.xpath("//button[contains(text(),'Remove')]");
    By btnAddAnotherBorrowerOrGuarantor= By.xpath("//span[contains(text(),'Add Another Borrower or Guarantor')]");
    By btnNext= By.xpath("(//span[contains(text(),'Next')])[2]");
    public void AddABorrowerOrGuarantor(){
        driverUtil.clickAnElement(btnAddABorrowerOrGuarantor, "Add a Borrower or Guarantor");
    }

    public void enterFirstName(String firstName){
        driverUtil.performOpration(txtFirstName,"input",firstName, "First Name");
    }
    public void enterLastName(String lastName){
        driverUtil.performOpration(txtLastName,"input",lastName, "Last Name");
    }

    public void enterEmail(String eMail){
        driverUtil.performOpration(txtEmail,"input",eMail, "Email");
    }

    public void enterMbNo(String mbNo){
        driverUtil.performOpration(txtMbNo,"input",mbNo, "Mobile Phone Number");
    }

    public void selectRole(String role){
        driverUtil.performOpration(selRole,"selectByVal",role, "Role");
    }

    public void selectRoleOnLoan(String roleOnLoan){
        driverUtil.performOpration(selRoleOnLoan,"selectByVal",roleOnLoan, "Role on Loan");
    }

    public void clickRemove(){
        driverUtil.clickAnElement(btnRemove, "Remove");
    }

    public void clickAddAnotherBorrowerOrGuarantor(){
        driverUtil.clickAnElement(btnAddAnotherBorrowerOrGuarantor, "Add Another Borrower or Guarantor");
    }

    public void clickNext(){
        driverUtil.clickAnElement(btnNext, "Next");
    }
    public void clickSaveAndComeBackLater(){
        new CommonUtil().clickSaveAndComeBackLater();
    }

    public void enterOtherInvolved(String firstName, String lastName, String eMail, String mbNo, String role, String roleOnLoan){
        new JSWaiter().waitAllRequest();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(eMail);
        enterMbNo(mbNo);
        selectRole(role);
        selectRoleOnLoan(roleOnLoan);
    }

    public void enterOtherInvolvedAndContinue(dataManager.OtherInvolved otherInvolved){
        new JSWaiter().waitAllRequest();
        String firstName=otherInvolved.getBorrowerFirstName();
        String lastName= otherInvolved.getBorrowerLastName();
        String eMail= otherInvolved.getBorrowerEMail();
        String mbNo= otherInvolved.getBorrowerMbNo();
        String role= otherInvolved.getBorrowerRole();
        String roleOnLoan= otherInvolved.getBorrowerRoleOnLoan();
        AddABorrowerOrGuarantor();
        enterOtherInvolved(firstName, lastName, eMail, mbNo, role, roleOnLoan);
        clickNext();
    }
}
