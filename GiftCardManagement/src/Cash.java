/**
 * A class that represents a quantity of cash.
 * 
 */
public class Cash {
	
  //@ public invariant 0 < amount;
  
  /**
   * The amount of money represented by this Cash.
   */
  //@ public model int amount;
  //@ private represents amount = my_amount;
  private final int my_amount; //@ in amount;
  
  
  /**
   * A flag indicating whether this Cash has been loaded onto a gift card.
   */
  //@ public model boolean loaded;
  //@ private represents loaded = is_loaded;
  //@ public constraint \old(loaded) ==> loaded;
  private boolean is_loaded; //@ in loaded;

  
  /**
   * Constructs a Cash representing the specified amount of money.
   * 
   * @param the_amount The amount of money to represent.
   */
  //@ requires 0 < the_amount;
  //@ ensures amount == the_amount;
  //@ ensures !loaded;
  //@ pure
  public Cash(final int the_amount) {
    my_amount = the_amount;
    is_loaded = false;
  }
  
  
  /**
   * @return How much money do you represent?
   */
  //@ ensures \result == amount;
  public /*@ pure */ int amount() {
    return my_amount;
  }
  
  /**
   * @return Have you been loaded onto a gift card?
   */
  //@ ensures \result == loaded;
  public /*@ pure */ boolean loaded() {
    return is_loaded;
  }
  

}
