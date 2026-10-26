package exer3_bank;

/**
 * Runs the test cases of Exercise 3.
 */
public class Main {
  /**
   * Deposits an amount and handles any exception that is thrown.
   *
   * @param account the account to deposit into
   * @param amount the amount to deposit
   */
  private static void tryDeposit(BankAccount account, double amount) {
    try {
      account.deposit(amount);
    } catch (AccountFrozenException | InvalidAmountException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Withdraws an amount and handles any exception that is thrown.
   *
   * @param account the account to withdraw from
   * @param amount the amount to withdraw
   */
  private static void tryWithdraw(BankAccount account, double amount) {
    try {
      account.withdraw(amount);
    } catch (AccountFrozenException | InvalidAmountException e) {
      System.out.println(e.getMessage());
    } catch (InsufficientFundsException e) {
      System.out.println(e.getMessage());
      System.out.printf("Current balance: %.2f%n", account.getBalance());
    }
  }

  /**
   * Program entry point.
   *
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    BankAccount acc1 = new SavingsAccount("Test0");
    BankAccountManager accM1 = new BankAccountManager();

    // Setup: build up a balance of 500.125 with two valid transactions
    tryDeposit(acc1, 1000.125);
    tryWithdraw(acc1, 500);

    System.out.println("\n--- Test Case 1: deposit with negative amount");
    tryDeposit(acc1, -500);

    System.out.println("\n--- Test Case 2: deposit when account is frozen");
    acc1.freezeAccount();
    tryDeposit(acc1, 11500);
    acc1.unfreezeAccount();

    System.out.println("\n--- Test Case 3: withdraw with negative amount");
    tryWithdraw(acc1, -100);

    System.out.println("\n--- Test Case 4: withdraw with insufficient funds");
    tryWithdraw(acc1, 1500);

    System.out.println("\n--- Test Case 5: withdraw when account is frozen");
    acc1.freezeAccount();
    tryWithdraw(acc1, 500);
    acc1.unfreezeAccount();

    // Setup: one more valid withdrawal so the history has three entries
    System.out.println();
    tryWithdraw(acc1, 100);

    System.out.println("\n--- Test Case 6: filter transactions at or above");
    System.out.println("Filtering transactions at or above 200...");
    System.out.println(
        accM1.filterTransactionsAtOrAbove(200, acc1.getTransactionHistory()));

    System.out.println("\n--- Test Case 7: sort transactions by amount");
    System.out.println("Sorting transactions by amount...");
    System.out.println(
        accM1.sortTransactionsByAmount(acc1.getTransactionHistory()));
  }
}
