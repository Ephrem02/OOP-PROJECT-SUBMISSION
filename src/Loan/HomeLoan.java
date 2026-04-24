package Loan;

public class HomeLoan extends LoanManager {
    private String propertyAddress;

    public HomeLoan() {
        super();
        this.propertyAddress = "";
    }

    public HomeLoan(String loanId, double loanAmount, double interestRate, int loanDuration, String loanStatus, String officerName, String branchLocation, String propertyAddress) {
        super(loanId, "Home", loanAmount, interestRate, loanDuration, loanStatus, officerName, branchLocation);
        this.propertyAddress = propertyAddress;
    }

    public String getPropertyAddress() { return propertyAddress; }
    public void setPropertyAddress(String propertyAddress) { this.propertyAddress = propertyAddress; }

    public String toString() {
        return super.toString() + ", Property Address: " + propertyAddress;
    }

    public boolean checkEligibility() {
        return super.checkEligibility() && getLoanAmount() <= 50000000;
    }

    public void generateLoanReport() {
        System.out.println("--- Home Loan Report ---");
        System.out.println(toString());
        System.out.println("Total Repayment: " + calculateTotalRepayment());
        System.out.println("Monthly Installment: " + calculateMonthlyInstallment());
    }

    public boolean validateLoanDetails() {
        return super.validateLoanDetails() && propertyAddress != null && !propertyAddress.isEmpty();
    }
}
