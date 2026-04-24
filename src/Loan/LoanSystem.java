package Loan;

import java.util.Scanner;

public class LoanSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputValidator validator = new InputValidator(scanner);
        LoanFactory factory = new LoanFactory();

        System.out.println("===============================================");
        System.out.println("    BANK OF KIGALI LOAN MANAGEMENT SYSTEM    ");
        System.out.println("===============================================");

        // Customer details
        System.out.println("\n--- Enter Customer Details ---");
        String customerId = validator.getString("Customer ID: ");
        String customerName = validator.getString("Customer Name: ");
        String nationalId = validator.getNationalId("National ID (16 digits): ");
        String phoneNumber = validator.getPhoneNumber("Phone Number: ");

        Customer customer = new Customer(customerId, customerName, nationalId, phoneNumber);

        // Loan details
        System.out.println("\n--- Enter Loan Details ---");
        String loanType = validator.getValidLoanType("Loan Type (Personal, Home, Car, Business, Student, Agricultural): ");
        String loanId = validator.getString("Loan ID: ");
        double loanAmount = validator.getDouble("Loan Amount (max 10B): ", false);
        double interestRate = validator.getDouble("Interest Rate (%): ", true);
        int loanDuration = validator.getInt("Loan Duration (months): ", false);
        
        String officerName = validator.getString("Officer Name: ");
        String branchLocation = validator.getString("Branch Location: ");
        String extraAttribute = validator.getString("Provide specific details (e.g. purpose, model, address, registry no., etc.): ");

        // Create Loan using Factory
        LoanManager loan = factory.createLoan(loanType, loanId, loanAmount, interestRate, loanDuration, officerName, branchLocation, extraAttribute);

        if (loan != null) {
            System.out.println("\nValidating Loan details...");
            if (loan.validateLoanDetails()) {
                System.out.println("Details valid. Checking eligibility...");
                if (loan.checkEligibility()) {
                    loan.approveLoan();
                    System.out.println("Notice: Loan Approved!\n");
                } else {
                    loan.rejectLoan();
                    System.out.println("Notice: Loan Rejected due to eligibility rules.\n");
                }
            } else {
                loan.rejectLoan();
                System.out.println("Notice: Loan Details are invalid. Loan Rejected.\n");
            }
            
            // Output summary
            System.out.println("-----------------------------------------------");
            System.out.println("Customer Summary: " + customer.toString());
            loan.generateLoanReport();
            
            // Process payment if approved
            if ("Approved".equals(loan.getLoanStatus())) {
                System.out.println("\n--- Process a Repayment ---");
                double paymentAmount = validator.getDouble("Enter payment amount: ", true);
                String paymentId = validator.getString("Enter Payment ID: ");
                String paymentDate = validator.getString("Enter Payment Date (YYYY-MM-DD): ");
                
                Repayment repayment = new Repayment(paymentId, loan, paymentAmount, paymentDate);
                repayment.updateRemainingBalance();
                
                System.out.println("\n--- Payment Summary ---");
                System.out.println(repayment.toString());
                loan.generatePaymentReceipt();
            }

        } else {
            System.out.println("Error: Failed to create loan.");
        }

        System.out.println("===============================================");
        System.out.println("               SYSTEM TERMINATED               ");
        System.out.println("===============================================");
    }
}
