import java.util.ArrayList;
import java.util.List;

interface Account {
    void deposit(double amount);

    void withdraw(double amount);
}

class SavingAccount implements Account {
    private double balance;

    public SavingAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Savings Account. Available Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Savings Account. Available Balance: " + balance);
        } else {
            System.out.println("Insufficient balance in Savings Account!");
        }
    }
}

class CurrentAccount implements Account {
    private double balance;

    public CurrentAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. Available Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. Available Balance: " + balance);
        } else {
            System.out.println("Insufficient balance in Current Account!");
        }
    }
}

class FixedDepositAccount implements Account {
    private double balance;

    public FixedDepositAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Fixed Deposit Account. Available Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdrawal not allowed in a Fixed Deposit Account!");
    }
}

class BankClient {
    private List<Account> accounts;

    public BankClient(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void processTransactions() {
        for (Account acc : accounts) {
            acc.deposit(1000);

            try {
                acc.withdraw(500);
            } catch (UnsupportedOperationException err) {
                System.out.println("Exception: " + err.getMessage());
            }
        }
    }
}

public class LSPViolated {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new SavingAccount());
        accounts.add(new CurrentAccount());
        accounts.add(new FixedDepositAccount());

        BankClient client = new BankClient(accounts);
        client.processTransactions();
    }
}
