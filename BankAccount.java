package exer3_bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Parent class of all bank accounts. Handles deposits, withdrawals, the
 * frozen status and the history of successful transactions.
 */
public class BankAccount {
  /** Used to keep two decimal places. */
  private static final double HUNDRED = 100.0;

  /** Current balance of the account. */
  private double balance;

  /** Whether the account is frozen. */
  private boolean isFrozen;

  /** Record of every successful deposit and withdrawal. */
  private List<Transaction> transactionHistory;

  /**
   * Creates an unfrozen account with a zero balance and an empty
   * transaction history.
   */
  public BankAccount() {
    this.balance = 0;
    this.isFrozen = false;
    this.transactionHistory = new ArrayList<>();
  }

  /**
   * Rounds a value to two decimal places.
   *
   * @param value the value to round
   * @return the value rounded to two decimal places
   */
  static double round(double value) {
    return Math.round(value * HUNDRED) / HUNDRED;
  }

  /**
   * Returns the name of the account owner. A plain bank account has no
   * owner, so child classes override this.
   *
   * @return the owner's name
   */
  public String getOwnerName() {
    return "N/A";
  }

  /**
   * Deposits an amount and records the transaction.
   *
   * @param amount the amount to deposit
   * @throws AccountFrozenException if the account is frozen
   * @throws InvalidAmountException if the amount is zero or negative
   */
  public void deposit(double amount)
      throws AccountFrozenException, InvalidAmountException {
    if (isFrozen) {
      throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
    }
    System.out.printf("Amount deposited: %.2f%n", amount);
    if (amount <= 0) {
      throw new InvalidAmountException("Invalid amount. Must be greater than 0");
    }
    balance += amount;
    System.out.printf("Current balance: %.2f%n", balance);
    transactionHistory.add(new Transaction("Deposit", amount));
  }

  /**
   * Withdraws an amount and records the transaction.
   *
   * @param amount the amount to withdraw
   * @throws AccountFrozenException if the account is frozen
   * @throws InvalidAmountException if the amount is zero or negative
   * @throws InsufficientFundsException if the amount exceeds the balance
   */
  public void withdraw(double amount)
      throws AccountFrozenException, InvalidAmountException,
      InsufficientFundsException {
    if (isFrozen) {
      throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
    }
    System.out.printf("Amount withdrawn: %.2f%n", amount);
    if (amount <= 0) {
      throw new InvalidAmountException("Invalid amount. Must be greater than 0");
    }
    if (amount > balance) {
      throw new InsufficientFundsException("Insufficient balance.");
    }
    balance -= amount;
    System.out.printf("Current balance: %.2f%n", balance);
    transactionHistory.add(new Transaction("Withdraw", amount));
  }

  /**
   * Returns the current balance.
   *
   * @return the balance
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Freezes the account so no deposits or withdrawals can be made.
   */
  public void freezeAccount() {
    isFrozen = true;
  }

  /**
   * Unfreezes the account so transactions can be made again.
   */
  public void unfreezeAccount() {
    isFrozen = false;
  }

  /**
   * Returns whether the account is frozen.
   *
   * @return true if the account is frozen
   */
  public boolean isFrozen() {
    return isFrozen;
  }

  /**
   * Returns the transaction history of this account.
   *
   * @return the list of transactions
   */
  public List<Transaction> getTransactionHistory() {
    return transactionHistory;
  }
}
