import java.util.List;
import java.util.ArrayList;

interface DepositOnlyAccount {
    void deposit(double amount);
}

interface WithdrawableAccount extends DepositOnlyAccount {
    void withdraw(double amount);
}

class SavingAccount implements WithdrawableAccount {
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
            System.out.println("Withdrawn: " + amount + " from Savings Account. Available Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance in Savings Account!");
        }
    }

}

class CurrentAccount implements WithdrawableAccount {
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
            System.out.println("Withdrawn: " + amount + " from Current Account. Available Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance in Current Account!");
        }
    }
}

class FixedDepositAccount implements DepositOnlyAccount {
    private double balance;

    public FixedDepositAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. Available Balance: " + balance);
    }
}

class BankClient {
    private List<WithdrawableAccount> withdrawAbleaAcounts;

    private List<DepositOnlyAccount> depositOnlyAccounts;

    public BankClient(List<WithdrawableAccount> withdrawAbleaAcounts, List<DepositOnlyAccount> depositOnlyAccounts) {
        this.withdrawAbleaAcounts = withdrawAbleaAcounts;
        this.depositOnlyAccounts = depositOnlyAccounts;
    }

    public void processTransactions() {
        for (WithdrawableAccount acc : withdrawAbleaAcounts) {
            acc.deposit(1000);
            acc.withdraw(1000);
        }

        for (DepositOnlyAccount acc : depositOnlyAccounts) {
            acc.deposit(5000);
        }
    }
}

class LSPFollowed {
    public static void main(String[] args) {
        List<WithdrawableAccount> withdrawableAccounts = new ArrayList<>();
        withdrawableAccounts.add(new SavingAccount());
        withdrawableAccounts.add(new CurrentAccount());

        List<DepositOnlyAccount> depositOnlyAccounts = new ArrayList<>();
        depositOnlyAccounts.add(new FixedDepositAccount());

        BankClient client = new BankClient(withdrawableAccounts, depositOnlyAccounts);
        client.processTransactions();
    }
}
