public class Sqrt {

    /*@
    public normal_behavior
      requires 0 <= the_input;
      ensures \result == Math.sqrt(the_input);
    also public exceptional_behavior
      requires the_input < 0;
      signals (IllegalArgumentException e) true;
      signals_only IllegalArgumentException;
    @*/
    public static double sqrt(final double the_input)
            throws IllegalArgumentException {
        if (the_input < 0) { throw new IllegalArgumentException(); }
        return Math.sqrt(the_input);
    }

}