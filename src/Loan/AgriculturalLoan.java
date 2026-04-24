package Loan;

public class AgriculturalLoan extends LoanManager {
    private String farmSize;

    public AgriculturalLoan() {
        super();
        this.farmSize = "";
    }

    public AgriculturalLoan(String loanId, double loanAmount, double interestRate, int loanDuration, String loanStatus, String officerName, String branchLocation, String farmSize) {
        super(loanId, "Agricultural", loanAmount, interestRate, loanDuration, loanStatus, officerName, branchLocation);
        this.farmSize = farmSize;
    }

    public String getFarmSize() { return farmSize; }
    public void setFarmSize(String farmSize) { this.farmSize = farmSize; }

    public String toString() {
        return super.toString() + ", Farm Size: " + farmSize;
    }

    public boolean checkEligibility() {
        return super.checkEligibility() && getLoanAmount() <= 8000000;
    }

    public void generateLoanReport() {
        System.out.println("--- Agricultural Loan Report ---");
        System.out.println(toString());
        System.out.println("Total Repayment: " + calculateTotalRepayment());
        System.out.println("Monthly Installment: " + calculateMonthlyInstallment());
    }

    public boolean validateLoanDetails() {
        return super.validateLoanDetails() && farmSize != null && !farmSize.isEmpty();
    }
}
