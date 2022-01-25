/**
 * A Reloadable gift card.
 * 
 */
public class ReloadableGiftCard extends GiftCard {
  
  /**
   * Constructs a gift card with zero balance.
   */
  //@ ensures balance == 0;
  public ReloadableGiftCard() {
    super();
  }
  
  /**
   * Constructs a gift card loaded with the specified cash.
   * 
   * @param the_cash The cash to load.
   */
  //@ ensures balance == the_cash.amount;
  public ReloadableGiftCard(final Cash the_cash) {
    super(the_cash);
  }
  
  
  /**
   * Load the_cash by yourself!
   * 
   * @param the_cash The cash.
   */
  //@ requires balance() + the_cash.amount() <= Integer.MAX_VALUE;
  //@ ensures balance == \old(balance) + the_cash.amount;
  //@ assignable balance;
  public void load(final Cash the_cash) {
    setBalance(balance() + the_cash.amount());
  }
}