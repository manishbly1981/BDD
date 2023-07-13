package dataManager;

public class Eligibility {
    private String loanAmount;
    private String loanPurpose;

    public String getLoanTermMonths() {
        return loanTermMonths;
    }

    public void setLoanTermMonths(String loanTermMonths) {
        this.loanTermMonths = loanTermMonths;
    }

    private String loanTermMonths;
    private String repaymentTypes;
    private String amortizedTermMonths;
    private String captialRepaymentHolidayMonths;

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }



    public String getRepaymentTypes() {
        return repaymentTypes;
    }

    public void setRepaymentTypes(String repaymentTypes) {
        this.repaymentTypes = repaymentTypes;
    }

    public String getAmortizedTermMonths() {
        return amortizedTermMonths;
    }

    public void setAmortizedTermMonths(String amortizedTermMonths) {
        this.amortizedTermMonths = amortizedTermMonths;
    }

    public String getCaptialRepaymentHolidayMonths() {
        return captialRepaymentHolidayMonths;
    }

    public void setCaptialRepaymentHolidayMonths(String captialRepaymentHolidayMonths) {
        this.captialRepaymentHolidayMonths = captialRepaymentHolidayMonths;
    }
}
