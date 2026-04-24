package Loan;

public class PersonalLoan extends LoanManager {
    private String purpose;

    public PersonalLoan() {
        super();
        this.purpose = "";
    }

    public PersonalLoan(String loanId, double loanAmount, double interestRate, int loanDuration, String loanStatus, String officerName, String branchLocation, String purpose) {
        super(loanId, "Personal", loanAmount, interestRate, loanDuration, loanStatus, officerName, branchLocation);
        this.purpose = purpose;
    }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public String toString() {
        return super.toString() + ", Purpose: " + purpose;
    }

    public boolean checkEligibility() {
        return super.checkEligibility() && getLoanAmount() <= 5000000;
    }

    public void generateLoanReport() {
        System.out.println("--- Personal Loan Report ---");
        System.out.println(toString());
        System.out.println("Total Repayment: " + calculateTotalRepayment());
        System.out.println("Monthly Installment: " + calculateMonthlyInstallment());
    }

    public boolean validateLoanDetails() {
        return super.validateLoanDetails() && purpose != null && !purpose.isEmpty();
    }
}
