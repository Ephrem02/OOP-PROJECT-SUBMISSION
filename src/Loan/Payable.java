package Loan;

public interface Payable {
    void processPayment(double amount);
    double calculateRemainingBalance();
    void generatePaymentReceipt();
}
