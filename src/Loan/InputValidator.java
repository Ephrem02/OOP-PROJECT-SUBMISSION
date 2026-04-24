package Loan;

import java.util.Scanner;

public class InputValidator {
    private Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getString(String prompt) {
        String input = "";
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty. Please try again.");
            } else {
                break;
            }
        }
        return input;
    }

    public double getDouble(String prompt, boolean allowZeroAndNegative) {
        double value = 0;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty. Please try again.");
                continue;
            }
            boolean valid = true;
            int dotCount = 0;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '-' && i == 0) continue;
                if (c == '.') {
                    dotCount++;
                    if (dotCount > 1) { valid = false; break; }
                } else if (!Character.isDigit(c)) {
                    valid = false;
                    break;
                }
            }
            if (!valid || input.equals(".") || input.equals("-") || input.equals("-.")) {
                System.out.println("Error: Invalid number format. Please enter a valid number.");
                continue;
            }
            
            value = Double.parseDouble(input);
            if (!allowZeroAndNegative && value <= 0) {
                System.out.println("Error: Value must be strictly positive.");
                continue;
            }
            
            if (value > 10000000000.0) {
                System.out.println("Error: Amount is too large to be processed (Max 10 Billion).");
                continue;
            }
            break;
        }
        return value;
    }

    public int getInt(String prompt, boolean allowZeroAndNegative) {
        int value = 0;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty. Please try again.");
                continue;
            }
            boolean valid = true;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '-' && i == 0) continue;
                if (!Character.isDigit(c)) {
                    valid = false;
                    break;
                }
            }
            if (!valid || input.equals("-")) {
                System.out.println("Error: Invalid integer format. Please enter a valid whole number.");
                continue;
            }
            
            value = Integer.parseInt(input);
            if (!allowZeroAndNegative && value <= 0) {
                System.out.println("Error: Value must be greater than zero.");
                continue;
            }
            break;
        }
        return value;
    }

    public String getPhoneNumber(String prompt) {
        String phone = "";
        while (true) {
            phone = getString(prompt);
            boolean valid = true;
            for(int i = 0; i < phone.length(); i++) {
                if(!Character.isDigit(phone.charAt(i)) && phone.charAt(i) != '+') {
                    valid = false;
                    break;
                }
            }
            if (phone.length() < 10 || !valid) {
                System.out.println("Error: Invalid phone number format. Please enter at least 10 digits.");
            } else {
                break;
            }
        }
        return phone;
    }

    public String getNationalId(String prompt) {
        String id = "";
        while (true) {
            id = getString(prompt);
            if (id.length() != 16) {
                System.out.println("Error: Invalid National ID format. Must be exactly 16 characters.");
            } else {
                boolean valid = true;
                for (int i = 0; i < id.length(); i++) {
                    if (!Character.isDigit(id.charAt(i))) {
                        valid = false;
                        break;
                    }
                }
                if (!valid) {
                    System.out.println("Error: National ID must contain only digits.");
                } else {
                    break;
                }
            }
        }
        return id;
    }

    public String getValidLoanType(String prompt) {
        String type = "";
        while(true) {
            type = getString(prompt);
            if(type.equalsIgnoreCase("Personal") || type.equalsIgnoreCase("Home") || 
               type.equalsIgnoreCase("Car") || type.equalsIgnoreCase("Business") || 
               type.equalsIgnoreCase("Student") || type.equalsIgnoreCase("Agricultural")) {
                   break;
            }
            System.out.println("Error: Invalid loan type. Allowed: Personal, Home, Car, Business, Student, Agricultural.");
        }
        return type;
    }
}
