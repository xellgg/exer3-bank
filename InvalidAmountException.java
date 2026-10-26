package exer3_bank;

/**
 * Thrown when an invalid amount (negative or zero) is deposited or withdrawn.
 */
public class InvalidAmountException extends Exception {
  /** Version id used when the exception is serialized. */
  private static final long serialVersionUID = 1L;

  /** Message describing why the exception was thrown. */
  private String message;

  /**
   * Creates the exception with the given message.
   *
   * @param message the message describing the problem
   */
  public InvalidAmountException(String message) {
    super(message);
    this.message = message;
  }

  /**
   * Returns the message describing the problem.
   *
   * @return the message
   */
  @Override
  public String getMessage() {
    return message;
  }
}
