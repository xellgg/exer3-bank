package exer3_bank;

/**
 * A savings account owned by a named account holder.
 */
public class SavingsAccount extends BankAccount {
  /** Name of the account owner. */
  private String ownerName;

  /**
   * Creates a savings account for the given owner.
   *
   * @param ownerName the owner's name
   */
  public SavingsAccount(String ownerName) {
    super();
    this.ownerName = ownerName;
  }

  /**
   * Returns the name of the account owner.
   *
   * @return the owner's name
   */
  @Override
  public String getOwnerName() {
    return ownerName;
  }
}
