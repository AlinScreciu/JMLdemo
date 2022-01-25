 /**
 * A gift card that can be used for only one purchase.
 * 
 */
public class SingleUseGiftCard extends GiftCard {
  
  /**
   * A flag indicating whether this gift card has been used.
   */
  //@ public model boolean used;
  //@ private represents used = is_used;
  //@ public constraint \old(used) ==> used;
  private boolean is_used; //@ in used;

  
  /**
   * Constructs a gift card loaded with the specified cash.
   * 
   * @param the_cash The cash to load.
   */
  //@ ensures balance == the_cash.amount;
  //@ ensures !used;
    public SingleUseGiftCard(final Cash the_cash) {
    super(the_cash);
    is_used = false;
  }
  
  /**
   * Makes a purchase with the_amount and ensures it can be used only once
   * 
   * @param the_amount The amount.
   */
  public void purchase(final int the_amount) {
	  super.purchase(the_amount);
	  is_used = true;
  }
  

  /**
   * Checks to see if the gift card can be used to make a purchase.
   * A single use gift card can only be used if it hasn't yet
   * been used.
   * 
   * @return Can this be used to make a purchase of the_amount?
   */
  //@ also ensures \result <==> !used;
  @Override
  public /*@ pure */ boolean canUseForPurchase() {
    return !is_used;
  }
  
}