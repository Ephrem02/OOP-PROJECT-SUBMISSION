package Loan;

public class Repayment {
    private String paymentId;
    private LoanManager loan;
    private double amountPaid;
    private String paymentDate;
    private double remainingBalance;

    public Repayment() {
        this.paymentId = "";
        this.loan = null;
        this.amountPaid = 0.0;
        this.paymentDate = "";
        this.remainingBalance = 0.0;
    }

    public Repayment(String paymentId, LoanManager loan, double amountPaid, String paymentDate) {
        this.paymentId = paymentId;
        this.loan = loan;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        if (loan != null) {
            this.remainingBalance = loan.calculateRemainingBalance() - amountPaid;
            if (this.remainingBalance < 0) {
                this.remainingBalance = 0;
            }
        }
    }

    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }
    public LoanManager getLoan() { return loan; }
    public void setLoan(LoanManager loan) { this.loan = loan; }
    public double getAmountPaid() { return amountPaid; }
    public void setAmountPaid(double amountPaid) { this.amountPaid = amountPaid; }
    public String getPaymentDate() { return paymentDate; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }
    public double getRemainingBalance() { return remainingBalance; }
    public void setRemainingBalance(double remainingBalance) { this.remainingBalance = remainingBalance; }

    public void updateRemainingBalance() {
        if (loan != null) {
            loan.processPayment(amountPaid);
            this.remainingBalance = loan.calculateRemainingBalance();
        }
    }

    public String toString() {
        return "Payment ID: " + paymentId + ", Amount Paid: " + amountPaid + ", Date: " + paymentDate + ", Remaining Balance: " + remainingBalance;
    }
}
