package exer3_bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Concrete {@link Bank} that stores accounts in a Map keyed by account id.
 */
public class BankAccountManager implements Bank {
  /** Maximum number of accounts that can be created. */
  private static final int MAX_ACCOUNTS = 100;

  /** Maps each account id to its bank account. */
  private Map<Integer, BankAccount> accounts;

  /** Id that will be given to the next account added. */
  private int id;

  /**
   * Creates an empty manager whose first account id will be 0.
   */
  public BankAccountManager() {
    accounts = new HashMap<>();
    id = 0;
  }

  /**
   * Stores an account under the next id, up to the maximum limit.
   *
   * @param account the account to add
   */
  @Override
  public void addAccount(BankAccount account) {
    if (accounts.size() >= MAX_ACCOUNTS) {
      System.out.println("Cannot add account: limit of "
          + MAX_ACCOUNTS + " accounts reached.");
      return;
    }
    accounts.put(id, account);
    System.out.println("Account added successfully with ID: " + id);
    id++;
  }

  /**
   * Returns the account with the given id.
   *
   * @param id the account id
   * @return the matching account, or null if none exists
   */
  @Override
  public BankAccount getAccount(int id) {
    return accounts.get(id);
  }

  /**
   * Displays the id, owner name and balance of every stored account.
   */
  public void listAccounts() {
    for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
      BankAccount account = entry.getValue();
      System.out.println("Account ID: " + entry.getKey()
          + ", Account Name: " + account.getOwnerName()
          + ", Balance: " + BankAccount.round(account.getBalance()));
    }
  }

  /**
   * Filters the transactions whose amount is greater than or equal to the
   * given amount.
   *
   * @param amount the minimum transaction amount to keep
   * @param txList the transactions to filter
   * @return a new list of the matching transactions
   */
  public List<Transaction> filterTransactionsAtOrAbove(double amount,
      List<Transaction> txList) {
    List<Transaction> filtered = new ArrayList<>(txList);
    filtered.removeIf(tx -> tx.getAmount() < amount);
    return filtered;
  }

  /**
   * Sorts the transactions by amount in ascending order.
   *
   * @param txList the transactions to sort
   * @return a new list sorted by amount, smallest first
   */
  public List<Transaction> sortTransactionsByAmount(
      List<Transaction> txList) {
    List<Transaction> sorted = new ArrayList<>(txList);
    sorted.sort((a, b) -> Double.compare(a.getAmount(), b.getAmount()));
    return sorted;
  }
}
