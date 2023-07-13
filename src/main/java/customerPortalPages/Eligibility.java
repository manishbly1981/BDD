package customerPortalPages;

import cucumber.api.DataTable;
import util.DriverUtil;
import org.openqa.selenium.By;
import util.JSWaiter;

public class Eligibility {
    private DriverUtil driverUtil;
    public Eligibility (){
        driverUtil= new DriverUtil();
    }
    By txtLoanAmount= By.xpath("//label[contains(text(),'Loan Amount')]/..//input");
    By selLoanPurpose= By.xpath("//label[contains(text(),'Loan Purpose')]/..//select");
    By txtLongTermMonths= By.xpath("//label[contains(text(),'Loan Term (Months)')]/..//input");
    By selRepaymentTypes= By.xpath("//label[contains(text(),'Repayment Types')]/..//select");
    By txtAmortizedTermMonths= By.xpath("//label[contains(text(),'Amortized Term (Months)')]/..//input");
    By txtCaptialRepaymentHolidayMonths= By.xpath("//label[contains(text(),'Capital Repayment Holiday (Months)')]/..//input");



    public void enterLoanAmount(String loanAmount){
        driverUtil.performOpration(txtLoanAmount, "input", loanAmount, "Loan Amount");
    }

    public void selectLoanPurpose(String loanPurpose){
        driverUtil.performOpration(selLoanPurpose, "selectByVal", loanPurpose, "Loan Purpose");
    }

    public void enterLongTermMonths(String longTermMonths){
        driverUtil.performOpration(txtLongTermMonths, "input", longTermMonths, "Long Term (Months)");
    }

    public void selectRepaymentTypes(String repaymentTypes){
        driverUtil.performOpration(selRepaymentTypes, "selectByVal", repaymentTypes, "Repayment Types");
    }

    public void enterAmortizedTermMonths(String amortizedTermMonths){
        driverUtil.performOpration(txtAmortizedTermMonths, "input", amortizedTermMonths, "Amortized Term (Months)");
    }

    public void enterCaptialRepaymentHolidayMonths(String captialRepaymentHolidayMonths){
        driverUtil.performOpration(txtCaptialRepaymentHolidayMonths, "input", captialRepaymentHolidayMonths, "Captial Repayment Holiday (Months)");
    }

    public void clickNext(){
        new CommonUtil().clickNext();
    }

    public void clickSaveAndComeBackLater(){
        new CommonUtil().clickSaveAndComeBackLater();
    }

    public void enterEligibilityCriteriaForBusiness(dataManager.Eligibility eligibility){
        enterLoanAmount(eligibility.getLoanAmount());
        selectLoanPurpose(eligibility.getLoanPurpose()); //Added as on 4th June, 19
        enterLongTermMonths(eligibility.getLoanTermMonths()); //Added as on 4th June, 19
        selectRepaymentTypes(eligibility.getRepaymentTypes()); //Added as on 4th June, 19
        enterAmortizedTermMonths(eligibility.getAmortizedTermMonths()); //Added as on 4th June, 19
        enterCaptialRepaymentHolidayMonths(eligibility.getCaptialRepaymentHolidayMonths()); //Added as on 4th June, 19
    }
    public void enterEligibilityCriteriaForIndividual(dataManager.Eligibility eligibility){
        enterLoanAmount(eligibility.getLoanAmount());
        selectLoanPurpose(eligibility.getLoanPurpose()); //Added as on 4th June, 19
    }
    public void enterEligibilityCriteriaAndContinue(String mortageType, dataManager.Eligibility eligibility){
        if(mortageType.trim().equalsIgnoreCase(new util.PropertyUtil().getBusinessText())) {
            enterEligibilityCriteriaForBusiness(eligibility);
            clickNext();
        }else if(mortageType.trim().equalsIgnoreCase(new util.PropertyUtil().getIndividualText())) {
            enterEligibilityCriteriaForIndividual(eligibility);
            clickNext();
        }else{
            new util.ExceptionHandler().customizedException("Need to write the logic for the martage type: '"+ mortageType + "' for eligibility screen");
        }

    }
}
