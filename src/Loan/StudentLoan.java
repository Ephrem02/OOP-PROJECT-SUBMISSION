package Loan;

public class StudentLoan extends LoanManager {
    private String universityName;

    public StudentLoan() {
        super();
        this.universityName = "";
    }

    public StudentLoan(String loanId, double loanAmount, double interestRate, int loanDuration, String loanStatus, String officerName, String branchLocation, String universityName) {
        super(loanId, "Student", loanAmount, interestRate, loanDuration, loanStatus, officerName, branchLocation);
        this.universityName = universityName;
    }

    public String getUniversityName() { return universityName; }
    public void setUniversityName(String universityName) { this.universityName = universityName; }

    public String toString() {
        return super.toString() + ", University: " + universityName;
    }

    public boolean checkEligibility() {
        return super.checkEligibility() && getLoanAmount() <= 2000000;
    }

    public void generateLoanReport() {
        System.out.println("--- Student Loan Report ---");
        System.out.println(toString());
        System.out.println("Total Repayment: " + calculateTotalRepayment());
        System.out.println("Monthly Installment: " + calculateMonthlyInstallment());
    }

    public boolean validateLoanDetails() {
        return super.validateLoanDetails() && universityName != null && !universityName.isEmpty();
    }
}
