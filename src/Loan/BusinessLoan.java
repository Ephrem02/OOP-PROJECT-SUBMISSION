package Loan;

public class BusinessLoan extends LoanManager {
    private String businessRegistrationNumber;

    public BusinessLoan() {
        super();
        this.businessRegistrationNumber = "";
    }

    public BusinessLoan(String loanId, double loanAmount, double interestRate, int loanDuration, String loanStatus, String officerName, String branchLocation, String businessRegistrationNumber) {
        super(loanId, "Business", loanAmount, interestRate, loanDuration, loanStatus, officerName, branchLocation);
        this.businessRegistrationNumber = businessRegistrationNumber;
    }

    public String getBusinessRegistrationNumber() { return businessRegistrationNumber; }
    public void setBusinessRegistrationNumber(String businessRegistrationNumber) { this.businessRegistrationNumber = businessRegistrationNumber; }

    public String toString() {
        return super.toString() + ", Registration Number: " + businessRegistrationNumber;
    }

    public boolean checkEligibility() {
        return super.checkEligibility() && getLoanAmount() <= 100000000;
    }

    public void generateLoanReport() {
        System.out.println("--- Business Loan Report ---");
        System.out.println(toString());
        System.out.println("Total Repayment: " + calculateTotalRepayment());
        System.out.println("Monthly Installment: " + calculateMonthlyInstallment());
    }

    public boolean validateLoanDetails() {
        return super.validateLoanDetails() && businessRegistrationNumber != null && !businessRegistrationNumber.isEmpty();
    }
}
