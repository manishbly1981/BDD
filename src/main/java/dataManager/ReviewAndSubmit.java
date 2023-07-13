package dataManager;

public class ReviewAndSubmit {
    private String loanType;
    //Eligibility
    private String loanAmount;
    private String loanPurpose;
    private String loanTermMonths;
    private String repaymentTypes;
    private String amortizedTermMonths;
    private String captialRepaymentHolidayMonths;

    //Business Info
    private String legalBusinessName;
    private String cRN;
    private String dateOfIncorporation;
    private String applicationType;
    private String industryDoesBusinessBelongTo;
    //...Billing Address
    private String regAddress;
    private String regCity;
    private String regCntry;
    private String regPostCode;
    //...Shipping Address
    private String tradingAddress;
    private String tradingCity;
    private String tradingCntry;
    private String tradingPostCode;

    String totalNoOfProperties;
    String estimatedPortfolioValue;
    String totalOutstandingMortgageBalance;
    String totalMontlyRentalIncome;
    String totalMonthlyMortgagePayment;

    //Personal Info
    private String role;
    private String title;
    private String dateOfAppointment;
    private String shareholding20OrGreater;
    private String percentShare;
    private String nationality;
    private String maritalStatus;
    private String dOB;
    private String nINumber;

    private String permanentRightToResideInsideUK=""; //New field added on 3rdJun, 19
    private String fromBirth=""; //New field added on 3rdJun, 19
    private String lengthOfResidencyYears=""; //New field added on 3rdJun, 19
    private String lengthOfResidencyMonths=""; //New field added on 3rdJun, 19
    private String previousTitle=""; //New field added on 3rdJun, 19
    private String previousFirstName=""; //New field added on 3rdJun, 19
    private String previousMiddleName=""; //New field added on 3rdJun, 19
    private String previousLastName=""; //New field added on 3rdJun, 19

    private String homePhone;
    private String mobileNumber;
    private String marketingPreference;
    private String byEmail;
    private String byTelephone;
    private String bySms;

    //Personal Continued
    private String residentialStatus="";

    //...Mailing Address
    private String mailingStreet="";
    private String city="";
    private String country="";
    private String postCode="";
    private String previousStreet="";
    private String previousCity="";
    private String previousCountry="";
    private String previousPostCode="";

    //Collateral
    private String securityEstimatedValue;
    private String securityPurchasePrice;
    private String securityLocation;
    private String securityCountry;
    //...Security Address
    private String securityStreetAddress;
    private String securityCity;
    private String securityPostCode;

    private String borrowerFirstName;
    private String borrowerLastName;
    private String borrowerRoleOnLoan;

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

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


    public String getLoanTermMonths() {
        return loanTermMonths;
    }

    public void setLoanTermMonths(String loanTermMonths) {
        this.loanTermMonths = loanTermMonths;
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

    public String getLegalBusinessName() {
        return legalBusinessName;
    }

    public void setLegalBusinessName(String legalBusinessName) {
        this.legalBusinessName = legalBusinessName;
    }

    public String getcRN() {
        return cRN;
    }

    public void setcRN(String cRN) {
        this.cRN = cRN;
    }

    public String getDateOfIncorporation() {
        return dateOfIncorporation;
    }

    public void setDateOfIncorporation(String dateOfIncorporation) {
        this.dateOfIncorporation = dateOfIncorporation;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getIndustryDoesBusinessBelongTo() {
        return industryDoesBusinessBelongTo;
    }

    public void setIndustryDoesBusinessBelongTo(String industryDoesBusinessBelongTo) {
        this.industryDoesBusinessBelongTo = industryDoesBusinessBelongTo;
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

    public String getRegCity() {
        return regCity;
    }

    public void setRegCity(String regCity) {
        this.regCity = regCity;
    }

    public String getRegCntry() {
        return regCntry;
    }

    public void setRegCntry(String regCntry) {
        this.regCntry = regCntry;
    }

    public String getRegPostCode() {
        return regPostCode;
    }

    public void setRegPostCode(String regPostCode) {
        this.regPostCode = regPostCode;
    }

    public String getTradingAddress() {
        return tradingAddress;
    }

    public void setTradingAddress(String tradingAddress) {
        this.tradingAddress = tradingAddress;
    }

    public String getTradingCity() {
        return tradingCity;
    }

    public void setTradingCity(String tradingCity) {
        this.tradingCity = tradingCity;
    }

    public String getTradingCntry() {
        return tradingCntry;
    }

    public void setTradingCntry(String tradingCntry) {
        this.tradingCntry = tradingCntry;
    }

    public String getTradingPostCode() {
        return tradingPostCode;
    }

    public void setTradingPostCode(String tradingPostCode) {
        this.tradingPostCode = tradingPostCode;
    }

    public String getTotalNoOfProperties() {
        return totalNoOfProperties;
    }

    public void setTotalNoOfProperties(String totalNoOfProperties) {
        this.totalNoOfProperties = totalNoOfProperties;
    }

    public String getEstimatedPortfolioValue() {
        return estimatedPortfolioValue;
    }

    public void setEstimatedPortfolioValue(String estimatedPortfolioValue) {
        this.estimatedPortfolioValue = estimatedPortfolioValue;
    }

    public String getTotalOutstandingMortgageBalance() {
        return totalOutstandingMortgageBalance;
    }

    public void setTotalOutstandingMortgageBalance(String totalOutstandingMortgageBalance) {
        this.totalOutstandingMortgageBalance = totalOutstandingMortgageBalance;
    }

    public String getTotalMontlyRentalIncome() {
        return totalMontlyRentalIncome;
    }

    public void setTotalMontlyRentalIncome(String totalMontlyRentalIncome) {
        this.totalMontlyRentalIncome = totalMontlyRentalIncome;
    }

    public String getTotalMonthlyMortgagePayment() {
        return totalMonthlyMortgagePayment;
    }

    public void setTotalMonthlyMortgagePayment(String totalMonthlyMortgagePayment) {
        this.totalMonthlyMortgagePayment = totalMonthlyMortgagePayment;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(String dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public String getShareholding20OrGreater() {
        return shareholding20OrGreater;
    }

    public void setShareholding20OrGreater(String shareholding20OrGreater) {
        this.shareholding20OrGreater = shareholding20OrGreater;
    }

    public String getPercentShare() {
        return percentShare;
    }

    public void setPercentShare(String percentShare) {
        this.percentShare = percentShare;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public String getnINumber() {
        return nINumber;
    }

    public void setnINumber(String nINumber) {
        this.nINumber = nINumber;
    }

    public String getPermanentRightToResideInsideUK() {
        return permanentRightToResideInsideUK;
    }

    public void setPermanentRightToResideInsideUK(String permanentRightToResideInsideUK) {
        this.permanentRightToResideInsideUK = permanentRightToResideInsideUK;
    }

    public String getFromBirth() {
        return fromBirth;
    }

    public void setFromBirth(String fromBirth) {
        this.fromBirth = fromBirth;
    }

    public String getLengthOfResidencyYears() {
        return lengthOfResidencyYears;
    }

    public void setLengthOfResidencyYears(String lengthOfResidencyYears) {
        this.lengthOfResidencyYears = lengthOfResidencyYears;
    }

    public String getLengthOfResidencyMonths() {
        return lengthOfResidencyMonths;
    }

    public void setLengthOfResidencyMonths(String lengthOfResidencyMonths) {
        this.lengthOfResidencyMonths = lengthOfResidencyMonths;
    }

    public String getPreviousTitle() {
        return previousTitle;
    }

    public void setPreviousTitle(String previousTitle) {
        this.previousTitle = previousTitle;
    }

    public String getPreviousFirstName() {
        return previousFirstName;
    }

    public void setPreviousFirstName(String previousFirstName) {
        this.previousFirstName = previousFirstName;
    }

    public String getPreviousMiddleName() {
        return previousMiddleName;
    }

    public void setPreviousMiddleName(String previousMiddleName) {
        this.previousMiddleName = previousMiddleName;
    }

    public String getPreviousLastName() {
        return previousLastName;
    }

    public void setPreviousLastName(String previousLastName) {
        this.previousLastName = previousLastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMarketingPreference() {
        return marketingPreference;
    }

    public void setMarketingPreference(String marketingPreference) {
        this.marketingPreference = marketingPreference;
    }

    public String getByEmail() {
        return byEmail;
    }

    public void setByEmail(String byEmail) {
        this.byEmail = byEmail;
    }

    public String getByTelephone() {
        return byTelephone;
    }

    public void setByTelephone(String byTelephone) {
        this.byTelephone = byTelephone;
    }

    public String getBySms() {
        return bySms;
    }

    public void setBySms(String bySms) {
        this.bySms = bySms;
    }

    public String getResidentialStatus() {
        return residentialStatus;
    }

    public void setResidentialStatus(String residentialStatus) {
        this.residentialStatus = residentialStatus;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }

    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPreviousStreet() {
        return previousStreet;
    }

    public void setPreviousStreet(String previousStreet) {
        this.previousStreet = previousStreet;
    }

    public String getPreviousCity() {
        return previousCity;
    }

    public void setPreviousCity(String previousCity) {
        this.previousCity = previousCity;
    }

    public String getPreviousCountry() {
        return previousCountry;
    }

    public void setPreviousCountry(String previousCountry) {
        this.previousCountry = previousCountry;
    }

    public String getPreviousPostCode() {
        return previousPostCode;
    }

    public void setPreviousPostCode(String previousPostCode) {
        this.previousPostCode = previousPostCode;
    }

    public String getSecurityEstimatedValue() {
        return securityEstimatedValue;
    }

    public void setSecurityEstimatedValue(String securityEstimatedValue) {
        this.securityEstimatedValue = securityEstimatedValue;
    }

    public String getSecurityPurchasePrice() {
        return securityPurchasePrice;
    }

    public void setSecurityPurchasePrice(String securityPurchasePrice) {
        this.securityPurchasePrice = securityPurchasePrice;
    }

    public String getSecurityLocation() {
        return securityLocation;
    }

    public void setSecurityLocation(String securityLocation) {
        this.securityLocation = securityLocation;
    }

    public String getSecurityCountry() {
        return securityCountry;
    }

    public void setSecurityCountry(String securityCountry) {
        this.securityCountry = securityCountry;
    }

    public String getSecurityStreetAddress() {
        return securityStreetAddress;
    }

    public void setSecurityStreetAddress(String securityStreetAddress) {
        this.securityStreetAddress = securityStreetAddress;
    }

    public String getSecurityCity() {
        return securityCity;
    }

    public void setSecurityCity(String securityCity) {
        this.securityCity = securityCity;
    }

    public String getSecurityPostCode() {
        return securityPostCode;
    }

    public void setSecurityPostCode(String securityPostCode) {
        this.securityPostCode = securityPostCode;
    }

    public String getBorrowerFirstName() {
        return borrowerFirstName;
    }

    public void setBorrowerFirstName(String borrowerFirstName) {
        this.borrowerFirstName = borrowerFirstName;
    }

    public String getBorrowerLastName() {
        return borrowerLastName;
    }

    public void setBorrowerLastName(String borrowerLastName) {
        this.borrowerLastName = borrowerLastName;
    }

    public String getBorrowerRoleOnLoan() {
        return borrowerRoleOnLoan;
    }

    public void setBorrowerRoleOnLoan(String borrowerRoleOnLoan) {
        this.borrowerRoleOnLoan = borrowerRoleOnLoan;
    }
}
