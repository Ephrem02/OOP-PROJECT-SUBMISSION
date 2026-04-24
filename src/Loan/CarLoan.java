package Loan;

public class CarLoan extends LoanManager {
    private String vehicleModel;

    public CarLoan() {
        super();
        this.vehicleModel = "";
    }

    public CarLoan(String loanId, double loanAmount, double interestRate, int loanDuration, String loanStatus, String officerName, String branchLocation, String vehicleModel) {
        super(loanId, "Car", loanAmount, interestRate, loanDuration, loanStatus, officerName, branchLocation);
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleModel() { return vehicleModel; }
    public void setVehicleModel(String vehicleModel) { this.vehicleModel = vehicleModel; }

    public String toString() {
        return super.toString() + ", Vehicle Model: " + vehicleModel;
    }

    public boolean checkEligibility() {
        return super.checkEligibility() && getLoanAmount() <= 15000000;
    }

    public void generateLoanReport() {
        System.out.println("--- Car Loan Report ---");
        System.out.println(toString());
        System.out.println("Total Repayment: " + calculateTotalRepayment());
        System.out.println("Monthly Installment: " + calculateMonthlyInstallment());
    }

    public boolean validateLoanDetails() {
        return super.validateLoanDetails() && vehicleModel != null && !vehicleModel.isEmpty();
    }
}
