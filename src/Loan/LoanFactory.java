package Loan;

public class LoanFactory {
    public LoanManager createLoan(String loanType, String loanId, double loanAmount, double interestRate, int loanDuration, String officerName, String branchLocation, String extraAttribute) {
        if (loanType.equalsIgnoreCase("Personal")) {
            return new PersonalLoan(loanId, loanAmount, interestRate, loanDuration, "Pending", officerName, branchLocation, extraAttribute);
        } else if (loanType.equalsIgnoreCase("Home")) {
            return new HomeLoan(loanId, loanAmount, interestRate, loanDuration, "Pending", officerName, branchLocation, extraAttribute);
        } else if (loanType.equalsIgnoreCase("Car")) {
            return new CarLoan(loanId, loanAmount, interestRate, loanDuration, "Pending", officerName, branchLocation, extraAttribute);
        } else if (loanType.equalsIgnoreCase("Business")) {
            return new BusinessLoan(loanId, loanAmount, interestRate, loanDuration, "Pending", officerName, branchLocation, extraAttribute);
        } else if (loanType.equalsIgnoreCase("Student")) {
            return new StudentLoan(loanId, loanAmount, interestRate, loanDuration, "Pending", officerName, branchLocation, extraAttribute);
        } else if (loanType.equalsIgnoreCase("Agricultural")) {
            return new AgriculturalLoan(loanId, loanAmount, interestRate, loanDuration, "Pending", officerName, branchLocation, extraAttribute);
        }
        return null;
    }
}
