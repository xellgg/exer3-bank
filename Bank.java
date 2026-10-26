package exer3_bank;

/**
 * Blueprint for a bank that stores accounts and looks them up by id.
 */
public interface Bank {
  /**
   * Adds a new account to the bank.
   *
   * @param account the account to add
   */
  void addAccount(BankAccount account);

  /**
   * Returns the account with the given id.
   *
   * @param id the account id
   * @return the matching account, or null if none exists
   */
  BankAccount getAccount(int id);
}
