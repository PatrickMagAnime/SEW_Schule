class BankAccount {
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Der Einzahlungsbetrag muss größer als 0 sein.");
        }
        balance += amount;
    }

    // Withdraw Method
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Der Abhebungsbetrag muss größer als 0 sein.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Unzureichender Kontostand für diese Abhebung.");
        }
        balance -= amount;
    }

    // Transfer Method
    public void transfer(BankAccount toAccount, double amount) throws InvalidAccountException, InsufficientFundsException {
        if (toAccount == null) {
            throw new InvalidAccountException("Das Zielkonto ist ungültig.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Der Überweisungsbetrag muss größer als 0 sein.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Unzureichender Kontostand für die Überweisung.");
        }
        this.withdraw(amount);
        toAccount.deposit(amount);
    }

    // Print Account Details
    public void printAccountDetails() {
        System.out.println("Kontoinhaber: " + accountHolderName);
        System.out.println("Aktueller Kontostand: " + balance);
    }
}
