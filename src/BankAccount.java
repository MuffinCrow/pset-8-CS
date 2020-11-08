import java.lang.String;
import java.math.BigDecimal;

public class BankAccount {
    AccountOwner owner;
    double balance;
    long accountNumber = -1;

    public BankAccount(AccountOwner accountOwner, double balance) {
        this.owner = accountOwner;
        this.balance = balance;
        this.accountNumber = accountNumberGenerator();
    }

    public int deposit(double amount) {
        if (amount <= 0) return 2;
        balance += amount;
        return 1;
    }

    public int withdraw(double amount) {
        if (amount <= 0) return 2;
        if (amount > balance) return 3;
        balance -= amount;
        return 1;
    }

    public int transfer(long account, double amount) {
        if (ATM.lookup(account) == null) return 4;
        if (amount <= 0) return 2;
        if (this.balance < amount) return 3;

        ATM.lookup(account).deposit(amount);
        this.balance -= amount;
        return 1;
    }

    public String getMaskedAccountNumber() {
        String[] tempA = String.valueOf(accountNumber).split("");
        String temp = "****";
        int l = tempA.length;

        temp += tempA[l - 4] + tempA[l - 3] + tempA[l - 2] + tempA[l - 1];
        return temp;
    }

    public String getFormattedBalance() {
        String output = String.format("$%,.02f", balance);
        return output;
    }

    public BigDecimal validateBalance(double balance) {
        if (balance < 0) return BigDecimal.ZERO;
        return BigDecimal.valueOf(balance);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public AccountOwner getAccountOwner() {
        return this.owner;
    }

    public void setAccountOwner(AccountOwner accountOwner) {
        this.owner = accountOwner;
    }

    public BigDecimal getBalance() {
        return BigDecimal.valueOf(balance);
    }

    public long accountNumberGenerator() {
       if (accountNumber == -1) {
           long temp;
           boolean check = false;
           while (check == false) {
               temp = (long) (Math.random() * 99999999L);
               BankAccount checkAccount = ATM.lookup(temp);
               if (checkAccount == null) {
                   return temp;
               }
           }
       }
       return accountNumber;
    }
}
