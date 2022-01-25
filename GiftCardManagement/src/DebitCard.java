/**
 * A reloadable gift card that can also have cash withdrawn from it;
 * 
 */
public class DebitCard extends ReloadableGiftCard {
  
  /**
   * The most recently converted Cash.
   */
  private /*@ nullable */ Cash my_recent_cash; //@ in recent_cash, converted;
  //@ public model nullable Cash recent_cash;
  //@ private represents recent_cash = my_recent_cash;
  //@ public model boolean converted;
  //@ private represents converted = (my_recent_cash != null);
  
    
  /**
   * Constructs a debit card with zero balance.
   */
  //@ ensures balance == 0;
  //@ ensures !converted;
  public DebitCard() {
    super();
    my_recent_cash = null;
  }
  
  /**
   * Constructs a debit card loaded with the specified cash.
   * 
   * @param the_cash The cash to load.
   */
  //@ ensures balance == the_cash.amount;
  //@ ensures !converted;
  public DebitCard(final Cash the_cash) {
    super(the_cash);
    my_recent_cash = null;
  }
  
  
  /**
   * @return Have you ever converted any of your balance to cash?
   */
  //@ ensures \result == converted;
  public boolean converted() {
    return my_recent_cash != null;
  }
  
  /**
   * @return Recently converted cash
   */
  //@ requires converted;
  //@ ensures \result == recent_cash;
  public Cash lastCash() {
    return my_recent_cash;
  }
  
  
  /**
   * Convert the_amount of your balance into cash
   * 
   * @param the_amount The amount to convert.
   */
  //@ requires the_amount <= balance && 0 < the_amount;
  //@ ensures balance == \old(balance) - the_amount;
  //@ ensures converted;
  //@ ensures \fresh(recent_cash);
  //@ ensures recent_cash.amount == the_amount;
  //@ assignable balance, recent_cash;
  public void convert(final int the_amount) {
	my_recent_cash = new Cash(the_amount);
    setBalance(balance() - the_amount);
  }
}
