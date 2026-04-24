package Loan;

public class LoanManager extends Loan implements Payable {
    private String officerName;
    private String branchLocation;
    private double amountPaid;

    public LoanManager() {
        super();
        this.officerName = "";
        this.branchLocation = "";
        this.amountPaid = 0.0;
    }

    public LoanManager(String loanId, String loanType, double loanAmount, double interestRate, int loanDuration, String loanStatus, String officerName, String branchLocation) {
        super(loanId, loanType, loanAmount, interestRate, loanDuration, loanStatus);
        this.officerName = officerName;
        this.branchLocation = branchLocation;
        this.amountPaid = 0.0;
    }

    public String getOfficerName() { return officerName; }
    public void setOfficerName(String officerName) { this.officerName = officerName; }
    public String getBranchLocation() { return branchLocation; }
    public void setBranchLocation(String branchLocation) { this.branchLocation = branchLocation; }
    public double getAmountPaid() { return amountPaid; }
    public void setAmountPaid(double amountPaid) { this.amountPaid = amountPaid; }

    public String toString() {
        return super.toString() + ", Officer: " + officerName + ", Branch: " + branchLocation;
    }

    public double calculateInterest() {
        return (getLoanAmount() * getInterestRate() * (getLoanDuration() / 12.0)) / 100.0;
    }

    public double calculateMonthlyInstallment() {
        if (getLoanDuration() <= 0) return 0;
        return calculateTotalRepayment() / getLoanDuration();
    }

    public boolean checkEligibility() {
        return getLoanAmount() > 0 && getLoanDuration() > 0;
    }

    public void approveLoan() {
        if (checkEligibility()) {
            setLoanStatus("Approved");
        }
    }

    public void rejectLoan() {
        setLoanStatus("Rejected");
    }

    public double calculateTotalRepayment() {
        return getLoanAmount() + calculateInterest();
    }

    public void generateLoanReport() {
        System.out.println("--- System Loan Report ---");
        System.out.println(toString());
        System.out.println("Total Repayment: " + calculateTotalRepayment());
        System.out.println("Monthly Installment: " + calculateMonthlyInstallment());
    }

    public boolean validateLoanDetails() {
        return getLoanAmount() > 0 && getInterestRate() >= 0 && getLoanDuration() > 0;
    }

    public void processPayment(double amount) {
        if (amount > 0) {
            this.amountPaid += amount;
        }
    }

    public double calculateRemainingBalance() {
        double balance = calculateTotalRepayment() - amountPaid;
        return balance > 0 ? balance : 0;
    }

    public void generatePaymentReceipt() {
        System.out.println("--- Payment Receipt ---");
        System.out.println("Loan ID: " + getLoanId());
        System.out.println("Amount Paid Summary: " + amountPaid);
        System.out.println("Remaining Balance: " + calculateRemainingBalance());
    }
}
