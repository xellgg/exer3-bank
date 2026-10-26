package exer3_bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a single bank account transaction (a deposit or a withdrawal)
 * together with the date and time it was made.
 */
public class Transaction {
  /** Format used when displaying the time stamp. */
  private static final DateTimeFormatter FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  /** Type of the transaction, e.g. "Deposit" or "Withdraw". */
  private String type;

  /** Amount involved in the transaction. */
  private double amount;

  /** Date and time the transaction was created. */
  private LocalDateTime time_stamp;

  /**
   * Creates a transaction stamped with the current date and time.
   *
   * @param type the type of the transaction
   * @param amount the amount of the transaction
   */
  public Transaction(String type, double amount) {
    this.type = type;
    this.amount = amount;
    this.time_stamp = LocalDateTime.now();
  }

  /**
   * Returns the amount of this transaction.
   *
   * @return the transaction amount
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Returns the type, amount and time stamp of this transaction.
   *
   * @return a string description of the transaction
   */
  @Override
  public String toString() {
    return "Transaction [type=" + type
        + ", amount=" + amount
        + ", time_stamp=" + time_stamp.format(FORMATTER)
        + "]";
  }
}
